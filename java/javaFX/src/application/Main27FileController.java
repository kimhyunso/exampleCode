package application;
	
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main27FileController implements Initializable {
	
	private Stage primaryStage;
	private File selectedFile = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleFileOpenAction(ActionEvent event) {
		String currentPath;
		String lastPath;
		
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files","*.txt"),
				new ExtensionFilter("Image file","*.png","*.jpg","*.gif")
		);
		
		if(selectedFile !=null) {
			lastPath = selectedFile.getPath().replace(selectedFile.getName(), "");
			currentPath = lastPath;
		}else {
			currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		}
		
		fileChooser.setInitialDirectory(new File(currentPath));
		
		selectedFile = fileChooser.showOpenDialog(primaryStage);
		
		if(selectedFile != null) {
			System.out.println(selectedFile.getPath());
		}
	}
	
	
	public void handleFileSaveAction(ActionEvent event) {
		
		String currentPath;
		String lastPath;
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files","*.*"));
		
		if(selectedFile !=null) {
			lastPath = selectedFile.getPath().replace(selectedFile.getName(), "");
			currentPath = lastPath;
		}else {
			currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		}
		
		fileChooser.setInitialDirectory(new File(currentPath));
		
		selectedFile = fileChooser.showSaveDialog(primaryStage);
		
		if(selectedFile != null) {
			System.out.println(selectedFile.getPath());
		}
		
	}
	
	public void handleDirOpenAction(ActionEvent event){
		DirectoryChooser dirChooser = new DirectoryChooser();
		File selectedDir = dirChooser.showDialog(primaryStage);
		
		if(selectedDir != null) {
			System.out.println(selectedDir.getPath());
			System.out.println(selectedDir.getParent());
		}
		
	}
	
	public void handlePopupAction(ActionEvent e) throws Exception{
		
		Popup popup = new Popup();
		HBox hbox = null;
		
		try {
			hbox = (HBox) FXMLLoader.load(getClass().getResource("main27A.fxml"));
			ImageView imageView = (ImageView) hbox.lookup("#apple");
			imageView.setOnMouseClicked(event -> popup.hide());
			
			Label javaFX = (Label) hbox.lookup("#javaFX");
			javaFX.setText("Hello JavaFX");
			javaFX.setOnMouseClicked(event -> popup.hide());
			
			popup.getContent().add(hbox);
			popup.setAutoHide(true);
			popup.show(primaryStage);
			
		}catch(Exception e1) {
			System.out.println("오류"+e1.getMessage());
		}
		
	}
	
	public void handleDialogAction(ActionEvent e) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		
		dialog.setTitle("dialog practice");
		try {
			AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("main27B.fxml"));
			Label title = (Label)anchorPane.lookup("#title");
			title.setText("프로그램에 의한 제목 변경");
			Button button = (Button)anchorPane.lookup("#apply");
			
			button.setOnAction(event -> dialog.close());
			
			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			
		}catch(Exception e1) {}
		
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
}