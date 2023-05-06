/**********************************************
Workshop 7
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-11
**********************************************/
package Task1;

//Extend superclass (Car) and Implements interface (ecoboost)
public class HybridCar<T extends Car> extends Car implements ecoboost {
	public double efficiency;
	public T engineType;
	
	//All argument constructor
	public HybridCar(T maker, T model, int year, T engineType, double efficiency) {
		//Use super keyword to use objects from superclass Car
		super(maker, model, year);
		this.engineType = engineType;
		this.efficiency = efficiency;
	}
	
	//Default constructor
	public HybridCar() {};
	
	public HybridCar(String make, String model, int year, String engineType2, double efficiencyIndex) {
		// TODO Auto-generated constructor stub
	}

	@Override
	//Override drive method from car class
	public void drive() {
		System.out.println("Hybrid car");
		
	}
	//Override fueleconomy method from ecoboost interface
	@Override
	public void fueleconomy(int distance, String roadconditions) {
		double fuelEfficiency = 0;
		System.out.println("Calculating fuel economy for a Car with distance " + distance + " and road conditions " + roadconditions);
		if (roadconditions.equals("Good"))
		{
			fuelEfficiency = efficiency + 0.05;
		} 
		else if(roadconditions.equals("Bad"))
		{
			fuelEfficiency = efficiency - 0.05;
		}
		System.out.println("Fuel Efficiency: " + fuelEfficiency);
		}
	
	@Override
	//Override toString method
	public String toString()
	{
		return "Car (" + maker + ", " + model + ", " + year + ", " + engineType +", " + efficiency + ")";
	}
	//Return engineType
	public T getEngineType()
	{
		return engineType;
	}
	//Return efficiency
	public double getEfficiency()
	{
		return efficiency;
	}


}
