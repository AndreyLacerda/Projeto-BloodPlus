package br.edu.ifsp.aluno.bd2a3.conexaosql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;

public class CRUDDoador {
	
	public static boolean inserirDoador(Doador doador) {
		
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			String insert = "INSERT INTO Doador VALUES ('"+doador.getEmail()+"', '"+doador.getSenha()+"', '"+doador.getNome()+"', "
					+ "'"+doador.getSobrenome()+"', '"+doador.getDt_nasc()+"', '"+doador.getTel()+"', '"+doador.getCelular()+"', "
							+ ""+doador.getPeso()+", '"+doador.getTipo_sangue()+"', "+doador.isSangue()+", "+doador.isRim()+", "
									+ ""+doador.isFigado()+", "+doador.isMedula()+", "+doador.isPulmao()+", "+doador.isPancreas()+", "
											+ "'"+doador.getRegiao()+"', '"+doador.getEndereco()+"',"+doador.isAtivo()+", '"+doador.getCpf()+"');";
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
	
	public static boolean deleteDoador(String email) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try {
				String delete = "DELETE FROM Doador WHERE email = '"+email+"';";
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
	
	public static ResultSet loginDoador(String email, String senha) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String select = "SELECT * FROM Doador WHERE email = '" + email + "' AND senha = '" + senha + "' ";
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
	
	public static boolean updateDoador(String email, String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String update = "UPDATE Doador SET "+campo+" = '"+valor+"' WHERE email = '"+email+"';";
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
	
	public static boolean updateDoador2(String email, String campo, boolean valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String update = "UPDATE Doador SET "+campo+" = "+valor+" WHERE email = '"+email+"';";
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
	
	public static ResultSet selectDoador (String campo, String valor) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
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
	
	public static ResultSet selectDoador2 (String campo1, String valor1, String campo2, String valor2) {
		Statement stmt = null;
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String select = "SELECT * FROM Doador WHERE "+campo1+" = "+valor1+" AND "+campo2+" = '"+valor2+"';";
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
	
	public static ResultSet selectDoador3 (String campo, String valor) {
		
		Connection conn = TesteConnectionSQLite.checarConexão();
		if (conn != null) {
			try{
				String select = "SELECT * FROM Doador WHERE "+campo+" = '"+valor+"';";
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