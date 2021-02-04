package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;
import clases.Paciente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class controladorRegistroPaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField respuesta;

    @FXML
    private JFXComboBox<String> preguntaSeguridad;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField edad;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXComboBox<String> genero;

    @FXML
    private JFXButton botonRegistroFin;
    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");
    ObservableList<String> generos = FXCollections.observableArrayList("Hombre", "Mujer");

    @FXML
    void registrarse(ActionEvent event) {
    	
    	//Creo el paciente (Medico aleatorio , mensajes y pulsaciones vacio
    	Paciente paciente = new Paciente(nombre.getText(), dni.getText(),pass.getText(),Integer.parseInt(edad.getText()),genero.getSelectionModel().getSelectedItem().toString(),
    			preguntaSeguridad.getSelectionModel().getSelectedItem().toString(),respuesta.getText(), false, false, false, telefono.getText());
    	
    	//Asigno al medico el paciente y lo guardamos en el Json
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		if(medicos.get(i).getNombre().equals(paciente.getMedico()))
    			encontrado = true;
    		i++;
    	}
    	medicos.get(i-1).aņadirPaciente(paciente);
    	medico.modificarMedico(medicos);
    	
    	//Informo al usuario del registro exitoso
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
	    alert.setTitle("Registrado");
	    alert.setContentText("Registrado con exito\nSu medico asociado es: " + paciente.getMedico());
	    alert.showAndWait();
    	Stage stage = (Stage) botonRegistroFin.getScene().getWindow();
    	stage.close();
    	
    }

    @FXML
    void initialize() {
    	preguntaSeguridad.setItems(preguntas);
    	genero.setItems(generos);
    }
}
