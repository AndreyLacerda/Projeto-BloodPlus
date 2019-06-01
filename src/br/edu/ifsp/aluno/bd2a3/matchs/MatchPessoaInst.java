package br.edu.ifsp.aluno.bd2a3.matchs;

import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class MatchPessoaInst {
	
	private Doador doador;
	private ReceptorJuridico receptor;
	private String doacao, motivo;
	private boolean fracasso, sucesso, cancelada, finalizada;
	
	public MatchPessoaInst(Doador doador, ReceptorJuridico receptor, String doacao) {
		super();
		this.doador = doador;
		this.receptor = receptor;
		this.doacao = doacao;
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

	public Doador getDoador() {
		return doador;
	}

	public ReceptorJuridico getReceptor() {
		return receptor;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
}
