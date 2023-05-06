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
package Task2;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bank_Id;
		double loan_amount;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
		System.out.println("2023W JAC444 JISEOK SHIM 122758170");
		
		System.out.print("Number of banks: ");
		int n = input.nextInt();
		
		//Create double type array that called balance and set size as n(number of banks)
		double[] balance = new double[n];
		//Create multidemensinal double type array that called borrow and set size as n
		double[][] borrow = new double[n][n];
		
		System.out.print("Minimum asset limit: ");
		int limit = input.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("For Bank #" + i);
			System.out.print("    Balance: ");
			//Get balance from user and store in balance[i] array
			balance[i] = input.nextDouble();
			
			System.out.print("Number of banks Loaned: ");
			int num_loanbank = input.nextInt();
			
			for(int j = 0; j < num_loanbank; j++)
			{
				System.out.print("      Bank ID who gets the loan: ");
				bank_Id = input.nextInt();
				
				System.out.print("      Loaned Amount: ");
				loan_amount = input.nextDouble();
				//Save loan_amount into borrow[i][bank_id] array 
				borrow[i][bank_Id] = loan_amount; 
			}
		}
		//Create boolean array that called verify and set size as n
		boolean[] verify = new boolean[n];
		do
		{
			flag = false;
			
			for(int i = 0; i< n; i++)
			{
				//Save balance array value into bank_balance
				double bank_balance = balance[i];
				for(int j = 0; j < borrow[i].length; j++)
				{
					//bank_balance = bank_balance + borrow[i][j]
					bank_balance += borrow[i][j];
				}
				
				//If bank_balance is less than limit
				if(bank_balance < limit)
				{
					//Set verify true
					verify[i] = true;
					for(int k = 0; k < borrow.length; k++)
					{
						if(borrow[k][i] != 0)
						{
							borrow[k][i] = 0;
							flag = true;
						}
					}
				}
			}
		}while(flag);
		
		System.out.println("\n");
		System.out.println("Unsafe banks are: ");
		//Display unsafe banks 
		for(int i = 0; i < verify.length; i++)
		{
			//If verify[i] is true
			if(verify[i])
			{
				System.out.print("Bank " + i + " ");
			}
		}
		
		input.close();
		
	}

}
