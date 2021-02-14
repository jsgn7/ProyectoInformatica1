package controlador;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controladorMenuSeleccionMedicos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label doctor;

    @FXML
    private JFXButton botonTickets;

    @FXML
    private JFXButton botonSensores;

    @FXML
    private JFXButton botonPulsaciones;

    private String medico;
    
    @FXML
    void clickPulsaciones(ActionEvent event) {
    	try {
			FXMLLoader loaderPulsaciones =new FXMLLoader(getClass().getResource("/vista/Pulsaciones.fxml"));
			controladorPulsaciones controlPulsaciones = new controladorPulsaciones();

            loaderPulsaciones.setController(controlPulsaciones);
            Parent rootPulsaciones = loaderPulsaciones.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootPulsaciones));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void clickSensores(ActionEvent event) {
    	try {
			FXMLLoader loaderSensorPac=new FXMLLoader(getClass().getResource("/vista/sensorespaciente.fxml"));
			controladorSensorPaciente controlSensorPac=new controladorSensorPaciente();

            loaderSensorPac.setController(controlSensorPac);
            Parent rootSensorPac=loaderSensorPac.load();
            
            controlSensorPac.setMedico(medico);
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootSensorPac));
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
    
    void setMedico(String medico) {
    	this.doctor.setText(doctor.getText() + medico);
    	this.medico = medico;
    }

    @FXML
    void initialize() {
        assert doctor != null : "fx:id=\"doctor\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";
        assert botonTickets != null : "fx:id=\"botonTickets\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";
        assert botonSensores != null : "fx:id=\"botonSensores\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";
        assert botonPulsaciones != null : "fx:id=\"botonPulsaciones\" was not injected: check your FXML file 'MenuSeleccion.fxml'.";

    }
}
