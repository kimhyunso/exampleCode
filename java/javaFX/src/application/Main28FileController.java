package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Main28FileController implements Initializable {
	
	private Stage primaryStage;
	@FXML private TextArea display; 
	
	private File selectedFile = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleFileOpenAction(ActionEvent event) {
		String currentPath;
		String lastPath;
		FileChooser fileChooser = new FileChooser();
		
		FileReader in = null;
		BufferedReader br = null;
		
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
			try {
				in = new FileReader(selectedFile.getPath());
				br = new BufferedReader(in);
				String line;
				
				display.appendText(selectedFile.getName()+"\n");
				display.appendText(selectedFile.getPath()+"\n");
				display.appendText(selectedFile.getParent()+"\n");
				
				while((line = br.readLine()) != null) {
					display.appendText("내용 : "+line+"\n");
				}
				
			}catch(Exception e) {
				
			}finally {
				try {
					in.close();
					br.close();
				}catch(Exception e) {}
			}
			//System.out.println(selectedFile.getPath());
			
		}
		
	}
	
	
	public void handleFileSaveAction(ActionEvent event) {
		String currentPath;
		String lastPath;
		FileChooser fileChooser = new FileChooser();
		
		BufferedWriter bw = null;
		FileWriter out = null;
		
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
		selectedFile = fileChooser.showSaveDialog(primaryStage);
		
		if(selectedFile != null) {
			try {
				out = new FileWriter(selectedFile.getPath());
				bw = new BufferedWriter(out);
				
				out.write("가나다라家羅多羅馬테스트1231231      Save     Space");
				out.flush();
			}catch(Exception e) {
				
			}finally {
				try {
					out.close();
					bw.close();
				}catch(Exception e) {}
			}
		}
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
}