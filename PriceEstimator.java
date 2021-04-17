package com.selvasankari;


public class PriceEstimator {
	public static float CabTypePrice(String cabType)
	{
		//allocate price based on cab type
		float price;
		switch(cabType)
		{
		case "MICRO" : price=10; break;
		case "MINI" : price=15;  break;
		default:
		   price=20;
		   break;
		}
		return price;
	}
}
