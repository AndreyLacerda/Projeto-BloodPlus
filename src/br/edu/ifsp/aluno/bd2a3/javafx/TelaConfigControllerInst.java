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
import javafx.scene.image.Image;
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
	
	private ReceptorJuridico receptor;
	
	public void setResultSet(ReceptorJuridico  rs) throws SQLException {
		receptor = rs;
		setPlaceHolders();
	}
	
	private void setPlaceHolders() throws SQLException {
		email.setPromptText(receptor.getEmail());
		nome.setPromptText(receptor.getNome_instituição());
		tel1.setPromptText(receptor.getTel1());
		tel2.setPromptText(receptor.getTel2());
		tipo_sangue.setValue(receptor.getMain_tipo_sangue());
		regiao.setValue(receptor.getRegiao());
		endereco.setPromptText(receptor.getEndereco());
		
		if (receptor.isSangue() == true) {
			sangue.setSelected(true);
		}
		if (receptor.isRim() == true) {
			rim.setSelected(true);
		}
		if (receptor.isFigado() == true) {
			figado.setSelected(true);
		}
		if (receptor.isMedula() == true) {
			medula.setSelected(true);
		}
		if (receptor.isPulmao() == true) {
			pulmao.setSelected(true);
		}
		if (receptor.isPancreas() == true) {
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
		String emailAtualizado = receptor.getEmail();
		if (email.getText() != null && !email.getText().trim().isEmpty() && !email.getText().contains("*") && !email.getText().contains("--") && !email.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(receptor.getEmail(), "email", email.getText());
			emailAtualizado = email.getText();
		}
		if (senha.getText() != null && !senha.getText().trim().isEmpty() && !senha.getText().contains("*") && !senha.getText().contains("--") && !senha.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(emailAtualizado, "senha", senha.getText());
		}
		if (nome.getText() != null && !nome.getText().trim().isEmpty() && !nome.getText().contains("*") && !nome.getText().contains("--") && !nome.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(emailAtualizado, "nome_instituição", nome.getText());
		}
		if (tel1.getText() != null && !tel1.getText().trim().isEmpty() && !tel1.getText().contains("*") && !tel1.getText().contains("--") && !tel1.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(emailAtualizado, "tel1", tel1.getText());
		}
		if (tel2.getText() != null && !tel2.getText().trim().isEmpty() && !tel2.getText().contains("*") && !tel2.getText().contains("--") && !tel2.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(emailAtualizado, "tel2", tel2.getText());
		}
		if (endereco.getText() != null && !endereco.getText().trim().isEmpty() && !endereco.getText().contains("*") && !endereco.getText().contains("--") && !endereco.getText().contains("//")) {
			CRUDReceptorJuridico.updateReceptor(emailAtualizado, "endereco", endereco.getText());
		}
		CRUDReceptorJuridico.updateReceptor(emailAtualizado, "main_tipo_sangue", tipo_sangue.getValue());
		CRUDReceptorJuridico.updateReceptor(emailAtualizado, "regiao", regiao.getValue());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "sangue", sangue.isSelected());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "rim", rim.isSelected());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "figado", figado.isSelected());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "medula", medula.isSelected());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "pulmao", pulmao.isSelected());
		CRUDReceptorJuridico.updateReceptor2(emailAtualizado, "pancreas", pancreas.isSelected());
		ResultSet user = CRUDReceptorJuridico.selectReceptor3("email", emailAtualizado);
		CRUDMatchPessoaInst.deleteMatchReceptor(receptor.getEmail());
		
		ReceptorJuridico receptorNovo = new ReceptorJuridico(user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(6), user.getString(7), user.getString(8), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, user.getString(16));
		this.receptor = receptorNovo;
		user.close();
		MatchInstFactory.criarMatchReceptor(receptor);
		
		Stage stage = (Stage) voltar.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
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
	
	public void excluir(ActionEvent event) throws SQLException, IOException {
		CRUDMatchPessoaInst.deleteMatchReceptor(receptor.getEmail());
		CRUDReceptorJuridico.deleteReceptor(receptor.getEmail());
		Stage stage = (Stage) excluir.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
		MainScreenController main = (MainScreenController)loader.getController();
		main.setErr("Obrigado por ter usado nosso app!");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void voltar(ActionEvent event) throws IOException, SQLException {
		Stage stage = (Stage) voltar.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
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
