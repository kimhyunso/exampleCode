package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Main39ServiceController implements Initializable {
	
	@FXML private Label workRate, workResult;
	@FXML private Button start, stop;
	@FXML private ProgressBar progressbar;
	
	//private Task<Integer> task; //취소cancel 성공success 실패filed
	private TimeService timeService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		timeService = new TimeService();
	}
	
	public void handleStartAction(ActionEvent event) {
		timeService.restart();
		workResult.setText("");
		
	}
		
	public void handleStopAction(ActionEvent event) {
		timeService.cancel();
	}
	
	
	class TimeService extends Service<Integer>{
			
		@Override
		protected Task<Integer> createTask() {
			Task<Integer> task = new Task<Integer>() { //작업하는 클래스
				@Override
				protected Integer call() throws Exception {
						
					int result = 0;
						
					for(int i=0; i<=100; i++) {
							
							
						if(isCancelled()) {
							updateMessage("취소되었습니다.");
							break;
						}
							
						result += i;
							
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
					return result;
				}
			};
			
			progressbar.progressProperty().bind(task.progressProperty()); //메모리를 탑재한다. updateProgress() 연동
			workRate.textProperty().bind(task.messageProperty()); //updateMessage() 연동
			workResult.setText("");
			
			return task;
		}
		
		@Override
		protected void running() {
			// TODO Auto-generated method stub
			workResult.setText("Running !!");
		}

		@Override
		protected void succeeded() {
			// TODO Auto-generated method stub
			workResult.setText(String.valueOf(getValue()));
		}

		@Override
		protected void cancelled() {
			// TODO Auto-generated method stub
			workResult.setText("Cancelled !!");
		}

		@Override
		protected void failed() {
			// TODO Auto-generated method stub
			workResult.setText("Failed !!");
		}
 	}
}