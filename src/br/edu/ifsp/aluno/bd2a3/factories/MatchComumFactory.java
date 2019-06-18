package br.edu.ifsp.aluno.bd2a3.factories;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.matchs.MatchComum;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;

public class MatchComumFactory {
	
	public static void criarMatchDoador(Doador doador) throws SQLException {
		if (doador.isFigado() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("figado", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Fígado");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (doador.isMedula() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("medula", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Medula Óssea");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (doador.isRim() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("rim", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Rim");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (doador.isPulmao() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("pulmao", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Pulmão");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (doador.isPancreas() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("pancreas", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Páncreas");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (doador.isSangue() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Sangue");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
	}
	
	public static void criarMatchReceptor(ReceptorComum receptor) throws SQLException {
		if (receptor.isFigado() == true) {
			ResultSet rs = CRUDDoador.selectDoador("figado", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Fígado");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (receptor.isMedula() == true) {
			ResultSet rs = CRUDDoador.selectDoador("medula", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Medula Óssea");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (receptor.isRim() == true) {
			ResultSet rs = CRUDDoador.selectDoador("rim", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Rim");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (receptor.isPulmao() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pulmao", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Pulmão");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (receptor.isPancreas() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pancreas", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Pâncreas");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
		if (receptor.isSangue() == true) {
			ResultSet rs = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Sangue");
				CRUDMatchComum.inserirMatchComum(match);
			}
		}
	}

}
