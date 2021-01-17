 package application;

import controlador.controladorLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application {
	
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loaderMain=new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
			controladorLogin controlMain=new controladorLogin();

            loaderMain.setController(controlMain);
            Parent rootMain=loaderMain.load();

            primaryStage.setScene(new Scene(rootMain));
            primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

