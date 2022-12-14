package application;
	
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Main12WebController implements Initializable {

	@FXML private WebView webview;
	@FXML private TextField search;
	@FXML private Button homeButton;
	
	private WebEngine site;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		search.requestFocus();
		site = webview.getEngine();
		site.load("http://www.google.com");
	}
	
	public void hadleEnter(ActionEvent event) {
		if(event.getSource() == search) {
			URL url = null;
			try {
				String protocol = "http://";
				String search = this.search.getText();
				search = search.replaceFirst("http://", "");
				search = search.replaceFirst("https://", "");
				
				System.out.println(search);
				url = new URL(protocol+search);
				
				String test = url.getHost().replaceFirst("www.", "");
				
				site.load(protocol+test);
			}catch(Exception e) {
				System.out.println("¿À·ù"+e.getMessage());
			}
		}else if(event.getSource() == homeButton) {
			site.load("http://google.com");
		}
		
	}

}