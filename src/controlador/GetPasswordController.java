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
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hoxha
 */
public class GetPasswordController implements Initializable {
   
    PreparedStatement ps,ps1; 
     String ans;
       String pass;
    

    @FXML
    private TextField usernametxt;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField questiontxt;

    @FXML
    private TextField answertxt;

    @FXML
    private TextField passtxt;

    @FXML
    private Button searchBtn;

    @FXML
    private Button getpswBtn;

    @FXML
    private Button backBtn;
    
    @FXML
    private Label errorLb;
    
    @FXML
    private Label errorAnswer;

    
     @FXML
    void searchPsw(ActionEvent event) throws IOException {
            
    }
    
     @FXML
    void retrivePsw(ActionEvent event) throws IOException {
        
          if(ans.equals(answertxt.getText().trim())){
            passtxt.setText(pass);
        }
        else {
         errorAnswer.setText("Your answer is wrong. Please try again");
        }
            
    }
    
    @FXML
    void backLogin(ActionEvent event) throws IOException {
       Parent view4=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene4=new Scene(view4);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene4);
                window.show();
     
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
