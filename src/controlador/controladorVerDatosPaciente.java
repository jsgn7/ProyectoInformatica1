package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class controladorVerDatosPaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label doctor;

    @FXML
    private Label paciente;

    @FXML
    private Label dniPaciente;

    @FXML
    private Label edad;

    @FXML
    private Label genero;

    @FXML
    private Label telefonoPaciente;

    @FXML
    private Label nombreEncargado;

    @FXML
    private Label dniEncargado;

    @FXML
    private Label telefonoEncargado;

    @FXML
    private Label emailEncargado;
    
    void setDatos(String doctor, String paciente, String dniPaciente, String edad, String genero, String telefonoPaciente, 
    		String nombreEncargado, String dniEncargado, String telefonoEncargado, String emailEncargado) {
    	this.doctor.setText(this.doctor.getText() + doctor);
    	this.paciente.setText(this.paciente.getText() + paciente);
    	this.dniPaciente.setText(this.dniPaciente.getText() + dniPaciente);
    	this.edad.setText(this.edad.getText() + edad);
    	this.genero.setText(this.genero.getText() + genero);
    	this.telefonoPaciente.setText(this.telefonoPaciente.getText() + telefonoPaciente);
    	this.nombreEncargado.setText(this.nombreEncargado.getText() + nombreEncargado);
    	this.dniEncargado.setText(this.dniEncargado.getText() + dniEncargado);
    	this.telefonoEncargado.setText(this.telefonoEncargado.getText() + telefonoEncargado);
    	this.emailEncargado.setText(this.emailEncargado.getText() + emailEncargado);
    }
    
    @FXML
    void initialize() {
        assert doctor != null : "fx:id=\"doctor\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert paciente != null : "fx:id=\"paciente\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert dniPaciente != null : "fx:id=\"dniPaciente\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert edad != null : "fx:id=\"edad\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert genero != null : "fx:id=\"genero\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert telefonoPaciente != null : "fx:id=\"telefonoPaciente\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert nombreEncargado != null : "fx:id=\"nombreEncargado\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert dniEncargado != null : "fx:id=\"dniEncargado\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert telefonoEncargado != null : "fx:id=\"telefonoEncargado\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";
        assert emailEncargado != null : "fx:id=\"emailEncargado\" was not injected: check your FXML file 'VerDatosPaciente.fxml'.";

    }
}
