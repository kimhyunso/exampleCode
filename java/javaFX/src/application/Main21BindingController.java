package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Main21BindingController implements Initializable {
	
	@FXML private TextArea massage1;
	@FXML private TextArea massage2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Bindings.bindBidirectional(massage1.textProperty(), massage2.textProperty());
	}
	
}