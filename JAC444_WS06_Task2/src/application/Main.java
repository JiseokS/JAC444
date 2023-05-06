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

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

//Extend Application to use JAVA FX GUI
public class Main extends Application 
{
    
    File f_file;
    int cnt = 0;

    //Create each objects String type ArrayList 
    ArrayList<String> m_make = new ArrayList<>();
    ArrayList<String> m_model = new ArrayList<>();
    ArrayList<String> m_year = new ArrayList<>();
    ArrayList<String> m_enginetype = new ArrayList<>();
    ArrayList<Double> m_index = new ArrayList<>();
    private TextField m_distance = new TextField();
    private TextField m_condition = new TextField();
    private Text tResult = new Text("");

    //Main method
    public static void main(String[] args) 
    {
    	System.out.println("2023W JAC444 JISEOK SHIM 122758170");
    	//Launch application
        launch(args);
    }
    
    public void start(Stage prime_Stage) 
    {
    	//Set GridPane 
        GridPane m_root = new GridPane();
        GridPane BtnGr = new GridPane();
        GridPane m_GrName = new GridPane();
        GridPane m_AddGr = new GridPane();

        //m_root and m_GrName are not visible
        m_root.setGridLinesVisible(false);
        m_GrName.setGridLinesVisible(false);

        //Set text have own name
        Text tb1 = new Text("Car brand:");
        Text tb2 = new Text("Car model:");
        Text tb3 = new Text("Year of car:");
        Text tb4 = new Text("Car engine type:");
        Text tb5 = new Text("Car efficieny index:");

        //Set TextField
        TextField fd1 = new TextField();
        TextField fd2 = new TextField();
        TextField fd3 = new TextField();
        TextField fd4 = new TextField();
        TextField fd5 = new TextField();

        //Set buttons have own name
        Button InsertBtn = new Button("Store information");
        Button calculatebtn = new Button("Distance Estimation");
        Button exitbtn = new Button("Exit");

        //Set buttons width
        calculatebtn.setPrefWidth(90);
        InsertBtn.setPrefWidth(90);
        exitbtn.setPrefWidth(90);
        
        //Set padding for each GridPane 
        m_root.setPadding(new Insets(10, 10, 10, 10));
        m_GrName.setPadding(new Insets(10, 10, 10, 10));
        m_AddGr.setPadding(new Insets(10, 10, 10, 10));
        BtnGr.setPadding(new Insets(10, 10, 10, 10));

        //Set Vertical and Horizon gaps of each GridPane 
        m_GrName.setVgap(5);
        m_GrName.setHgap(5);
        BtnGr.setVgap(5);
        BtnGr.setHgap(9);
        m_AddGr.setVgap(5);
        m_AddGr.setHgap(5);

        //Set m_root and BtnGr positions
        m_root.setAlignment(Pos.TOP_LEFT);
        BtnGr.setAlignment(Pos.TOP_CENTER);

        //Add text and textfield and buttons into each GridPane
        m_GrName.add(tb1, 1, 1);
        m_GrName.add(fd1, 2, 1, 90, 1);
        m_GrName.add(tb2, 1, 4);
        m_GrName.add(fd2, 2, 4, 90, 1);

        m_root.add(m_GrName, 1, 1);
        m_AddGr.add(tb3, 1, 1);
        m_AddGr.add(fd3, 2, 1);
        m_AddGr.add(tb4, 3, 1);
        m_AddGr.add(fd4, 4, 1);
        m_AddGr.add(tb5, 5, 1);
        m_AddGr.add(fd5, 6, 1);

        m_root.add(m_AddGr, 1, 2);
        BtnGr.add(InsertBtn, 1, 1);
        BtnGr.add(calculatebtn, 2, 1);
        BtnGr.add(exitbtn, 3, 1);

        m_root.add(BtnGr, 1, 3);
        
        //Set Title name as "HybridCar"
        prime_Stage.setTitle("HybridCar");        
        Scene scene = new Scene(m_root, 590, 210);
        
        //Set on a JAVAFX stage
        prime_Stage.setScene(scene);
        prime_Stage.show();
        
        
        Text tb6 = new Text("Distance:");
        Text tb7 = new Text("Road Condition:");
        
        TextField fd6 = new TextField();
        TextField fd7 = new TextField();


        Button yes = new Button("Calculate");
        yes.setPrefWidth(90);

        GridPane GPresult = new GridPane();
        
        GPresult.setPadding(new Insets(35, 25, 5, 55));

        GPresult.setHgap(10);
        GPresult.setVgap(10);

        GPresult.add(tb6, 0, 0, 10, 1);
        GPresult.add(fd6, 1, 0, 20, 1);
        GPresult.add(tb7, 0, 1, 10, 1);
        GPresult.add(fd7, 2, 1, 20, 1);
        GPresult.add(yes, 0, 3);

        Stage sresult = new Stage();
        sresult.setTitle("Calculate fule efficiency");

        Scene result_sc = new Scene(GPresult, 400, 170);
        sresult.setScene(result_sc);
        
        
        GridPane Presult1 = new GridPane();
        
        Presult1.setPadding(new Insets(35, 25, 5, 55));

        Presult1.setHgap(10);
        Presult1.setVgap(10);

        Presult1.add(tResult, 0, 0, 10, 1);
        
        Stage ssresult = new Stage();
        ssresult.setTitle("Fule efficiency");

        Scene fuel_result = new Scene(Presult1, 350, 170);
        ssresult.setScene(fuel_result);
        
        
        //Insert Button function
        InsertBtn.setOnAction( e -> 
        {
            //Call storeInfo and store values into file
            storeInfo(fd1.getText(), fd2.getText(), fd3.getText(), fd4.getText(), Double.parseDouble(fd5.getText()));
  
        });
        
        //Calculate Button function
        calculatebtn.setOnAction(e -> {
        	
            sresult.show();
        });
  
        //Exit button function
        exitbtn.setOnAction(e -> {
            System.exit(0);
        });
        
        //Yes button function
        yes.setOnAction(e -> {
        	sresult.hide();
        	results(m_index, m_condition);
        	ssresult.show();
        });
        
       
    }

    public void results(ArrayList<Double> index, TextField condition) 
    {

    	double new_index = index.get(cnt);
        double fuelefficiency = 0;
        if (condition.equals("Good"))
		{
        	fuelefficiency = new_index + 0.05;
		} 
		else if(condition.equals("Bad"))
		{
			fuelefficiency = new_index - 0.05;
		}

        String result = String.format("Fuel Efficiency: %s", fuelefficiency);

        tResult.setText(result);
    }
    
    //Store information into file
    public void storeInfo(String make, String model, String year, String enginetype, Double index)
    {
    	
        m_make.add(make);
        m_model.add(model);
        m_enginetype.add(enginetype);
        m_index.add(index);
        m_year.add(year);
        
        String data = "Car info added: " + make + " " + model + " " + year + " " + enginetype + " " + index;
        
        System.out.println(data);
        cnt++;
        
        fileWriting();
        
    }

    //File Writing function
    private void fileWriting() 
    {
        try 
        {
        	//Create a new file that called "hybridCar.txt"
            f_file = new File ("hybridCar.txt");
            
            if (f_file.createNewFile()) 
            {
                System.out.println("New File created.");
            }
            else 
            {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) 
        {
        	
            System.out.println("Error!!");
            //Use printStackTrace to display the line and class name that error occurred
            e.printStackTrace();
        }

        try 
        {
        	//Random Access f_file and only write and reading  
            RandomAccessFile m_rafile = new RandomAccessFile(f_file, "rw");
            String[] str = new String[m_make.size()];
            
            for (int i = 0; i < m_make.size(); i++) 
            {
                str[i] = m_make.get(i) + " " + m_model.get(i) + " " + m_year.get(i) + " " + m_enginetype.get(i)+ " " + m_index.get(i) + " ";
            }
            
            m_rafile.close();
        } 
        catch(IOException ex) 
        {
            System.out.println(ex.toString());
        }
    }

    

}