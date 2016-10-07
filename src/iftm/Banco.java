package iftm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	static String sql_criaBanco = "create database clinica";
	static String sql_criaBase = "CREATE TABLE atendimentos(slot int(11) NOT NULL, nome varchar(50) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;";

	public static void criaBase() {
		String url = "jdbc:mysql://localhost:3306/";
		String usuario = "root";
		String senha = "";
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			stmt = con.createStatement();
			stmt.execute(sql_criaBanco);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void criaTabela() {
		String url = "jdbc:mysql://localhost:3306/clinica";
		String usuario = "root";
		String senha = "";
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			stmt = con.createStatement();
			stmt.execute(sql_criaBase);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void excluir(int i) {
		String url = "jdbc:mysql://localhost:3306/clinica";
		String usuario = "root";
		String senha = "";
		String sql = "delete from atendimentos where slot=" + i;
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void gravaDados(Dados d) {
		String url = "jdbc:mysql://localhost:3306/clinica";
		String usuario = "root";
		String senha = "";
		String sql_novoContato = "insert into atendimentos(slot,nome) values('" + d.slot + "','" + d.nome + "');";
		Connection con;
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			stmt = con.createStatement();
			stmt.executeUpdate(sql_novoContato);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static List<Dados> listaTodos() {
		String url = "jdbc:mysql://localhost:3306/clinica";
		String usuario = "root";
		String senha = "";
		String sql_novoContato = "select * from atendimentos;";
		Connection con;
		Statement stmt;
		ResultSet resultados;
		int slot;
		String nome;
		List<Dados> lista = new ArrayList<Dados>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			stmt = con.createStatement();
			resultados = stmt.executeQuery(sql_novoContato);
			while (resultados.next()) {
				nome = resultados.getString("nome");
				slot = resultados.getInt("slot");
				lista.add(new Dados(slot, nome));
			}
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	public static void main(String[] args) {
		Banco.criaBase();
		Banco.criaTabela();
		Banco.gravaDados(new Dados(1, "Edson"));
		Banco.gravaDados(new Dados(7, "Wilton"));
		Banco.gravaDados(new Dados(2, "Bruno"));
		for (Dados d : Banco.listaTodos()) {
			System.out.println(d.slot + "," + d.nome);
		}
	}
}
