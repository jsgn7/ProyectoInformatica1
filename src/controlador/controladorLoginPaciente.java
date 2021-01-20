package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Paciente;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controladorLoginPaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXPasswordField contraseña;

    @FXML
    private JFXTextField usuario;

    @FXML
    private Label recuperarContraseña;

    @FXML
    private JFXButton botonRegistro;

    @FXML
    private JFXButton entrar;

    @FXML
    void entrarEnApp(ActionEvent event) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> pacientes = paciente.recuperarPacientes();
    	int i = 0;
    	boolean encontrado = false;
    	while(i<pacientes.size() && !encontrado) {
    		if(pacientes.get(i).getDni().equals(usuario.getText()) && pacientes.get(i).getPass().equals(contraseña.getText())) {
    			encontrado = true;
    		}
    		i++;
    	}
    	if(encontrado) {
    		try {
    			FXMLLoader loaderTicketPaciente=new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_paciente.fxml"));
    			controlador_visu_ti_paciente controlTicketPaciente=new controlador_visu_ti_paciente();

                loaderTicketPaciente.setController(controlTicketPaciente);
                Parent rootTicketPaciente=loaderTicketPaciente.load();
                
                Stage stage = new Stage();

                stage.setScene(new Scene(rootTicketPaciente));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error de identificacion");
    	    alert.setContentText("Usuario o contraseña incorrectos");
    	    alert.showAndWait();
    	}
    }

    @FXML
    void recuperarContraseñaVentana(MouseEvent event) {
    	try {
			FXMLLoader loaderRecuperarContraseña=new FXMLLoader(getClass().getResource("/vista/RecuperarContraseña.fxml"));
			controladorRecuperarContraseña controlRecuperarContraseña=new controladorRecuperarContraseña();

            loaderRecuperarContraseña.setController(controlRecuperarContraseña);
            Parent rootRecuperarContraseña=loaderRecuperarContraseña.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRecuperarContraseña));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void registro(ActionEvent event) {
    	try {
			FXMLLoader loaderRegistroPaciente=new FXMLLoader(getClass().getResource("/vista/RegistroPaciente.fxml"));
			controladorRegistroPaciente controlRegistroPaciente=new controladorRegistroPaciente();

            loaderRegistroPaciente.setController(controlRegistroPaciente);
            Parent rootRegistroPaciente=loaderRegistroPaciente.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRegistroPaciente));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert contraseña != null : "fx:id=\"contraseña\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert recuperarContraseña != null : "fx:id=\"recuperarContraseña\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert botonRegistro != null : "fx:id=\"botonRegistro\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'LoginPaciente.fxml'.";

    }
}
