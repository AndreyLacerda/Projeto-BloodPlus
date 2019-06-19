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
			rs.close();
		}
		if (doador.isMedula() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("medula", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Medula Óssea");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (doador.isRim() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("rim", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Rim");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (doador.isPulmao() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("pulmao", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Pulmão");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (doador.isPancreas() == true) {
			ResultSet rs = CRUDReceptorComum.selectReceptor("pancreas", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(doador.getEmail() ,rs.getString(1), "Páncreas");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (doador.isSangue() == true) {
			if (doador.getTipo_sangue().equals("A+")) {
				ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
				while (rs1.next() == true) {
					MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs1.close();
				ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
				while (rs2.next() == true) {
					MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs2.close();
			} else {
				if (doador.getTipo_sangue().equals("A-")) {
					ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
					while (rs1.next() == true) {
						MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs1.close();
					ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
					while (rs2.next() == true) {
						MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs2.close();
					ResultSet rs3 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "A+");
					while (rs3.next() == true) {
						MatchComum match = new MatchComum(doador.getEmail() ,rs3.getString(1), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs3.close();
					ResultSet rs4 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB-");
					while (rs4.next() == true) {
						MatchComum match = new MatchComum(doador.getEmail() ,rs4.getString(1), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs4.close();
				} else {
					if (doador.getTipo_sangue().equals("B+")) {
						ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
						while (rs1.next() == true) {
							MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
							CRUDMatchComum.inserirMatchComum(match);
						}
						rs1.close();
						ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
						while (rs2.next() == true) {
							MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
							CRUDMatchComum.inserirMatchComum(match);
						}
						rs2.close();
					} else {
						if (doador.getTipo_sangue().equals("B-")) {
							ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
							while (rs1.next() == true) {
								MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs1.close();
							ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
							while (rs2.next() == true) {
								MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs2.close();
							ResultSet rs3 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "B+");
							while (rs3.next() == true) {
								MatchComum match = new MatchComum(doador.getEmail() ,rs3.getString(1), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs3.close();
							ResultSet rs4 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB-");
							while (rs4.next() == true) {
								MatchComum match = new MatchComum(doador.getEmail() ,rs4.getString(1), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs4.close();
						} else {
							if (doador.getTipo_sangue().equals("AB+")) {
								ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
								while (rs1.next() == true) {
									MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
									CRUDMatchComum.inserirMatchComum(match);
								}
								rs1.close();
							} else {
								if (doador.getTipo_sangue().equals("AB-")) {
									ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
									while (rs1.next() == true) {
										MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs1.close();
									ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
									while (rs2.next() == true) {
										MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs2.close();
								} else {
									if (doador.getTipo_sangue().equals("O+")) {
										ResultSet rs1 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", doador.getTipo_sangue());
										while (rs1.next() == true) {
											MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs1.close();
										ResultSet rs2 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "AB+");
										while (rs2.next() == true) {
											MatchComum match = new MatchComum(doador.getEmail() ,rs2.getString(1), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs2.close();
										ResultSet rs3 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "A+");
										while (rs3.next() == true) {
											MatchComum match = new MatchComum(doador.getEmail() ,rs3.getString(1), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs3.close();
										ResultSet rs4 = CRUDReceptorComum.selectReceptor2("sangue", "1", "tipo_sangue", "B+");
										while (rs4.next() == true) {
											MatchComum match = new MatchComum(doador.getEmail() ,rs4.getString(1), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs4.close();
									} else {
										if (doador.getTipo_sangue().equals("O-")) {
											ResultSet rs1 = CRUDReceptorComum.selectReceptor("sangue", "1");
											while (rs1.next() == true) {
												MatchComum match = new MatchComum(doador.getEmail() ,rs1.getString(1), "Sangue");
												CRUDMatchComum.inserirMatchComum(match);
											}
											rs1.close();
										}
									}
								}
							}
						}
					}
				}
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
			rs.close();
		}
		if (receptor.isMedula() == true) {
			ResultSet rs = CRUDDoador.selectDoador("medula", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Medula Óssea");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (receptor.isRim() == true) {
			ResultSet rs = CRUDDoador.selectDoador("rim", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Rim");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (receptor.isPulmao() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pulmao", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Pulmão");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (receptor.isPancreas() == true) {
			ResultSet rs = CRUDDoador.selectDoador("pancreas", "1");
			while (rs.next() == true) {
				MatchComum match = new MatchComum(rs.getString(1), receptor.getEmail(), "Pâncreas");
				CRUDMatchComum.inserirMatchComum(match);
			}
			rs.close();
		}
		if (receptor.isSangue() == true) {
			if (receptor.getTipo_sangue().equals("A+")) {
				ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
				while (rs1.next() == true) {
					MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs1.close();
				ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "A-");
				while (rs2.next() == true) {
					MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs2.close();
				ResultSet rs3 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O+");
				while (rs3.next() == true) {
					MatchComum match = new MatchComum(rs3.getString(1), receptor.getEmail(), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs3.close();
				ResultSet rs4 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
				while (rs4.next() == true) {
					MatchComum match = new MatchComum(rs4.getString(1), receptor.getEmail(), "Sangue");
					CRUDMatchComum.inserirMatchComum(match);
				}
				rs4.close();
			} else {
				if (receptor.getTipo_sangue().equals("A-")) {
					ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
					while (rs1.next() == true) {
						MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs1.close();
					ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
					while (rs2.next() == true) {
						MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
						CRUDMatchComum.inserirMatchComum(match);
					}
					rs2.close();
				} else {
					if (receptor.getTipo_sangue().equals("B-")) {
						ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
						while (rs1.next() == true) {
							MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
							CRUDMatchComum.inserirMatchComum(match);
						}
						rs1.close();
						ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
						while (rs2.next() == true) {
							MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
							CRUDMatchComum.inserirMatchComum(match);
						}
						rs2.close();
					} else {
						if (receptor.getTipo_sangue().equals("B+")) {
							ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
							while (rs1.next() == true) {
								MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs1.close();
							ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "B-");
							while (rs2.next() == true) {
								MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs2.close();
							ResultSet rs3 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O+");
							while (rs3.next() == true) {
								MatchComum match = new MatchComum(rs3.getString(1), receptor.getEmail(), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs3.close();
							ResultSet rs4 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
							while (rs4.next() == true) {
								MatchComum match = new MatchComum(rs4.getString(1), receptor.getEmail(), "Sangue");
								CRUDMatchComum.inserirMatchComum(match);
							}
							rs4.close();
						} else {
							if (receptor.getTipo_sangue().equals("AB+")) {
								ResultSet rs1 = CRUDDoador.selectDoador("sangue", "1");
								while (rs1.next() == true) {
									MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
									CRUDMatchComum.inserirMatchComum(match);
								}
								rs1.close();
							} else {
								if (receptor.getTipo_sangue().equals("AB-")) {
									ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
									while (rs1.next() == true) {
										MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs1.close();
									ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "A-");
									while (rs2.next() == true) {
										MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs2.close();
									ResultSet rs3 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "B-");	
									while (rs3.next() == true) {
										MatchComum match = new MatchComum(rs3.getString(1), receptor.getEmail(), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs3.close();
									ResultSet rs4 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
									while (rs4.next() == true) {
										MatchComum match = new MatchComum(rs4.getString(1), receptor.getEmail(), "Sangue");
										CRUDMatchComum.inserirMatchComum(match);
									}
									rs4.close();
								} else {
									if (receptor.getTipo_sangue().equals("O+")) {
										ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
										while (rs1.next() == true) {
											MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs1.close();
										ResultSet rs2 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", "O-");
										while (rs2.next() == true) {
											MatchComum match = new MatchComum(rs2.getString(1), receptor.getEmail(), "Sangue");
											CRUDMatchComum.inserirMatchComum(match);
										}
										rs2.close();
									} else {
										if (receptor.getTipo_sangue().equals("O-")) {
											ResultSet rs1 = CRUDDoador.selectDoador2("sangue", "1", "tipo_sangue", receptor.getTipo_sangue());
											while (rs1.next() == true) {
												MatchComum match = new MatchComum(rs1.getString(1), receptor.getEmail(), "Sangue");
												CRUDMatchComum.inserirMatchComum(match);
											}
											rs1.close();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}