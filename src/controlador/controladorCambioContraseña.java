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

public class controladorCambioContraseña {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContraseñaBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContraseña;

    @FXML
    private JFXPasswordField CambioContraseñaConfirmar;

    @FXML
    void cambioDeContraseña(ActionEvent event) {
    	if(cambioContraseña.getText().equals(CambioContraseñaConfirmar.getText())) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		if(medicos.get(i).getNombre().equals(usuarioEtiqueta.getText())) {
    			medicos.get(i).setPass(cambioContraseña.getText());
    			encontrado = true;
    		} else {
    			int j = 0;
    			while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    				if(medicos.get(i).getPacientes().get(j).getNombre().equals(usuarioEtiqueta.getText())) {
    					medicos.get(i).getPacientes().get(j).setPass(cambioContraseña.getText());
    					encontrado = true;
    				}
    			}
    		}
    	}
    	medico.modificarMedico(medicos);
    	Stage stage = (Stage) cambiarContraseñaBoton.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Contraseñas no coinciden");
    	    alert.setContentText("Las contraseñas no coinciden");
    	    alert.showAndWait();
    	}
    }
    
    public void usuario(String usuario) {
    	usuarioEtiqueta.setText(usuario);
    }

    @FXML
    void initialize() {
        assert cambiarContraseñaBoton != null : "fx:id=\"cambiarContraseñaBoton\" was not injected: check your FXML file 'CambioContraseña.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContraseña.fxml'.";
        assert cambioContraseña != null : "fx:id=\"cambioContraseña\" was not injected: check your FXML file 'CambioContraseña.fxml'.";
        assert CambioContraseñaConfirmar != null : "fx:id=\"CambioContraseñaConfirmar\" was not injected: check your FXML file 'CambioContraseña.fxml'.";

    }
}
