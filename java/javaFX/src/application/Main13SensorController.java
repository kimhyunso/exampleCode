package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main13SensorController implements Initializable {

	@FXML private WebView webview;
	@FXML private Slider widthSlider;
	@FXML private Slider heightSlider;
	
	@FXML private TextField widthText;
	@FXML private TextField heightText;
	
	@FXML private Button applyButton;
	
	@FXML private TableView<UserData> tableView;
	
	@FXML private TableColumn<UserData,Integer> noColumn, seqColumn;
	@FXML private TableColumn<UserData,String> idColumn, timeColumn;
	@FXML private TableColumn<UserData,Float> tempColumn, humColumn;
	@FXML private LineChart<String,Float> lineChart;
	
	private XYChart.Series<String, Float> s1 = new  XYChart.Series<String, Float>();
	private XYChart.Series<String, Float> s2 = new  XYChart.Series<String, Float>();
	private XYChart.Series<String, Float> s3 = new  XYChart.Series<String, Float>();
	private XYChart.Series<String, Float> s4 = new  XYChart.Series<String, Float>();
	
	private ObservableList<UserData> list = FXCollections.observableArrayList();
	private WebEngine site;
	private int width;
	private int height;
	
	private UDPChatting udpChatting;
	private int port = 10001;
	private DataBase db;
	private float temp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		db = new DataBase();
		site = webview.getEngine();
		site.load("http://localhost/googleChart.php");
		udpChatting = new UDPChatting(port, 10001, "127.0.0.1",db);
		
		noColumn.setCellValueFactory(new PropertyValueFactory<UserData, Integer>("no"));
		seqColumn.setCellValueFactory(new PropertyValueFactory<UserData, Integer>("seq"));
		idColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("id"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("time"));
		tempColumn.setCellValueFactory(new PropertyValueFactory<UserData, Float>("temp"));
		humColumn.setCellValueFactory(new PropertyValueFactory<UserData,  Float>("hum"));
		
		widthSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				width = newValue.intValue();
				widthText.setText(String.valueOf(newValue.intValue()));
			}
		});
		
		heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				height = newValue.intValue();
				heightText.setText(String.valueOf(newValue.intValue()));
			}
		});
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				udpChatting.testReceive(tableView);
			}
		});
		thread.start();
		
		s1.setName("s1");
		//s1.setData(lists1);
		
		s2.setName("s2");
		s3.setName("s3");
		s4.setName("s4");
		
		
		
		
		tableView.setItems(list);
	}
	
	public void handleSetting(ActionEvent event) {
		
		
	}
	
}