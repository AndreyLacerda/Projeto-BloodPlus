package br.edu.ifsp.aluno.bd2a3.javafx;

import br.edu.ifsp.aluno.bd2a3.conexaosql.TesteConnectionSQLite;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainScreenFXML.fxml"));
		stage.getIcons().add(new Image("/logo.png"));
		stage.setTitle("Blood+");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		TesteConnectionSQLite.testarConnection();
		launch();

	}

}
