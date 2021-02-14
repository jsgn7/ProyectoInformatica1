package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;

import clases.Medico;
import clases.Paciente;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controladorCambioContrasena {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContrasenaBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContrasena;

    @FXML
    private JFXPasswordField CambioContrasenaConfirmar;

    @FXML
    void cambioDeContrasena(ActionEvent event) {
    	if(cambioContrasena.getText().equals(CambioContrasenaConfirmar.getText())) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		if(medicos.get(i).getNombre().equals(usuarioEtiqueta.getText())) {
    			medicos.get(i).setPass(cambioContrasena.getText());
    			encontrado = true;
    		} else {
    			int j = 0;
    			while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    				if(medicos.get(i).getPacientes().get(j).getNombre().equals(usuarioEtiqueta.getText())) {
    					medicos.get(i).getPacientes().get(j).setPass(cambioContrasena.getText());
    					encontrado = true;
    					j++;
    				}
    				i++;
    			}
    		}
    	}
    	medico.modificarMedico(medicos);
    	Stage stage = (Stage) cambiarContrasenaBoton.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Contrasenas no coinciden");
    	    alert.setContentText("Las contrasenas no coinciden");
    	    alert.showAndWait();
    	}
    }
    
    public void usuario(String usuario) {
    	usuarioEtiqueta.setText(usuario);
    }

    @FXML
    void initialize() {
        assert cambiarContrasenaBoton != null : "fx:id=\"cambiarContrasenaBoton\" was not injected: check your FXML file 'CambioContrasena.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContrasena.fxml'.";
        assert cambioContrasena != null : "fx:id=\"cambioContrasena\" was not injected: check your FXML file 'CambioContrasena.fxml'.";
        assert CambioContrasenaConfirmar != null : "fx:id=\"CambioContrasenaConfirmar\" was not injected: check your FXML file 'CambioContrasena.fxml'.";

    }
}
