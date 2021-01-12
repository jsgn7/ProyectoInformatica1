/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.MainLogin;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author hoxha
 */
public class FXMLDocumentController  {
     private MainLogin main;

    // connect main class to controller
    public void setMain(MainLogin main) {
        this.main = main; 
       
    }

    @FXML
    private Label label;

    @FXML
    private TextField txtusername;

    @FXML
    private Button loginBtn;

      @FXML
    private Label errorLabel;

    @FXML
    private Label errorMsg;
      
    @FXML
    private PasswordField txtpass;
    
    @FXML
    private Button forgotBtn;
    
    @FXML
    private Button exitBtn;

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
@FXML
public void exit(ActionEvent event)throws IOException{
exitBtn.setOnAction(e -> Platform.exit());
} 
   
    @FXML
    void login(ActionEvent event) throws IOException {
          
    }
    
    @FXML
public void signupScene(ActionEvent event)throws IOException{
Parent view3=FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
                Scene scene3=new Scene(view3);
                Stage window =new Stage();
                window.setScene(scene3);
                window.show();
}  

@FXML
public void forgotPsw(ActionEvent event)throws IOException{
Parent view4=FXMLLoader.load(getClass().getResource("GetPassword.fxml"));
                Scene scene4=new Scene(view4);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene4);
                window.show();
}  
  

}
