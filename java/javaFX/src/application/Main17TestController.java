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
			display.appendText("제목 : "+title.getText()+"\n");
			display.appendText("작성자 : "+reader.getText()+"\n");
			display.appendText("날짜 : "+day.getValue()+"\n");
			
			if(man.isSelected()) {
				display.appendText("성별 : 남자 \n");
			}else {
				display.appendText("성별 : 여자\n");
			}
			
			display.appendText("나이 : "+(int)age.getValue()+"\n");
			
			display.appendText("내용 : "+memo);
		}
	}
	
}