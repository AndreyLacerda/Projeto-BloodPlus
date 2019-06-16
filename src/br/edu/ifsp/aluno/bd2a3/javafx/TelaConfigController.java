package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaConfigController {
	
	@FXML
	public Button salvar;
	
	@FXML
	public Button voltar;
	
	@FXML
	public Label mensagem;
	
	private ResultSet user;
	
	@FXML
	public void initialize(){
	}
	
	public void salvarAlteracoes(ActionEvent event) {
		
	}
	
	public void voltar(ActionEvent event) throws IOException {
		Stage stage = (Stage) voltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaUser.fxml"));
		TelaUserController telaUser = (TelaUserController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
