package br.com.alura.jpa.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jpa.modelo.Conta;

public class TesteSQL {

	public static void main(String[] args) throws Exception {

		Connection cnn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/alura_jpa?useTimezone=true;serverTimezone=UTC", "root", "root");

		String sql = "SELECT * FROM Conta";

		PreparedStatement ps = cnn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Conta> contas = new ArrayList<>();

		while (rs.next()) {
			Conta conta = new Conta();
			conta.setAgencia(rs.getInt("agencia"));
			conta.setNumero(rs.getInt("numero"));
			conta.setSaldo(rs.getDouble("saldo"));

			contas.add(conta);
		}

		for (Conta conta : contas) {
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
			System.out.println("==============================");
		}

	}

}
