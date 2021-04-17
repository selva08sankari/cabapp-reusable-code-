package com.selvasankari;

import java.time.LocalTime;

public class PeakHours {
	public static int excessRate(String travelTime)
	{
		//check travelling time is peak hur or not
		LocalTime cabPickUpTime= LocalTime.parse(travelTime);		
		int hour = cabPickUpTime.getHour();
		//System.out.println("Hour:"+hour);
		if(hour >=17 &&  hour <= 19)
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
	}

}
