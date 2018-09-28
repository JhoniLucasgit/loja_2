package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericDAO<T> {
	
	private static EntityManager manager;	
	
	public abstract Class<T> getClassType();
	
	@SuppressWarnings("static-access")
	protected EntityManager getEntityManager() {
		if(manager == null || !manager.isOpen()) {
			manager = DataBase.getInstance().getEntityManager();
		}
		return manager;
	}
	
	public void operacaoDataBase(Operacao operacao, T entity) {
		manager.getTransaction().begin();
		switch(operacao) {
			case INSERIR:
				manager.persist(entity);
				break;
			case REMOVER:
				manager.remove(entity);
				break;
			case ATUALIZAR:
				manager.merge(entity);
		}
		manager.getTransaction().commit();
	}
	
	public void insert(T entity) {
		operacaoDataBase(Operacao.INSERIR, entity);
	}

	public void update(T entity) {
		operacaoDataBase(Operacao.ATUALIZAR, entity);
	}
	
	public void delete(T entity) {
		operacaoDataBase(Operacao.REMOVER, entity);
	}
	
	public T findById(Integer id) {
		return manager.find(this.getClassType(), id);//(nomeDaEntidade.class, id)
	}
	
	public List<T> findAll(){// manager = this.getEntityManager(); é a msm coisa
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();//criar um construtor
		CriteriaQuery<T> query = builder.createQuery(this.getClassType());//criar uma query pegando o tipo de classe que o construtor tem
		Root<T> entity = query.from(this.getClassType());//criar uma entidade pegando a classe da query
		CriteriaQuery<T> select = query.select(entity);//cria um select com o query e passando a entity criada
		TypedQuery<T> consulta = this.getEntityManager().createQuery(select);//cria a consulta a partir do manager e passando o select criado
		return consulta.getResultList();//retorna o array com todos os valores
	}
	
	public List<T> findAll2(){
		String entity = this.getClassType().getName();
		String sql = "SELECT t FROM " + entity + " t";
		TypedQuery<T> query = this.getEntityManager().createQuery(sql, this.getClassType());
		return query.getResultList();
	}
}
