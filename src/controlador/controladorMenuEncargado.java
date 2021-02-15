package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import clases.Medico;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class controladorMenuEncargado {
	
	String pacienteEncargado = "";
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label paciente;

    @FXML
    private Label medico;

    @FXML
    private LineChart<Number, Number> chartPulsaciones;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Label posicion;

    @FXML
    private Label respiracion;
    
    void setMedico(String medico) {
    	this.medico.setText(this.medico.getText() + medico);
    }
    
    void setPaciente(String paciente) {
    	this.paciente.setText(this.paciente.getText() + paciente);
    	this.pacienteEncargado = paciente;
    	
    }
    
    void setPosicion(String posicion) {
    	this.posicion.setText(this.posicion.getText() + posicion);
    }
    
    void setRespiracion(String respiracion) {
    	this.respiracion.setText(this.respiracion.getText() + respiracion);
    }
    
    void setGrafica(String paciente) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	int j = 0;
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(paciente))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	XYChart.Series<Number, Number> pulsaciones = new XYChart.Series<>();
        pulsaciones.setName("Pulsaciones");
        ArrayList<Integer> pulsacionesList = medicos.get(i-1).getPacientes().get(j-1).getPulsaciones(); 
        
        for(int k = 0;k<pulsacionesList.size();k++) {
        	pulsaciones.getData().add(new XYChart.Data<>(k, pulsacionesList.get(k)));
        	System.out.println(pulsacionesList.get(k));
        }
        
        chartPulsaciones.getData().clear();
        chartPulsaciones.getData().add(pulsaciones);
    }
    
    
    @FXML
    void initialize() {
    	
    }
}
