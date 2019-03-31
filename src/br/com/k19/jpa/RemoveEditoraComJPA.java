package br.com.k19.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveEditoraComJPA {
	
	public static void main(String[] args) {
		
		
		//Cria conexão com o banco
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("livraria-pu");
		
		//Passa a conexão para o objeto de persistência entityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Criando o objeto editora
		Editora editora = new Editora();
		
		//Cria o objeto de captura do teclado
		Scanner teclado = new Scanner(System.in);
		
		//Passando o id para remoção
		System.out.println("Informe o id da editora para remoção: ");
		editora.setId(teclado.nextLong());
		
		//Localizando o id para ser alterado
		editora = entityManager.find(Editora.class, editora.getId());

		//Fechando o objeto de captura
		teclado.close();
		
		//Persistindo o objeto editora no banco de dados
		entityManager.remove(editora);
		
		//Colocando o objeto em memória
		entityManager.getTransaction().begin();
		//Executando o objeto em memória
		entityManager.getTransaction().commit();

		//Mostrando o id da editora salva
		System.out.println("Editora cadastrada com o id: "+editora.getId());
		
		//Fechando o objeto de persistência
		entityManager.close();
		//Fechando a conexão
		entityManagerFactory.close();
		
		
		
	}

}
