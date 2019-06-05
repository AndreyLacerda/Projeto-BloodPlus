package br.edu.ifsp.aluno.bd2a3.factories;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class ReceptorComumFactory {

	public static String getReceptorComum(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf,
			String tel, String celular, float peso, String tipo_sangue, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo,
			String regiao, String endereco) {
		
		String ano_nasc1 = dt_nasc.substring(10, 4);
		int ano_nasc = Integer.parseInt(ano_nasc1);
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8) {
			return ("Senha inválida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty()) {
				return ("Senha inválida!");
			} else
				if(nome.isEmpty() || nome.length() < 2) {
					return ("Senha inválida!");
				} else
					if(sobrenome.isEmpty() || sobrenome.length() < 2) {
						return ("Senha inválida!");
					} else
						if(dt_nasc.isEmpty() || ano_nasc < 2003 || dt_nasc.length() < 4 || dt_nasc.length() > 10) {
							return ("Senha inválida!");
						} else
							if(cpf.isEmpty() || cpf.length() < 12 || cpf.length() > 14) {
								return ("Senha inválida!");
							} else
								if(tel.isEmpty() || tel.length() < 7) {
									return ("Senha inválida!");
								} else
									if(celular.isEmpty() || celular.length() < 10 || celular.length() >= 12) {
										return ("Senha inválida!");
									} else
										if(tipo_sangue.isEmpty() || tipo_sangue.length() < 2 || tipo_sangue.length() > 2) {
											return ("Senha inválida!");
										} else
											if(regiao.isEmpty() || regiao.length() < 2) {
												return ("Senha inválida!");
											} else
												if(peso < 50) {
													return ("Senha inválida!");
												} else
													if(sangue == false || rim == false || figado == false || medula == false || pulmao == false || pancreas == false) {
														return ("Senha inválida!");
													}
		
		ReceptorComum receptorC = new ReceptorComum(email, senha, nome, sobrenome, dt_nasc, cpf, tel, celular, peso, tipo_sangue, sangue, rim, figado, medula, pulmao, pancreas, ativo, regiao, endereco);
		
		return ("Cadastro realizado com sucesso!");
	}
	
}
