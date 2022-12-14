package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Main37TaskController implements Initializable {
	
	@FXML private Label workRate;
	@FXML private Button start, stop;
	@FXML private ProgressBar progressbar;
	
	private Task<Void> task;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleStartAction(ActionEvent event) {
		task = new Task<Void>() { //작업하는 클래스

			@Override
			protected Void call() throws Exception {
				
				for(int i=0; i<=100; i++) {
					
					if(isCancelled()) {
						updateMessage("취소되었습니다.");
						break;
					}
					
					updateProgress(i,100);
					updateMessage(String.valueOf(i));
					
					try {
						Thread.sleep(100);
					}catch(Exception e) {
						if(isCancelled()) {
							updateMessage("취소되었습니다. 2");
							break;
						}
					}
				}
				
				return null;
			}
		};
		
		progressbar.progressProperty().bind(task.progressProperty()); //메모리를 탑재한다. updateProgress() 연동
		workRate.textProperty().bind(task.messageProperty()); //updateMessage() 연동
		
		Thread thread = new Thread(task);
		thread.start();
	}
	
	public void handleStopAction(ActionEvent event) {
		task.cancel();
	}
	
}