package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main29StageController implements Initializable {
	
	@FXML private Button ok;
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleOKAction(ActionEvent event) {
		
		//control은 자신의 부모 Scene 정보를 얻을 수 있고,
		//Scene은 자신의 부모 Stage 정보를 얻을 수 있다.
		primaryStage = (Stage) ok.getScene().getWindow();
		
		HBox hbox = new HBox();
		hbox.setPrefSize(500, 400);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(10.0);
		
		Button prev = new Button("Prev");
		Button next = new Button("next");
		
		prev.setPrefSize(100, 30);
		next.setPrefSize(100, 30);
		
		hbox.getChildren().addAll(prev,next);
		
		Scene scene = new Scene(hbox);
		primaryStage.setTitle("new Scene My Controller");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}