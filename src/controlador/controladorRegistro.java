package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

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
    private JFXComboBox<String> Rol;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField apellidos;

    @FXML
    private JFXTextField edad;

    @FXML
    private JFXTextField respuesta;

    @FXML
    private JFXComboBox<String> preguntaSeguridad1;

    @FXML
    private JFXButton confirmar;
    
    ObservableList<String> roles = FXCollections.observableArrayList("Medico","Paciente");
    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");
    
    @FXML
    void registro(ActionEvent event) {
    	Vector<Usuario> usuarios = desserializarJsonAArray();
    	Usuario usuario = new Usuario(NombreUsuario.getText(), Password.getText(), Rol.getSelectionModel().getSelectedItem().toString(),
    			dni.getText(),nombre.getText(), apellidos.getText(),Integer.parseInt(edad.getText()),preguntaSeguridad1.getSelectionModel().getSelectedItem().toString(),
    			respuesta.getText());
    	usuarios.add(usuario);
    	Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
    	try (FileWriter writer = new FileWriter("usuarios.json",false)){
    		prettyGson.toJson(usuarios,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Stage stage = (Stage) confirmar.getScene().getWindow();
		stage.close();
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
    	Rol.setItems(roles);
    	preguntaSeguridad1.setItems(preguntas);
    }
}
