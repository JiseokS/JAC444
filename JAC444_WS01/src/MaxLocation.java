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
import java.util.Scanner;

public class MaxLocation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns in the array: ");
		
		//Set the array size(column and row)
		int column = input.nextInt();
		int row = input.nextInt();
		double[][] m_array = new double[column][row];
		
		//Type the elements
		System.out.println("Enter the array: ");
		for(int i = 0; i < m_array.length; i++)
		{
			for(int j = 0; j < m_array[i].length; j++)
			{
				m_array[i][j] = input.nextDouble();
			}
		}
		
		//Find largest element and location
		int[] maxLocation = getMaxValueLocation(m_array);
		System.out.println("The location of the largest element is " + getMaxValue(m_array) +
				" at (" + maxLocation[0] + ", " + maxLocation[1] +")");
		//Find smallest element and location
		int[] minLocation = getMinValueLocation(m_array);
		System.out.println("The location of the smallest element is " + getMinValue(m_array) +
				" at (" + minLocation[0] + ", " + minLocation[1] +")");
		//Calculate sum of all elements
		System.out.println("The sum of all elements is " + getSum(m_array));
		//Calculate average of all elements
		System.out.println("The sum of all elements is " + (getSum(m_array))/(column * row));
	}
	
	//The method that calculate sum of all elements of array
	public static double getSum(double[][] array)
	{
		double sum = 0.0;
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				sum += array[i][j];
			}
		}
		return sum;
	}
	
	//Get maximum value location in m_array
	public static int[] getMaxValueLocation(double[][] array)
	{
		double maxValue = array[0][0];
		int arrayColumn =0;
		int arrayRow = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(array[i][j] > maxValue);
				{
					maxValue = array[i][j];
					arrayColumn = i -1;
					arrayRow = j -1;
				}
			}
		}
		int[] location = {arrayColumn, arrayRow};
		return location;
	}
	
	//Get minimum value location in m_array
	public static int[] getMinValueLocation(double[][] array)
	{
		int arrayColumn = 0;
		int arrayRow = 0;
		double minValue = array[0][0];
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(array[i][j] < minValue)
				{
					minValue = array[i][j];
					arrayColumn = i;
					arrayRow = j;
				}
			}
		}
		int[] location = {arrayColumn, arrayRow};
		return location;
	}
	
	//Get maximum value in m_array
	public static double getMaxValue(double[][] array)
	{
		double maxValue = array[0][0];
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(array[i][j] > maxValue)
				{
					maxValue = array[i][j];
					
				}
			}
		}
		return maxValue;
	}
	
	//Get minimum value in m_array
	public static double getMinValue(double[][] array)
	{
		double minValue = array[0][0];
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(array[i][j] < minValue)
				{
					minValue = array[i][j];
				}
			}
		}
		return minValue;
	}
	
}
