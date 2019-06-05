package br.edu.ifsp.aluno.bd2a3.factories;

import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class ReceptorJuridicoFactory {

	public static String getReceptorJuridico(String email, String senha, String nome_institui��o, String cNPJ, String tel1, String tel2,
			String regiao, String endereco, boolean sangue, boolean rim, boolean figado, boolean medula, boolean pulmao,
			boolean pancreas, boolean ativo, String main_tipo_sangue) {
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8) {
			return ("Senha inv�lida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty()) {
				return ("Senha inv�lida!");
			} else
				if(nome_institui��o.isEmpty() || nome_institui��o.length() < 2) {
					return ("Senha inv�lida!");
				} else
					if(cNPJ.isEmpty() || cNPJ.length() < 17 || cNPJ.length() > 18) {
						return ("Senha inv�lida!");
					} else
						if(tel1.isEmpty() || tel1.length() < 7 || tel1.length() > 8) {
							return ("Senha inv�lida!");
						} else
							if(tel2.isEmpty() || tel2.length() < 7 || tel2.length() > 8) {
								return ("Senha inv�lida!");
							} else
								if(regiao.isEmpty() || regiao.length() < 2) {
									return ("Senha inv�lida!");
								} else
									if(endereco.isEmpty() || endereco.length() < 7) {
										return ("Senha inv�lida!");
									} else 
										if(sangue == false || rim == false || figado == false || medula == false || pulmao == false || pancreas == false) {
											return ("Senha inv�lida!");
										}
		
		ReceptorJuridico receptorJ = new ReceptorJuridico(email, senha, nome_institui��o, cNPJ, tel1, tel2, regiao, endereco, rim, figado, medula, pulmao, pancreas, ativo, sangue, main_tipo_sangue);
		
		return ("Cadastro realizado com sucesso!");
		
	}
	
}
