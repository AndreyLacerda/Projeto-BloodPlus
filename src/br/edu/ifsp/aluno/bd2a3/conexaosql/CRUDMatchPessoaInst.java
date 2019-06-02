package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.matchs.MatchPessoaInst;

public class CRUDMatchPessoaInst {
	
	public static boolean inserirMatchPessoaInst(MatchPessoaInst match) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				String insert = "INSERT INTO MatchPessoaInst VALUES ('"+match.getDoador().getEmail()+"', '"+match.getReceptor().getEmail()+"', "
						+ "'"+match.getDoacao()+"', "+match.getMotivo()+", "+match.isFracasso()+", "+match.isSucesso()+", "
								+ ""+match.isCancelada()+", "+match.isFinalizada()+" )";
				
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
	
	public static boolean deleteMatch(MatchPessoaInst match) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				String delete = "DELETE FROM MatchPessoaInst WHERE email_doador ="+match.getDoador().getEmail()+" AND email_receptorJuridico = "+match.getReceptor().getEmail()+"";
				Connection conn = DriverManager.getConnection(connectionUrl);
				stmt = conn.createStatement();
				stmt.execute(delete);
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
	
	public static boolean updateMatchPessoaInst(MatchPessoaInst match,String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try {
				String update = "UPDATE MatchPessoaInst SET "+campo+" = "+valor+" WHERE email_doador = "+match.getDoador().getEmail()+" AND email_receptorJuridico = "+match.getReceptor().getEmail()+"";
				Connection conn = DriverManager.getConnection(connectionUrl);
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
	
	public static ResultSet selectMatchPessoaInst(String campo, String valor) {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";
		Statement stmt = null;
		
		boolean testeConnection;
		if (testeConnection = TesteConnectionSQLite.checarConexão()) {
			try{
				Connection conn = DriverManager.getConnection(connectionUrl);
				String select = "SELECT * FROM MatchPessoaInst WHERE "+campo+" = "+valor+";";
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