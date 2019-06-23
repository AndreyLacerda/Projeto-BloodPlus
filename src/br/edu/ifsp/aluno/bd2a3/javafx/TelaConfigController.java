package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDDoador;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchComum;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchPessoaInst;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorComum;
import br.edu.ifsp.aluno.bd2a3.factories.MatchComumFactory;
import br.edu.ifsp.aluno.bd2a3.factories.MatchInstFactory;
import br.edu.ifsp.aluno.bd2a3.usuarios.Doador;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorComum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaConfigController {
	
	@FXML
	public Button salvar;
	
	@FXML
	public Button excluir;
	
	@FXML
	public Button voltar;
	
	@FXML
	public Label mensagem;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField senha;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField sobrenome;
	
	@FXML
	private TextField peso;
	
	@FXML
	private TextField tel;
	
	@FXML
	private TextField cel;
	
	@FXML
	private TextArea endereco;
	
	@FXML
	private CheckBox sangue;
	
	@FXML
	private CheckBox medula;
	
	@FXML
	private CheckBox pulmao;
	
	@FXML
	private CheckBox pancreas;
	
	@FXML
	private CheckBox rim;
	
	@FXML
	private CheckBox figado;
	
	ObservableList<String> list1 = FXCollections.observableArrayList();
	
	ObservableList<String> list2 = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> regiao;
	
	@FXML
	private ChoiceBox<String> tipo_sangue;
	
	private ResultSet user;
	
	private String type;
	
	public void setResultSetType(ResultSet  rs, String tipo) throws SQLException {
		user = rs;
		type = tipo;
		setPlaceHolders();
	}
	
	private void setPlaceHolders() throws SQLException {
		email.setPromptText(user.getString(1));
		nome.setPromptText(user.getString(3));
		sobrenome.setPromptText(user.getString(4));
		tel.setPromptText(user.getString(6));
		cel.setPromptText(user.getString(7));
		peso.setPromptText(user.getString(8));
		tipo_sangue.setValue(user.getString(9));
		regiao.setValue(user.getString(16));
		endereco.setPromptText(user.getString(17));
		
		if (user.getString(10).equals("1") || user.getString(10).equals("true")) {
			sangue.setSelected(true);
		} else {
			sangue.setSelected(false);
		}
		if (user.getString(11).equals("1") || user.getString(11).equals("true")) {
			rim.setSelected(true);
		} else {
			rim.setSelected(false);
		}
		if (user.getString(12).equals("1") || user.getString(12).equals("true")) {
			figado.setSelected(true);
		} else {
			figado.setSelected(false);
		}
		if (user.getString(13).equals("1") || user.getString(13).equals("true")) {
			medula.setSelected(true);
		} else {
			medula.setSelected(false);
		}
		if (user.getString(14).equals("1") || user.getString(14).equals("true")) {
			pulmao.setSelected(true);
		} else {
			pulmao.setSelected(false);
		}
		if (user.getString(15).equals("1") || user.getString(15).equals("true")) {
			pancreas.setSelected(true);
		} else {
			pancreas.setSelected(false);
		}
	}
	
	@FXML
	public void initialize() throws SQLException {
		loadData();
		if (user != null) {
			user.close();
		}
	}
	
	private void loadData() {
		list1.removeAll(list1);
		String a = "Norte";
		String b = "Sul";
		String c = "Leste";
		String d = "Oeste";
		String e = "Centro";
		String f = "Centro-Oeste";
		String g = "Noroeste";
		String h = "Sudoeste";
		String i = "Nordeste";
		String j = "Sudeste";
		list1.addAll(a, b, c, d, e, f, g, h, i, j);
		regiao.setItems(list1);
		list2.removeAll(list2);
		a = "A+";
		b = "A-";
		c = "B+";
		d = "B-";
		e = "AB+";
		f = "AB-";
		g = "O+";
		h = "O-";
		list2.addAll(a, b, c, d, e, f, g, h);
		tipo_sangue.setItems(list2);
	}
	
	public void salvarAlteracoes(ActionEvent event) throws SQLException, IOException {
		if (type.equals("Doador")) {
			if (email.getText() != null && !email.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "email", email.getText());
			}
			if (senha.getText() != null && !senha.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "senha", senha.getText());
			}
			if (nome.getText() != null && !nome.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "nome", nome.getText());
			}
			if (sobrenome.getText() != null && !sobrenome.getText().trim().isEmpty()) {
				CRUDReceptorComum.updateReceptor(user.getString(1), "sobrenome", sobrenome.getText());
			}
			if (tel.getText() != null && !tel.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "tel", tel.getText());
			}
			if (cel.getText() != null && !cel.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "cel", cel.getText());
			}
			if (endereco.getText() != null && !endereco.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(user.getString(1), "endereco", endereco.getText());
			}
			CRUDDoador.updateDoador(user.getString(1), "regiao", regiao.getValue());
			CRUDDoador.updateDoador2(user.getString(1), "sangue", sangue.isSelected());
			CRUDDoador.updateDoador2(user.getString(1), "rim", rim.isSelected());
			CRUDDoador.updateDoador2(user.getString(1), "figado", figado.isSelected());
			CRUDDoador.updateDoador2(user.getString(1), "medula", rim.isSelected());
			CRUDDoador.updateDoador2(user.getString(1), "pulmao", pulmao.isSelected());
			CRUDDoador.updateDoador2(user.getString(1), "pancreas", pancreas.isSelected());
			String email = user.getString(1);
			user.close();
			user = CRUDDoador.selectDoador3("email", email);
			
			CRUDMatchComum.deleteMatchDoador(user.getString(1));
			CRUDMatchPessoaInst.deleteMatchDoador(user.getString(1));
			Doador doador = new Doador (user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(19), user.getString(6), user.getString(7), user.getString(9), user.getString(16), user.getString(17), Float.parseFloat(user.getString(8)), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true);
			MatchComumFactory.criarMatchDoador(doador);
			MatchInstFactory.criarMatchDoador(doador);
			
		} else {
			if (type.equals("Receptor")) {
				if (email.getText() != null && !email.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "email", email.getText());
				}
				if (senha.getText() != null && !senha.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "senha", senha.getText());
				}
				if (nome.getText() != null && !nome.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "nome", nome.getText());
				}
				if (sobrenome.getText() != null && !sobrenome.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "sobrenome", sobrenome.getText());
				}
				if (tel.getText() != null && !tel.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "tel", tel.getText());
				}
				if (cel.getText() != null && !cel.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "cel", cel.getText());
				}
				if (endereco.getText() != null && !endereco.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(user.getString(1), "endereco", endereco.getText());
				}
				CRUDReceptorComum.updateReceptor(user.getString(1), "regiao", regiao.getValue());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "sangue", sangue.isSelected());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "rim", rim.isSelected());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "figado", figado.isSelected());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "medula", rim.isSelected());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "pulmao", pulmao.isSelected());
				CRUDReceptorComum.updateReceptor2(user.getString(1), "pancreas", pancreas.isSelected());
				this.user = CRUDReceptorComum.selectReceptor3("email", user.getString(1));
				
				CRUDMatchComum.deleteMatchReceptor(user.getString(1));
				ReceptorComum receptor = new ReceptorComum (user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(13), user.getString(6), user.getString(7), Float.parseFloat(user.getString(8)), user.getString(9), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, user.getString(10), user.getString(19));
				MatchComumFactory.criarMatchReceptor(receptor);
			}
		}
		
		Stage stage = (Stage) voltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
		TelaUserController telaUser = (TelaUserController)loader.getController();
		telaUser.setResultSetLabelType(user, "Instituição");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void excluir(ActionEvent event) throws SQLException, IOException {
		if (type.equals("Doador")) {
			CRUDMatchComum.deleteMatchDoador(user.getString(1));
			CRUDMatchPessoaInst.deleteMatchDoador(user.getString(1));
			CRUDDoador.deleteDoador(user.getString(1));
			user.close();
			Stage stage = (Stage) excluir.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
			MainScreenController main = (MainScreenController)loader.getController();
			main.setErr("Obrigado por usar nosso app.Esperamos que tenha gostado!");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} else {
			if (type.equals("Receptor")) {
				CRUDMatchComum.deleteMatchReceptor(user.getString(1));
				CRUDReceptorComum.deleteReceptor(user.getString(1));
				user.close();
				Stage stage = (Stage) excluir.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
				MainScreenController main = (MainScreenController)loader.getController();
				main.setErr("Obrigado por usar nosso app.Esperamos que tenha gostado!");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			}
		}
	}
	
	public void voltar(ActionEvent event) throws IOException, SQLException {
		Stage stage = (Stage) voltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
		TelaUserController telaUser = (TelaUserController)loader.getController();
		telaUser.setResultSetLabelType(user, type);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
