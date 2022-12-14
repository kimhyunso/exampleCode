package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main17TestController implements Initializable {
	
	@FXML private Button ok;
	@FXML private TextField title, reader;
	@FXML private RadioButton man, woman;
	@FXML private TextArea display;
	@FXML private Slider age;
	@FXML private DatePicker day;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void handleOKAction(ActionEvent event) {
		if(event.getSource() == ok) {
			String memo = display.getText();
			
			display.appendText("\n\n==========================\n");
			display.appendText("���� : "+title.getText()+"\n");
			display.appendText("�ۼ��� : "+reader.getText()+"\n");
			display.appendText("��¥ : "+day.getValue()+"\n");
			
			if(man.isSelected()) {
				display.appendText("���� : ���� \n");
			}else {
				display.appendText("���� : ����\n");
			}
			
			display.appendText("���� : "+(int)age.getValue()+"\n");
			
			display.appendText("���� : "+memo);
		}
	}
	
}