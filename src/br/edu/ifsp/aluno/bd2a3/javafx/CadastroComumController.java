package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.SQLException;

import br.edu.ifsp.aluno.bd2a3.factories.DoadorFactory;
import br.edu.ifsp.aluno.bd2a3.factories.ReceptorComumFactory;
import br.edu.ifsp.aluno.bd2a3.factories.ReceptorJuridicoFactory;
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

public class CadastroComumController {
	
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
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
	private TextField cpf;
	
	@FXML
	private TextField dt_nasc;
	
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
	
	@FXML
	private CheckBox hiv;
	
	@FXML
	private CheckBox htlv;
	
	@FXML
	private CheckBox hepatite;
	
	@FXML
	private CheckBox chagas;
	
	@FXML
	private Label err;
	
	ObservableList<String> list1 = FXCollections.observableArrayList();
	
	ObservableList<String> list2 = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> regiao;
	
	@FXML
	private ChoiceBox<String> tipo_sangue;
	
	@FXML
	private Button confirmar;
	
	@FXML
	private Button preTela;
	
	@FXML
	public void initialize() {
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
	
	public void setLabels(String valor1, String valor2) {
		label1.setText(valor1);
		label2.setText(valor2);
	}
	
	public void setLabelInst(String valor) {
		label2.setText(valor);
	}
	
	public void PreCadastro(ActionEvent event) throws IOException {
		Stage stage = (Stage) preTela.getScene().getWindow();
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("PreCadastro.fxml"));
		PreCadastroController preCadastro = (PreCadastroController)loader.getController();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void confirmarCadastro(ActionEvent event) throws SQLException {
		String result = "a";
		try {
			if (label1.getText() != null && label1.getText().equals("Cadastro de Doador")){
				if (regiao.getValue() == null || tipo_sangue.getValue() == null || peso.getText() == null || dt_nasc.getText() == null) {
					result = "Por favor preencha todos os campos!";
				} else {
					result = DoadorFactory.buildarDoador(email.getText(), senha.getText(), nome.getText(), sobrenome.getText(), dt_nasc.getText(), cpf.getText(), tel.getText(), cel.getText(), tipo_sangue.getValue(), regiao.getValue(), endereco.getText(), Float.parseFloat(peso.getText()), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, hiv.isSelected(), hepatite.isSelected(), htlv.isSelected(), chagas.isSelected(), hepatite.isSelected());
				}
		} else
				if (label1.getText() != null && label1.getText().equals("Cadastro de Receptor")){
					if (regiao.getValue() == null || tipo_sangue.getValue() == null || peso.getText() == null || dt_nasc.getText() == null) {
						result = "Por favor preencha todos os campos de forma correta!";
					} else
						result = ReceptorComumFactory.buildarReceptorComum(email.getText(), senha.getText(), nome.getText(), sobrenome.getText(), dt_nasc.getText(), cpf.getText(), tel.getText(), cel.getText(), Float.parseFloat(peso.getText()), tipo_sangue.getValue(), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, regiao.getValue(), endereco.getText(), hiv.isSelected(), hepatite.isSelected(), htlv.isSelected(), chagas.isSelected(), hepatite.isSelected());
				} else 
					if (label1.getText() != null && label1.getText().equals("Cadastro de Instituição")){
						if (regiao == null || tipo_sangue == null) {
							result = "Por favor preencha todos os campos!";
						} else
							result = ReceptorJuridicoFactory.buildarReceptorJuridico(email.getText(), senha.getText(), nome.getText(), cpf.getText(), tel.getText(), cel.getText(), regiao.getValue(), endereco.getText(), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, tipo_sangue.getValue());
				}
			if (result.equals("Cadastro realizado com sucesso!")) {
				Stage stage = (Stage) confirmar.getScene().getWindow();
				stage.getIcons().add(new Image("/logo.png"));
				stage.setTitle("Blood+");
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
				MainScreenController main = (MainScreenController)loader.getController();
				main.setErr(result);
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} else {
				err.setText(result);
			}
		} catch (IOException ex) {
			System.err.println("Bugou o seguinte: "+ex.getMessage());
			err.setText("Ops, ocorreu um erro. Tente mais tarde");
		}
	}
}