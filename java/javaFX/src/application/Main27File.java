package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main27File extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main27.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			Main27FileController control = loader.getController();
			control.setPrimaryStage(primaryStage);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Java FX : File Open");
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
