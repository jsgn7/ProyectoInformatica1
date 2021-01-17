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

public class controladorMenuSeleccionPaciente {

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
			FXMLLoader loaderSensorPac=new FXMLLoader(getClass().getResource("/vista/sensorespaciente.fxml"));
			controladorsensorpaciente controlSensorPac=new controladorsensorpaciente();

            loaderSensorPac.setController(controlSensorPac);
            Parent rootSensorPac=loaderSensorPac.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootSensorPac));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickSensoresPuertas(ActionEvent event) {
    	try {
			FXMLLoader loaderControlPuertas = new FXMLLoader(getClass().getResource("/vista/controlpuertas.fxml"));
			controladorpuertas controlControlPuertas = new controladorpuertas();

            loaderControlPuertas.setController(controlControlPuertas);
            Parent rootControlPuertas = loaderControlPuertas.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootControlPuertas));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickTickets(ActionEvent event) {
    	try {
			FXMLLoader loaderTicketPac =new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_paciente.fxml"));
			controlador_visu_ti_paciente controlTicketPac = new controlador_visu_ti_paciente();

            loaderTicketPac.setController(controlTicketPac);
            Parent rootTicketPac = loaderTicketPac.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootTicketPac));
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
