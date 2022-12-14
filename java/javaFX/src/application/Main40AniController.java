package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main40AniController implements Initializable {
	
	@FXML private Button loginBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void handleLoginBtnAction(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("main40Login.fxml"));
			
			StackPane root = (StackPane)loginBtn.getScene().getRoot();
			root.getChildren().add(login);
		}catch(Exception e) {}
	}
	
	
		
}