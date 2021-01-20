package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controladorMain {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> desplegableMedicoPaciente;

    @FXML
    private JFXButton botonEntrar;
    
    ObservableList<String> roles = FXCollections.observableArrayList("Medico","Paciente");
    
    @FXML
    void entrar(ActionEvent event) {
    	if(desplegableMedicoPaciente.getSelectionModel().getSelectedItem().toString().equals("Medico")) {
    		try {
    			FXMLLoader loaderLoginMedico=new FXMLLoader(getClass().getResource("/vista/LoginMedico.fxml"));
    			controladorLoginMedico controlLoginMedico=new controladorLoginMedico();

                loaderLoginMedico.setController(controlLoginMedico);
                Parent rootLoginMedico=loaderLoginMedico.load();
                
                Stage stage = new Stage();

                stage.setScene(new Scene(rootLoginMedico));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else {
    		try {
    			FXMLLoader loaderLoginPaciente=new FXMLLoader(getClass().getResource("/vista/LoginPaciente.fxml"));
    			controladorLoginPaciente controlLoginPaciente=new controladorLoginPaciente();

                loaderLoginPaciente.setController(controlLoginPaciente);
                Parent rootLoginPaciente=loaderLoginPaciente.load();
                
                Stage stage = new Stage();

                stage.setScene(new Scene(rootLoginPaciente));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void initialize() {
    	desplegableMedicoPaciente.setItems(roles);
    }
}

