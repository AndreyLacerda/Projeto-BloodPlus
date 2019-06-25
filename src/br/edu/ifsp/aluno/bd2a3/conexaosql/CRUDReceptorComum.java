package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class CRUDReceptorComum {
	
	public static boolean inserirReceptor(ReceptorComum receptor) {
		
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			String insert = "INSERT INTO ReceptorComum VALUES ('"+receptor.getEmail()+"', '"+receptor.getSenha()+"', '"+receptor.getNome()+"', "
					+ "'"+receptor.getSobrenome()+"', '"+receptor.getDt_nasc()+"', '"+receptor.getTel()+"', '"+receptor.getCelular()+"', "
							+ ""+receptor.getPeso()+", '"+receptor.getTipo_sangue()+"', '"+receptor.getRegiao()+"', "+receptor.isAtivo()+", "
									+ ""+receptor.isSangue()+", '"+receptor.getCpf()+"', "+receptor.isPulmao()+", "+receptor.isFigado()+", "
											+ "'"+receptor.isRim()+"', '"+receptor.isPancreas()+"',"+receptor.isMedula()+", '"+receptor.getEndereco()+"');";
			try{
				stmt = conn.createStatement();
				stmt.execute(insert);
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
	
	public static boolean deleteReceptor(String email) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String delete = "DELETE FROM ReceptorComum WHERE email = '"+email+"'";
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
	
	public static ResultSet loginReceptor(String email, String senha) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
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
	
	public static boolean updateReceptor(String email, String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String update = "UPDATE ReceptorComum SET "+campo+" = '"+valor+"' WHERE email = '"+email+"';";
				
				stmt = conn.createStatement();
				stmt.execute(update);
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
	
	public static boolean updateReceptor2(String email, String campo, boolean valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String update = "UPDATE ReceptorComum SET "+campo+" = "+valor+" WHERE email = '"+email+"';";
				
				stmt = conn.createStatement();
				stmt.execute(update);
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
	
	public static ResultSet selectReceptor (String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
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
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
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
	
	public static ResultSet selectReceptor3 (String campo, String valor) {
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
				String select = "SELECT * FROM ReceptorComum WHERE "+campo+" = '"+valor+"';";
				ResultSet rs = conn.createStatement().executeQuery(select);
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