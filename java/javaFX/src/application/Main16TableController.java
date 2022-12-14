package application;
	
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main16TableController implements Initializable {
	@FXML private TextField id, name;
	@FXML private Button okButton;
	@FXML private Slider age;
	
	@FXML private TableView<Person> tableView;
	
	@FXML private TableColumn<Person,Integer> noCol;
	@FXML private TableColumn<Person,String> idCol;
	@FXML private TableColumn<Person,String> nameCol;
	@FXML private TableColumn<Person,Integer> ageCol;
	@FXML private TableColumn<Person,String> timeCol;
	
	private ObservableList<Person> myList = FXCollections.observableArrayList(
			//new Person(1,"myID","myName",20,"Test Time"),
			//new Person(2,"myID2","myName2",50,"Test Time2")
	);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noCol.setCellValueFactory(new PropertyValueFactory<Person,Integer>("no"));
		idCol.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
		ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Person, String>("time"));
		
		/*age.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				ageNumber = newValue.intValue();
				System.out.println(ageNumber);
			}
		});*/
		
		timeCol.prefWidthProperty().setValue(2000);
		tableView.setItems(myList);
	}
	
	public void handleOKAction(ActionEvent event) {
		/*int nextCount = myList.size() + 1;
		myList.add(new Person(nextCount, id.getText(), name.getText(), (int)age.getValue(), sdf.format(new Date())));*/
		
		int nextCount = tableView.getItems().size() + 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//String printDate = date.toString();
		
		tableView.getItems().add(new Person(nextCount, id.getText(), name.getText(), (int)age.getValue(), sdf.format(new Date())));
	}
	
}