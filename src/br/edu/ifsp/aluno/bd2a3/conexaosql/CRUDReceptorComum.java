package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class CRUDReceptorComum {
	
	public static boolean inserirReceptor(ReceptorComum receptor) {
		
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			String insert = "INSERT INTO receptor VALUES ('"+receptor.getEmail()+"', '"+receptor.getSenha()+"', '"+receptor.getNome()+"', "
					+ "'"+receptor.getSobrenome()+"', '"+receptor.getDt_nasc()+"', '"+receptor.getTel()+"', '"+receptor.getCelular()+"', "
							+ ""+receptor.getPeso()+", '"+receptor.getTipo_sangue()+"', "+receptor.getRegiao()+", "+receptor.isAtivo()+", "
									+ ""+receptor.isSangue()+", "+receptor.getCpf()+", "+receptor.isPulmao()+", "+receptor.isFigado()+", "
											+ "'"+receptor.isRim()+"', '"+receptor.isPancreas()+"',"+receptor.isMedula()+", "+receptor.getEndereco()+");";
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
	
	public static boolean deleteReceptor(String email, String senha) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				String delete = "DELETE FROM ReceptorComum WHERE email = '"+email+"' AND senha = '"+senha+"';";
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
	
	public static ResultSet loginReceptor(String email, String senha) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM ReceptorComum WHERE email = '"+email+"' AND senha = '"+senha+"' ";
				
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
	
	public static boolean updateReceptor(ReceptorComum receptor, String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				Connection conn = DriverManager.getConnection(connectionUrl);
				String update = "UPDATE ReceptorComum SET "+campo+" = "+valor+" WHERE email = "+receptor.getEmail()+";";
				
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
	
	public static ResultSet selectReceptor (String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM ReceptorComum WHERE "+campo+" = "+valor+";";
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
	
	public static ResultSet selectReceptor2 (String campo1, String valor1, String campo2, String valor2) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM ReceptorComum WHERE "+campo1+" = "+valor1+" AND "+campo2+" = '"+valor2+"';";
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