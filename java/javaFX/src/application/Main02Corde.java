package application;
	

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main02Corde extends Application {

	private VBox vbox;
	private Label label;
	private Button button;
	private Scene scene;
	
	@Override
	public void init() throws Exception {
		vbox = new VBox();
		vbox.setPrefHeight(400.0);
		vbox.setPrefWidth(500.0);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10.0);
		
		label = new Label();
		label.setText("Java FX World ÇÑ±Û");
		label.setFont(new Font(40));
		
		button  = new Button("javaFX Button");
		button.setOnAction(event->Platform.exit());
		
		vbox.getChildren().add(label);
		vbox.getChildren().add(button);
		
		scene = new Scene(vbox);
		
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			primaryStage.setTitle("Java FX Stage");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
