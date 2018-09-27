package br.senac.rn.loja.testes;

import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.model.Departamento;

public class TestaDepartamento {

	public static void main(String[] args) {
		Departamento departamento = new Departamento();
		departamento.setNome("Uniforme");
		departamento.setSigla("UNI");
		departamento.setDesconto(0.15f);
		
		DepartamentoDAO dao = new DepartamentoDAO();
		dao.insert(departamento);
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ConexaoDB");//cria uma fabrica de persistencia
//		EntityManager manager = factory.createEntityManager();//cria um gerenciador da fabrica, com a persistencia criar a entidade
//		
		//transação insert, delete e update
//		manager.getTransaction().begin();
//		manager.persist(departamento);
//		manager.getTransaction().commit();
		
		//buscas com hibernate
		System.out.println(dao.findAll());
		
//		manager.close();
//		factory.close();

	}

}
