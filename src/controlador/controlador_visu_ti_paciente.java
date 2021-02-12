package controlador;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import clases.Medico;
import clases.Ticket;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class controlador_visu_ti_paciente{

   // la tabla que contiene todo se llama tablaTickets
   // se pone la clase y el tipo de atributo para cada columna

	String sFile="Ticket.json";

	@FXML
    private TableView<Ticket> tablaTickets;
    
    @FXML
    private TableColumn<Ticket, Integer> codigoColumna;

    @FXML
    private TableColumn<Ticket, String> pacienteColumna;

    @FXML
    private TableColumn<Ticket, String> clinicoColumna;

    @FXML
    private TableColumn<Ticket, String> descripcionColumna;

    @FXML
    private TableColumn<Ticket, String> respuestaColumna;

    @FXML
    private TableColumn<Ticket, String> estadoColumna;

    @FXML
    private TextField codigotxt;

    @FXML
    private TextField pacientetxt;

    @FXML
    private TextField clinicotxt;

    @FXML
    private TextField descripciontxt;

    @FXML
    private TextField respuestatxt;

    @FXML
    private TextField estadotxt;
    
    @FXML
    private Button btnAgregar;
    
    @FXML
    private Button btnModificar;
    
    private String DniGlobalPaciente="Andres";
    
    private int tamañoLista=0;
    // se crea una lista para despues meterla en la tabla (esta es la lista base y luego se va agregando)
    ObservableList<Ticket> lista=FXCollections.observableArrayList(
    		//new Ticket("1","01","02","2","2"),
    		//new Ticket("2","01","02","03","05"),
    		//new Ticket("3","01","02","03","05")
    		
    		);

    // Pasar de Aquí a JSO
    private static void ticketAJson(Ticket ticket,String sJson){
    	Gson gson=new GsonBuilder().setPrettyPrinting().create();
    	try(FileWriter writer= new FileWriter(sJson)){
    		gson.toJson(ticket,writer);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
  
 // Pasar de JSON a Aquí

    public Vector<Ticket> desserializarJsonAArray() {
		Vector<Ticket> Vectics = new Vector<Ticket>();
		
		try (Reader reader = new FileReader("tickets_2.json")) {
			Gson gson = new Gson();
			Type tipoListaTickets = new TypeToken<Vector<Ticket>>(){}.getType();
			Vectics = gson.fromJson(reader, tipoListaTickets);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return Vectics;
	}
    
    public Vector<Medico> desserializarJsonAArrayMedico() {
		Vector<Medico> Vectmeds = new Vector<Medico>();
		
		try (Reader reader = new FileReader("medicos.json")) {
			Gson gson = new Gson();
			Type tipoListaMedicos = new TypeToken<Vector<Medico>>(){}.getType();
			Vectmeds = gson.fromJson(reader, tipoListaMedicos);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return Vectmeds;
	}
    
    
    public void actualizarTabla() {
    	tablaTickets.getItems().clear();
    	tablaTickets.setItems(lista);
    	codigoColumna.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("codigoTicket"));
    	pacienteColumna.setCellValueFactory(new PropertyValueFactory<Ticket,String>("DNIpaciente"));
    	clinicoColumna.setCellValueFactory(new PropertyValueFactory<>("DNIdoctor"));
    	descripcionColumna.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	respuestaColumna.setCellValueFactory(new PropertyValueFactory<>("respuesta"));
    	
    	codigotxt.setDisable(true);
    	
    	Vector<Ticket> vecTicsNuevo = new Vector<Ticket>();
		vecTicsNuevo=desserializarJsonAArray(); 
		
		
		// Aquí se iguala el valor de los DNIS de doctor al de la sesión para solo mostrar
		// esos tickets
		
		ArrayList<Ticket> arraylista = new ArrayList<Ticket>(vecTicsNuevo);
    	pacientetxt.setText(DniGlobalPaciente);
		for(int j=0;j<arraylista.size();j++) {
			System.out.println(arraylista.get(j));
		}
		
		DniGlobalPaciente="Andres";
		if(vecTicsNuevo!=null) {
			for(int i=0;i<arraylista.size();i++) {
				if(arraylista.get(i).DNIpaciente.equals(DniGlobalPaciente)) {
			    Ticket tii=new Ticket();
				tii=arraylista.get(i);
				lista.add(tii);
				}
			  }
			}
    }
    @FXML
    public void initialize() {
    	
    	//darle la lista de tickets a la tabla -> y con propertyvaluefactory -> agarrar de la propiedad de la clase
    	actualizarTabla();
		}
    
    @FXML
    void AgregarTicket(ActionEvent event) {
    	
    	boolean medicoExiste=true;
    	
    	if(clinicotxt.getText().isEmpty()) 
    	{
    		JOptionPane.showMessageDialog(null, "Llena todos los campos por favor");	
    	}
    	else 
    	{
    	respuestatxt.setText("");
    	
    	

    	Vector<Ticket> vecTicsNuevoTicket = new Vector<Ticket>();
    	
    	vecTicsNuevoTicket=desserializarJsonAArray(); 
    	
		ArrayList<Ticket> arraylista3 = new ArrayList<Ticket>(vecTicsNuevoTicket);

		tamañoLista=arraylista3.size();
		
		Vector<Medico> vecTicsNuevoMedico = new Vector<Medico>();
    	vecTicsNuevoMedico=desserializarJsonAArrayMedico(); 
    	ArrayList<Medico> arraylistaMedico = new ArrayList<Medico>(vecTicsNuevoMedico);
    	
    	//pacientes": ["52525252D"]
    	for(int aaa=0;aaa<arraylistaMedico.size();aaa++) {
    		if(arraylistaMedico.get(aaa).getNombre().equals(clinicotxt.getText().replace(" ","")) ) {
    			medicoExiste=false;
    		}
    	}
		if(medicoExiste==true) {
    	tamañoLista+=1;
    	Ticket nuevoTicket=new Ticket(tamañoLista,
				pacientetxt.getText(),
				clinicotxt.getText(),
				descripciontxt.getText(),
				respuestatxt.getText());
    	

    	//aqui lo agrego a la tabla visual
		
		lista.add(nuevoTicket);		
		arraylista3.add(nuevoTicket);
		
		Vector<Ticket> vNumbers = new Vector<Ticket>( arraylista3 );
    	
		Gson prettyGson=new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer=new FileWriter("tickets_2.json")){
			prettyGson.toJson(vNumbers,writer); 
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		actualizarTabla();
	  }
		else {
			JOptionPane.showMessageDialog(null, "Escoge un clinico que exista");
		}
	 }
    }

    @FXML
    void clicItem1(MouseEvent event) {
    	Ticket filaTicket=tablaTickets.getSelectionModel().getSelectedItem();
    	codigotxt.setText(String.valueOf(filaTicket.getCodigoTicket()));
    	pacientetxt.setText(filaTicket.getDNIpaciente());
    	clinicotxt.setText(filaTicket.getDNIdoctor());
    	descripciontxt.setText(filaTicket.getDescripcion());
    	respuestatxt.setText(filaTicket.getRespuesta());
    	
    	respuestatxt.setDisable(true);
    }
    
    
}

