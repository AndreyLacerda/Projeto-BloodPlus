package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class ReceptorJuridicoFactory {

	public static String buildarReceptorJuridico(String email, String senha, String nome_institui��o, String cNPJ, String tel1, String tel2,
			String regiao, String endereco, boolean sangue, boolean rim, boolean figado, boolean medula, boolean pulmao,
			boolean pancreas, boolean ativo, String main_tipo_sangue) throws SQLException {
		
		if (senha.contains(" ") || senha.isEmpty() || senha.length() < 8) {
			return ("Senha inv�lida!");
		} else
			if(!email.contains("@") || email.length() < 4 || email.isEmpty()) {
				return ("Email inv�lido!");
			} else
				if (CRUDReceptorJuridico.selectReceptor3("email", email).next() == true) {
					return ("Email J� Cadastrado!");
				} else
					if(nome_institui��o.isEmpty() || nome_institui��o.length() < 2) {
						return ("Nome inv�lido!");
					} else
						if(cNPJ.isEmpty() || cNPJ.length() < 17 || cNPJ.length() > 18) {
							return ("CNPJ inv�lido!");
						} else
							if(tel1.isEmpty() || tel1.length() < 8 || tel1.length() > 10) {
								return ("Telefone 1 inv�lido!");
							} else
								if(tel2.isEmpty() || tel2.length() < 8 || tel2.length() > 10) {
									return ("Telefone 2 inv�lido!");
								} else
									if(regiao.isEmpty() || regiao.length() < 3) {
										return ("Regi�o inv�lida!");
									} else
										if(endereco.isEmpty() || endereco.length() < 7) {
											return ("Endere�o inv�lida!");
										} else 
											if(sangue == false && rim == false && figado == false && medula == false && pulmao == false && pancreas == false) {
												return ("Pedido inv�lido!");
											} else {
												ReceptorJuridico receptorJ = new ReceptorJuridico(email, senha, nome_institui��o, cNPJ, tel1, tel2, regiao, endereco, sangue, rim, figado, medula, pulmao, pancreas, ativo, main_tipo_sangue);
												boolean result = CRUDReceptorJuridico.inserirReceptor(receptorJ);
												if (result == true) {
													MatchInstFactory.criarMatchReceptor(receptorJ);
													return ("Cadastro realizado com sucesso!");
												}
												else
													return ("Error ao Cadastrar Usu�rio");
											}		
	}
}
