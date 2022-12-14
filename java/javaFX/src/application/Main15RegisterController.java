package application;
	
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main15RegisterController implements Initializable {
	
	@FXML private Button okButton, cancelButton;
	@FXML private TextField title;
	@FXML private PasswordField pass;
	@FXML private ComboBox<String> level;
	@FXML private DatePicker day;
	@FXML private TextArea display;
	
	private ObservableList<String> levelList = FXCollections.observableArrayList("»ó","Áß","ÇÏ");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		level.setItems(levelList);
	}
	
	public void handleOKAction(ActionEvent event) {
		String msg = display.getText();
		
		display.appendText("\n\n ================================ \n");
		display.appendText("title = "+title.getText()+"\n");
		display.appendText("password = "+pass.getText()+"\n");
		display.appendText("level = "+level.getValue()+"\n");
		
		display.appendText("test = "+day.getValue()+"\n");
		LocalDate localDate = day.getValue();
		
		display.appendText("endDay = "+localDate+"\n");
		
		display.appendText("contents = \n"+msg+"\n");
	}
	
	public void handleCancelAction(ActionEvent event) {
		Platform.exit();
	}
	
}