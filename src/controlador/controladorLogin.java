package controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import clases.Usuario;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controladorLogin {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="contrase�a"
    private JFXPasswordField contrase�a; // Value injected by FXMLLoader

    @FXML // fx:id="usuario"
    private JFXTextField usuario; // Value injected by FXMLLoader

    @FXML // fx:id="recuperarContrase�a"
    private Label recuperarContrase�a; // Value injected by FXMLLoader

    @FXML // fx:id="entrar"
    private JFXButton entrar; // Value injected by FXMLLoader
    
    @FXML // fx:id="mensajeError"
    private Label mensajeError; // Value injected by FXMLLoader
    
    @FXML
    private JFXButton registro;
    
    @FXML
    void registrarse(ActionEvent event) {
    	try {
			FXMLLoader loaderRegistro=new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
			controladorRegistro controlRegistro=new controladorRegistro();

            loaderRegistro.setController(controlRegistro);
            Parent rootRegistro=loaderRegistro.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRegistro));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	@FXML
	void entrarEnApp(ActionEvent event) {
		Vector<Usuario> usuarios = desserializarJsonAArray();
		boolean nombreUsuario = false;
		boolean contrase�aCorrecta = false;
		int i = 0;
		while (i < usuarios.size() && !nombreUsuario) {
			if (usuarios.get(i).getNombreUsuario().equals(usuario.getText()))
				nombreUsuario = true;
			if (usuarios.get(i).getPass().equals(contrase�a.getText()))
				contrase�aCorrecta = true;
			i++;
		}
		if (nombreUsuario && contrase�aCorrecta) {
				try {
					if (usuarios.get(i-1).getRol().equals("Paciente")) {

						FXMLLoader loaderMenuPac = new FXMLLoader(getClass().getResource("/vista/MenuSeleccion.fxml"));
						controladorMenuSeleccionPaciente controlMenuPac = new controladorMenuSeleccionPaciente();

						loaderMenuPac.setController(controlMenuPac);
						Parent rootMenuPac = loaderMenuPac.load();
						
						Stage stage = new Stage();
						
						stage.setScene(new Scene(rootMenuPac));
						stage.show();
						
						Stage stage1 = (Stage) entrar.getScene().getWindow();
						stage1.close();
					}else {

						FXMLLoader loaderMenuMed = new FXMLLoader(getClass().getResource("/vista/MenuSeleccion.fxml"));
						controladorMenuSeleccionMedicos controlMenuMed = new controladorMenuSeleccionMedicos();

						loaderMenuMed.setController(controlMenuMed);
						Parent rootMenuMed = loaderMenuMed.load();
						
						Stage stage = new Stage();
						stage.setScene(new Scene(rootMenuMed));
						stage.show();
						
						Stage stage1 = (Stage) entrar.getScene().getWindow();
						stage1.close();
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		} else {
			mensajeError.setText("Usuario o contrase�a incorrectos");
		}
	}

    @FXML
    void recuperarContrase�aVentana(MouseEvent event) {
    	try {
			FXMLLoader loaderRecuperarContrase�a=new FXMLLoader(getClass().getResource("/vista/RecuperarContrase�a.fxml"));
			controladorRecuperarContrase�a controlRecuperarContrase�a=new controladorRecuperarContrase�a();

            loaderRecuperarContrase�a.setController(controlRecuperarContrase�a);
            Parent rootRecuperarContrase�a=loaderRecuperarContrase�a.load();
            
            Stage stage = new Stage();

            stage.setScene(new Scene(rootRecuperarContrase�a));
            stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    /*
     * Lee un fichero JSON y lo guarda en un vector de Usuarios
     */
    public Vector<Usuario> desserializarJsonAArray(){
    	Vector<Usuario> usuarios = new Vector<Usuario>();
    	
    	try(Reader reader = new FileReader("usuarios.json")){
    		Gson gson = new Gson();
    		Type tipoListaUsuarios = new TypeToken<Vector<Usuario>>() {}.getType();
    		usuarios = gson.fromJson(reader, tipoListaUsuarios);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return usuarios;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert contrase�a != null : "fx:id=\"contrase�a\" was not injected: check your FXML file 'Login.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'Login.fxml'.";
        assert recuperarContrase�a != null : "fx:id=\"recuperarContrase�a\" was not injected: check your FXML file 'Login.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
