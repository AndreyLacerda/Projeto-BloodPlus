package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchPessoaInst;
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
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (doador.isMedula() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("medula", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Medula Óssea");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (doador.isRim() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("rim", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Rim");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (doador.isPulmao() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("pulmao", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Pulmão");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (doador.isPancreas() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor("pancreas", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Pâncreas");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (doador.isSangue() == true) {
			ResultSet rs = CRUDReceptorJuridico.selectReceptor2("sangue", "1", "main_tipo_sangue", doador.getTipo_sangue());
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(doador.getEmail() ,rs.getString(1), "Sangue");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
	}
	
	public static void criarMatchReceptor(ReceptorJuridico receptor) throws SQLException {
		if (receptor.isFigado() == true) {
			ResultSet rs = CRUDDoador.selectDoador("figado", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Fígado");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (receptor.isMedula() == true) {
			ResultSet rs = CRUDDoador.selectDoador("medula", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Medula Óssea");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (receptor.isRim() == true) {
			ResultSet rs = CRUDDoador.selectDoador("rim", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Rim");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (receptor.isPulmao() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pulmao", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Pulmão");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (receptor.isPancreas() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pancreas", "1");
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Pâncreas");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
		if (receptor.isSangue() == true) {
			ResultSet rs = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getMain_tipo_sangue());
			while (rs.next() == true) {
				MatchPessoaInst match = new MatchPessoaInst(rs.getString(1), receptor.getEmail(), "Sangue");
				CRUDMatchPessoaInst.inserirMatchPessoaInst(match);
			}
			rs.close();
		}
	}
}
