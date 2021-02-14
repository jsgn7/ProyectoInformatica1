package controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class controladorTicketPaciente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label medico;

    @FXML
    private TextArea pregunta;

    @FXML
    private TextArea respuesta;

    @FXML
    private JFXButton botonResponder;

    @FXML
    void responder(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert medico != null : "fx:id=\"medico\" was not injected: check your FXML file 'TicketsPaciente.fxml'.";
        assert pregunta != null : "fx:id=\"pregunta\" was not injected: check your FXML file 'TicketsPaciente.fxml'.";
        assert respuesta != null : "fx:id=\"respuesta\" was not injected: check your FXML file 'TicketsPaciente.fxml'.";
        assert botonResponder != null : "fx:id=\"botonResponder\" was not injected: check your FXML file 'TicketsPaciente.fxml'.";

    }
}
