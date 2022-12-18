package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main18Chart extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main18.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Java FX : Chart");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.exit(0);
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}