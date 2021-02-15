package controlador;

import com.jfoenix.controls.JFXButton;

import clases.Medico;
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

public class controladorTicketPaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label paciente;

    @FXML
    private Label medico;

    @FXML
    private TextArea mensajeMedico;

    @FXML
    private TextArea mensajePaciente;

    @FXML
    private JFXButton botonResponder;

    @FXML
    private ComboBox<Integer> listaTickets;

    String pacienteActual;
    
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
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(this.pacienteActual))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).setMensajePaciente(mensajePaciente.getText());
    	medico.modificarMedico(medicos);
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
    			if(medicos.get(i).getPacientes().get(j).getNombre().equals(this.pacienteActual))
    				encontrado = true;
    			j++;
    		}
    		i++;
    	}
    	mensajeMedico.setText(medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajeMedico());
    	mensajePaciente.setText(medicos.get(i-1).getPacientes().get(j-1).getTickets().get(listaTickets.getSelectionModel().getSelectedItem()).getMensajePaciente());
    }

    void rellenarCB(String paciente){
        Medico medico = new Medico();
        Vector<Medico> medicos = medico.recuperarMedicos();

        int i = 0;
        int j = 0;
        boolean encontrado = false;
        while(i<medicos.size() && !encontrado){
            while(j<medicos.size() && !encontrado){
                if(medicos.get(i).getPacientes().get(j).getNombre().equals(paciente))
                    encontrado = true;
                j++;
            }
            i++;
        }

        ArrayList<Ticket> tickets = medicos.get(i-1).getPacientes().get(j-1).getTickets();
        for(int k = 0;k<tickets.size();k++){
            listaTickets.getItems().add(k);
        }

    
    }

    void setPaciente(String paciente){
        this.paciente.setText(this.paciente.getText() + paciente);
        this.pacienteActual = paciente;
    }

    @FXML
    void initialize() {

    }
}
