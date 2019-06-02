package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;

public class CRUDDoador {
	
	public static boolean inserirDoador(Doador doador) {
		
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			String insert = "INSERT INTO Doador VALUES ('"+doador.getEmail()+"', '"+doador.getSenha()+"', '"+doador.getNome()+"', "
					+ "'"+doador.getSobrenome()+"', '"+doador.getDt_nasc()+"', '"+doador.getTel()+"', '"+doador.getCelular()+"', "
							+ ""+doador.getPeso()+", '"+doador.getTipo_sangue()+"', "+doador.isSangue()+", "+doador.isRim()+", "
									+ ""+doador.isFigado()+", "+doador.isMedula()+", "+doador.isPulmao()+", "+doador.isPancreas()+", "
											+ "'"+doador.getRegiao()+"', '"+doador.getEndereco()+"',"+doador.isAtivo()+", '"+doador.getCpf()+"');";
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				stmt = conn.createStatement();
				stmt.execute(insert);
				return true;
			} catch(SQLException esql) {
				System.err.println("SQLException: " + esql.getMessage());
				System.err.println("SQLState: " + esql.getSQLState());
				System.err.println("VendorError: " + esql.getErrorCode());
				return false;
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean deleteDoador(String email, String senha) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				String delete = "DELETE FROM Doador WHERE email = "+email+" AND senha = "+senha+";";
				Connection conn = DriverManager.getConnection(connectionUrl);
				stmt = conn.createStatement();
				stmt.execute(delete);
			} catch(SQLException esql) {
				System.err.println("SQLException: " + esql.getMessage());
				System.err.println("SQLState: " + esql.getSQLState());
				System.err.println("VendorError: " + esql.getErrorCode());
				return false;
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public static ResultSet loginDoador(String email, String senha) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM Doador WHERE email = "+email+" AND senha = "+senha+";";
				
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select);
				
				return rs;
			} catch(SQLException esql) {
				System.err.println("SQLException: " + esql.getMessage());
				System.err.println("SQLState: " + esql.getSQLState());
				System.err.println("VendorError: " + esql.getErrorCode());
				return null;
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static boolean updateDoador(Doador doador, String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				Connection conn = DriverManager.getConnection(connectionUrl);
				String update = "UPDATE Doador SET "+campo+" = "+valor+" WHERE email = "+doador.getEmail()+";";
				
				stmt = conn.createStatement();
				stmt.execute(update);
				
				return true;
			} catch(SQLException esql) {
				System.err.println("SQLException: " + esql.getMessage());
				System.err.println("SQLState: " + esql.getSQLState());
				System.err.println("VendorError: " + esql.getErrorCode());
				return false;
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	public static ResultSet selectDoador (String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM Doador WHERE "+campo+" = "+valor+";";
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(select);
				
				return rs;
			} catch(SQLException esql) {
				System.err.println("SQLException: " + esql.getMessage());
				System.err.println("SQLState: " + esql.getSQLState());
				System.err.println("VendorError: " + esql.getErrorCode());
				return null;
			} catch (Exception e) {
				System.err.println("Erro: " + e.getMessage());
				return null;
			}
		} else {
			return null;
		}
		
	}
}