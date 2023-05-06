/**********************************************
Workshop 2
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-04
**********************************************/
import java.util.Scanner;

//Abstract class Rocket 
abstract class Rocket {
	String rocket_name;
	int rocket_height;
	int payload_capacity;
	int number_reuses;
	
	//Abstract payloadOrbit method
	abstract void payloadtoOrbit(int m0, int m1, double deltav, int ve);

}

//Concrete class ReusableRocket that is derived by superclass Rocket
class ReusableRocket extends Rocket{
	
	//Real payloadOrbit method
	void payloadtoOrbit(int m0, int m1, double deltav, int ve)
	{
		//display Tsiolkovsky's rocket equation
		//(exp-(deltaV/Ve)) --> m1/m0 --> 0.00%
		double result = (double)m1/(double)m0;
		System.out.println("(exp-(" + deltav + "/" + ve + ")) -->" + m1 + "/" + m0 + " --> " + Math.round(result*100)/100.0 + "%");
	}
	
}

//Main class
public class WS02
{
	//Main method 
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		Scanner input = new Scanner(System.in);		
		//Create new_rocket is reserved for memory allocation and ReusableRocket is constructor method in the class 
		ReusableRocket new_rocket = new ReusableRocket();
		int choice;
		
		do 
		{
			//Display menu to user
			System.out.println("Choose one of the following 1 options: ");
			System.out.println("1)Display technical specifications of the Falcon 9 re-usable rocket.");
			System.out.println("2)Calculate the payload mass acceleration.");
			System.out.println("3)Exit");
			System.out.println("\nChoice: ");
			//Choose options of menu
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Technical speicification:");
				//If rocket_name is null print "System doesn't have rocket information!"
				if(new_rocket.rocket_name == null)
				{
					System.out.println("System doesn't have rocket information!\n");
					break;
				}
				//If rocket_name is not null print rocket's technical specification
				System.out.println("Rocket name: " + new_rocket.rocket_name);
				System.out.println("Rocket height: " + new_rocket.rocket_height);
				System.out.println("Rocket payload capacity: " + new_rocket.payload_capacity);
				System.out.println("The number of times this rocket has been launched before: " + new_rocket.number_reuses + "\n");
				break;
			case 2:
				System.out.println("Please enter the following data:");
				System.out.print("Enter Rocket Name: ");
                new_rocket.rocket_name = input.next();
                //skip is to remove the opening character like "\n" 
                String skip = input.next();
                
                System.out.print("Enter Height: ");
                new_rocket.rocket_height = input.nextInt();
                
                System.out.print("Enter Payload Capacity: ");
                new_rocket.payload_capacity = input.nextInt();
                
                System.out.print("Enter Number of Reuses: ");
                new_rocket.number_reuses = input.nextInt();
			
				System.out.println("Enter the initial mass of the rocket launch or take-off, incluing rocket fuel.");
				System.out.println("It is represented as M0 in tons: ");
				int M0 = input.nextInt();
				
				System.out.println("Enter the \"final\" mass of the rocket once it reaches orbit (with fuel burned).");
				System.out.println("It is represented as M1 in tons: ");
				int M1 = input.nextInt();
				
				System.out.println("Enter a value for delta V, that represents the change in rocket velocity to achieve Low Earth Orbit (LEO). ");
				System.out.println("This is typically a minimum of 7.5km/s and about 10km/s (between 7.5 and 11):  ");
				double deltaV = input.nextDouble();
				//If deltaV is not between 7.5 and 11 
				if(deltaV < 7.5 || deltaV > 11)
				{
					//Only deltaV is between 7.5 and 11 system escape the while loop
					while(deltaV < 7.5 || deltaV > 11)
					{
						System.out.println("Invalid input!! (deltaV should be between 7.5 and 11)");
						System.out.println("Enter a value for delta V, that represents the change in rocket velocity to achieve Low Earth Orbit (LEO). ");
						System.out.println("This is typically a minimum of 7.5km/s and about 10km/s (between 7.5 and 11):  ");
						deltaV = input.nextDouble();
					}
				}
			
				System.out.println("Enter the rocket ejection velocity Ve (more than 10 km/s): ");
				int vE = input.nextInt();
				//If Ve value is less than 10
				if(vE <= 10)
				{
					//Only escape while loop when Ve is more than 10
					while(vE <= 10)
					{
						System.out.println("Invalid input!! (Ve should be more than 10 km/s)");
						System.out.println("Enter the rocket ejection velocity Ve (more than 10 km/s): ");
						vE = input.nextInt();
					}
				}
			
				System.out.println("The calculated mass fraction of this launch is: ");
				//Call payloadtoOrbit method with M0, M1, deltaV, vE values through new_rocket
				new_rocket.payloadtoOrbit(M0, M1, deltaV, vE);
			
				System.out.println("Wow!!! Another successful launch. Bringing Space to everyones backyard.\n");
				break;
			case 3:
				System.out.println("Exit...\n");
				break;
			}
		}while(choice != 3);
		//If choice is 3 program end do while loop
	}
}
