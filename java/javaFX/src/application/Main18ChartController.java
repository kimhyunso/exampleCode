package application;
	
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Main18ChartController implements Initializable {

	@FXML private PieChart pieChart;
	@FXML private AreaChart<String, Integer> areaChart;
	@FXML private LineChart<String, Integer> lineChart;
	@FXML private BubbleChart<Integer, Integer> bubbleChart;
		
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pieChart.setData(  
				FXCollections.observableArrayList( 
						new PieChart.Data("국어", 70),
						new PieChart.Data("수학", 110),
						new PieChart.Data("영어", 75),
						new PieChart.Data("과학", 98)
				)
		);
			
			// X,Y축 정보(Series)가 필요한 나머지 차트
			XYChart.Series<String, Integer> s1 = new XYChart.Series<String,Integer>();
			s1.setName("남자");
			s1.setData(FXCollections.observableArrayList(
					new XYChart.Data<String,Integer>("국어", 80),
					new XYChart.Data<String,Integer>("수학", 30),
					new XYChart.Data<String,Integer>("영아", 60),
					new XYChart.Data<String,Integer>("과학", 90)
			));
			
			
			XYChart.Series<String, Integer> s2 = new XYChart.Series<String, Integer>();
			s2.setName("여자");
			s2.setData(FXCollections.observableArrayList( 
					new XYChart.Data<String,Integer>("국어", 80),
					new XYChart.Data<String,Integer>("영어", 60),
					new XYChart.Data<String,Integer>("수학", 30),
					new XYChart.Data<String,Integer>("과학", 95)
					
			));
			
			XYChart.Series<String, Integer> s3 = new XYChart.Series<String, Integer>();
			s3.setName("남자");
			s3.setData(FXCollections.observableArrayList( 
					new XYChart.Data<String,Integer>("국어", 20),
					new XYChart.Data<String,Integer>("영어", 70),
					new XYChart.Data<String,Integer>("수학", 90),
					new XYChart.Data<String,Integer>("과학", 65)
					
			));
			
			XYChart.Series<String, Integer> s4 = new XYChart.Series<String, Integer>();
			s4.setName("여자");
			s4.setData(FXCollections.observableArrayList( 
					new XYChart.Data<String,Integer>("국어", 80),
					new XYChart.Data<String,Integer>("영어", 60),
					new XYChart.Data<String,Integer>("수학", 30),
					new XYChart.Data<String,Integer>("과학", 95)
					
			));
			
			lineChart.getData().add(s1);
			lineChart.getData().add(s2);
			// linechart.getData().addAll(s1, s2, s3);
			
			//areaChart.getData().addAll(s3, s4);
			
			
			areaChart.getData().addAll(s3,s4);
			XYChart.Series<Integer, Integer> s5 = new XYChart.Series<Integer, Integer>();
			s5.setName("남자");
			s5.setData(FXCollections.observableArrayList( 
					new XYChart.Data<Integer, Integer>(100, 80, 5),
					new XYChart.Data<Integer, Integer>(200, 180, 20),
					new XYChart.Data<Integer, Integer>(350, 130, 30),
					new XYChart.Data<Integer, Integer>(400, 95, 10)
					
			));
			
			XYChart.Series<Integer, Integer> s6 = new XYChart.Series<Integer, Integer>();
			s6.setName("여자");
			s6.setData(FXCollections.observableArrayList( 
					new XYChart.Data<Integer, Integer>(70, 180, 15),
					new XYChart.Data<Integer, Integer>(150, 100, 20),
					new XYChart.Data<Integer, Integer>(250, 130, 50),
					new XYChart.Data<Integer, Integer>(300, 120, 40)
					
			));
			bubbleChart.getData().addAll(s5, s6);
			
		}

		public void handleOKAction(ActionEvent event)
		{
			

		}
	
}