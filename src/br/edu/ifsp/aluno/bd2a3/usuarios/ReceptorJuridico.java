package br.edu.ifsp.aluno.bd2a3.usuarios;

public class ReceptorJuridico {
	
	private String email, senha, nome_instituição, CNPJ;
	private String tel1, tel2, regiao, endereco;
	private boolean sangue, rim, figado, medula, pulmao, pancreas, ativo;
	
	public ReceptorJuridico(String email, String senha, String nome_instituição, String cNPJ, String tel1, String tel2,
			String regiao, String endereco, boolean sangue, boolean rim, boolean figado, boolean medula, boolean pulmao,
			boolean pancreas, boolean ativo) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome_instituição = nome_instituição;
		CNPJ = cNPJ;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.regiao = regiao;
		this.endereco = endereco;
		this.sangue = sangue;
		this.rim = rim;
		this.figado = figado;
		this.medula = medula;
		this.pulmao = pulmao;
		this.pancreas = pancreas;
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome_instituição() {
		return nome_instituição;
	}

	public void setNome_instituição(String nome_instituição) {
		this.nome_instituição = nome_instituição;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isSangue() {
		return sangue;
	}

	public void setSangue(boolean sangue) {
		this.sangue = sangue;
	}

	public boolean isRim() {
		return rim;
	}

	public void setRim(boolean rim) {
		this.rim = rim;
	}

	public boolean isFigado() {
		return figado;
	}

	public void setFigado(boolean figado) {
		this.figado = figado;
	}

	public boolean isMedula() {
		return medula;
	}

	public void setMedula(boolean medula) {
		this.medula = medula;
	}

	public boolean isPulmao() {
		return pulmao;
	}

	public void setPulmao(boolean pulmao) {
		this.pulmao = pulmao;
	}

	public boolean isPancreas() {
		return pancreas;
	}

	public void setPancreas(boolean pancreas) {
		this.pancreas = pancreas;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void trocarSenha(String nova_senha) {
		if (nova_senha.contains(" ") || nova_senha.isEmpty() || nova_senha.length() < 8) {
			System.out.println("Valor de Senha inválido!");
		} else {
			this.setSenha(nova_senha);
			System.out.println("Senha alterada com sucesso!");
		}
	}
	
	public void trocarEmail(String novo_email) {
		if (novo_email.contains("@")) {
			this.setEmail(novo_email);
			System.out.println("E-mail alterado com sucesso!");
		}else
			System.out.println("Valor de e-mail inválido");
	}
}
