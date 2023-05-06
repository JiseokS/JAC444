/**********************************************
Workshop 6
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-07
**********************************************/
package application;
	
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.Math;

public class Main extends Application {
	private TextField tname = new TextField();
	private TextField theight = new TextField();
	private TextField tcapacity = new TextField();
	private TextField treuses = new TextField();
	private TextField tm0 = new TextField();
	private TextField tm1 = new TextField();
	private TextField tdeltaV = new TextField();
	private TextField tve = new TextField();
	private Text tResult = new Text("");
	private Text tResult2 = new Text("");
	
	public void start(Stage primaryStage) {
		
		Label Lname = new Label("Enter the Rocket name:");
		Label Lheight = new Label("Enter the Rocket height:");
		Label Lcapacity = new Label("Enter a Rocket payload capacity(in tons):");
		Label Lreuses = new Label("Enter number of re-uses:");
		Label Lm0 = new Label("Enter M0(Mass at take-off):");
		Label Lm1 = new Label("Enter M1(Final mass)");
		Label LdeltaV = new Label("Enter Delta V(Between 7.5 and 11)");
		Label Lve = new Label("Enter VE(Must be over 10km/s)");
		
		Button calculatebtn = new Button("Payload mass acceleration");
		Button exitbtn = new Button("Exit");
		
		calculatebtn.setPrefWidth(300);
		exitbtn.setPrefWidth(90);
		
		GridPane maingrd = new GridPane();
		
		maingrd.setPadding(new Insets(25,25,25,25));
		maingrd.setVgap(10);
		maingrd.setHgap(10);
		
		maingrd.add(Lname, 0, 0);
		maingrd.add(tname, 1, 0);
		maingrd.add(Lheight, 0, 1);
		maingrd.add(theight, 1, 1);
		maingrd.add(Lcapacity, 0, 2);
		maingrd.add(tcapacity, 1, 2);
		maingrd.add(Lreuses, 0, 3);
		maingrd.add(treuses, 1, 3);
		maingrd.add(Lm0, 0, 4);
		maingrd.add(tm0, 1, 4);
		maingrd.add(Lm1, 0, 5);
		maingrd.add(tm1, 1, 5);
		maingrd.add(LdeltaV, 0, 6);
		maingrd.add(tdeltaV, 1, 6);
		maingrd.add(Lve, 0, 7);
		maingrd.add(tve, 1, 7);
		
		maingrd.add(calculatebtn, 0, 8);
		maingrd.add(exitbtn, 0, 9);
		
		primaryStage.setTitle("ReusableRocket");
		
		Scene queryScene = new Scene(maingrd, 350, 400);
		primaryStage.setScene(queryScene);
		
		primaryStage.show();
        

        GridPane GPresult = new GridPane();
        
        GPresult.setPadding(new Insets(35, 25, 5, 55));

        GPresult.setHgap(10);
        GPresult.setVgap(10);

        GPresult.add(tResult, 0, 0, 10, 1);
        GPresult.add(tResult2, 0, 0, 10, 5);

        Stage sresult = new Stage();
        sresult.setTitle("Payload mass acceleration");

        Scene result_sc = new Scene(GPresult, 500, 150);
        sresult.setScene(result_sc);



        calculatebtn.setOnAction(e -> {
            results();
            sresult.show();
        });

        exitbtn.setOnAction(e -> {
            System.exit(0);
        });

    }

    private void results() 
    {

    	String str_height = theight.getText();
    	String str_capacity = tcapacity.getText();
    	String str_reuses = treuses.getText();
        String str_name = tname.getText();
        int str_m0 = Integer.parseInt(tm0.getText());
        int str_m1 = Integer.parseInt(tm1.getText());
        double str_deltaV = Double.parseDouble(tdeltaV.getText());
        int str_ve = Integer.parseInt(tve.getText());
       

        double r = (double)str_m0 / (double)str_m1;
        String result = String.format("Rocket specs (%s, %sm, %stons, %s)", str_name, str_height, str_capacity, str_reuses);
        String result2 = String.format("Mass fraction of this launch - (exp-(%s/%s)) --> %s/%s --> %s percentage", str_deltaV, str_ve, str_m1, str_m0, Math.round(r*100)/100.0);

        tResult.setText(result);
        tResult2.setText(result2);
    }
	
	public static void main(String[] args) {
		System.out.println("2023W JAC444 JISEOK SHIM 122758170");
		launch(args);
	}
}
