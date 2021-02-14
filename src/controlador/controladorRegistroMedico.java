package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;
import clases.Paciente;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
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

public class controladorRegistroMedico {
    
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
    private JFXButton botonRegistroFin;
    
    @FXML
    void registrarse(ActionEvent event) {
    	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    	Medico medico = new Medico(nombre.getText(),pass.getText(),preguntaSeguridad.getSelectionModel().getSelectedItem().toString(),respuesta.getText(),pacientes);
    	medico.anadirMedico(medico);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Registrado");
	    alert.setContentText("Registrado con exito");
	    alert.showAndWait();
    	Stage stage = (Stage) botonRegistroFin.getScene().getWindow();
    	stage.close();
    }
    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");

    @FXML
    void initialize() {
    	preguntaSeguridad.setItems(preguntas);
    }
}
