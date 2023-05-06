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
    ArrayList<String> first_name = new ArrayList<>();
    ArrayList<String> last_name = new ArrayList<>();
    ArrayList<String> m_city = new ArrayList<>();
    ArrayList<String> m_prv = new ArrayList<>();
    ArrayList<String> m_postal = new ArrayList<>();

    //Main method
    public static void main(String[] args) 
    {
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
        Text tb1 = new Text("First Name:");
        Text tb2 = new Text("Last Name:");
        Text tb3 = new Text("City:");
        Text tb4 = new Text("Province:");
        Text tb5 = new Text("Postal Code:");

        //Set TextField
        TextField fd1 = new TextField();
        TextField fd2 = new TextField();
        TextField fd3 = new TextField();
        TextField fd5 = new TextField();

        //Set buttons have own name
        Button InsertBtn = new Button("Add");
        Button m_FirstBtn = new Button("First");
        Button NxtBtn = new Button("Next");
        Button Prv_Btn = new Button("Previous");
        Button m_LastBtn = new Button("Last");
        Button UpdtBtn = new Button("Update");

        //Set buttons width
        InsertBtn.setPrefWidth(90);
        m_FirstBtn.setPrefWidth(90);
        NxtBtn.setPrefWidth(90);
        Prv_Btn.setPrefWidth(90);
        m_LastBtn.setPrefWidth(90);
        UpdtBtn.setPrefWidth(90);

        //Create choice box for choice provinces and territories of Canada
        ChoiceBox<String> fld4 = new ChoiceBox();
        
        fld4.setValue("Province");
        fld4.getItems().addAll("AB", "BC", "MB", "NB", "NL", "NT", "NS", "NU", "ON", "PE", "QC", "SK", "YT");

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
        m_AddGr.add(fld4, 4, 1);
        m_AddGr.add(tb5, 5, 1);
        m_AddGr.add(fd5, 6, 1);

        m_root.add(m_AddGr, 1, 2);
        BtnGr.add(InsertBtn, 1, 1);
        BtnGr.add(m_FirstBtn, 2, 1);
        BtnGr.add(NxtBtn, 3, 1);
        
        BtnGr.add(Prv_Btn, 4, 1);
        BtnGr.add(m_LastBtn, 5, 1);
        BtnGr.add(UpdtBtn, 6, 1);

        m_root.add(BtnGr, 1, 3);
        
        //Set Title name as "Address Book"
        prime_Stage.setTitle("Address Book");        
        Scene scene = new Scene(m_root, 590, 210);
        
        //Set on a JAVAFX stage
        prime_Stage.setScene(scene);
        prime_Stage.show();
        
        //Insert Button function
        InsertBtn.setOnAction( e -> 
        {
            System.out.println("ADD button pressed.");
            //Call storeInfo and store values into file
            storeInfo(fd1.getText(), fd2.getText(), fd3.getText(), fld4.getValue(), fd5.getText());
        });
  
        //First button function
        m_FirstBtn.setOnAction(e -> {
        	
            System.out.println("FIRST button pressed.");
            
            //Get first contact information of file
            fd1.setText(first_name.get(0));
            fd2.setText(last_name.get(0));
            fd3.setText(m_city.get(0));
            fld4.setValue(m_prv.get(0));
            fd5.setText(m_postal.get(0));
            
            cnt = 0;
            
            String data = "First contact: " + first_name.get(0) + " " + last_name.get(0) + " " + m_city.get(0) + " " + m_prv.get(0) + " " + m_postal.get(0);
            
            System.out.println(data);
        });
        
        //Next button function
        NxtBtn.setOnAction(e -> {
        	//Set cnt = cnt + 1;
            cnt++;
            System.out.println("Next button pressed.");
            
            //Get next contact information of file
            fd1.setText(first_name.get(cnt));
            fd2.setText(last_name.get(cnt));
            fd3.setText(m_city.get(cnt));
            fld4.setValue(m_prv.get(cnt));
            fd5.setText(m_postal.get(cnt));
            
            String data = "Next contact: " + first_name.get(cnt) + " " + last_name.get(cnt) + " " + m_city.get(cnt) + " " + m_prv.get(cnt) + " " + m_postal.get(cnt);
            
            System.out.println(data);
        });
        
        //Previous button function
        Prv_Btn.setOnAction( e -> {
        	//Set cnt = cnt - 1;
            cnt--;
            
            System.out.println("Previous button pressed.");
            
            //Get previous contact information of file
            fd1.setText(first_name.get(cnt));
            fd2.setText(last_name.get(cnt));
            fd3.setText(m_city.get(cnt));
            fld4.setValue(m_prv.get(cnt));
            fd5.setText(m_postal.get(cnt));
            
            String data = "Previous contact: " + first_name.get(cnt) + " " + last_name.get(cnt) + " " + m_city.get(cnt) + " " + m_prv.get(cnt) + " " + m_postal.get(cnt);
            System.out.println(data);
            
        });
       
        //Last button function
        m_LastBtn.setOnAction( e -> {
        	
            System.out.println("Last button pressed.");
            
            //To use object.size() -1 to get last contact
            fd1.setText(first_name.get(first_name.size()-1));
            fd2.setText(last_name.get(last_name.size()-1));
            fd3.setText(m_city.get(m_city.size()-1));
            fld4.setValue(m_prv.get(m_prv.size()-1));
            fd5.setText(m_postal.get(m_postal.size()-1));
            
            String data = "Last contact: " + first_name.get(first_name.size()-1) + " " + last_name.get(last_name.size()-1) + " " + m_city.get(m_city.size()-1) + " " + m_prv.get(m_prv.size()-1) + " " + m_postal.get(m_postal.size()-1);
            
            System.out.println(data);
            
        });
        
        //Update button function
        UpdtBtn.setOnAction( e -> {
            System.out.println("UPDATE button pressed.");
            
            //Change current contact's information
            first_name.set(cnt, fd1.getText());
            last_name.set(cnt, fd2.getText());
            m_city.set(cnt, fd3.getText());
            m_prv.set(cnt, fld4.getValue());
            m_postal.set(cnt, fd5.getText());
            
            String data = "Contact updated: " + fd1.getText() + " " + fd2.getText() + " " + fd3.getText() + " " + fld4.getValue() + " " + fd5.getText();
            
            System.out.println(data);
            
            fileWriting();
            
        });
    }

    //Store information into file
    public void storeInfo(String firstName, String lastName, String City, String Province, String pcode)
    {
    	
        first_name.add(firstName);
        last_name.add(lastName);
        m_city.add(City);
        m_prv.add(Province);
        m_postal.add(pcode);
        
        String data = "Contact added: " + firstName + " " + lastName + " " + City + " " + Province + " " + pcode;
        
        System.out.println(data);
        cnt++;
        
        fileWriting();
        
    }

    //File Writing function
    private void fileWriting() 
    {
        try 
        {
        	//Create a new file that called "StoredData.txt"
            f_file = new File ("StoredData.txt");
            
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
            String[] str = new String[first_name.size()];
            
            for (int i = 0; i < first_name.size(); i++) 
            {
                str[i] = first_name.get(i) + " " + last_name.get(i) + " " + m_city.get(i) + " " + m_prv.get(i) + " ";
            }

            for (int j = 0; j < first_name.size(); j++) 
            {
                m_rafile.write(str[j].getBytes());
                m_rafile.write(m_postal.get(j).getBytes());
                m_rafile.writeBytes("\n"); 
            }
            m_rafile.close();
        } 
        catch(IOException ex) 
        {
            System.out.println(ex.toString());
        }
    }

    

}