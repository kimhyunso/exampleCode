package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Main() {
		System.out.println("Main() is created !!");
	}
	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init() start");
		super.init();
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("stop() start");
		super.stop();
	}

	@Override
	public void start(Stage primaryStage) {
		System.out.println("start");
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("start main()");
		launch(args);
		System.out.println("end main()");
	}
}
