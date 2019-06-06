package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainScreenController {
	@FXML
	private Hyperlink cadastro;
	
	@FXML
	private Label error;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField pass;
	
	ObservableList list = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> users;
	
	@FXML
	private void initialize(){
		loadData();
		users.setValue("Doador");
	}
	
	private void loadData() {
		list.removeAll(list);
		String a = "Doador";
		String b = "Receptor";
		String c = "Instituição";
		list.addAll(a, b, c);
		users.getItems().addAll(list);
	}
	
	public void Login(ActionEvent event) throws SQLException {
		String user = users.getValue();
		if (user.equals("Doador")) {
			if (CRUDDoador.loginDoador(email.getText(), pass.getText()).next() == false) {
				error.setText("Email ou senha inválidos");
			}
		}
		else
			if (user.equals("Receptor")) {
				if(CRUDReceptorComum.loginReceptor(email.getText(), pass.getText()).next() == false) {
					error.setText("Email ou senha inválidos");
				}
			}
			else
				if (user.equals("Instituição")) {
					if(CRUDReceptorJuridico.loginReceptor(email.getText(), pass.getText()).next() == false) {
						error.setText("Email ou senha inválidos");
					}
				}
				else
					System.out.println("Deu ruim!");
	}
	
	public void cadastro(ActionEvent event) throws IOException {
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("PreCadastro.fxml"));
		PreCadastroController preCadastro = (PreCadastroController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
