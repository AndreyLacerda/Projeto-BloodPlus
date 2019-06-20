package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
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
	
	private ResultSet user;
	
	private String type;
	
	public void setResultSetLabelType(ResultSet  rs, String tipo) throws SQLException {
		user = rs;
		mensagem.setText("Ol�, "+user.getString(3)+"!");
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
			if (type.equals("Institui��o")) {
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
	
}
