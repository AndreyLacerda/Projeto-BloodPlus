package br.edu.ifsp.aluno.bd2a3.matchs;

import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class MatchComum {
	
	private String email_doador;
	private String email_receptor;
	private String doacao, motivo;
	private boolean fracasso, sucesso, cancelada, finalizada;
	
	public MatchComum(String doador, String receptor, String doacao) {
		super();
		this.email_doador = doador;
		this.email_receptor = receptor;
		this.doacao = doacao;
	}

	public String getDoador() {
		return email_doador;
	}

	public String getReceptor() {
		return email_receptor;
	}

	public String getDoacao() {
		return doacao;
	}

	public void setDoacao(String doacao) {
		this.doacao = doacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public boolean isFracasso() {
		return fracasso;
	}

	public void setFracasso(boolean fracasso) {
		this.fracasso = fracasso;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
}
