package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import clases.Encargado;
import clases.Medico;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class controladorRegistroEncargado {
	
	private String paciente;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXButton botonRegistroFin;

    @FXML
    void registrarse(ActionEvent event) {
    	
    	Medico medico = new Medico();
    	
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	int j = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado){
    		j = 0;
    		while(j<medicos.get(i).getPacientes().size() && !encontrado){
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(paciente))
    			encontrado = true;
    			j++;
			}
    		i++;
		}
    	
    	//Si ha sido encontrado agrego al paciente su encargado asociado
    	if(encontrado) {
    		medicos.get(i-1).getPacientes().get(j-1).getEncargado().setNombre(nombre.getText());
    		medicos.get(i-1).getPacientes().get(j-1).getEncargado().setDni(dni.getText());
    		medicos.get(i-1).getPacientes().get(j-1).getEncargado().setTelefono(telefono.getText());
    		medicos.get(i-1).getPacientes().get(j-1).getEncargado().setEmail(email.getText());
    				//new Encargado(nombre.getText(),dni.getText(),telefono.getText(),email.getText()));
    		medico.modificarMedico(medicos);
    		//Informo al usuario del registro exitoso
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setHeaderText(null);
    	    alert.setTitle("Registrado");
    	    alert.setContentText("Registrado con exito\nSu medico asociado es: " + 
    	    		medicos.get(i-1).getPacientes().get(j-1).getMedico());
    	    alert.showAndWait();
        	Stage stage = (Stage) botonRegistroFin.getScene().getWindow();
        	stage.close();
    	} else {
    		//Informo al usuario del registro exitoso
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setHeaderText(null);
    	    alert.setTitle("Error en el registro");
    	    alert.setContentText("Revise la informacion");
    	    alert.showAndWait();
    	}
    	
    	
    }
    
    public void setPaciente(String paciente) {
    	this.paciente = paciente;
    }

    @FXML
    void initialize() {
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'RegistroEncargado.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'RegistroEncargado.fxml'.";
        assert telefono != null : "fx:id=\"telefono\" was not injected: check your FXML file 'RegistroEncargado.fxml'.";
        assert dni != null : "fx:id=\"dni\" was not injected: check your FXML file 'RegistroEncargado.fxml'.";
        assert botonRegistroFin != null : "fx:id=\"botonRegistroFin\" was not injected: check your FXML file 'RegistroEncargado.fxml'.";

    }
}
