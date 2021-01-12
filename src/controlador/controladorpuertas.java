package controlador;

import clases.Personas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class controladorpuertas {

	@FXML
	private TableView<Personas> tablapersonas;

	@FXML
	private TableColumn<Personas, String> nombreCL;

	@FXML
	private TableColumn<Personas, String> apellidoCL;

	@FXML
	private TableColumn<Personas, String> DNICL;

	@FXML
	private TableColumn<Personas, String> telefonocl;

	@FXML
	private TableColumn<Personas, String> sensorespuertascl;

	ObservableList<Personas> personas;
	private int posicionPersonasenTabla;

	@FXML
	private TextField tfnombre;

	@FXML
	private TextField tfapellidos;

	@FXML
	private TextField tfdni;

	@FXML
	private TextField tftelefono;

	@FXML
	private TextField tfsensores;

	@FXML
	private Button añadirbutton;

	@FXML
	private Button modificarbutton;

	@FXML
	private Button eliminarbutton;



	ObservableList<Personas> listapersona=FXCollections.observableArrayList(
			new Personas("Juan", "Hernansez", 658251652, 505875585 , false)
			//new Personas(null, null, posicionPersonaEnTabla, posicionPersonaEnTabla, false),
			//new Personas(null, null, posicionPersonaEnTabla, posicionPersonaEnTabla, false)
			);



	private int posicionPersonaEnTabla;
	/**
	 * Método que realiza las acciones tras pulsar el boton "Añadir"
	 *
	 * @param event
	 */
	@FXML
	void anadir(ActionEvent event) {
		Personas persona= new Personas();
		
		persona.setNombre(tfnombre.getText());
		persona.setApellido(tfapellidos.getText());
		persona.setDNI(Integer.parseInt(tfdni.getText()));
		persona.setTelefono(Integer.parseInt(tftelefono.getText()));
		persona.setSensor(Boolean.parseBoolean(tfsensores.getText()));
		listapersona.add(persona);
	}
	/**
	 * Método que realiza las acciones tras pulsar el boton "Eliminar"
	 *
	 * @param event
	 */
	@FXML
	void eliminar(ActionEvent event) {
		listapersona.remove(posicionPersonasenTabla);

	}

	/**
	 * Método que realiza las acciones tras pulsar el boton "Modificar"
	 *
	 * @param event
	 */
	@FXML private void modificar(ActionEvent event) {
		Personas persona = new Personas();
		persona.setNombre(tfnombre.getText());
		persona.setApellido(tfapellidos.getText());
		persona.setDNI(Integer.parseInt(tfdni.getText()));
		persona.setTelefono(Integer.parseInt(tftelefono.getText()));
		persona.setSensor(Boolean.parseBoolean(tfsensores.getText()));
		
		listapersona.set(posicionPersonasenTabla, persona);
	}

	/**
	 * Método para inicializar la tabla
	 */
	public void initialize() {
		tablapersonas.setItems(listapersona);
		nombreCL.setCellValueFactory(new PropertyValueFactory<Personas, String>("nombre"));
		apellidoCL.setCellValueFactory(new PropertyValueFactory<Personas, String>("apellido"));
		DNICL.setCellValueFactory(new PropertyValueFactory<Personas, String>("DNI"));
		telefonocl.setCellValueFactory(new PropertyValueFactory<Personas, String>("telefono"));

	
		
	}

	
}

