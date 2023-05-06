/**********************************************
Workshop 10
Course: JAC444 - WINTER
Last Name: SHIM
First Name: JISEOK
ID: 122758170
Section: NBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-04-05
**********************************************/
package Task1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// Implements Compareable<Time> interface to compare this Time with another one based on elapsed seconds
// Implements Clonable interface to clone a Time object
public class Time implements Comparable<Time>, Cloneable{
    
	private long elapsedTime;
	
	//No argument constructor 
	public Time()
	{
		//Set elapsed Time to current time
	}
	//Constructor with hour, minute, second to create elapsed time for current object
	public Time(int hour, int minute, int second)
	{
		this.elapsedTime = (hour * 3600) + (minute * 60) + second;
	}
	//Constructor with long type elapsed store into current object's elapsedTime
	public Time(long elapsed)
	{
		this.elapsedTime = elapsed;
	}
	//Return current hour 
	public int getHour()
	{
		//Devide by 3600(1 hour is 3600 seconds)
		return (int)(this.elapsedTime / 3600) % 24;
	}
	//Return current minute
	public int getMinute()
	{
		//Divide by 60(1 minute is 60 seconds)
		return (int)(this.elapsedTime / 60) % 60;
	}
	//Return current second
	public int getSecond()
	{
		return (int)this.elapsedTime % 60;
	}
	//Return total seconds which is elapsed Time
	public long getSeconds()
	{
		return elapsedTime;
	}
	
	@Override
	//Override toString method to return "@@ hours @@ minutes @@ seconds" formet
	public String toString()
	{
		return String.format(this.getHour()%24  + " hours " + this.getMinute() + " minutes "+ this.getSecond() +" seconds");
	}
	//Return substract between current time(this.elapsedTime) and argument time(time.elapsedTime) 
	public int compareTo(Time time) 
	{
		//Use (int) to convert to integer type
		return (int)(this.elapsedTime - time.elapsedTime);
	}
	//Return same variable with current object
	public Time clone()
	{
		Time n_Time = new Time(elapsedTime);
		return n_Time;
	}
	
	
	
}
