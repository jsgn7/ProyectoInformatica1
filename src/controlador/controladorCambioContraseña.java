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

public class controladorCambioContrase�a {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContrase�aBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContrase�a;

    @FXML
    private JFXPasswordField CambioContrase�aConfirmar;

    @FXML
    void cambioDeContrase�a(ActionEvent event) {
    	if(cambioContrase�a.getText().equals(CambioContrase�aConfirmar.getText())) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> pacientes = paciente.recuperarPacientes();
    	boolean encontrado = false;
    	int i = 0;
    	while(i<pacientes.size() && !encontrado) {
    		if(pacientes.get(i).getDni().equals(usuarioEtiqueta.getText())) {
    			encontrado = true;
    		}
    		if(encontrado) {
    			pacientes.get(i).setPass(cambioContrase�a.getText());
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
    				medicos.get(i).setPass(cambioContrase�a.getText());
    				medico.modificarMedico(medicos);
    			}
    			i++;
    		}
    	}
    	Stage stage = (Stage) cambiarContrase�aBoton.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Contrase�as no coinciden");
    	    alert.setContentText("Las contrase�as no coinciden");
    	    alert.showAndWait();
    	}
    }
    
    public void usuario(String usuario) {
    	usuarioEtiqueta.setText(usuario);
    }

    @FXML
    void initialize() {
        assert cambiarContrase�aBoton != null : "fx:id=\"cambiarContrase�aBoton\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert cambioContrase�a != null : "fx:id=\"cambioContrase�a\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert CambioContrase�aConfirmar != null : "fx:id=\"CambioContrase�aConfirmar\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";

    }
}
