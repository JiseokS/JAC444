/**********************************************
Workshop 8
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-18
**********************************************/
package Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static int limit = 2000;
	private static double[][] matrix1 = new double[limit][limit];
	private static double[][] matrix2 = new double[limit][limit];
	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("2023W JAC444 JISEOK SHIM 122758170");
		long s_time, e_time;
		int select = 0;
		Scanner input = new Scanner(System.in);
		
		do
		{
			try 
			{
				System.out.println("Please Choose an option");
		    	System.out.println("1) Matrix Addition");
		    	System.out.println("2) Reverse Thread");
		    	System.out.println("3) System Exit");
		    	select = input.nextInt();
		    	
		    	if(select == 1)
		    	{
		    		System.out.println("System calculate paerllel and Sequential Matrixs");
		    		s_time = System.currentTimeMillis();
		    		for(int i = 0; i < matrix1.length; i ++)
		    		{
		    			for(int j = 0; j < matrix2.length; j++)
		    			{
		    				matrix1[i][j] = Math.random();
		    				matrix2[i][j] = Math.random();
		    			}
		    		}
		    		
		    		Thread thrd1 = new Thread(String.valueOf(matrixAdd.parallelAddMatrix(matrix1, matrix2)));
		    		Thread thrd2 = new Thread(String.valueOf(matrixAdd.parallelAddMatrix(matrix1, matrix2)));
		    		Thread thrd3 = new Thread(String.valueOf(matrixAdd.parallelAddMatrix(matrix1, matrix2)));
		    		Thread thrd4 = new Thread(String.valueOf(matrixAdd.parallelAddMatrix(matrix1, matrix2)));
		    		
		    		thrd1.start();
		    		thrd2.start();
		    		thrd3.start();
		    		thrd4.start();
		    		
		    		thrd1.join();
		    		thrd2.join();
		    		thrd3.join();
		    		thrd4.join();
		    		
		    		e_time = System.currentTimeMillis();
		    		System.out.println("Parellel Matrix takes " + (e_time - s_time) + "milliseconds.");
		    		
		    		s_time = System.currentTimeMillis();
		    		matrixAdd.sequentialAddMatrix(matrix1, matrix2);
		    		e_time = System.currentTimeMillis();
		    		
		    		System.out.println("Sequential Matrix takes " + (e_time - s_time) + "milliseconds.");
		    		
		    		
		    	}
		    	else if(select == 2)
		    	{
		    		ReverseThread thread = new ReverseThread(1);
		    		thread.start();
		    	}
		    	else if(select == 3)
		    	{
		    		System.out.println("System Exit...");
		    		return;
		    	}
		    	else
		    	{
		    		System.out.println("Invalid number");
		    	}
			}
			catch (InputMismatchException err)
			{
				System.out.println("Error!!!");
			}
			
		}while(select != 3);
		
		input.close();
	}
	
}
