package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainScreenController {
	@FXML
	private Hyperlink cadastro;
	
	@FXML
	private Button login;
	
	@FXML
	private Label error;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField pass;
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> users;
	
	@FXML
	public void initialize(){
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
	
	public void setErr(String valor) {
		error.setText(valor);
		error.setTextFill(Color.web("#4bb117"));
	}
	
	public void Login(ActionEvent event) throws SQLException, IOException {
		String user = users.getValue();
		if (user.equals("Doador")) {
			ResultSet rs = CRUDDoador.loginDoador(email.getText(), pass.getText());
			if (rs.next() == false) {
				error.setText("Email ou senha inválidos");
				rs.close();
			} else {
				Stage stage = (Stage) login.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
				TelaUserController telaUser = (TelaUserController)loader.getController();
				telaUser.setResultSetLabelType(rs, "Doador");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			}
		}
		else
			if (user.equals("Receptor")) {
				ResultSet rs = CRUDReceptorComum.loginReceptor(email.getText(), pass.getText());
				if(rs.next() == false) {
					error.setText("Email ou senha inválidos");
					rs.close();
				} else {
					Stage stage = (Stage) login.getScene().getWindow();
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
					TelaUserController telaUser = (TelaUserController)loader.getController();
					telaUser.setResultSetLabelType(rs, "Receptor");
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.show();
				}
			}
			else
				if (user.equals("Instituição")) {
					ResultSet rs = CRUDReceptorJuridico.loginReceptor(email.getText(), pass.getText());
					if(rs.next() == false) {
						error.setText("Email ou senha inválidos");
						rs.close();
					} else {
						Stage stage = (Stage) login.getScene().getWindow();
						FXMLLoader loader = new FXMLLoader();
						Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
						TelaUserController telaUser = (TelaUserController)loader.getController();
						telaUser.setResultSetLabelType(rs, "Instituição");
						Scene scene = new Scene(root);
						stage.setScene(scene);
						stage.setResizable(false);
						stage.show();
					}
				}
				else
					System.out.println("Ocorreu um erro. Por favor tente novamente mais tarde.");
	}
	
	public void cadastro(ActionEvent event) throws IOException {
		Stage stage = (Stage) cadastro.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("PreCadastro.fxml"));
		PreCadastroController preCadastro = (PreCadastroController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
