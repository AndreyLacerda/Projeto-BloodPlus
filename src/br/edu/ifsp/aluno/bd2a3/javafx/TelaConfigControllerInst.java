package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDMatchPessoaInst;
import br.edu.ifsp.aluno.bd2a3.conexaosql.CRUDReceptorJuridico;
import br.edu.ifsp.aluno.bd2a3.factories.MatchInstFactory;
import br.edu.ifsp.aluno.bd2a3.usuarios.ReceptorJuridico;
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

public class TelaConfigControllerInst {
	
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
	private TextField tel1;
	
	@FXML
	private TextField tel2;
	
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
	
	public void setResultSet(ResultSet  rs) throws SQLException {
		user = rs;
		setPlaceHolders();
	}
	
	private void setPlaceHolders() throws SQLException {
		email.setPromptText(user.getString(1));
		nome.setPromptText(user.getString(3));
		tel1.setPromptText(user.getString(5));
		tel2.setPromptText(user.getString(6));
		tipo_sangue.setValue(user.getString(16));
		regiao.setValue(user.getString(7));
		endereco.setPromptText(user.getString(8));
		
		if (user.getString(9).equals("1") || user.getString(9).equals("true")) {
			sangue.setSelected(true);
		}
		if (user.getString(10).equals("1") || user.getString(10).equals("true")) {
			rim.setSelected(true);
		}
		if (user.getString(11).equals("1") || user.getString(11).equals("true")) {
			figado.setSelected(true);
		}
		if (user.getString(12).equals("1") || user.getString(12).equals("true")) {
			medula.setSelected(true);
		}
		if (user.getString(13).equals("1") || user.getString(13).equals("true")) {
			pulmao.setSelected(true);
		}
		if (user.getString(14).equals("1") || user.getString(14).equals("true")) {
			pancreas.setSelected(true);
		}
	}
	
	@FXML
	public void initialize() throws SQLException {
		loadData();
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
		if (email.getText() != null && !email.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "email", email.getText());
		}
		if (senha.getText() != null && !senha.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "senha", senha.getText());
		}
		if (nome.getText() != null && !nome.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "nome_instituição", nome.getText());
		}
		if (tel1.getText() != null && !tel1.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "tel1", tel1.getText());
		}
		if (tel2.getText() != null && !tel2.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "tel2", tel2.getText());
		}
		if (endereco.getText() != null && !endereco.getText().trim().isEmpty()) {
			CRUDReceptorJuridico.updateReceptor(user.getString(1), "endereco", endereco.getText());
		}
		CRUDReceptorJuridico.updateReceptor(user.getString(1), "main_tipo_sangue", tipo_sangue.getValue());
		CRUDReceptorJuridico.updateReceptor(user.getString(1), "regiao", regiao.getValue());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "sangue", sangue.isSelected());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "rim", rim.isSelected());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "figado", figado.isSelected());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "medula", rim.isSelected());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "pulmao", pulmao.isSelected());
		CRUDReceptorJuridico.updateReceptor2(user.getString(1), "pancreas", pancreas.isSelected());
		this.user = CRUDReceptorJuridico.selectReceptor3("email", user.getString(1));
		
		CRUDMatchPessoaInst.deleteMatchReceptor(user.getString(1));
		
		ReceptorJuridico receptor = new ReceptorJuridico(user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(6), user.getString(7), user.getString(8), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, user.getString(16));
		MatchInstFactory.criarMatchReceptor(receptor);
		
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
		CRUDMatchPessoaInst.deleteMatchReceptor(user.getString(1));
		CRUDReceptorJuridico.deleteReceptor(user.getString(1));
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
	
	public void voltar(ActionEvent event) throws IOException, SQLException {
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
}
