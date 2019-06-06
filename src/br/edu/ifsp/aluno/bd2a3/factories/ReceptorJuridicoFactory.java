package br.edu.ifsp.aluno.bd2a3.factories;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class ReceptorJuridicoFactory {

	public static String getReceptorJuridico(String email, String senha, String nome_instituição, String cNPJ, String tel1, String tel2,
			String regiao, String endereco, boolean sangue, boolean rim, boolean figado, boolean medula, boolean pulmao,
			boolean pancreas, boolean ativo, String main_tipo_sangue) {
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8) {
			return ("Senha inválida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty()) {
				return ("Email inválido!");
			} else
				if(nome_instituição.isEmpty() || nome_instituição.length() < 2) {
					return ("Nome inválido!");
				} else
					if(cNPJ.isEmpty() || cNPJ.length() < 17 || cNPJ.length() > 18) {
						return ("CNPJ inválido!");
					} else
						if(tel1.isEmpty() || tel1.length() < 7 || tel1.length() > 8) {
							return ("Telefone 1 inválido!");
						} else
							if(tel2.isEmpty() || tel2.length() < 7 || tel2.length() > 8) {
								return ("Telefone 2 inválido!");
							} else
								if(regiao.isEmpty() || regiao.length() < 2) {
									return ("Região inválida!");
								} else
									if(endereco.isEmpty() || endereco.length() < 7) {
										return ("Endereço inválida!");
									} else 
										if(sangue == false || rim == false || figado == false || medula == false || pulmao == false || pancreas == false) {
											return ("Pedido inválido!");
										} else {
											ReceptorJuridico receptorJ = new ReceptorJuridico(email, senha, nome_instituição, cNPJ, tel1, tel2, regiao, endereco, rim, figado, medula, pulmao, pancreas, ativo, sangue, main_tipo_sangue);
											boolean result = CRUDReceptorJuridico.inserirReceptor(receptorJ);
											if (result == true)
												return ("Cadastro realizado com sucesso!");
											else
												return ("Error ao Cadastrar Usuário");
										}

		
	}
	
}
