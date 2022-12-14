package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main25Stage extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("main25.fxml"));
			//Scene scene = new Scene(root);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main25.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			Main25StageController control = loader.getController();
			control.setPrimaryStage(primaryStage);
			
			//���������δ� �Ʒ�ó�� ���� �޼ҵ� ȣ��
			//�׷���, ��ü�� �ι� �����Ǳ� ������ �ٸ��� �������Ѵ�.
			/*Main25StageController control = new Main25StageController();
			control.setPrimaryStage(primaryStage);*/
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Java FX : Chart");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.exit(0);
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
