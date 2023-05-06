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

public class AutonomousCar<T extends Car> extends Car implements selfdriving{
	public T ai;
	public T autopilot;
	public T basicRange;
	int FSD;
	
	//Default constructor
	AutonomousCar(){};
	//All argument constructor
	public AutonomousCar(T maker, T model, int year, T ai, T autopilot, T basicRange, int FSD)
	{
		super(maker, model, year);
		this.ai = ai;
		this.autopilot = autopilot;
		this.basicRange = basicRange;
		this.FSD = FSD;
	}
	
	
	public AutonomousCar(String make, String model, int year, Object object, Object object2, Object object3, int i) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Driving autonomous car!");
	}
	 
	@Override
	public void accuracy(int distance, String roadconditions, int pedestrianavoidance) {
		// TODO Auto-generated method stub
		int accuracy = 100;
		//Every over 500 meter accuracy percentage subtract 1 
		accuracy -= distance/500;
		//If road condition is bad accuracy percentage subtract 1
		if(roadconditions.equals("Bad"))
		{
			accuracy -= 1;
			//Set pedestrian avoidance to how many of pedestrian on road
			accuracy -= pedestrianavoidance;
			System.out.println("Accuracy is " + accuracy + "%\n");
			if(accuracy >= 97)
			{
				System.out.println("Improving everyday with more than 97% accuracy !!! Keep going, can’t wait for my RoboTaxi !!!");
			}
		}
		else
		{
			//Set pedestrian avoidance to how many of pedestrian on road
			accuracy -= pedestrianavoidance;
			System.out.println("Accuracy is " + accuracy + "%\n");
			if(accuracy >= 97)
			{
				System.out.println("Improving everyday with more than 97% accuracy !!! Keep going, can’t wait for my RoboTaxi !!!");
			}
		}
		
	}
	
	public int DistanceEstimate(double detectTime)
	{
		//Detect time is base on millisecond
		double distance = 300000;
		distance *= detectTime;
		
		return (int)distance;
	}
	
	@Override
	public String toString()
	{
		return "Car (" + maker + ", " + model + ", " + year + ", " + ai + ", " + autopilot + ", " + basicRange + ", " + FSD + ")" ;
	}
	
	public T getAi()
	{
		return ai;
	}
	
	public T getAutopilot()
	{
		return autopilot;
	}
	
	public T getBasicRange()
	{
		return basicRange;
	}
	
	public int getFSD()
	{
		return FSD;
	}
	
	

}
