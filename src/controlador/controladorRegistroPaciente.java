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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    	ArrayList<Integer> pulsaciones = new ArrayList<Integer>();
    	Paciente paciente = new Paciente(nombre.getText(), dni.getText(),pass.getText(),Integer.parseInt(edad.getText()),genero.getSelectionModel().getSelectedItem().toString(),
    			preguntaSeguridad.getSelectionModel().getSelectedItem().toString(),respuesta.getText(),pulsaciones, false, false, false, telefono.getText());
    	paciente.añadirPaciente(paciente);
    }

    @FXML
    void initialize() {
    	preguntaSeguridad.setItems(preguntas);
    	genero.setItems(generos);
    }
}
