package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Joao");
		conta.setNumero(342324);
		conta.setAgencia(456787);
		conta.setSaldo(150.0);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

		EntityManager em2 = emf.createEntityManager();
//		System.out.println("ID da conta do Dudu: " + conta.getId());
		conta.setSaldo(260.0);

		em2.getTransaction().begin();

		em2.merge(conta);

		em2.getTransaction().commit();
	}

}
