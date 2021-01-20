package controlador;



/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Medico;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controladorLoginMedico {

	   @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private JFXPasswordField contraseña;

	    @FXML
	    private JFXTextField usuario;

	    @FXML
	    private Label recuperarContraseña;

	    @FXML
	    private JFXButton botonRegistro;

	    @FXML
	    private JFXButton entrar;
    
    @FXML
    void registro(ActionEvent event) {
    	try {
			FXMLLoader loaderRegistroMedico=new FXMLLoader(getClass().getResource("/vista/RegistroMedico.fxml"));
			controladorRegistroMedico controlRegistroMedico=new controladorRegistroMedico();

            loaderRegistroMedico.setController(controlRegistroMedico);
            Parent rootRegistroMedico=loaderRegistroMedico.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRegistroMedico));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	@FXML
	void entrarEnApp(ActionEvent event) {
		Medico medico = new Medico();
		Vector<Medico> medicos = medico.recuperarMedicos();
		int i = 0;
		boolean encontrado = false;
		while(i<medicos.size() && !encontrado) {
			if(medicos.get(i).getNombre().equals(usuario.getText()) && medicos.get(i).getPass().equals(contraseña.getText()))
				encontrado = true;
			i++;
		}
		if(encontrado) {
			try {
				FXMLLoader loaderMenuSeleccion=new FXMLLoader(getClass().getResource("/vista/MenuSeleccion.fxml"));
				controladorMenuSeleccionMedicos controlMenuSeleccion=new controladorMenuSeleccionMedicos();

	            loaderMenuSeleccion.setController(controlMenuSeleccion);
	            Parent rootMenuSeleccion=loaderMenuSeleccion.load();
	            
	            Stage stage = new Stage();

	            stage.setScene(new Scene(rootMenuSeleccion));
	            stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error de identificacion");
    	    alert.setContentText("Usuario o contraseña incorrectos");
    	    alert.showAndWait();
		}
	}

    @FXML
    void recuperarContraseñaVentana(MouseEvent event) {
    	try {
			FXMLLoader loaderRecuperarContraseña=new FXMLLoader(getClass().getResource("/vista/RecuperarContraseña.fxml"));
			controladorRecuperarContraseña controlRecuperarContraseña=new controladorRecuperarContraseña();

            loaderRecuperarContraseña.setController(controlRecuperarContraseña);
            Parent rootRecuperarContraseña=loaderRecuperarContraseña.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRecuperarContraseña));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert contraseña != null : "fx:id=\"contraseña\" was not injected: check your FXML file 'Login.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert recuperarContraseña != null : "fx:id=\"recuperarContraseña\" was not injected: check your FXML file 'Login.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
