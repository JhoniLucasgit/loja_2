package br.senac.rn.loja.testes;

import br.senac.rn.loja.dao.MarcaDAO;
import br.senac.rn.loja.model.Marca;

public class TestaMarca {

	public static void main(String[] args) {
		Marca marca = new Marca();
		marca.setNome("");
		
		MarcaDAO dao = new MarcaDAO();
		dao.insert(marca);
				
		System.out.println(new MarcaDAO().findAll());

	}

}
