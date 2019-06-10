package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import br.edu.ifsp.aluno.bd2a3.matchs.MatchPessoaInst;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;

public class MatchInstFactory {
	
	public static void criarMatchDoador(Doador doador) throws SQLException {
		if (doador.isFigado() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("figado", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Fígado");
			}
		}
		if (doador.isMedula() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("medula", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Medula Óssea");
			}
		}
		if (doador.isRim() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("rim", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Rim");
			}
		}
		if (doador.isPulmao() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("pulmao", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Pulmão");
			}
		}
		if (doador.isPancreas() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("pancreas", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Pâncreas");
			}
		}
		if (doador.isSangue() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Sangue");
			}
		}
	}
	
	public static void criarMatchReceptor(ReceptorJuridico receptor) throws SQLException {
		if (receptor.isFigado() == true) {
			ResultSet rs = CRUDDoador.selectDoador("figado", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Fígado");
			}
		}
		if (receptor.isMedula() == true) {
			ResultSet rs = CRUDDoador.selectDoador("medula", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Medula Óssea");
			}
		}
		if (receptor.isRim() == true) {
			ResultSet rs = CRUDDoador.selectDoador("rim", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Rim");
			}
		}
		if (receptor.isPulmao() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pulmao", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Pulmão");
			}
		}
		if (receptor.isPancreas() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pancreas", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Pâncreas");
			}
		}
		if (receptor.isSangue() == true) {
			ResultSet rs = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getMain_tipo_sangue());
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Sangue");
			}
		}
	}
}
