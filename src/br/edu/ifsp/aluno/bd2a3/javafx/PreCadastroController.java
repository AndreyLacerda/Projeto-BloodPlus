package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PreCadastroController {
	
	@FXML
	public Button doador;
	
	@FXML
	public Button receptor;
	
	@FXML
	public Button insti;
	
	@FXML
	public Button voltar;
	
	public void doadorEvento(ActionEvent event) throws IOException {
		Stage stage = (Stage) doador.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		ScrollPane root = loader.load(getClass().getResource("CadastroUsersComuns.fxml").openStream());
		CadastroComumController cadastroComum = (CadastroComumController)loader.getController();
		cadastroComum.setLabels("Cadastro de Doador", "Procura Doar:");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void receptorEvento(ActionEvent event) throws IOException {
		Stage stage = (Stage) receptor.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		ScrollPane root = loader.load(getClass().getResource("CadastroUsersComuns.fxml").openStream());
		CadastroComumController cadastroComum = (CadastroComumController)loader.getController();
		cadastroComum.setLabels("Cadastro de Receptor", "Procura Receber:");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void instEvento(ActionEvent event) throws IOException {
		Stage stage = (Stage) insti.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		ScrollPane root = loader.load(getClass().getResource("CadastroUserInst.fxml").openStream());
		CadastroComumController cadastroComum = (CadastroComumController)loader.getController();
		cadastroComum.setLabelInst ("Procura Receber:");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void mainScreen(ActionEvent event) throws IOException {
		Stage stage = (Stage) voltar.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml"));
		MainScreenController main = (MainScreenController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
