package controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controladorMenuSeleccionMedicos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton botonTickets;

    @FXML
    private JFXButton botonSensores;

    @FXML
    private JFXButton botonSensoresPuertas;

    @FXML
    void clickSensores(ActionEvent event) {
    	try {
			FXMLLoader loader2=new FXMLLoader(getClass().getResource("/vista/sensorespaciente.fxml"));
			controladorsensorpaciente control2=new controladorsensorpaciente();

            loader2.setController(control2);
            Parent root2=loader2.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(root2));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickSensoresPuertas(ActionEvent event) {
    	try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/vista/controlpuertas.fxml"));
			controladorpuertas control3 = new controladorpuertas();

            loader3.setController(control3);
            Parent root3 = loader3.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(root3));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickTickets(ActionEvent event) {
    	try {
			FXMLLoader loader4 =new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_clinico.fxml"));
			controlador_visu_ti_clinico control4 = new controlador_visu_ti_clinico();

            loader4.setController(control4);
            Parent root4 = loader4.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(root4));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert botonTickets != null : "fx:id=\"botonTickets\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";
        assert botonSensores != null : "fx:id=\"botonSensores\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";
        assert botonSensoresPuertas != null : "fx:id=\"botonSensoresPuertas\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";

    }
}
