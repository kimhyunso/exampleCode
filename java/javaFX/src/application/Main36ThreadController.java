package application;
	
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main36ThreadController implements Initializable {
	
	@FXML private Label time;
	@FXML private Button start, stop;
	
	private boolean stopFlag;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stopFlag = true;
	}
	
	public void handleStartAction(ActionEvent event) {
		stopFlag = false; //start
		
		Thread thread = new Thread() {
			public void run() {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				while(stopFlag == false) {
					String formatTime = dateFormat.format(new Date());
					/*************************************************/
					
					//eventQueue ÇÏ³ª¾¿ »©³»¿È 
					Platform.runLater(()->{
						time.setText(formatTime);
						System.out.println(this.getState());
						
					});
					
					/*************************************************/
					try {
						Thread.sleep(100);
					}catch(Exception e) {}
				}
			}
		};
		
		thread.start();
	}
	
	public void handleStopAction(ActionEvent event) {
		stopFlag = true;
		
	}
}