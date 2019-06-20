package br.edu.ifsp.aluno.bd2a3.usuarios;

public class Doador {
	
	private String email, senha, nome, sobrenome, dt_nasc, cpf;
	private String tel, celular, tipo_sangue, regiao, endereco; 
	private float peso;
	private boolean sangue, rim, figado, medula, pulmao, pancreas, ativo;
	
	public Doador(String email, String senha, String nome, String sobrenome, String dt_nasc, String cpf, String tel, String celular,
			String tipo_sangue, String regiao, String endereco, float peso, boolean sangue, boolean rim, boolean figado,
			boolean medula, boolean pulmao, boolean pancreas, boolean ativo) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dt_nasc = dt_nasc;
		this.cpf = cpf;
		this.tel = tel;
		this.celular = celular;
		this.tipo_sangue = tipo_sangue;
		this.regiao = regiao;
		this.endereco = endereco;
		this.peso = peso;
		this.sangue = sangue;
		this.rim = rim;
		this.figado = figado;
		this.medula = medula;
		this.pulmao = pulmao;
		this.pancreas = pancreas;
		this.ativo = ativo;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTipo_sangue() {
		return tipo_sangue;
	}
	public void setTipo_sangue(String tipo_sangue) {
		this.tipo_sangue = tipo_sangue;
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
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
}
