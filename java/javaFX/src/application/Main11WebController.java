package application;
	

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Main11WebController implements Initializable {

	@FXML WebView webview;
	@FXML TextField search;
	@FXML Label searchLabel;
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
			String url = search.getText();
			site.load("http://"+url);
		}
	}

}