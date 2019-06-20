package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class CRUDReceptorJuridico {
	
	public static boolean inserirReceptor(ReceptorJuridico receptor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			String insert = "INSERT INTO ReceptorJuridico VALUES ('"+receptor.getEmail()+"', '"+receptor.getSenha()+"', '"+receptor.getNome_instituição()+"', "
					+ "'"+receptor.getCNPJ()+"', '"+receptor.getTel1()+"', '"+receptor.getTel2()+"', '"+receptor.getRegiao()+"', "
							+ "'"+receptor.getEndereco()+"', '"+receptor.isSangue()+"', "+receptor.isRim()+", "+receptor.isFigado()+", "
									+ ""+receptor.isMedula()+", "+receptor.isPulmao()+", "+receptor.isPancreas()+", "+receptor.isAtivo()+", '"+receptor.getMain_tipo_sangue()+"');";
			try{
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
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String delete = "DELETE FROM ReceptorJuridico WHERE email = '"+email+"' AND senha = '"+senha+"';";
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
	
	public static ResultSet loginReceptor(String email, String senha) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
				String select = "SELECT * FROM ReceptorJuridico WHERE email = '"+email+"' AND senha = '"+senha+"' ";
				
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
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
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
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
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
	
	public static ResultSet selectReceptor2 (String campo1, String valor1, String campo2, String valor2) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String select = "SELECT * FROM ReceptorJuridico WHERE "+campo1+" = "+valor1+" AND "+campo2+" = '"+valor2+"';";
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
	
	public static ResultSet selectReceptor3 (String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
				String select = "SELECT * FROM ReceptorJuridico WHERE "+campo+" = '"+valor+"';";
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
