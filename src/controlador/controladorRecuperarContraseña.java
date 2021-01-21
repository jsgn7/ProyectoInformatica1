package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;
import clases.Paciente;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class controladorRecuperarContrase�a {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private JFXComboBox<String> preguntaSeguridadCambio;

	    @FXML
	    private JFXTextField respuestaCambio;

	    @FXML
	    private JFXButton botonCambioContrase�a;

	    @FXML
	    private JFXTextField nombreUsuario;

    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");

    @FXML
    void cambiarContrase�a(ActionEvent event) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> pacientes = paciente.recuperarPacientes();
    	boolean respuestaCorrecta = false;
    	boolean usuarioCorrecto = false;
    	boolean preguntaCorrecta = false;
    	boolean esPaciente = true;
    	int i = 0;
    	while(i<pacientes.size() && !usuarioCorrecto) {
    		if(pacientes.get(i).getDni().equals(nombreUsuario.getText()))
    				usuarioCorrecto = true;
    		if(pacientes.get(i).getPreguntaSeguridad().equals(preguntaSeguridadCambio.getSelectionModel().getSelectedItem().toString()))
    				preguntaCorrecta = true;
    		if(pacientes.get(i).getRespuesta().equals(respuestaCambio.getText())) {
    			respuestaCorrecta = true;
    		}
    		i++;
    	}
    	if(!usuarioCorrecto)
    	esPaciente = false;
    	
		Medico medico = new Medico();
		Vector<Medico> medicos = medico.recuperarMedicos();
		i = 0;
		while (i < medicos.size() && !usuarioCorrecto) {
			System.out.println(medicos.get(i).getNombre().equals(nombreUsuario.getText()));
			if (medicos.get(i).getNombre().equals(nombreUsuario.getText()))
				usuarioCorrecto = true;
			if (medicos.get(i).getPreguntaSeguridad()
					.equals(preguntaSeguridadCambio.getSelectionModel().getSelectedItem().toString()))
				preguntaCorrecta = true;
			if (medicos.get(i).getRespuesta().equals(respuestaCambio.getText())) {
				respuestaCorrecta = true;
			}
			i++;
		}
		
    	if(respuestaCorrecta && usuarioCorrecto && preguntaCorrecta) {
    		try {
    			FXMLLoader loaderCambioContrase�a=new FXMLLoader(getClass().getResource("/vista/CambioContrase�a.fxml"));
    			controladorCambioContrase�a controlCambioContrase�a=new controladorCambioContrase�a();

                loaderCambioContrase�a.setController(controlCambioContrase�a);
                Parent rootCambioContrase�a=loaderCambioContrase�a.load();
                
                if(esPaciente) {
                	controlCambioContrase�a.usuario(pacientes.get(i-1).getDni());
                } else {
                	controlCambioContrase�a.usuario(medicos.get(i-1).getNombre());
                }
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(rootCambioContrase�a));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    	}
    	Stage stage = (Stage) botonCambioContrase�a.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error de identificacion");
    	    alert.setContentText("Informacion incorrecta");
    	    alert.showAndWait();
    	}
    }

    @FXML
    void initialize() {
        preguntaSeguridadCambio.setItems(preguntas);
    }
}
