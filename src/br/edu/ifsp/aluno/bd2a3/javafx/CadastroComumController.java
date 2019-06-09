package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import br.edu.ifsp.aluno.bd2a3.factories.DoadorFactory;
import br.edu.ifsp.aluno.bd2a3.factories.ReceptorComumFactory;
import br.edu.ifsp.aluno.bd2a3.factories.ReceptorJuridicoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroComumController implements Initializable{
	
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
	private DatePicker dt_nasc;
	
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
	
	ObservableList list1 = FXCollections.observableArrayList();
	
	ObservableList list2 = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> regiao;
	
	@FXML
	private ChoiceBox<String> tipo_sangue;
	
	@FXML
	public void initialize() {
		loadData1();
		loadData2();
	}
	
	private void loadData1() {
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
		regiao.getItems().addAll(list1);
	}
	
	private void loadData2() {
		list2.removeAll(list2);
		String a = "A+";
		String b = "A-";
		String c = "B+";
		String d = "B-";
		String e = "AB+";
		String f = "AB-";
		String g = "O+";
		String h = "O-";
		list2.addAll(a, b, c, d, e, f, g, h);
		tipo_sangue.getItems().addAll(list2);
	}
	
	public void setLabels(String valor1, String valor2) {
		label1.setText(valor1);
		label2.setText(valor2);
	}
	
	public void setLabelInst(String valor) {
		label2.setText(valor);
	}
	
	public void PreCadastro(ActionEvent event) throws IOException {
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("PreCadastro.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void confirmarCadastro(ActionEvent event) {
		String result = null;
		try {
			if (label1.getText().equals("Cadastro de Doador")){
				result = DoadorFactory.buildarDoador(email.getText(), senha.getText(), nome.getText(), sobrenome.getText(), dt_nasc.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), cpf.getText(), tel.getText(), cel.getText(), tipo_sangue.getValue(), regiao.getValue(), endereco.getText(), Float.parseFloat(peso.getText()), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, hiv.isSelected(), hepatite.isSelected(), htlv.isSelected(), chagas.isSelected(), hepatite.isSelected());
			} else
				if (label1.getText().equals("Cadastro de Receptor")){
					result = ReceptorComumFactory.buildarReceptorComum(email.getText(), senha.getText(), nome.getText(), sobrenome.getText(), dt_nasc.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), cpf.getText(), tel.getText(), cel.getText(), Float.parseFloat(peso.getText()), tipo_sangue.getValue(), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, regiao.getValue(), endereco.getText(), hiv.isSelected(), hepatite.isSelected(), htlv.isSelected(), chagas.isSelected(), hepatite.isSelected());
				} else 
					if (label1.getText().equals("Cadastro de Instituição")){
						result = ReceptorJuridicoFactory.buildarReceptorJuridico(email.getText(), senha.getText(), nome.getText(), cpf.getText(), tel.getText(), cel.getText(), regiao.getValue(), endereco.getText(), sangue.isSelected(), rim.isSelected(), figado.isSelected(), medula.isSelected(), pulmao.isSelected(), pancreas.isSelected(), true, tipo_sangue.getValue());
				}
			if (result.equals("Cadastro realizado com sucesso!")) {
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("MainScreenFXML.fxml").openStream());
				MainScreenController mainScreen = (MainScreenController)loader.getController();
				mainScreen.setErr(result);
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} else {
				err.setText(result);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			err.setText("Por favor preencha todos os campos");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
