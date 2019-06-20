package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchPessoaInst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
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
	
	private ResultSet user;
	
	private String type;
	
	public void setResultSetLabelType(ResultSet  rs, String tipo) throws SQLException {
		user = rs;
		mensagem.setText("Olá, "+user.getString(3)+"!");
		type = tipo;
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
			if (matchs1 == null && matchs2==null) {
				matchMessage.setText("Você ainda não possui matchs");
			} else {
				
			}
		} else {
			if (type.equals("Receptor")) {
				ResultSet matchs = CRUDMatchComum.selectMatchComum("email_receptor", user.getString(1));
				if (matchs == null) {
					matchMessage.setText("Você ainda não possui matchs");
				} else {
					
				}
			} else {
				if (type.equals("Instituição")) {
					ResultSet matchs = CRUDMatchPessoaInst.selectMatchPessoaInst("email_receptor", user.getString(1));
					if (matchs == null) {
						matchMessage.setText("Você ainda não possui matchs");
					} else {
						
					}
				}
			}
		}
	}
	
}
