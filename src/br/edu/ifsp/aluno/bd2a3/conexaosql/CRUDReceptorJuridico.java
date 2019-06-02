package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class CRUDReceptorJuridico {
	
	public static boolean inserirReceptor(ReceptorJuridico receptor) {
		
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			String insert = "INSERT INTO receptor VALUES ('"+receptor.getEmail()+"', '"+receptor.getSenha()+"', '"+receptor.getNome_instituição()+"', "
					+ "'"+receptor.getCNPJ()+"', '"+receptor.getTel1()+"', '"+receptor.getTel2()+"', '"+receptor.getRegiao()+"', "
							+ ""+receptor.getEndereco()+", '"+receptor.isSangue()+"', "+receptor.isRim()+", "+receptor.isFigado()+", "
									+ ""+receptor.isMedula()+", "+receptor.isPulmao()+", "+receptor.isPancreas()+", "+receptor.getMain_tipo_sangue()+");";
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
				String delete = "DELETE FROM ReceptorJuridico WHERE email = "+email+" AND senha = "+senha+";";
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
				String select = "SELECT * FROM ReceptorJuridico WHERE email = "+email+" AND senha = "+senha+";";
				
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
	
	public static boolean updateReceptor(ReceptorJuridico receptor, String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				Connection conn = DriverManager.getConnection(connectionUrl);
				String update = "UPDATE ReceptorJuridico SET "+campo+" = "+valor+" WHERE email = "+receptor.getEmail()+";";
				
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
				String select = "SELECT * FROM ReceptorJuridico WHERE "+campo+" = "+valor+";";
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
