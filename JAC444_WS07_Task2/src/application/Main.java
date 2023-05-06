/**********************************************
Workshop 7
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-13
**********************************************/
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashMap;

public class Main extends Application {

	private HashMap<String, String> countryCapital = new HashMap<String, String>(){
		{
			put("Afghanistan", "Kabul");
			put("Algeria", "Algers");
			put("Austalia","Canberra");
			put("Belgium","Brussels");
			put("Brazil","Brasilia");
			put("Cameroon","Yaounde");
			put("Canada","Ottawa");
			put("China","Beijing");
			put("Colombia","Bogota");
			put("Cuba","Havana");
			put("Denmark","Copenhagen");
			put("Egypt","Cairo");
			put("Finland","Helsinki");
			put("France","Paris");
			put("Germany","Berlin");
			put("Iran","Tehran");
			put("Italy","Rome");
			put("Japen","Tokyo");
			put("South Korea","Seoul");
			put("Mexico","Mexico City");
			put("Russia","Moscow");
			put("Senegal","Dakar");
			put("Ukraine","Keiv");
			put("USA","Washington D.C");
			put("Zimbabwe","Harare");
		}
	};
	
	public void start(Stage primaryStage) {
		
		Label country = new Label("Enter Country:");
		TextField c_textfield = new TextField();
		Label result = new Label();
		Button search = new Button("Search");
		
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(country, c_textfield, result, search);
		
		Scene m_scene = new Scene(vbox, 300, 200);
		primaryStage.setScene(m_scene);
		primaryStage.setTitle("Countries and Capitals");
		primaryStage.show();
		
		search.setOnAction(e->
		{
			String str_country = c_textfield.getText();
			String str_capital = countryCapital.get(str_country);
			if(str_country != null)
			{
				result.setText("Capital of " + str_country + " is " + str_capital);
			}
			else if(str_country == null)
			{
				result.setText("Country doesn't exist");
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		System.out.println("JAC444W 2023 JISEOK SHIM 122758170");
		launch(args);
	}
}
