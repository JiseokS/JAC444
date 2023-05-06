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

public class ReverseThread extends Thread{

	private static int count;
	
	public ReverseThread(int val)
	{
		count = val;
		//Use setName to change the name of the thread
		this.setName(String.valueOf(val));
	}
	
	public void run()
	{
		count++;
		if(count <= 51)
		{
			ReverseThread thread = new ReverseThread(count);
			thread.start();
			
			try
			{
				thread.join();
				System.out.println("Hello from Thread! <" + this.getName() + ">");
				
			}
			catch(Exception error)
			{
				error.printStackTrace();
			}
		}
		
		return;
	}
}
