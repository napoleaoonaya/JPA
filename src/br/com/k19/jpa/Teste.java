package br.com.k19.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("livraria-pu");
		
		entityManagerFactory.close();
	}

}
