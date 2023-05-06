/**********************************************
Workshop 10
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-04-05
**********************************************/
package Task1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("2023W JAC444 JISEOK SHIM 122758170");
		System.out.println("Enter time1 (hour minute second): ");
		//Create time1 and store user input(hour minute second) into time1 
		Time time1 = new Time(input.nextInt(), input.nextInt(), input.nextInt());
		//print time1 using time(int hour, int minute, int second) method
		System.out.println(time1);
		
		//call getseconds to get total elapsed seconds in time1
		System.out.println("Elapsed seconds in time1: " + time1.getSeconds());
		System.out.println("\n");
		
		System.out.println("Enter time2 (elapsed time in seconds): ");
		long new_time = input.nextLong();
		
		//Create time2 and store new_time value into time2
		Time time2 = new Time(new_time);
		//Print time2 using time(int hour, int minute, int second) method
		System.out.println(time2);
		//Call getSeconds method to display total elapsed seconds in time2
		System.out.println("Elapsed seconds in time2: " + time2.getSeconds()+ "\n");
		//Call compareTo method with time2 in time1 to calculate time1 substract time2 
		System.out.println("time1.compareTo(time2)? "+ time1.compareTo(time2) + "\n");
		
		//Call clone method to copy value of time1 and save it in time3
		Time time3 = time1.clone();
		System.out.println("time3 is created as a clone of time1");
		//Call compareTo method to with time3 in time1 to get value(time1 substract time3)
		System.out.println("time1.compareTo(time3)? " + time1.compareTo(time3));
		
		
		
		

	}

}
