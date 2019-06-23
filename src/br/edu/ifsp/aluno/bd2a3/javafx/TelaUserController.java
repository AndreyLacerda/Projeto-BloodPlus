package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchPessoaInst;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaUserController {
	
	@FXML
	public Button logout;
	
	@FXML
	public Button config;
	
	@FXML
	public Label mensagem;
	
	@FXML
	public Label matchMessage;
	
	@FXML
	public AnchorPane areaMatchs;
	
	private ResultSet user;
	
	private String type;
	
	public void setResultSetLabelType(ResultSet  rs, String tipo) throws SQLException {
		user = rs;
		mensagem.setText("Olá, "+user.getString(3)+"!");
		type = tipo;
		//setarMatchs();
	}
	
	public void config(ActionEvent event) throws IOException, SQLException {
		if (type.equals("Doador") || type.equals("Receptor")) {
			Stage stage = (Stage) config.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			ScrollPane root = loader.load(getClass().getResource("TelaConfig.fxml").openStream());
			TelaConfigController telaConfig = (TelaConfigController)loader.getController();
			telaConfig.setResultSetType(user, type);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} else {
			if (type.equals("Instituição")) {
				Stage stage = (Stage) config.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				ScrollPane root = loader.load(getClass().getResource("TelaConfigInst.fxml").openStream());
				TelaConfigControllerInst telaConfig = (TelaConfigControllerInst)loader.getController();
				telaConfig.setResultSet(user);
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			}
		}
	}
	
	public void logout(ActionEvent event) throws IOException, SQLException {
		user.close();
		Stage stage = (Stage) logout.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml"));
		MainScreenController main = (MainScreenController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void setarMatchs() throws SQLException {
		if (type.equals("Doador")) {
			ResultSet matchs1 = CRUDMatchComum.selectMatchComum("email_doador", user.getString(1));
			ResultSet matchs2 = CRUDMatchPessoaInst.selectMatchPessoaInst("email_doador", user.getString(1));
			if (matchs1.getString(1) == null && matchs2.getString(1) == null) {
				matchMessage.setText("Você ainda não possui matchs");
			} else {
				while(matchs1.getString(1) != null) {
					ResultSet receptor = CRUDReceptorComum.selectReceptor3("email", matchs1.getString(2));
					Label doadorLabel = new Label(user.getString(3)+" "+user.getString(4));	
					Label receptorLabel = new Label(receptor.getString(3)+" "+receptor.getString(4));
					Label doacaoLabel = new Label(matchs1.getString(3));
					areaMatchs.getChildren().addAll(doadorLabel, receptorLabel, doacaoLabel);
					matchs1.next();
				}
				matchs1.close();
				while(matchs2.getString(1) != null) {
					ResultSet receptor = CRUDReceptorJuridico.selectReceptor3("email", matchs2.getString(2));
					Label doadorLabel = new Label(user.getString(3)+" "+user.getString(4));
					Label receptorLabel = new Label(receptor.getString(3));
					Label doacaoLabel = new Label(matchs2.getString(3));
					areaMatchs.getChildren().addAll(doadorLabel, receptorLabel, doacaoLabel);
					matchs2.next();
				}
				matchs2.close();
			}
		} else {
			if (type.equals("Receptor")) {
				ResultSet matchs = CRUDMatchComum.selectMatchComum("email_receptor", user.getString(1));
				if (matchs == null) {
					matchMessage.setText("Você ainda não possui matchs");
				} else {
					while(matchs.next()) {
						ResultSet doador = CRUDDoador.selectDoador3("email", matchs.getString(1));
						Label receptorLabel = new Label(user.getString(3)+" "+user.getString(4));	
						Label doadorLabel = new Label(doador.getString(3)+" "+doador.getString(4));
						Label doacaoLabel = new Label(matchs.getString(3));
						areaMatchs.getChildren().addAll(doadorLabel, receptorLabel, doacaoLabel);
						doador.close();
						matchs.next();
					}
					matchs.close();
				}
			} else {
				if (type.equals("Instituição")) {
					ResultSet matchs = CRUDMatchPessoaInst.selectMatchPessoaInst("email_receptorJuridico", user.getString(1));
					if (matchs == null) {
						matchMessage.setText("Você ainda não possui matchs");
					} else {
						while(matchs != null) {
							ResultSet doador = CRUDDoador.selectDoador3("email", matchs.getString(1));
							Label receptorLabel = new Label(user.getString(3));	
							Label doadorLabel = new Label(doador.getString(3)+" "+doador.getString(4));
							Label doacaoLabel = new Label(matchs.getString(3));
							areaMatchs.getChildren().addAll(doadorLabel, receptorLabel, doacaoLabel);
							doador.close();
							matchs.next();
						}
						matchs.close();
					}
				}
			}
		}
	}
	
}
