package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.senac.rn.loja.model.Departamento;

public class DepartamentoDAO extends GenericDAO<Departamento>{
	
	@Override
	public Class<Departamento> getClassType() {
		return Departamento.class;
	}
	
	public List<Departamento> findAll() {
		String sql = "SELECT d FROM Departamento d";
		//Departamento citado no sql é a entidade e não a classe
		TypedQuery<Departamento> query = manager.createQuery(sql, Departamento.class);
		return query.getResultList();
	}
	

}
