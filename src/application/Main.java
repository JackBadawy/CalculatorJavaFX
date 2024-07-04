package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;



public class Main extends Application {
	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		
		
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		
		Scene scene = new Scene(root,600,600,Color.LIGHTSKYBLUE);
		Stage stage = new Stage();
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
