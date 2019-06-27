package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class ReceptorComumFactory {

	public static String buildarReceptorComum(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf,
			String tel, String celular, float peso, String tipo_sangue, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo,
			String regiao, String endereco, boolean aids, boolean hepatite11, boolean htlv1ou2, boolean chagas, boolean hepatiteBouC) throws SQLException {
		
		String ano_nasc1 = dt_nasc.substring(6, 10);
		int ano_nasc = Integer.parseInt(ano_nasc1);
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8 || senha.contains("//") || senha.contains("--") || senha.contains("*")) {
			return ("Senha inválida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty() || email == null || email.contains("//") || email.contains("--") || email.contains("*")) {
				return ("Email inválido!");
			} else
				if (CRUDReceptorComum.selectReceptor3("email", email).next() == true) {
					return ("Email Já Cadastrado!");
				} else
					if(nome.isEmpty() || nome.length() < 2 || nome == null || nome.contains("//") || nome.contains("--") || nome.contains("*")) {
						return ("Nome inválido!");
					} else
						if(sobrenome.isEmpty() || sobrenome.length() < 2 || sobrenome == null || sobrenome.contains("//") || sobrenome.contains("--") || sobrenome.contains("*")) {
							return ("Sobrenome inválido!");
						} else
							if(dt_nasc.isEmpty() || ano_nasc > 2003 || dt_nasc.length() < 8 || dt_nasc.length() > 10 || dt_nasc == null || dt_nasc.contains("--") || dt_nasc.contains("*")) {
								return ("Data de Nascimento inválida!");
							} else
								if(cpf.isEmpty() || cpf.length() < 12 || cpf.length() > 14 || cpf == null || cpf.contains("//") || cpf.contains("--") || cpf.contains("*")) {
									return ("CPF inválido!");
								} else
									if(tel.isEmpty() || tel.length() < 8 || tel == null || tel.contains("//") || tel.contains("--") || tel.contains("*")) {
										return ("Telefone inválido!");
									} else
										if(celular.isEmpty() || celular.length() < 9 || celular.length() >= 12 || celular == null || celular.contains("//") || celular.contains("--") || celular.contains("*")) {
											return ("Celular inválido!");
										} else
											if(tipo_sangue.isEmpty() || tipo_sangue.length() < 2 || tipo_sangue.length() > 3 || tipo_sangue == null) {
												return ("Tipo Sanguíneo inválido!");
											} else
												if(regiao.isEmpty() || regiao.length() < 3 || regiao == null) {
													return ("Região inválida!");
												} else
													if(endereco.isEmpty() || endereco.length() < 7 || endereco == null || endereco.contains("//") || endereco.contains("--") || endereco.contains("*")) {
														return ("Endereço inválido!");
													} else
													if(peso < 50) {
														return ("Peso inválido!");
													} else
														if(sangue == false && rim == false && figado == false && medula == false && pulmao == false && pancreas == false) {
															return ("Pedido inválido!");
														} else {
															ReceptorComum receptorC = new ReceptorComum(email, senha, nome, sobrenome, dt_nasc, cpf, tel, celular, peso, tipo_sangue, sangue, rim, figado, medula, pulmao, pancreas, ativo, regiao, endereco);
															boolean result = CRUDReceptorComum.inserirReceptor(receptorC);
															if (result == true) {
																MatchComumFactory.criarMatchReceptor(receptorC);
																return ("Cadastro realizado com sucesso!");
															}
															else
																return ("Error ao Cadastrar Usuário");
															}
	}
	
}
