package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class controladorLoginEncargado {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXPasswordField contrasena;

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXButton entrar;

    @FXML
    void entrarEnApp(ActionEvent event) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	
    	boolean encontrado = false;
    	int i = 0;
    	int j = 0;
    	while(i<medicos.size() &&!encontrado) {
    		while(j<medicos.get(i).getPacientes().size() && !encontrado){
    			if(medicos.get(i).getPacientes().get(j).getEncargado().getNombre().equals(usuario.getText()) && medicos.get(i).getPacientes().get(j).getPass().equals(contrasena.getText())) {			
    				encontrado = true;
    			}
    			j++;
    		}
    		i++;
    	}
    	if (encontrado) {
    		try {
    			FXMLLoader loaderMenuEncargado = new FXMLLoader(getClass().getResource("/vista/MenuEncargado.fxml"));
    			controladorMenuEncargado controlMenuEncargado = new controladorMenuEncargado();

                loaderMenuEncargado.setController(controlMenuEncargado);
                Parent rootMenuEncargado = loaderMenuEncargado.load();
                
                controlMenuEncargado.setMedico(medicos.get(i-1).getNombre());
                controlMenuEncargado.setPaciente(medicos.get(i-1).getPacientes().get(j-1).getNombre());
                controlMenuEncargado.setGrafica(medicos.get(i-1).getPacientes().get(j-1).getNombre());
                if(medicos.get(i-1).getPacientes().get(j-1).isRespiracion() == true)
                	controlMenuEncargado.setRespiracion("Anormal, contacte con el medico");
                else
                	controlMenuEncargado.setRespiracion("Normal");
                
                int k = 0;
            	boolean posicionEncontrada = false;
            	while(k<medicos.get(i-1).getPacientes().get(j-1).getSensores().size() != posicionEncontrada) {
            		if(medicos.get(i-1).getPacientes().get(j-1).getSensores().get(k) == true)
            			posicionEncontrada = true;
            		k++;
            	}
            	switch(k) {
            		case 0 : controlMenuEncargado.setPosicion("Cocina");
            		break;
            		case 1 :  controlMenuEncargado.setPosicion("Baño");
            		break;
            		case 2 :  controlMenuEncargado.setPosicion("Dormitorio");
            		break;
            		case 3 :  controlMenuEncargado.setPosicion("Salon");
            		break;
            		case 4 :  controlMenuEncargado.setPosicion("Fuera de casa");
            		break;
            	}
                
                Stage stage = new Stage();

                stage.setScene(new Scene(rootMenuEncargado));
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
    void initialize() {
        assert contrasena != null : "fx:id=\"contrasena\" was not injected: check your FXML file 'LoginEncargado.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'LoginEncargado.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'LoginEncargado.fxml'.";

    }
}
