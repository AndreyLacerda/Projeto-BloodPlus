package br.edu.ifsp.aluno.bd2a3.conexaosql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConnectionSQLite {
	
	private static Connection conn;
	
	public static Connection checarConexão() {
		if (conn != null)
			return conn;
		else
			return null;
	}
	
	public static void testarConnection() {
		String connectionUrl = "jdbc:sqlite:DataBase/BloodPlusDB.db";

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {			
			Connection conne = DriverManager.getConnection(connectionUrl);
			System.out.println("Conexão obtida com sucesso");
			
			String SQL = "SELECT email, senha, nome FROM Doador WHERE email = 'teste@teste.com'";
			String insert = "INSERT INTO Doador VALUES ('teste@teste.com', '1234', 'Teste', 'Conexão', '2019-05-19', '(11) 1111-1111', '(11) 91111-1111', 75, 'A+', 1, 1, 1, 1, 1, 1, 'Zona Leste', 'Rua Teste, Teste, Nº55', 0, '123.456.789-15');";
			
			pstmt = conne.prepareStatement(insert);
			pstmt.execute();
			
			System.out.println("Insert com sucesso");
			stmt = conne.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );
			}
			
			System.out.println("Tudo deu certo");	
			
			rs.close();
			pstmt.close();
			conn = conne;
			
		} catch(SQLException esql) {
			
			System.err.println("SQLException: " + esql.getMessage());
			System.err.println("SQLState: " + esql.getSQLState());
			System.err.println("VendorError: " + esql.getErrorCode());
			
		} catch(Exception e) {
			
			System.err.println("Erro: " + e.getMessage());
		}
	}
}