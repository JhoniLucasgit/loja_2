package br.senac.rn.loja.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.senac.rn.loja.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente>{

	@Override
	public Class<Cliente> getClassType() {
		return Cliente.class;
	}
	
	public List<Cliente> findAll(){	
		String sql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = manager.createQuery(sql, Cliente.class);
		return query.getResultList();
	}
}
