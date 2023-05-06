/**********************************************
Workshop 3
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-12
**********************************************/
package workshop3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("2023W JAC444 JISEOK SHIM 122758170");
		Scanner input = new Scanner(System.in);
		//Create List that called carList set as HybridCar format
		//Use ArrayList to manage object by index and change size dynamically 
		List<HybridCar> carList = new ArrayList<>();
		
		int choice;
		//When user enter 3, it escapes the do while loop
		do
		{
			System.out.println("1) Enter detail of Car or HybridCar");
			System.out.println("2) Choose the type of car and calculate the available range, accurary, efficiency or some other metric");
			System.out.println("3) Exit");
			System.out.println("Choose the option: ");
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("1) Basic Car");
				System.out.println("2) Hybrid Car");
				System.out.println("Choose the option: ");
				int c = input.nextInt();
				
				if(c == 1)
				{
					System.out.println("Enter details of basic car.");
					System.out.println("Please enter the following data:");
					
                    //Use try and catch to prepare for unexpected errors. Such as user input wrong data type
	                try
	                {
	                	System.out.print("Enter Car brand: ");
		                String make = input.next();
		                
		                System.out.print("Enter Car model: ");
		                String model = input.next();
		                
		                System.out.print("Enter year of Car: ");
		                int year = input.nextInt();
		                input.nextLine();
		                
		                //Create a new object that called car and put values in object 
	                	HybridCar car = new HybridCar(make, model, year, null, 0);
	                	//Add car into carList
		                carList.add(car);
	                }
	                catch(Exception e){
	                	//When error happen display "Cannot store in list"
	                	System.out.println("Cannot store in list");
	                }
	                System.out.println("\n");
	                
				}
				else if(c == 2)
				{
					System.out.println("Enter details of hybrid car.");
					System.out.println("Please enter the following data:");
	                
	                try
	                {
	                	System.out.print("Enter Car brand: ");    
		                String make = input.next();

		                System.out.print("Enter Car model: ");
		                String model = input.next();
		                
		                System.out.print("Enter year of Car: ");
		                int year = input.nextInt();
		                input.nextLine();
		                
		                System.out.print("Enter Car engine type: ");
		                String engineType = input.next();
		                
		                System.out.print("Enter Car efficiency index: ");
		                double efficiencyIndex = input.nextDouble();
		                
		                //Create a new object that called newHybridCar and put values in object 
	                	HybridCar newHybridCar = new HybridCar(make, model, year, engineType, efficiencyIndex);
	                	//Add newHybridCar into carList
		                carList.add(newHybridCar);
	                }catch(Exception e){
	                	//When error happen display "Cannot store in list"
	                	System.out.println("Cannot store in list");
	                }
	                System.out.println("\n");
				}
				break;
			case 2:
				//When carList is empty display "There is no car"
				if(carList.isEmpty())
				{
					System.out.println("There is no car.");
					break;
				}
				//Display all objects in the carList and use toString method
				for(HybridCar x : carList)
				{
					System.out.println(x);
					
				}
				System.out.println("Enter distance");
				int distance = input.nextInt();
				
				System.out.println("Enter road condition(Must be Good or Bad)");
				String roadconditions = input.next();
				
				//Display all objects in the carLIst again and call fueleconomy method
				for(HybridCar x : carList)
				{
					System.out.println(x);
					x.fueleconomy(distance, roadconditions);
				}
				System.out.println("\n");
				break;
			case 3:
				//Exit program
				System.out.println("System Exit...");
				break;
			}
		}while(choice != 3);

	}

}
