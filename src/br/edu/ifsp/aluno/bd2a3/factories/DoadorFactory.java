package br.edu.ifsp.aluno.bd2a3.factories;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;

public class DoadorFactory {

	public static String buildarDoador(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf, String tel, String celular,
			String tipo_sangue, String regiao, String endereco, float peso, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo, boolean aids, boolean hepatite11, boolean htlv1ou2, boolean chagas, boolean hepatiteBouC) {
		
		String ano_nasc1 = dt_nasc.substring(10, 4);
		int ano_nasc = Integer.parseInt(ano_nasc1);
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8) {
			return ("Senha inv�lida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty()) {
				return ("Email inv�lido!");
			} else
				if(nome.isEmpty() || nome.length() < 2) {
					return ("Nome inv�lido!");
				} else
					if(sobrenome.isEmpty() || sobrenome.length() < 2) {
						return ("Sobrenome inv�lido!");
					} else
						if(dt_nasc.isEmpty() || ano_nasc < 2003 || dt_nasc.length() < 4 || dt_nasc.length() > 10) {
							return ("Data de Nascimento inv�lida!");
						} else
							if(cpf.isEmpty() || cpf.length() < 12 || cpf.length() > 14) {
								return ("CPF inv�lido!");
							} else
								if(tel.isEmpty() || tel.length() < 7) {
									return ("Telefone inv�lido!");
								} else
									if(celular.isEmpty() || celular.length() < 10 || celular.length() >= 12) {
										return ("Celular inv�lido!");
									} else
										if(tipo_sangue.isEmpty() || tipo_sangue.length() < 2 || tipo_sangue.length() > 2) {
											return ("Tipo Sangu�neo inv�lido!");
										} else
											if(regiao.isEmpty() || regiao.length() < 2) {
												return ("Regi�o inv�lida!");
											} else
												if(endereco.isEmpty() || endereco.length() < 7) {
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
																				if (result == true)
																					return ("Cadastro realizado com sucesso!");
																				else
																					return ("Error ao Cadastrar Usu�rio");
																				}
	}
	
}
