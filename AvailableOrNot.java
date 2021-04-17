package com.datetimevalidation;

import java.time.LocalDate;
import java.time.LocalTime;


public class AvailableOrNot {
	public static String pickUpTimeDate(String traveltime , String traveldate)
	{
		//check the journey date and time is available or not
		LocalTime cabPickUpTime= LocalTime.parse(traveltime);		
		LocalTime currentTime=LocalTime.now();
		LocalDate  cabPickUpDate= LocalDate.parse(traveldate);
		LocalDate currentDate=LocalDate.now();
		
		if(cabPickUpDate.equals(currentDate))
		{
			if(cabPickUpTime == currentTime || cabPickUpTime.isAfter(currentTime))
			{
				return "Available";
			}
			else
			{
				return "Not Available";
			}
		}
		else if(cabPickUpDate.isAfter(currentDate))
		{
			return "Available";
		}
		else
		{
			return "Not Available";
		}
	}

}
