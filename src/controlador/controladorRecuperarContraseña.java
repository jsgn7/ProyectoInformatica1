package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;
import clases.Paciente;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class controladorRecuperarContraseña {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private JFXComboBox<String> preguntaSeguridadCambio;

	    @FXML
	    private JFXTextField respuestaCambio;

	    @FXML
	    private JFXButton botonCambioContraseña;

	    @FXML
	    private JFXTextField nombreUsuario;

    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");

    @FXML
    void cambiarContraseña(ActionEvent event) {
    	boolean esMedico = false;
    	boolean encontrado = false;
    	boolean informacionCorrecta = false;
    	Medico medico = new Medico();
    	Vector<Medico> medicos = medico.recuperarMedicos();
    	int i = 0;
    	int j = 0;
    	while(i<medicos.size() && !encontrado && !esMedico) {
    		if(medicos.get(i).getNombre().equals(nombreUsuario.getText())) {
    			esMedico = true;
    			encontrado = true;
    			if(medicos.get(i).getPreguntaSeguridad().equals(preguntaSeguridadCambio.getSelectionModel().getSelectedItem().toString()) && 
    					medicos.get(i).getRespuesta().equals(respuestaCambio.getText())) {
    				informacionCorrecta = true;
    			}
    		} else {
    			j = 0;
    			while(j<medicos.get(i).getPacientes().size() && !encontrado && !esMedico) {
    				if(medicos.get(i).getPacientes().get(j).getNombre().equals(nombreUsuario.getText())) {
    					encontrado = true;
    					if(medicos.get(i).getPacientes().get(j).getPreguntaSeguridad().equals(preguntaSeguridadCambio.getSelectionModel().getSelectedItem().toString()) &&
    							medicos.get(i).getPacientes().get(j).getRespuesta().equals(respuestaCambio.getText())) {
    						informacionCorrecta = true;
    					}
    				}
    				j++;
    			}
    		}
    		i++;
    	}
		
    	if(encontrado && informacionCorrecta) {
    		try {
    			FXMLLoader loaderCambioContraseña=new FXMLLoader(getClass().getResource("/vista/CambioContraseña.fxml"));
    			controladorCambioContraseña controlCambioContraseña=new controladorCambioContraseña();

                loaderCambioContraseña.setController(controlCambioContraseña);
                Parent rootCambioContraseña=loaderCambioContraseña.load();
                
                if(!esMedico) {
                	controlCambioContraseña.usuario(medicos.get(i-1).getPacientes().get(j-1).getNombre());
                } else {
                	controlCambioContraseña.usuario(medicos.get(i-1).getNombre());
                }
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(rootCambioContraseña));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    	}
    	Stage stage = (Stage) botonCambioContraseña.getScene().getWindow();
    	stage.close();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error de identificacion");
    	    alert.setContentText("Informacion incorrecta");
    	    alert.showAndWait();
    	}
    }

    @FXML
    void initialize() {
        preguntaSeguridadCambio.setItems(preguntas);
    }
}
