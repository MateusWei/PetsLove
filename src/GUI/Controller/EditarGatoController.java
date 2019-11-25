package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import GUI.System.CadastrarGatoApp;
import GUI.System.EditarGatoApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.enums.EnumPelagem;
import PetsLove.sistema.negocios.beans.enums.EnumRacaGato;
import PetsLove.sistema.negocios.beans.enums.EnumSexo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarGatoController implements Initializable{

	public static Gato selecionado;

	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbPelagem;
	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private ComboBox<String> cbRaca;
	@FXML private DatePicker dpDataDeNascimento;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> pelagem = FXCollections.observableArrayList(EnumPelagem.FELPUDO.valor, EnumPelagem.MEDIO.valor, EnumPelagem.RASO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaGato.getValues());

	@FXML
	void handleCancelar( ) {
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		EditarGatoApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSalvar( ) {

		//TODO: Colocar Regras de Cadastro (Todos os campos devem ser preenchidos)

		int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();

		EnumSexo sexo = null;
		if(cbSexo.getValue().equals(EnumSexo.MACHO.valor)){
			sexo = EnumSexo.MACHO;
		}else if(cbSexo.getValue().equals(EnumSexo.FEMEA.valor)){
			sexo = EnumSexo.FEMEA;
		}

		EnumPelagem pelagem = null;
		for(EnumPelagem e: EnumPelagem.values()){
			if(e.valor.equals(cbPelagem.getValue())){
				pelagem = e;
			}
		}

		EnumRacaGato raca = null;
		for(EnumRacaGato e: EnumRacaGato.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
			}
		}

		selecionado.setNome(tfNome.getText());
		selecionado.setIdade(idade);
		selecionado.setDescricao(taDescricao.getText());
		selecionado.setRaca(raca);
		selecionado.setPelagem(pelagem);
		selecionado.setSexo(sexo);
		
		FachadaPL.getInstance().atualizarAnimal(selecionado);
		
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		EditarGatoApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbPelagem.setItems(pelagem);
		cbRaca.setItems(raca);
	}

	public static void setSelecionado(Animal animal) {
		if(FachadaPL.getUsuarioLogado().equals(FachadaPL.getInstance().procurarUsuario(animal.getEmailDono()))) {
			selecionado = (Gato) animal;
		}
	}

}
