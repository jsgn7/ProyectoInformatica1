package controlador;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

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

public class controladorRecuperarContraseña {

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
    private JFXButton botonCambioContraseña;
    
    ObservableList<String> preguntas = FXCollections.observableArrayList("Nombre de su mascota","Pelicula favorita","Color favorito");

    @FXML
    void cambiarContraseña(ActionEvent event) {
    	Vector<Usuario> usuarios = desserializarJsonAArray();
    	boolean usuarioCorrecto = false;
    	boolean preguntaSeguridadCorrecta = false;
    	boolean respuestaCorrecta = false;
    	int i = 0;
    	while(usuarios.size()<i || !usuarioCorrecto) {
    		if(usuarios.get(i).getNombreUsuario().equals(nombreUsuario1.getText()))
    			usuarioCorrecto = true;
    		if(usuarios.get(i).getPreguntaSeguridad().equals(preguntaSeguridad.getSelectionModel().getSelectedItem().toString()))
    			preguntaSeguridadCorrecta = true;
    		if(usuarios.get(i).getRespuesta().equals(respuesta.getText()))
    			respuestaCorrecta = true;
    	}
    	if(usuarioCorrecto && preguntaSeguridadCorrecta && respuestaCorrecta)
    		try {
    			FXMLLoader loaderCambioContraseña=new FXMLLoader(getClass().getResource("/vista/CambioContraseña.fxml"));
    			controladorCambioContraseña controlCambioContraseña=new controladorCambioContraseña();

                loaderCambioContraseña.setController(controlCambioContraseña);
                Parent rootCambioContraseña=loaderCambioContraseña.load();
                
                controlCambioContraseña.usuario(usuarios.get(i).getNombreUsuario());;
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(rootCambioContraseña));
                stage.show();	
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	Stage stage = (Stage) botonCambioContraseña.getScene().getWindow();
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
