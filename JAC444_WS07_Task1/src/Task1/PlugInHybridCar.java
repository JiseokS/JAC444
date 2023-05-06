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

public class PlugInHybridCar<T extends Car> extends HybridCar{
	
	//Default constructor 
	public PlugInHybridCar() {};
	
	//Override toString method
	public String toString()
	{
		return "Car (" + maker + ", " + model + ", " + year + ", " + engineType + ", " + efficiency + ")";
	}

}
