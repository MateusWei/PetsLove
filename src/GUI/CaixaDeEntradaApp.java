package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CaixaDeEntradaApp extends Application {

private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View/CaixaDeEntrada.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Caixa de Entrada");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CaixaDeEntradaApp.stage = stage;
	}
}
