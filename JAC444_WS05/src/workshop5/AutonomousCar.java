package workshop5;

import Task1.selfdriving;

public class AutonomousCar extends Car implements selfdriving{
	String ai;
	String autopilot;
	String basicRange;
	int FSD;
	
	//Default constructor
	AutonomousCar(){};
	//All argument constructor
	public AutonomousCar(String maker, String model, int year, String ai, String autopilot, String basicRange, int FSD)
	{
		super(maker, model, year);
		this.ai = ai;
		this.autopilot = autopilot;
		this.basicRange = basicRange;
		this.FSD = FSD;
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
	
	public String getAi()
	{
		return ai;
	}
	
	public String getAutopilot()
	{
		return autopilot;
	}
	
	public String getBasicRange()
	{
		return basicRange;
	}
	
	public int getFSD()
	{
		return FSD;
	}
	
	

}

