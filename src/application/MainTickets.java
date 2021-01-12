package application;
	
import controlador.controlador_visu_ti_clinico;
import controlador.controlador_visu_ti_paciente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			int usuario=1;
			//1 = paciente || 0 = clinico
			if(usuario==1) {
				
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_paciente.fxml"));
			controlador_visu_ti_paciente control=new controlador_visu_ti_paciente();
			
			loader.setController(control);
			Parent root=loader.load();
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			}
			if(usuario==0) {
				
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Visualizar_ticket_clinico.fxml"));
			controlador_visu_ti_clinico control=new controlador_visu_ti_clinico();
			
			loader.setController(control);
			Parent root=loader.load();
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
