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
		//1. ���α׷��� ������Ʈ��(�ڹ� ������Ʈ) �׸��� ���
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
		
		//2. fxml������ �ϳ������� �ε��ϴ� ��� fxml�� ����� ���
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