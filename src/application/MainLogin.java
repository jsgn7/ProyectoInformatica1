 package application;

import controlador.controladorMain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application {
	
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loaderMain=new FXMLLoader(getClass().getResource("/vista/Main.fxml"));
			controladorMain controlMain=new controladorMain();

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

