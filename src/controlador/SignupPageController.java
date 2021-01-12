/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hoxha
 */
public class SignupPageController implements Initializable {
    
     
   
    ObservableList<String> questionBoxList = FXCollections.observableArrayList("What's your pet's name?","What's your favorite food?","Who was your childhood hero?");
   
    
PreparedStatement ps,ps1; 

    @FXML
    private Button closeBtn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private ComboBox questionBox;

    @FXML
    private TextField answerTxt;

    @FXML
    private Button createBtn;
    
    @FXML
    private Label errorMessage;
    
    
     @FXML
    void register(ActionEvent event) throws IOException {
       
    }
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questionBox.setValue("Choose your question");
    questionBox.setItems(questionBoxList);
    }  
    
  
    
}
