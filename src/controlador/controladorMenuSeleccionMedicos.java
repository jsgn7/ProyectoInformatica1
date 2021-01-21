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
    private JFXButton botonPulsaciones;


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
			FXMLLoader loaderTicketCl =new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_clinico.fxml"));
			controlador_visu_ti_clinico controlTicketCl = new controlador_visu_ti_clinico();

            loaderTicketCl.setController(controlTicketCl);
            Parent rootTicketCl = loaderTicketCl.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootTicketCl));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void clickPulsaciones(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    }
}
