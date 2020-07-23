package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaEduardo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaDoEduardo = em.find(Conta.class, 1L);

//		System.out.println("Conta do Eduardo: " + contaDoEduardo.getTitular());

		em.getTransaction().begin();

		contaDoEduardo.setSaldo(20.0);

		em.getTransaction().commit();
	}
}
