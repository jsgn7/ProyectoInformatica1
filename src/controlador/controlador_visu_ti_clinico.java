package controlador;
import java.awt.Label;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
    private TableColumn<Ticket, String> codigoColumna;

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
    		new Ticket("1","01","02","asdddddddddddddddddddddddddddddddddddddddddddd","sdddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"),
    		new Ticket("2","01","02","03","05"),
    		new Ticket("3","01","02","03","05")
    		);
    
    
    public void initialize() {
    	
    	//darle la lista de tickets a la tabla -> y con propertyvaluefactory -> agarrar de la propiedad de la clase
    	
    	tablaTickets.setItems(lista);
    	codigoColumna.setCellValueFactory(new PropertyValueFactory<Ticket,String>("codigoTicket"));
    	pacienteColumna.setCellValueFactory(new PropertyValueFactory<Ticket,String>("DNIpaciente"));
    	clinicoColumna.setCellValueFactory(new PropertyValueFactory<>("DNIdoctor"));
    	descripcionColumna.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	respuestaColumna.setCellValueFactory(new PropertyValueFactory<>("respuesta"));
    	
    	
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
    	lista.set(tablaTickets.getSelectionModel().getSelectedIndex(), new Ticket(
    			codigotxt.getText(),
    			pacientetxt.getText(),
				clinicotxt.getText(),
				descripciontxt.getText(),
				respuestatxt.getText()
    			));	
    }
    
    @FXML
    void clicItem(MouseEvent event) {
    	Ticket filaTicket=tablaTickets.getSelectionModel().getSelectedItem();
    	codigotxt.setText(filaTicket.getCodigoTicket());
    	pacientetxt.setText(filaTicket.getDNIpaciente());
    	clinicotxt.setText(filaTicket.getCodigoTicket());
    	descripciontxt.setText(filaTicket.getDescripcion());
    	respuestatxt.setText(filaTicket.getDescripcion());
    	
    	codigotxt.setDisable(true);
    	pacientetxt.setDisable(true);
    	clinicotxt.setDisable(true);
    	descripciontxt.setDisable(true);
    }
    
    
    
    
}

