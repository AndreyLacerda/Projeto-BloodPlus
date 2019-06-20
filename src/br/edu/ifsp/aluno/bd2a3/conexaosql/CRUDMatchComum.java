package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.matchs.MatchComum;

public class CRUDMatchComum {
	
	public static boolean inserirMatchComum(MatchComum match) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String insert = "INSERT INTO MatchComum VALUES ('"+match.getDoador()+"', '"+match.getReceptor()+"', "
						+ "'"+match.getDoacao()+"', "+match.isFracasso()+", "+match.isSucesso()+", "+match.getMotivo()+", "
								+ ""+match.isCancelada()+", "+match.isFinalizada()+" )";
				
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
	
	public static boolean deleteMatchDoador(String email) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String delete = "DELETE FROM MatchComum WHERE email_doador ='"+email+"'";
				stmt = conn.createStatement();
				stmt.execute(delete);
				stmt.close();
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
	
	public static boolean deleteMatchReceptor(String email) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String delete = "DELETE FROM MatchComum WHERE email_receptor ='"+email+"'";
				stmt = conn.createStatement();
				stmt.execute(delete);
				stmt.close();
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
	
	public static boolean updateMatchComum(MatchComum match,String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
				String update = "UPDATE MatchComum SET "+campo+" = "+valor+" WHERE email_doador = "+match.getDoador()+" AND email_receptor = "+match.getReceptor()+"";
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
	
	public static ResultSet selectMatchComum(String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String select = "SELECT * FROM MatchComum WHERE "+campo+" = "+valor+";";
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