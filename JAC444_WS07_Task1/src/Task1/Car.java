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

//Create abstract class
public abstract class Car<T> {
	public T maker;
	public T model;
	int year;
	
	//Default constructor
	Car(){};
	
	//All argument constructor
	public Car(T maker, T model, int year)
	{
		this.maker = maker;
		this.model = model;
		this.year = year;
	}
	//Abstract method
	public abstract void drive();
	
	//Return maker
	public T getMaker()
	{
		return maker;
	}
	//Return model
	public T getModel()
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
