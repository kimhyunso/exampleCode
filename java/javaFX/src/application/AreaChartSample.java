package application;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AreaChartSample extends Application {
      private Series series;
      private int xSeriesData=0;
      private ConcurrentLinkedQueue<Number> dataQ = new ConcurrentLinkedQueue<Number>();
      private ExecutorService executor;
      private AddToQueue addToQueue;
      private Timeline timeline2;
      private SequentialTransition animation;

      private void init(Stage primaryStage) {
          Group root = new Group();
          primaryStage.setScene(new Scene(root));

          NumberAxis xAxis = new NumberAxis();
          xAxis.setAutoRanging(true);

          NumberAxis yAxis = new NumberAxis();
          yAxis.setAutoRanging(true);

          //-- Chart
          final AreaChart<Number,Number> sc = new AreaChart<Number,Number>(xAxis,yAxis);
          sc.setTitle("Animated Area Chart");

          //-- Chart Series
          series=new AreaChart.Series<Number,Number>();
          series.setName("Area Chart Series");
         //series.getData().add(new AreaChart.Data<Number, Number>(5,5));
          sc.getData().add(series);

          root.getChildren().add(sc);
      }

      @Override public void start(Stage primaryStage) throws Exception {
          init(primaryStage);
          primaryStage.show();

          //-- Prepare Executor Services
         executor = Executors.newCachedThreadPool();
         addToQueue = new AddToQueue();
         executor.execute(addToQueue);

          //-- Prepare Timeline
         prepareTimeline();
      }

      public static void main(String[] args) { 
    	  launch(args); 
      }

      private class AddToQueue extends Thread {
          public void run(){

	          try {
	              Thread.currentThread().setName(Thread.currentThread().getId()+"-DataAdder");
	              //-- Add Random numbers to Q
	              dataQ.add(Math.random());
	              Thread.sleep(50);
	
	              executor.execute(addToQueue);
	
	          } catch (InterruptedException ex) {
	              Logger.getLogger(AreaChartSample.class.getName()).log(Level.SEVERE, null, ex);
	          }

          }
      }

      //-- Timeline gets called in the JavaFX Main thread
      private void prepareTimeline(){
          //-- Second slower timeline
          timeline2 = new Timeline();
          //-- This timeline is indefinite.  
          timeline2.setCycleCount(Animation.INDEFINITE);

          timeline2.getKeyFrames().add(
                  new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                      @Override public void handle(ActionEvent actionEvent) {
                          addDataToSeries();
                      }
                  })
          );

          //-- Set Animation- Timeline is created now.
          animation = new SequentialTransition();
          animation.getChildren().addAll(timeline2);
          animation.play();        

      }

      private void addDataToSeries(){

          if(dataQ.isEmpty()==false)   {
              series.getData().add(new AreaChart.Data(xSeriesData++,dataQ.remove()));
          }
              
      }


  }