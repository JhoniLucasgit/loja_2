package br.senac.rn.loja.dao;

import br.senac.rn.loja.model.Atendente;

public class AtendenteDAO extends GenericDAO<Atendente>{

	@Override
	public Class<Atendente> getClassType() {
		return Atendente.class;
	}
	
}
