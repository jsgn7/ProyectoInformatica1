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

public class controladorCambioContrase�a {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton cambiarContrase�aBoton;

    @FXML
    private Label usuarioEtiqueta;

    @FXML
    private JFXPasswordField cambioContrase�a;

    @FXML
    private JFXPasswordField CambioContrase�aConfirmar;

    @FXML
    void cambioDeContrase�a(ActionEvent event) {
    	Vector<Usuario> usuarios = desserializarJsonAArray();
    	if(cambioContrase�a.getText().equals(CambioContrase�aConfirmar.getText())) {
    		int i = 0;
    		boolean encontrado = false;
    		while(i<usuarios.size() && !encontrado) {
    			if(usuarios.get(i).getNombreUsuario().equals(usuarioEtiqueta.getText()))
    				encontrado = true;
    		}
    		usuarios.get(i).setContrase�a(cambioContrase�a.getText());
    	}
    	Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
    	try (FileWriter writer = new FileWriter("usuarios.json",false)){
    		prettyGson.toJson(usuarios,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Stage stage = (Stage) cambiarContrase�aBoton.getScene().getWindow();
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
        assert cambiarContrase�aBoton != null : "fx:id=\"cambiarContrase�aBoton\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert usuarioEtiqueta != null : "fx:id=\"usuarioEtiqueta\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert cambioContrase�a != null : "fx:id=\"cambioContrase�a\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";
        assert CambioContrase�aConfirmar != null : "fx:id=\"CambioContrase�aConfirmar\" was not injected: check your FXML file 'CambioContrase�a.fxml'.";

    }
}
