package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import clases.Paciente;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;

public class controladorTicketPaciente {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label etiquetaNombrePaciente;

	@FXML
	private Label etiquetaDniPaciente;

	@FXML
	private Label etiquetaMedico;

	@FXML
	private JFXTextArea pregunta;

	@FXML
	private JFXTextArea respuesta;

	@FXML
	private JFXButton botonRespuesta;

	@FXML
	private TreeTableColumn<?, ?> tablaMensajes;


	@FXML
	void anterior(ActionEvent event) {

	}

	@FXML
	void responder(ActionEvent event) {
		
	}

	@FXML
	void siguiente(ActionEvent event) {

	}

	public void dniPaciente(String dni) {
		etiquetaDniPaciente.setText(dni);
	}

	public void nombrePaciente(String nombrePacienteActual) {
		etiquetaNombrePaciente.setText(nombrePacienteActual);
	}

	public void doctor(String nombreDoctor) {
		etiquetaMedico.setText(etiquetaMedico.getText() + nombreDoctor);
	}

	public void setPregunta(String texto) {
		pregunta.setText(texto);
	}

	@FXML
	void initialize() {
		
	}
}
