package GUI.Controller;


import GUI.EditarCachorroApp;
import GUI.SeusAnimaisApp;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarCachorroController {


    @FXML
    private ChoiceBox<?> cbSexo;

    @FXML
    private ChoiceBox<?> cbRaca;

    @FXML
    private TextArea taDescricao;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfIdade;

    @FXML
    private ChoiceBox<?> cbTamanho;

    @FXML
    void handleCancelar( ) {
    	SeusAnimaisApp seusAnimaisTela = new SeusAnimaisApp();
    	EditarCachorroApp.getStage().close();
    	try {
			seusAnimaisTela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleSalvar() {

    }

}