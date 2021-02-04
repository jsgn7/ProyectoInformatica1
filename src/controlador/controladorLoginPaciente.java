package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;
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
    private JFXPasswordField contrasena;

    @FXML
    private JFXTextField usuario;

    @FXML
    private Label recuperarContrasena;

    @FXML
    private JFXButton botonRegistro;

    @FXML
    private JFXButton entrar;

    @FXML
    void entrarEnApp(ActionEvent event) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	int j = 0;
    	boolean encontrado = false;
    	String pregunta = "";
    	while(i<medicos.size() && !encontrado) {
    		j = 0;
    		while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(usuario.getText())) {
    				encontrado = true;
    				if(!medicos.get(i).getPacientes().get(j).getTickets().isEmpty())
    					pregunta = medicos.get(i).getPacientes().get(j).getTickets().get( medicos.get(i).getPacientes().get(j).getTickets().size()-1);
    			}
    			j++;
    		}
    		i++;
    	}
    	if(encontrado) {
    		try {
    			FXMLLoader loaderTicketPaciente=new FXMLLoader(getClass().getResource("/vista/TicketsPaciente.fxml"));
    			controladorTicketPaciente controlTicketPaciente=new controladorTicketPaciente();

                loaderTicketPaciente.setController(controlTicketPaciente);
                Parent rootTicketPaciente = loaderTicketPaciente.load();
                
                controlTicketPaciente.nombrePaciente(usuario.getText());
                controlTicketPaciente.doctor(medicos.get(i-1).getPacientes().get(j-1).getMedico());
                controlTicketPaciente.setPregunta(pregunta);
              
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
    	    alert.setContentText("Usuario o contrasena incorrectos");
    	    alert.showAndWait();
    	}
    }

    @FXML
    void recuperarContrasenaVentana(MouseEvent event) {
    	try {
			FXMLLoader loaderRecuperarContrasena=new FXMLLoader(getClass().getResource("/vista/RecuperarContrasena.fxml"));
			controladorRecuperarContrasena controlRecuperarContrasena=new controladorRecuperarContrasena();

            loaderRecuperarContrasena.setController(controlRecuperarContrasena);
            Parent rootRecuperarContrasena=loaderRecuperarContrasena.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRecuperarContrasena));
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
        assert contrasena != null : "fx:id=\"contrasena\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert recuperarContrasena != null : "fx:id=\"recuperarContrasena\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert botonRegistro != null : "fx:id=\"botonRegistro\" was not injected: check your FXML file 'LoginPaciente.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'LoginPaciente.fxml'.";

    }
}
