package application;
	

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Main09EventController implements Initializable {
	
	@FXML private TextField id;
	@FXML private PasswordField pass;

	public Main09EventController() {
		System.out.println("1");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("2");
	}
	
	public void handleOKAction(ActionEvent event) {
		System.out.println("id = " + id.getText());
		System.out.println("pass = " + pass.getText());
		System.out.println("OK");
	}
	
	public void handleCancelAction(ActionEvent event) {
		id.setText("");
		pass.setText("");
		System.out.println("Cancel");
	}
	
}
