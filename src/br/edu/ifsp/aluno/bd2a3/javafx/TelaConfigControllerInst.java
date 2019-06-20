package br.edu.ifsp.aluno.bd2a3.javafx;

import java.io.IOException;
import java.sql.ResultSet;

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
	
	ObservableList<String> list1 = FXCollections.observableArrayList();
	
	ObservableList<String> list2 = FXCollections.observableArrayList();
	
	@FXML
	private ChoiceBox<String> regiao;
	
	@FXML
	private ChoiceBox<String> tipo_sangue;
	
	private ResultSet user;
	
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
	
	public void salvarAlteracoes(ActionEvent event) {
		
	}
	
	public void excluir(ActionEvent event) {
		
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
