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
package Task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {

		public class PhantomBreakingException extends Exception {
		    public PhantomBreakingException() {
		        super("Phantom braking detected!");
		    }
		}

		public class RandomAccelerationException extends Exception {
		    public RandomAccelerationException() {
		        super("Random acceleration detected!");
		    }
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("2023W JAC444 JISEOK SHIM 122758170");
			Scanner input = new Scanner(System.in);
			List<AutonomousCar> AcarList = new ArrayList<>();
			List<HybridCar> HcarList = new ArrayList<>();
			
			
			int choice;
			
			do
			{
				System.out.println("1) Enter detail of Car or AutonomousCar");
				System.out.println("2) Calculate the Distance Estimation");
				System.out.println("3) Read data from file");
				System.out.println("4) Exit");
				System.out.println("Choose the option: ");
				choice = input.nextInt();
				
				switch(choice)
				{
				case 1:
					System.out.println("1) Basic Car");
					System.out.println("2) Hybrid Car");
					System.out.println("3) Autonomous Car");
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
			                AutonomousCar car = new AutonomousCar(make, model, year, null, null, null, 0);
	
		                	//Add car into carList
			                AcarList.add(car);
		                }
		                catch(Exception e){
		                	//When error happen display "Cannot store in list"
		                	System.out.println("Wrong input type! Cannot store in list");
		                }
		                System.out.println("\n");
		                
					}
					else if(c == 2)
					{
						System.out.println("1) Hybrid Car");
						System.out.println("2) PlugInHybrid Car");
						System.out.println("Choose the option:");
						int cc = input.nextInt();
						
						if(cc == 1)
						{
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
			                	
			                	//Save data to file hybrid.dat
			                	 try {
			                         BufferedWriter writer = new BufferedWriter(new FileWriter("hybrid.dat"));
			                         writer.write(newHybridCar.toString());
			                         writer.close();
			                     } catch (IOException e) {
			                         System.err.println("Error writing to file: " + e.getMessage());
			                     }
			                	//Add newHybridCar into carList
			                	HcarList.add(newHybridCar);
			                }catch(Exception e){
			                	//When error happen display "Cannot store in list"
			                	System.out.println("Cannot store in list");
			                }
						}
						else if (cc == 2)
						{
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
			                	
			                	//Save data to file hybrid.dat
			                	 try {
			                         BufferedWriter writer = new BufferedWriter(new FileWriter("hybrid.dat"));
			                         writer.write(newHybridCar.toString());
			                         writer.close();
			                     } catch (IOException e) {
			                         System.err.println("Error writing to file: " + e.getMessage());
			                     }
			                	//Add newHybridCar into carList
			                	HcarList.add(newHybridCar);
			                }catch(Exception e){
			                	//When error happen display "Cannot store in list"
			                	System.out.println("Cannot store in list");
			                }
						}
		                
		                System.out.println("\n");
					}
					else if(c == 3)
					{
						System.out.println("Enter details of Autonomous car.");
						System.out.println("Please enter the following data:");
		                
		                try
		                {
		                	System.out.print("Enter Car brand: ");    
			                String make = input.next();

			                System.out.print("Enter Car model: ");
			                String model = input.next();
			                
			                System.out.print("Enter year of Car(Must be 2010 or more recent): ");
			                int year = input.nextInt();
			                input.nextLine();
			                
			                if(year < 2010)
			                {
			                	System.out.print("Invalid value!! Year must be 2010 or more recent!\n");
			                	
			                	do
			                	{
			                		System.out.print("Enter year of Car(Must be 2010 or more recent): ");
			                		year = input.nextInt();
			 		                input.nextLine();
			                	}while(year < 2010);
			                }
			                
	                        String ai;
			                while(true)
			                {
			                	System.out.print("Enter AI(possible AI include: Siri, Alexa, Cortana, Echo): ");
				                ai = input.next();
				                if(ai.equalsIgnoreCase("Siri") || ai.equalsIgnoreCase("Alexa") ||ai.equalsIgnoreCase("Cortana")||ai.equalsIgnoreCase("Echo"))
				                {
				                	break;
				                }else
				                {
				                	System.out.print("Invalid value!! The possible AI only - Siri, Alexa, Cortana, Echo\n");
				                }
				                
			                }
			             
			                String autopilot;
			                while(true)
			                {
			                	System.out.print("Enter autopilot: ");
				                autopilot = input.next();
				                if(autopilot.equals("Yes"))
				                {
				                	break;
				                }else if(autopilot.equals("No"))
				                {
				                	break;
				                }else
				                {
				                	System.out.print("Invalid value!! Only accept Yes or No\n");
				                }
				                
			                }   
			                
			                String basicRange;
			                while(true)
			                {
			                	System.out.print("Basic range(Yes or No): ");
				                basicRange = input.next();
				                if(basicRange.equals("Yes"))
				                {
				                	break;
				                }else if(basicRange.equals("No"))
				                {
				                	break;
				                }else
				                {
				                	System.out.print("Invalid value!! Only accept Yes or No\n");
				                }
				                
			                }   
			                
			                
			                int FSD;
			                if(autopilot.equals("Yes"))
			                {
			                	System.out.print("Enter FSD(Full Self Driving Version 9 to 12: ");
				                FSD = input.nextInt();
			                }
			                else
			                {
			                	System.out.println("No FSD, FSD requires autopilot!!");
			                	FSD = 0;
			                }
			                
			                
			                //Create a new object that called autonomousCar and put values in object 
			                AutonomousCar newAutonomousCar = new AutonomousCar(make, model, year, ai, autopilot, basicRange, FSD);
			                
			              //Save data to file autonomous.dat
			                try {
			                    BufferedWriter writer = new BufferedWriter(new FileWriter("autonomous.dat"));
			                    writer.write(newAutonomousCar.toString());
			                    writer.close();
			                } catch (IOException e) {
			                    System.err.println("Error writing to file: " + e.getMessage());
			                }
			                
		                	//Add newHybridCar into carList
			                AcarList.add(newAutonomousCar);
		                }catch(Exception  e){
		                	//When error happen display "Cannot store in list"
		                	System.out.println("Cannot store in list");
		                }
		                System.out.println("\n");
					}
					break;
				case 2:
					//When carList is empty display "There is no car"
					if(AcarList.isEmpty() || HcarList.isEmpty())
					{
						System.out.println("There is no car.");
						break;
					}
					//Display all objects in the carList and use toString method
					for(AutonomousCar x : AcarList)
					{
						System.out.println(x);
						
					}
					for(HybridCar x : HcarList)
					{
						System.out.println(x);
						
					}
					System.out.println("Enter Detect Time to calculate distance: ");
					double detectTime = input.nextDouble();
					
					System.out.println("Enter road condition(Must be Good or Bad)");
					String roadconditions = input.next();
					
					System.out.println("Enter pedestrian number on road");
					int pedestrianavoidance = input.nextInt();
					
					//Display all objects in the carLIst again and calculate Distance Estimate and calculate accuracy percentage
					for(AutonomousCar x : AcarList)
					{
						System.out.println(x);
						int n_distance = x.DistanceEstimate(detectTime);
						x.accuracy(n_distance, roadconditions, pedestrianavoidance);
					}
					System.out.println("\n");
					break;
				case 3:
					System.out.println("Choose file");
					System.out.println("1) hybrid.dat");
					System.out.println("2) autonomous.dat");
					int o = input.nextInt();
					
					if(o == 1)
					{
						System.out.println("Hybrid Car List");
						try {
				            BufferedReader reader = new BufferedReader(new FileReader("hybrid.dat"));
				            String line = reader.readLine();
				            System.out.println("Data read from file: " + line);
				            reader.close();
				        } catch (IOException e) {
				            System.err.println("Error reading from file: " + e.getMessage());
				        }
					}
					else if(o == 2)
					{
						System.out.println("Autonomous Car List");
						try {
				            BufferedReader reader = new BufferedReader(new FileReader("autonomous.dat"));
				            String line = reader.readLine();
				            System.out.println("Data read from file: " + line);
				            reader.close();
				        } catch (IOException e) {
				            System.err.println("Error reading from file: " + e.getMessage());
				        }
					}
					break;
				case 4:
					System.out.println("System Exit...");
					break;
				}
			}while(choice != 4);

			input.close();
	}

}
