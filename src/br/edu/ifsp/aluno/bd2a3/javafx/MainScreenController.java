package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	@FXML
	private ImageView logo;
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> users;
	
	@FXML
	public void initialize(){
		logo.setImage(new Image(getClass().getResourceAsStream("/logo.png"), 229, 186, false, false));
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
				error.setTextFill(Color.web("c30f0f"));
				rs.close();
			} else {
				Doador doador = new Doador (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(19), rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(16), rs.getString(17), Float.parseFloat(rs.getString(8)), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getBoolean(15), true);
				rs.close();
				Stage stage = (Stage) login.getScene().getWindow();
				stage.setTitle("Blood+");
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
				TelaUserController telaUser = (TelaUserController)loader.getController();
				telaUser.setResultSetLabelType(doador, null, null, "Doador");
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
					error.setTextFill(Color.web("c30f0f"));
					rs.close();
				} else {
					ReceptorComum receptor = new ReceptorComum (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13), rs.getString(6), rs.getString(7), Float.parseFloat(rs.getString(8)), rs.getString(9), rs.getBoolean(12), rs.getBoolean(16), rs.getBoolean(15), rs.getBoolean(18), rs.getBoolean(14), rs.getBoolean(17), true, rs.getString(10), rs.getString(19));
					rs.close();
					Stage stage = (Stage) login.getScene().getWindow();
					stage.setTitle("Blood+");
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
					TelaUserController telaUser = (TelaUserController)loader.getController();
					telaUser.setResultSetLabelType(null, receptor, null, "Receptor");
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.show();
				}
			}
			else
				if (user.equals("Instituição")) {
					if(email.getText() != null && pass.getText() != null) {
						ResultSet rs = CRUDReceptorJuridico.loginReceptor(email.getText(), pass.getText());
						if(rs.next() == false) {
							error.setText("Email ou senha inválidos");
							error.setTextFill(Color.web("c30f0f"));
							rs.close();
						} else {
							ReceptorJuridico receptor = new ReceptorJuridico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), true, rs.getString(16));
							rs.close();
							Stage stage = (Stage) login.getScene().getWindow();
							stage.setTitle("Blood+");
							FXMLLoader loader = new FXMLLoader();
							Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
							TelaUserController telaUser = (TelaUserController)loader.getController();
							telaUser.setResultSetLabelType(null, null, receptor, "Instituição");
							Scene scene = new Scene(root);
							stage.setScene(scene);
							stage.setResizable(false);
							stage.show();
						}
					}
					else
						System.out.println("Ocorreu um erro. Por favor tente novamente mais tarde.");
				} else {
					error.setText("Por favor insira os dados!");
					error.setTextFill(Color.web("c30f0f"));
				}
	}
	
	public void cadastro(ActionEvent event) throws IOException {
		Stage stage = (Stage) cadastro.getScene().getWindow();
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("PreCadastro.fxml"));
		PreCadastroController preCadastro = (PreCadastroController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
