package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main25StageController implements Initializable {
	
	@FXML private Button ok;
	
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void handleOKAction(ActionEvent event) {
		//1. 프로그램을 직적컨트롤(자바 컨포넌트) 그리는 방법
		/*VBox vbox = new VBox();
		vbox.setPrefSize(500,400);
		vbox.setAlignment(Pos.CENTER);
		
		Button prev = new Button("Prev");
		Button next = new Button("Next");
		
		vbox.getChildren().addAll(prev,next);
		Scene scene	 = new Scene(vbox);
		primaryStage.setTitle("New Scene by Controller");
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		//2. fxml파일을 하나더만들어서 로딩하는 방법 fxml로 만드는 방법
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main17.fxml"));
		Parent root = null;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("New Scene by Controller");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(Exception e) {
			System.out.println("error");
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
}