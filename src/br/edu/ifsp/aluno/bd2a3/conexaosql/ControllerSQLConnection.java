package br.edu.ifsp.aluno.bd2a3.conexaosql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerSQLConnection {
	
	public static void checarConexão(String SQL) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=BloodPlusDB";

		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			
			Connection conn = DriverManager.getConnection(connectionUrl, "sa", "senhadoadministrador");
			
			System.out.println("Conexão obtida com sucesso");
		

			stmt = conn.createStatement();
			
			String insert = "INSERT INTO Doador "
					+ "VALUES "
					+ "('teste@teste.com', '1234', 'Teste', 'Conexão', '2019-05-19', '(11) 1111-1111', '(11) 91111-1111', "
					+ "75, 'A+', 1, 1, 1, 1, 1, 1, "
					+ "'Zona Leste', 'Rua Teste, Teste, Nº55', '', 0, '2019-05-19', 1000)";
			
			stmt.execute(insert);
			
			System.out.println("Insert com sucesso");
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );
			}
			System.out.println("Tudo deu certo");
			
		} catch(SQLException esql) {
			
			System.err.println("SQLException: " + esql.getMessage());
			System.err.println("SQLState: " + esql.getSQLState());
			System.err.println("VendorError: " + esql.getErrorCode());
			
			
		} catch(Exception e) {
			
			System.err.println("Erro: " + e.getMessage());
			
		}
	}
}