package application;

import controlador.controladorsensorpaciente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainControlsensor extends Application {
	
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/sensorespaciente.fxml"));
			controladorsensorpaciente control=new controladorsensorpaciente();

            loader.setController(control);
            Parent root=loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
