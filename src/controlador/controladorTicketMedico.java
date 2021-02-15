package controlador;
import com.jfoenix.controls.JFXButton;

import clases.Medico;
import clases.Paciente;
import clases.Ticket;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class controladorTicketMedico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label medico;

    @FXML
    private TextArea mensajePaciente;

    @FXML
    private TextArea mensajeMedico;

    @FXML
    private JFXButton botonResponder;

    @FXML
    private ComboBox<String> listaPacientes;

    @FXML
    private ComboBox<Integer> listaTickets;
    
    String medicoActual;

    @FXML
    void responder(ActionEvent event) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	boolean encontrado = false;
    	int i = 0;
    	int j = 0;
    	while(i<medicos.size() && !encontrado) {
    		j = 0;
    		while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(listaPacientes.getSelectionModel().getSelectedItem()))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).setMensajeMedico(mensajeMedico.getText());
    	medico.modificarMedico(medicos);
    }

    @FXML
    void seleccionPaciente(ActionEvent event) {
    	Medico medico = new Medico();
        Vector<Medico> medicos = medico.recuperarMedicos();

        int i = 0;
        int j = 0;
        boolean encontrado = false;
        while(i<medicos.size() && !encontrado){
            while(j<medicos.size() && !encontrado){
                if(medicos.get(i).getPacientes().get(j).getNombre().equals(listaPacientes.getSelectionModel().getSelectedItem()))
                    encontrado = true;
                j++;
            }
            i++;
        }
        
        listaTickets.getItems().clear();

        ArrayList<Ticket> tickets = medicos.get(i-1).getPacientes().get(j-1).getTickets();
        for(int k = 0;k<tickets.size();k++){
            listaTickets.getItems().add(k);
        }
        
        listaTickets.setDisable(false);

    
    }

    @FXML
    void seleccionTicket(ActionEvent event) {
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	boolean encontrado = false;
    	int i = 0;
    	int j = 0;
    	while(i<medicos.size() && !encontrado) {
    		j = 0;
    		while(j<medicos.get(i).getPacientes().size() && !encontrado) {
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(listaPacientes.getSelectionModel().getSelectedItem()))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	//String mensajeMedico = medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajeMedico();
    	//String mensajePaciente = medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajePaciente();
    	try {
    	this.mensajeMedico.setText(medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajeMedico());
    	} catch(Exception e){
    		
    	}
    	try {
    	this.mensajePaciente.setText(medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajePaciente());
    	} catch(Exception e){
    		
    	}
    }

    void setMedico(String medico) {
    	this.medico.setText(this.medico.getText() + medico);
    	this.medicoActual = medico;
    }
    
    void rellenarCB(String medicoActual){
        Medico medico = new Medico();
        Vector<Medico> medicos = medico.recuperarMedicos();

        int i = 0;
        boolean encontrado = false;
        while(i<medicos.size() && !encontrado){
                if(medicos.get(i).getNombre().equals(this.medicoActual))
                    encontrado = true;
            i++;
        }

        ArrayList<Paciente> pacientes = medicos.get(i-1).getPacientes();
        for(int k = 0;k<pacientes.size();k++){
            listaPacientes.getItems().add(pacientes.get(k).getNombre());
        }
    }
    
    @FXML
    void initialize() {
    }
}
