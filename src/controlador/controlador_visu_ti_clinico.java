package controlador;
import java.awt.Label;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import clases.Ticket;
import clases.Usuario;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class controlador_visu_ti_clinico{

   // la tabla que contiene todo se llama tablaTickets
   // se pone la clase y el tipo de atributo para cada columna
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
    
    /*@FXML
    private Button btnAgregar;
    */
    @FXML
    private Button btnModificar;
    
    // se crea una lista para despues meterla en la tabla (esta es la lista base y luego se va agregando)
    ObservableList<Ticket> lista=FXCollections.observableArrayList(
    		//new Ticket("1","01","02","2","2"),
    		//new Ticket("2","01","02","03","05"),
    		//new Ticket("3","01","02","03","05")
    		);
    
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
    
    // Pasar de Aquí a JSON
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
    private static Ticket JsonAticket(String sJson) {
    	Gson gson= new Gson();
    	Ticket ticket=new Ticket();
    	try(Reader reader=new FileReader(sJson)){
    		ticket=gson.fromJson(reader,Ticket.class);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return ticket;
    } 
    // convertir el json en un string para visualizarlo
    private static String jsonAelemento(String sJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonInString = new String();
        try (Reader reader = new FileReader(sJson)) {		
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            //Ahora lo podriamos convertir a lo que nos interese
            jsonInString = gson.toJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
	}
    
    	
    public void initialize() {
    	
    	//darle la lista de tickets a la tabla -> y con propertyvaluefactory -> agarrar de la propiedad de la clase
    	
    	tablaTickets.setItems(lista);
    	codigoColumna.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("codigoTicket"));
    	pacienteColumna.setCellValueFactory(new PropertyValueFactory<Ticket,String>("DNIpaciente"));
    	clinicoColumna.setCellValueFactory(new PropertyValueFactory<>("DNIdoctor"));
    	descripcionColumna.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	respuestaColumna.setCellValueFactory(new PropertyValueFactory<>("respuesta"));
    	
    	Vector<Ticket> vecTicsNuevo = new Vector<Ticket>();
		vecTicsNuevo=desserializarJsonAArray(); 
		if(vecTicsNuevo!=null) {
		for(int i=0;i<vecTicsNuevo.size();i++) {
			Ticket tii=new Ticket();
			tii=vecTicsNuevo.get(i);
			lista.add(tii);
		  }
		}
		else {
			
		}
	}
		 
    /*@FXML
    void AgregarTicket(ActionEvent event) {
    	if(codigotxt.getText().isEmpty()|| pacientetxt.getText().isEmpty() || clinicotxt.getText().isEmpty() || respuestatxt.getText().isEmpty()) 
    	{
    		JOptionPane.showMessageDialog(null, "Llena todos los campos por favor");	
    	}
    	else 
    	{
    	lista.add(new Ticket(codigotxt.getText(),
    						pacientetxt.getText(),
    						clinicotxt.getText(),
    						descripciontxt.getText(),
    						respuestatxt.getText())
    			);
    	}
    	}*/
    @FXML
    void ModificarTicket(ActionEvent event) {
    	if(codigotxt.getText().isEmpty() && respuestatxt.getText().isEmpty() || respuestatxt.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Llena la respuesta o elige un ticket por favor ");
    	}
    	else {
    		lista.set(tablaTickets.getSelectionModel().getSelectedIndex(), new Ticket(
    			Integer.parseInt(codigotxt.getText()),
    			pacientetxt.getText(),
				clinicotxt.getText(),
				descripciontxt.getText(),
				respuestatxt.getText()
    			));
    	
    	Vector<Ticket> vecTic = new Vector<Ticket>();
    	
    	// con esto se llena el vector vecTic con la lista de tickets en la tabla (lista)
    	for(int i=0;i<lista.size();i++) {
    		Ticket ti=new Ticket();
    		ti=lista.get(i);
    		vecTic.add(ti);
    		//System.out.println(ti.codigoTicket);		
    	}
    	System.out.println(vecTic);
		Gson prettyGson=new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer=new FileWriter("tickets_2.json")){
			prettyGson.toJson(vecTic,writer);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	  }
    }
    
    //PEQUEÑO CAMBIO
    @FXML
    void clicItem(MouseEvent event) {
    	Ticket filaTicket=tablaTickets.getSelectionModel().getSelectedItem();
    	codigotxt.setText(String.valueOf(filaTicket.getCodigoTicket()));
    	pacientetxt.setText(filaTicket.getDNIpaciente());
    	clinicotxt.setText(filaTicket.getDNIdoctor());
    	descripciontxt.setText(filaTicket.getDescripcion());
    	respuestatxt.setText(filaTicket.getRespuesta());
    	
    	codigotxt.setDisable(true);
    	pacientetxt.setDisable(true);
    	clinicotxt.setDisable(true);
    	descripciontxt.setDisable(true);
    }
    
    
    
    
}

