package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Main41AnimationController implements Initializable {
	
	@FXML private Button loginBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleLoginBtnAction(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("main41Login.fxml"));
			
			StackPane root = (StackPane)loginBtn.getScene().getRoot();
			root.getChildren().add(login);
			
			login.setTranslateX(400);
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		}catch(Exception e) {}
	}
	
}