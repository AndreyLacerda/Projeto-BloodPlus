package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;

public class DoadorFactory {

	public static String buildarDoador(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf, String tel, String celular,
			String tipo_sangue, String regiao, String endereco, float peso, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo, boolean aids, boolean hepatite11, boolean htlv1ou2, boolean chagas, boolean hepatiteBouC) throws SQLException {
		
		String ano_nasc1 = dt_nasc.substring(10, 4);
		int ano_nasc = Integer.parseInt(ano_nasc1);
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8 || senha == null) {
			return ("Senha inv�lida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty() || email == null) {
				return ("Email inv�lido!");
			} else
				if(nome.isEmpty() || nome.length() < 2 || nome == null) {
					return ("Nome inv�lido!");
				} else
					if(sobrenome.isEmpty() || sobrenome.length() < 2 || sobrenome == null) {
						return ("Sobrenome inv�lido!");
					} else
						if(dt_nasc.isEmpty() || ano_nasc < 2003 || dt_nasc.length() < 4 || dt_nasc.length() > 10 || dt_nasc == null) {
							return ("Data de Nascimento inv�lida!");
						} else
							if(cpf.isEmpty() || cpf.length() < 12 || cpf.length() > 14 || cpf == null) {
								return ("CPF inv�lido!");
							} else
								if(tel.isEmpty() || tel.length() < 7 || tel == null) {
									return ("Telefone inv�lido!");
								} else
									if(celular.isEmpty() || celular.length() < 10 || celular.length() >= 12 || celular == null) {
										return ("Celular inv�lido!");
									} else
										if(tipo_sangue.isEmpty() || tipo_sangue.length() < 2 || tipo_sangue.length() > 2 || tipo_sangue == null) {
											return ("Tipo Sangu�neo inv�lido!");
										} else
											if(regiao.isEmpty() || regiao.length() < 2 || regiao == null) {
												return ("Regi�o inv�lida!");
											} else
												if(endereco.isEmpty() || endereco.length() < 7 || endereco == null) {
													return ("Endere�o inv�lido!");
												} else 
													if(peso < 50) {
														return ("Peso inv�lido!");
													} else
														if(sangue == false || rim == false || figado == false || medula == false || pulmao == false || pancreas == false) {
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
