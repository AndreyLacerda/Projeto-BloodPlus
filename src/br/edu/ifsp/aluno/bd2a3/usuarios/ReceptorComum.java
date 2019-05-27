package br.edu.ifsp.aluno.bd2a3.usuarios;

public class ReceptorComum {
	
	private String email, senha, nome, sobrenome, dt_nasc;
	private String tel, celular;
	private float peso;
	private String tipo_sangue, necessidade;
	private boolean ativo, prime_vez;
	private String regiao, endereco;
	
	public ReceptorComum(String email, String senha, String nome, String sobrenome, String dt_nasc, String tel,
			String celular, float peso, String tipo_sangue, String necessidade, boolean ativo, boolean prime_vez,
			String regiao, String endereco) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dt_nasc = dt_nasc;
		this.tel = tel;
		this.celular = celular;
		this.peso = peso;
		this.tipo_sangue = tipo_sangue;
		this.necessidade = necessidade;
		this.ativo = ativo;
		this.prime_vez = prime_vez;
		this.regiao = regiao;
		this.endereco = endereco;
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getTipo_sangue() {
		return tipo_sangue;
	}
	public void setTipo_sangue(String tipo_sangue) {
		this.tipo_sangue = tipo_sangue;
	}
	public String getNecessidade() {
		return necessidade;
	}
	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isPrime_vez() {
		return prime_vez;
	}
	public void setPrime_vez(boolean prime_vez) {
		this.prime_vez = prime_vez;
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
}