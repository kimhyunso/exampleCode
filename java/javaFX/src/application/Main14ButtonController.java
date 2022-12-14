package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class Main14ButtonController implements Initializable {
	
	@FXML private Button okButton;
	@FXML private CheckBox reading;
	@FXML private CheckBox gamming;
	@FXML private CheckBox sleeping;
	@FXML private TextArea display;
	@FXML private RadioButton tcp;
	@FXML private RadioButton udp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void handleOkAction(ActionEvent event) {
		if(event.getSource() == okButton) {
			display.appendText("reading = "+reading.isSelected()+"\n");
			display.appendText("gamming = "+gamming.isSelected()+"\n");
			display.appendText("sleeping = "+sleeping.isSelected()+"\n");
			boolean t = tcp.isSelected() ? tcp.isSelected() : tcp.isSelected();
			
			if(t) {
				display.appendText("protocol = tcp \n");
			}else {
				display.appendText("protocol = udp \n");
			}
			
		}
	}
	
}