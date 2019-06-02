package br.edu.ifsp.aluno.bd2a3.conexaosql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConnectionSQLite {
	
	public static boolean checarConex�o() {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {			
			Connection conn = DriverManager.getConnection(connectionUrl);
			
			System.out.println("Conex�o obtida com sucesso");
			
			String SQL = "SELECT email, senha, nome FROM Doador WHERE email = 'teste@teste.com'";
			String insert = "INSERT INTO Doador VALUES ('teste@teste.com', '1234', 'Teste', 'Conex�o', '2019-05-19', '(11) 1111-1111', '(11) 91111-1111', 75, 'A+', 1, 1, 1, 1, 1, 1, 'Zona Leste', 'Rua Teste, Teste, N�55', 0, '123.456.789-15');";
			
			pstmt = conn.prepareStatement(insert);
			pstmt.execute();
			
			System.out.println("Insert com sucesso");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );
			}
			
			System.out.println("Tudo deu certo");	
			
			conn.close();
			rs.close();
			pstmt.close();
			
			return true;
			
		} catch(SQLException esql) {
			
			System.err.println("SQLException: " + esql.getMessage());
			System.err.println("SQLState: " + esql.getSQLState());
			System.err.println("VendorError: " + esql.getErrorCode());
			return false;
			
		} catch(Exception e) {
			
			System.err.println("Erro: " + e.getMessage());
			return false;
		}
	}
}