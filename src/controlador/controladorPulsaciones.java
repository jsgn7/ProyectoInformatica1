package controlador;

//import java.awt.Label;
import java.util.Vector;

import clases.Medico;
import clases.Paciente;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class controladorPulsaciones {
	@FXML
    private Label textoNombre;
	
	@FXML
    private Label textoGenero;
	
	@FXML
    private Label textoEdad;
	
	@FXML
	private JFXButton botonVolver;
	
	@FXML
	private LineChart<Number, Number> chartPulsaciones;
	
	@FXML
	private NumberAxis xAxis;
	
	@FXML
	private NumberAxis yAxis;
	
	@FXML
	void clickAmbulancia() {
		Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	medicos.get(0).getPacientes().get(0).setAmbulancia(true);
    	medico.modificarMedico(medicos);
	}
	
	@FXML
	void clickVolver(ActionEvent event) {
		Stage stage = (Stage) botonVolver.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
    void initialize() {
		Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	Paciente paciente = medicos.get(0).getPacientes().get(0);
    	textoNombre.setText(paciente.getNombre());
    	textoGenero.setText(paciente.getGenero());
    	textoEdad.setText(String.valueOf(paciente.getEdad() + " años"));
    	
    	XYChart.Series<Number, Number> pulsaciones = new XYChart.Series<>();
        pulsaciones.setName("Pulsaciones");
        ArrayList<Integer> pulsacionesList = paciente.getPulsaciones();
        for (int i = 0; i < pulsacionesList.size(); i++) {
        	pulsaciones.getData().add(new XYChart.Data<>(i, pulsacionesList.get(i)));
        }

        chartPulsaciones.getData().add(pulsaciones);
    }
}
