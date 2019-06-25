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
	
	private Doador doador;
	
	private ReceptorComum receptor;
	
	private String type;
	
	public void setResultSetType(Doador doador, ReceptorComum receptor, String tipo) throws SQLException {
		type = tipo;
		this.doador = doador;
		this.receptor = receptor;
		setPlaceHolders();
	}
	
	private void setPlaceHolders() throws SQLException {
		if (type.equals("Doador")) {
			email.setPromptText(doador.getEmail());
			nome.setPromptText(doador.getNome());
			sobrenome.setPromptText(doador.getSobrenome());
			tel.setPromptText(doador.getTel());
			cel.setPromptText(doador.getCelular());
			peso.setPromptText(""+doador.getPeso());
			tipo_sangue.setValue(doador.getTipo_sangue());
			regiao.setValue(doador.getRegiao());
			endereco.setPromptText(doador.getEndereco());
			
			if (doador.isSangue() == true) {
				sangue.setSelected(true);
			} else {
				sangue.setSelected(false);
			}
			if (doador.isRim() == true) {
				rim.setSelected(true);
			} else {
				rim.setSelected(false);
			}
			if (doador.isFigado() == true) {
				figado.setSelected(true);
			} else {
				figado.setSelected(false);
			}
			if (doador.isMedula() == true) {
				medula.setSelected(true);
			} else {
				medula.setSelected(false);
			}
			if (doador.isPulmao() == true) {
				pulmao.setSelected(true);
			} else {
				pulmao.setSelected(false);
			}
			if (doador.isPancreas() == true) {
				pancreas.setSelected(true);
			} else {
				pancreas.setSelected(false);
			}
		} else {
			email.setPromptText(receptor.getEmail());
			nome.setPromptText(receptor.getNome());
			sobrenome.setPromptText(receptor.getSobrenome());
			tel.setPromptText(receptor.getTel());
			cel.setPromptText(receptor.getCelular());
			peso.setPromptText(""+receptor.getPeso());
			tipo_sangue.setValue(receptor.getTipo_sangue());
			regiao.setValue(receptor.getRegiao());
			endereco.setPromptText(receptor.getEndereco());
			
			if (receptor.isSangue() == true) {
				sangue.setSelected(true);
			} else {
				sangue.setSelected(false);
			}
			if (receptor.isRim() == true) {
				rim.setSelected(true);
			} else {
				rim.setSelected(false);
			}
			if (receptor.isFigado() == true) {
				figado.setSelected(true);
			} else {
				figado.setSelected(false);
			}
			if (receptor.isMedula() == true) {
				medula.setSelected(true);
			} else {
				medula.setSelected(false);
			}
			if (receptor.isPulmao() == true) {
				pulmao.setSelected(true);
			} else {
				pulmao.setSelected(false);
			}
			if (receptor.isPancreas() == true) {
				pancreas.setSelected(true);
			} else {
				pancreas.setSelected(false);
			}
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
		if (type.equals("Doador")) {
			String emailAtualizado = doador.getEmail();
			if (email.getText() != null && !email.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(doador.getEmail(), "email", email.getText());
				emailAtualizado = email.getText();
			}
			if (senha.getText() != null && !senha.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "senha", senha.getText());
			}
			if (nome.getText() != null && !nome.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "nome", nome.getText());
			}
			if (sobrenome.getText() != null && !sobrenome.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "sobrenome", sobrenome.getText());
			}
			if (tel.getText() != null && !tel.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "tel_fixo", tel.getText());
			}
			if (cel.getText() != null && !cel.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "celular", cel.getText());
			}
			if (endereco.getText() != null && !endereco.getText().trim().isEmpty()) {
				CRUDDoador.updateDoador(emailAtualizado, "endereco", endereco.getText());
			}
			CRUDDoador.updateDoador(emailAtualizado, "regiao", regiao.getValue());
			CRUDDoador.updateDoador2(emailAtualizado, "sangue", sangue.isSelected());
			CRUDDoador.updateDoador2(emailAtualizado, "rim", rim.isSelected());
			CRUDDoador.updateDoador2(emailAtualizado, "figado", figado.isSelected());
			CRUDDoador.updateDoador2(emailAtualizado, "medula", medula.isSelected());
			CRUDDoador.updateDoador2(emailAtualizado, "pulmao", pulmao.isSelected());
			CRUDDoador.updateDoador2(emailAtualizado, "pancreas", pancreas.isSelected());
			ResultSet user = CRUDDoador.selectDoador3("email", emailAtualizado);
			
			CRUDMatchComum.deleteMatchDoador(doador.getEmail());
			CRUDMatchPessoaInst.deleteMatchDoador(doador.getEmail());
			Doador doadorNovo = new Doador (user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(19), user.getString(6), user.getString(7), user.getString(9), user.getString(16), user.getString(17), Float.parseFloat(user.getString(8)), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true);
			this.doador = doadorNovo;
			MatchComumFactory.criarMatchDoador(doador);
			MatchInstFactory.criarMatchDoador(doador);
			
		} else {
			if (type.equals("Receptor")) {
				String emailAtualizado = receptor.getEmail();
				if (email.getText() != null && !email.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(receptor.getEmail(), "email", email.getText());
					emailAtualizado = email.getText();
				}
				if (senha.getText() != null && !senha.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "senha", senha.getText());
				}
				if (nome.getText() != null && !nome.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "nome", nome.getText());
				}
				if (sobrenome.getText() != null && !sobrenome.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "sobrenome", sobrenome.getText());
				}
				if (tel.getText() != null && !tel.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "tel_fixo", tel.getText());
				}
				if (cel.getText() != null && !cel.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "celular", cel.getText());
				}
				if (endereco.getText() != null && !endereco.getText().trim().isEmpty()) {
					CRUDReceptorComum.updateReceptor(emailAtualizado, "endereco", endereco.getText());
				}
				CRUDReceptorComum.updateReceptor(emailAtualizado, "regiao", regiao.getValue());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "sangue", sangue.isSelected());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "rim", rim.isSelected());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "figado", figado.isSelected());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "medula", medula.isSelected());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "pulmao", pulmao.isSelected());
				CRUDReceptorComum.updateReceptor2(emailAtualizado, "pancreas", pancreas.isSelected());
				ResultSet user = CRUDReceptorComum.selectReceptor3("email", emailAtualizado);
				
				CRUDMatchComum.deleteMatchReceptor(user.getString(1));
				ReceptorComum receptorNovo = new ReceptorComum (user.getString(1), user.getString(2), user.getString(3), user.getString(4), user.getString(5), user.getString(13), user.getString(6), user.getString(7), Float.parseFloat(user.getString(8)), user.getString(9), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, user.getString(10), user.getString(19));
				this.receptor = receptorNovo;
				user.close();
				MatchComumFactory.criarMatchReceptor(receptor);
			}
		}
		
		Stage stage = (Stage) voltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaUser.fxml").openStream());
		TelaUserController telaUser = (TelaUserController)loader.getController();
		telaUser.setResultSetLabelType(doador, receptor, null, type);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void excluir(ActionEvent event) throws SQLException, IOException {
		if (type.equals("Doador")) {
			CRUDMatchComum.deleteMatchDoador(doador.getEmail());
			CRUDMatchPessoaInst.deleteMatchDoador(doador.getEmail());
			CRUDDoador.deleteDoador(doador.getEmail());
			Stage stage = (Stage) excluir.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
			MainScreenController main = (MainScreenController)loader.getController();
			main.setErr("Obrigado por ter usado nosso app!");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} else {
			if (type.equals("Receptor")) {
				CRUDMatchComum.deleteMatchReceptor(receptor.getEmail());
				CRUDReceptorComum.deleteReceptor(receptor.getEmail());
				Stage stage = (Stage) excluir.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
				MainScreenController main = (MainScreenController)loader.getController();
				main.setErr("Obrigado por ter usado nosso app!");
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
		telaUser.setResultSetLabelType(doador, receptor, null, type);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
