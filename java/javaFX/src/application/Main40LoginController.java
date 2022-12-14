package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Main40LoginController implements Initializable {
	
	@FXML private Button homeBtn;
	@FXML private AnchorPane loginPane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	
	public void handleHomeBtnAction(ActionEvent event) {
		StackPane root = (StackPane) homeBtn.getScene().getRoot();
		root.getChildren().remove(loginPane);
	}

		
}