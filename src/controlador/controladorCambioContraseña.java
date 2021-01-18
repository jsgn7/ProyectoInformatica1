package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;

import clases.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controladorCambioContraseņa {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContraseņaBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContraseņa;

    @FXML
    private JFXPasswordField CambioContraseņaConfirmar;

    @FXML
    void cambioDeContraseņa(ActionEvent event) {
    	Vector<Usuario> usuarios = desserializarJsonAArray();
    	if(cambioContraseņa.getText().equals(CambioContraseņaConfirmar.getText())) {
    		int i = 0;
    		boolean encontrado = false;
    		while(i<usuarios.size() && !encontrado) {
    			if(usuarios.get(i).getNombreUsuario().equals(usuarioEtiqueta.getText()))
    				encontrado = true;
    		}
    		usuarios.get(i).setContraseņa(cambioContraseņa.getText());
    	}
    	Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
    	try (FileWriter writer = new FileWriter("usuarios.json",false)){
    		prettyGson.toJson(usuarios,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Stage stage = (Stage) cambiarContraseņaBoton.getScene().getWindow();
    	stage.close();
    }
    
    public void usuario(String usuario) {
    	usuarioEtiqueta.setText(usuario);
    }
    
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

    @FXML
    void initialize() {
        assert cambiarContraseņaBoton != null : "fx:id=\"cambiarContraseņaBoton\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert cambioContraseņa != null : "fx:id=\"cambioContraseņa\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";
        assert CambioContraseņaConfirmar != null : "fx:id=\"CambioContraseņaConfirmar\" was not injected: check your FXML file 'CambioContraseņa.fxml'.";

    }
}
