/**********************************************
Workshop 1
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-01-27
**********************************************/
public class Craps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = rolling_two_dice();
		
		result(sum);

	}
	//Roll two dice(Random 1 to 6)
	public static int rolling_two_dice()
	{
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		int sum = dice1 + dice2;
		//Check the sum of the two dice
		System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
		return sum;
	}
	
	public static void result(int sum)
	{
		switch(sum)
		{
		//If sum of the two dice is 2 or 3 or 12 - lose
		case 2:
		case 3:
		case 12: 
			System.out.println("Craps, Better Luck Next Time, You lose");
		break;
		//If sum of the two dice is 7 or 11 - win
		case 7:
		case 11:
			System.out.println("Congratulations, You win");
		break;
		//Else roll dice until win or lose
		case 4:
		case 5:
		case 6:
		case 8:
		case 9:
		case 10:
			established(sum);
		break;
		}
	}
	
	public static void established(int sum)
	{
		System.out.println("Point is (established) set to " + sum);
		int new_sum;
		//Do while loop escape, Only when new_sum == sum or new_sum == 7
		do
		{
			new_sum = rolling_two_dice();
		}while(new_sum != sum && new_sum != 7);
		
		if(new_sum == 7)
		{
			System.out.println("Craps, Better Luck Next Time, You lose");
		}
		// new_sum == sum
		else
		{
			System.out.println("Congratulations, You win");
		}
	}

}
