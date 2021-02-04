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
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		if(medicos.get(i).getNombre().equals(usuarioEtiqueta.getText())) {
    			medicos.get(i).setPass(cambioContraseņa.getText());
    			encontrado = true;
    		} else {
    			int j = 0;
    			while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    				if(medicos.get(i).getPacientes().get(j).getNombre().equals(usuarioEtiqueta.getText())) {
    					medicos.get(i).getPacientes().get(j).setPass(cambioContraseņa.getText());
    					encontrado = true;
    				}
    			}
    		}
    	}
    	medico.modificarMedico(medicos);
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
