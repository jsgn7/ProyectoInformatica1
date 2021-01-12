package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import clases.Personas;
import clases.Sensores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class controladorsensorpaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Sensores> tablasensores;

    @FXML
    private TableColumn<Sensores, String> nombrecl;

    @FXML
    private TableColumn<Sensores, String> apellidocl;

    @FXML
    private TableColumn<Sensores, String> sensorescl;

    @FXML
    private TableColumn<Sensores, String> sensorescl2;

    @FXML
    private TableColumn<Sensores, String> telefonocl;

    @FXML
    private TextField tfnombre;

    @FXML
    private TextField tfapellido;

    @FXML
    private TextField tfsensores;

    @FXML
    private TextField tftelefono;

    @FXML
    private Button anadirbutton;

    @FXML
    private Button eliminabutton;

    @FXML
    private TextField tfsensores2;
    
    ObservableList<Sensores> sensores;
	private int posicionSensoresenTabla;
	
	ObservableList<Sensores>listasensores= FXCollections.observableArrayList(
			new Sensores("Juan", "Castejo", 658251652, false , false)
			);

    @FXML
    void anadir(ActionEvent event) {
    	Sensores sensor= new Sensores();
		
    	sensor.setNombre(tfnombre.getText());
    	sensor.setApellido(tfapellido.getText());
    	sensor.setTelefono(Integer.parseInt(tftelefono.getText()));
    	sensor.setSensores(Boolean.parseBoolean(tfsensores.getText()));
    	sensor.setSensores2((Boolean.parseBoolean(tfsensores2.getText())));
    	listasensores.add(sensor);
    }

    @FXML
    void eliminar(ActionEvent event) {
    	listasensores.remove(posicionSensoresenTabla);
    }

    @FXML
   public void initialize() {
      
    	tablasensores.setItems(listasensores);
    	nombrecl.setCellValueFactory(new PropertyValueFactory<Sensores, String>("Nombre"));
    	apellidocl.setCellValueFactory(new PropertyValueFactory<Sensores, String>("Apellidos"));
    	sensorescl.setCellValueFactory(new PropertyValueFactory<Sensores, String>("Sensores"));
    	sensorescl2.setCellValueFactory(new PropertyValueFactory<Sensores, String>("Sensores2"));
    	telefonocl.setCellValueFactory(new PropertyValueFactory<Sensores, String>("Telefono"));
    	
    }
}
