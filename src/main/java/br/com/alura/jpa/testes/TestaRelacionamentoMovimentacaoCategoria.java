package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");

		Conta conta = new Conta();
		conta.setId(2L);

		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Viagem à RJ");
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setData(LocalDateTime.now());
		mov.setValor(new BigDecimal(800.0));
		mov.setCategoria(Arrays.asList(categoria, categoria2));
		mov.setConta(conta);

		Movimentacao mov2 = new Movimentacao();
		mov2.setDescricao("Viagem à SP");
		mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov2.setData(LocalDateTime.now());
		mov2.setValor(new BigDecimal(1000.00));
		mov2.setCategoria(Arrays.asList(categoria, categoria2));
		mov2.setConta(conta);

		em.getTransaction().begin();

		em.persist(categoria);
		em.persist(categoria2);
		em.persist(mov);
		em.persist(mov2);

		em.getTransaction().commit();

		em.close();
	}

}
