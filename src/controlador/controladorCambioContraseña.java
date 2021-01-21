package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;

import clases.Medico;
import clases.Paciente;
import clases.Usuario;

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

public class controladorCambioContraseņa {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContraseņaBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContraseņa;

    @FXML
    private JFXPasswordField CambioContraseņaConfirmar;

    @FXML
    void cambioDeContraseņa(ActionEvent event) {
    	if(cambioContraseņa.getText().equals(CambioContraseņaConfirmar.getText())) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> pacientes = paciente.recuperarPacientes();
    	boolean encontrado = false;
    	int i = 0;
    	while(i<pacientes.size() && !encontrado) {
    		if(pacientes.get(i).getDni().equals(usuarioEtiqueta.getText())) {
    			encontrado = true;
    		}
    		if(encontrado) {
    			pacientes.get(i).setPass(cambioContraseņa.getText());
    			paciente.modificarPaciente(pacientes);
    		}
    		i++;
    	}
    	if(!encontrado) {
    		Medico medico = new Medico();
    		Vector<Medico> medicos = medico.recuperarMedicos();
    		i = 0;
    		while(i<medicos.size() && !encontrado) {
    			if(medicos.get(i).getNombre().equals(usuarioEtiqueta.getText()))
    				encontrado = true;
    			if(encontrado) {
    				medicos.get(i).setPass(cambioContraseņa.getText());
    				medico.modificarMedico(medicos);
    			}
    			i++;
    		}
    	}
    	Stage stage = (Stage) cambiarContraseņaBoton.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Contraseņas no coinciden");
    	    alert.setContentText("Las contraseņas no coinciden");
    	    alert.showAndWait();
    	}
    }
    
    public void usuario(String usuario) {
    	usuarioEtiqueta.setText(usuario);
    }

    @FXML
    void initialize() {
        assert cambiarContraseņaBoton != null : "fx:id=\"cambiarContraseņaBoton\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert cambioContraseņa != null : "fx:id=\"cambioContraseņa\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert CambioContraseņaConfirmar != null : "fx:id=\"CambioContraseņaConfirmar\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";

    }
}
