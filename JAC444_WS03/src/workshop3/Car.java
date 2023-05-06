/**********************************************
Workshop 3
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-12
**********************************************/
package workshop3;

//Create abstract class
public abstract class Car {
	String maker;
	String model;
	int year;
	
	//Default constructor
	Car(){};
	
	//All argument constructor
	public Car(String maker, String model, int year)
	{
		this.maker = maker;
		this.model = model;
		this.year = year;
	}
	//Abstract method
	public abstract void drive();
	
	//Return maker
	public String getMaker()
	{
		return maker;
	}
	//Return model
	public String getModel()
	{
		return model;
	}
	//Return year
	public int getYear()
	{
		return year;
	}
	
	//Override toString method
	public String toString()
	{
		return "Car{" + maker + ", " + model + ", " + year + "}";
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
				maker.equals(car.maker) &&
				model.equals(car.model);
	}
	
}
