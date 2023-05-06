/**********************************************
Workshop 4
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-21
**********************************************/
package workshop4;

public abstract class Car {
	String make;
	String model;
	int year;
	
	//Default constructor
	Car(){};
	
	//All argument constructor
	public Car(String make, String model, int year)
	{
		this.make = make;
		this.model = model;
		this.year = year;
	}
	//Abstract method
	public abstract void drive();
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return "Car (" + make + ", " + model + ", " + year + ")" ;
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		Car car = (Car) obj;
		return year == car.year && 
				make.equals(car.make) &&
				model.equals(car.model);
	}
	

}
