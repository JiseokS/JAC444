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

public class matrixAdd {

	//Add matrix method
	public static void addMatrix(double[][] a, double[][] b)
	{
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j ++)
			{
				res[i][j] = a[i][j] + b[i][j];
			}
		}
	}
	
	//Create new double type multi dimensional array 
	private static double[][] res;
	
	//Parellel Matrix
	public static double[][] parallelAddMatrix(double[][] a, double[][] b)
	{
		//Set res length
		res = new double[a.length][b.length];
		addMatrix(a,b);
		return res;
	}
	
	//Sequential Matrix
	public static double[][] sequentialAddMatrix(double[][] c, double[][] d)
	{
		res = new double[c.length][d.length];
		addMatrix(c,d);
		return res;
	}
}

