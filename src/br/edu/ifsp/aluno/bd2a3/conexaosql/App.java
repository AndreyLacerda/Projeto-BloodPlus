package br.edu.ifsp.aluno.bd2a3.conexaosql;

public class App {

	public static void main(String[] args) {
		
		String sql = "SELECT email, senha, nome FROM Doador WHERE email = 'teste@teste.com'";
		TesteConnectionSQLite.checarConexão(sql);
		
	}

}
