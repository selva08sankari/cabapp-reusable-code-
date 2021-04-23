package com.selvasankari;

import java.time.LocalTime;

public class PeakHours {
	public static int peakHoursCharges(String travelTime)
	{
		//check traveling time is peak hour or not
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
