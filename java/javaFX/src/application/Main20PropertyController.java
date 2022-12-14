package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class Main20PropertyController implements Initializable {

	@FXML private Label title;
	@FXML private Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				title.setFont(new Font(newValue.doubleValue()));
				System.out.println(" oldValue : "+oldValue+" newValue : "+newValue);
			}
		});
	}
	
	public void handle() {
		
	}
}