package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

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

public class controladorRegistro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXTextField NombreUsuario;

    @FXML
    private JFXTextField Rol;

    @FXML
    private JFXButton confirmar;

    @FXML
    void registro(ActionEvent event) {
    	Vector<Usuario> usuarios = desserializarJsonAArray();
    	Usuario usuario = new Usuario(NombreUsuario.getText(),Password.getText(),Rol.getText());
    	usuarios.add(usuario);
    	Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	
		try(FileWriter writer = new FileWriter("empleados.json")){
			prettyGson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'Registro.fxml'.";
        assert NombreUsuario != null : "fx:id=\"NombreUsuario\" was not injected: check your FXML file 'Registro.fxml'.";
        assert Rol != null : "fx:id=\"Rol\" was not injected: check your FXML file 'Registro.fxml'.";
        assert confirmar != null : "fx:id=\"confirmar\" was not injected: check your FXML file 'Registro.fxml'.";

    }
}
