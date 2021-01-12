package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import controlador.controladorpuertas;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainPuertas extends Application {
	
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/controlpuertas.fxml"));
			controladorpuertas control=new controladorpuertas();

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
