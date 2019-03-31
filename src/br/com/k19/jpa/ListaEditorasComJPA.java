package br.com.k19.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaEditorasComJPA {

	public static void main(String[] args) {
		
		
		//Cria conexão com o banco
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("livraria-pu");
		
		//Passa a conexão para o objeto de persistência entityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Criando o objeto de listagem com a classe Query
		Query query = entityManager.createQuery("SELECT e FROM Editora e");

		//Cria um array para armazenar a lista que veio do select do objeto query do método getResultList()
		List<Editora> editoras = query.getResultList();
		
		//Itera em cada objeto da lista
		for (Editora editora : editoras) {
			
			System.out.println("Editora email: "+editora.getEmail()+" - nome: "+editora.getNome());
			
		}
		
		//Fechando o objeto de persistência
		entityManager.close();
		//Fechando a conexão
		entityManagerFactory.close();
	}

}
