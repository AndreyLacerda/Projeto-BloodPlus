package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PreCadastroController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void doadorEvento(ActionEvent event) {
		
	}
	
	public void receptorEvento(ActionEvent event) {
		
	}

	public void instEvento(ActionEvent event) {
	
	}
	
	public void mainScreen(ActionEvent event) throws IOException {
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
