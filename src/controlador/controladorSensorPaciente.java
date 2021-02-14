package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import clases.Medico;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controladorSensorPaciente {
	
	private String medicoSesion;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label doctor;

    @FXML
    private JFXComboBox<String> pacientes;

    @FXML
    private Label posicion;

    @FXML
    private Label respiracion;

    @FXML
    private JFXButton boton;
    
    int i = 0;
    int j = 0;
    
    @FXML
    void seleccionPaciente(ActionEvent event) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	boolean encontrado = false;
    	while(i<medicos.size() && !encontrado) {
    		j = 0;
    		while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(pacientes.getSelectionModel().getSelectedItem()))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	int k = 0;
    	boolean posicionEncontrada = false;
    	while(k<medicos.get(i-1).getPacientes().get(j-1).getSensores().size() != posicionEncontrada) {
    		if(medicos.get(i-1).getPacientes().get(j-1).getSensores().get(k) == true)
    			posicionEncontrada = true;
    		k++;
    	}
    	switch(k) {
    		case 0 : posicion.setText("Cocina");
    		break;
    		case 1 : posicion.setText("Baño");
    		break;
    		case 2 : posicion.setText("Dormitorio");
    		break;
    		case 3 : posicion.setText("Salon");
    		break;
    		case 4 : posicion.setText("Fuera de casa");
    		break;
    	}
    	if(medicos.get(i-1).getPacientes().get(j-1).isRespiracion() == false) {
    		respiracion.setText("Normal");
    	} else {
    		respiracion.setText("Anormal, contacte con el paciente");
    	}
    }

    @FXML
    void verPaciente(ActionEvent event) {
    	try {
    		Medico medico = new Medico();
    		Vector<Medico> medicos = medico.recuperarMedicos();
			FXMLLoader loaderDatosPac =new FXMLLoader(getClass().getResource("/vista/VerDatosPaciente.fxml"));
			controladorVerDatosPaciente controlDatosPac = new controladorVerDatosPaciente();

            loaderDatosPac.setController(controlDatosPac);
            Parent rootSensorPac=loaderDatosPac.load();
            
            controlDatosPac.setDatos(medicoSesion, 
            		medicos.get(i-1).getPacientes().get(j-1).getNombre(),
            		medicos.get(i-1).getPacientes().get(j-1).getDni(), 
            		Integer.toString(medicos.get(i-1).getPacientes().get(j-1).getEdad()), 
            		medicos.get(i-1).getPacientes().get(j-1).getGenero(), 
            		medicos.get(i-1).getPacientes().get(j-1).getTelefono(), 
            		medicos.get(i-1).getPacientes().get(j-1).getEncargado().getNombre(), 
            		medicos.get(i-1).getPacientes().get(j-1).getEncargado().getDni(), 
            		medicos.get(i-1).getPacientes().get(j-1).getEncargado().getTelefono(), 
            		medicos.get(i-1).getPacientes().get(j-1).getEncargado().getEmail());
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootSensorPac));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    void setMedico(String medico) {
    	doctor.setText(doctor.getText() + medico);
    	medicoSesion = medico;
    }

    @FXML
    void initialize() {
        Medico medico = new Medico();
        Vector<Medico> medicos = medico.recuperarMedicos();
        
        int i = 0;
        boolean encontrado = false;
        while(i<medicos.size() && !encontrado) {
        	if(medicos.get(i).getNombre().equals(medicoSesion))
        		encontrado = true;
        	i++;
        }
        
       int j = 0;
       while(j<medicos.get(i-1).getPacientes().size()) {
    	   pacientes.getItems().add(medicos.get(i-1).getPacientes().get(j).getNombre());
    	   j++;
       }
        

    }
}
