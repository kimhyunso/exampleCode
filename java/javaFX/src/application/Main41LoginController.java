package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Main41LoginController implements Initializable {
	
	@FXML private Button homeBtn;
	@FXML private AnchorPane loginPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void handleHomeBtnAction(ActionEvent event) {
		StackPane root = (StackPane) homeBtn.getScene().getRoot();
		
		Timeline timeline = new Timeline();
		loginPane.setTranslateX(0);
		KeyValue keyValue = new KeyValue(loginPane.translateXProperty(), 400);
		
		KeyFrame keyFrame = new KeyFrame(
				Duration.millis(1000),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						root.getChildren().remove(loginPane);
					}
				},keyValue
		);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	
}