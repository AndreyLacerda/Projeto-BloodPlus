package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;

public class DoadorFactory {

	public static String buildarDoador(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf, String tel, String celular,
			String tipo_sangue, String regiao, String endereco, float peso, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo, boolean aids, boolean hepatite11, boolean htlv1ou2, boolean chagas, boolean hepatiteBouC) throws SQLException {
		
		String ano_nasc1 = dt_nasc.substring(6, 10);
		int ano_nasc = Integer.parseInt(ano_nasc1);
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8 || senha == null || senha.contains("//") || senha.contains("--") || senha.contains("*")) {
			return ("Senha inv�lida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty() || email == null || email.contains("//") || email.contains("--") || email.contains("*")) {
				return ("Email inv�lido!");
			} else
				if (CRUDDoador.selectDoador3("email", email).next() == true) {
					return ("Email J� Cadastrado!");
				} else	
					if(nome.isEmpty() || nome.length() < 2 || nome == null || nome.contains("//") || nome.contains("--") || nome.contains("*")) {
						return ("Nome inv�lido!");
					} else
						if(sobrenome.isEmpty() || sobrenome.length() < 2 || sobrenome == null || sobrenome.contains("//") || sobrenome.contains("--") || sobrenome.contains("*")) {
							return ("Sobrenome inv�lido!");
						} else
							if(dt_nasc.isEmpty() || ano_nasc > 2003 || dt_nasc.length() < 8 || dt_nasc.length() > 10 || dt_nasc == null || dt_nasc.contains("--") || dt_nasc.contains("*")) {
								return ("Data de Nascimento inv�lida!");
							} else
								if(cpf.isEmpty() || cpf.length() < 12 || cpf.length() > 14 || cpf == null || cpf.contains("//") || cpf.contains("--") || cpf.contains("*")) {
									return ("CPF inv�lido!");
								} else
									if(tel.isEmpty() || tel.length() < 8 || tel == null || tel.contains("//") || tel.contains("--") || tel.contains("*")) {
										return ("Telefone inv�lido!");
									} else
										if(celular.isEmpty() || celular.length() < 9 || celular.length() >= 12 || celular == null || celular.contains("//") || celular.contains("--") || celular.contains("*")) {
											return ("Celular inv�lido!");
										} else
											if(tipo_sangue.isEmpty() || tipo_sangue.length() < 2 || tipo_sangue.length() > 3 || tipo_sangue == null) {
												return ("Tipo Sangu�neo inv�lido!");
											} else
												if(regiao.isEmpty() || regiao.length() < 3 || regiao == null) {
													return ("Regi�o inv�lida!");
												} else
													if(endereco.isEmpty() || endereco.length() < 7 || endereco == null || endereco.contains("//") || endereco.contains("--") || endereco.contains("*")) {
														return ("Endere�o inv�lido!");
													} else 
														if(peso < 50) {
															return ("Peso inv�lido!");
														} else
															if(sangue == false && rim == false && figado == false && medula == false && pulmao == false && pancreas == false) {
																return ("Doa��o inv�lida!");
															} else 
																if(aids == true) {
																	return ("Voc� possui um requisito inv�lido.");
																} else
																	if(hepatite11 == true) {
																		return ("Voc� possui um requisito inv�lido.");
																	} else
																		if(htlv1ou2 == true) {
																			return ("Voc� possui um requisito inv�lido.");
																		} else 
																			if(hepatiteBouC == true) {
																				return ("Voc� possui um requisito inv�lido.");
																			} else
																				if(chagas == true) {
																					return ("Voc� possui um requisito inv�lido.");
																				} else {
																					Doador doador = new Doador(email, senha, nome, sobrenome, dt_nasc, cpf, tel, celular, tipo_sangue, regiao, endereco, peso, sangue, rim, figado, medula, pulmao, pancreas, ativo);
																					boolean result = CRUDDoador.inserirDoador(doador);
																					if (result == true) {
																						MatchComumFactory.criarMatchDoador(doador);
																						MatchInstFactory.criarMatchDoador(doador);
																						return ("Cadastro realizado com sucesso!");
																					}
																					else
																						return ("Ops, ocorreu um erro. Tente mais tarde");
																					}
	}
}
