package controlador;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import clases.Paciente;
import clases.Usuario;

import java.io.FileReader;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controladorRecuperarContrase�a {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> preguntaSeguridad;
    
    @FXML
    private JFXTextField nombreUsuario1;


    @FXML
    private JFXTextField respuesta;

    @FXML
    private JFXButton botonCambioContrase�a;
    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");

    @FXML
    void cambiarContrase�a(ActionEvent event) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> pacientes = paciente.recuperarPacientes();
    	boolean usuarioCorrecto = false;
    	boolean preguntaSeguridadCorrecta = false;
    	boolean respuestaCorrecta = false;
    	int i = 0;
    	while(pacientes.size()<i && !usuarioCorrecto) {
    		if(pacientes.get(i).getDni().equals(nombreUsuario1.getText()))
    			usuarioCorrecto = true;
    		if(pacientes.get(i).getPreguntaSeguridad().equals(preguntaSeguridad.getSelectionModel().getSelectedItem().toString()))
    			preguntaSeguridadCorrecta = true;
    		if(pacientes.get(i).getRespuesta().equals(respuesta.getText()))
    			respuestaCorrecta = true;
    		i++;
    	}
    	if(usuarioCorrecto && preguntaSeguridadCorrecta && respuestaCorrecta)
    		try {
    			FXMLLoader loaderCambioContrase�a=new FXMLLoader(getClass().getResource("/vista/CambioContrase�a.fxml"));
    			controladorCambioContrase�a controlCambioContrase�a=new controladorCambioContrase�a();

                loaderCambioContrase�a.setController(controlCambioContrase�a);
                Parent rootCambioContrase�a=loaderCambioContrase�a.load();
                
                controlCambioContrase�a.usuario(pacientes.get(i).getDni());;
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(rootCambioContrase�a));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	Stage stage = (Stage) botonCambioContrase�a.getScene().getWindow();
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
        preguntaSeguridad.setItems(preguntas);
    }
}
