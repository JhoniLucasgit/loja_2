package br.senac.rn.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {
	
	private static DataBase instance = new DataBase();
	private static EntityManager manager;
	//o construtor cria um manager
	public DataBase() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ConexaoDB");
		manager = factory.createEntityManager();
	}
	//metodo para criar uma instancia de database
	public static DataBase getInstance() {
		return instance;
	}
	//pega o manager
	public static EntityManager getEntityManager() {
		return manager;
	}
}
