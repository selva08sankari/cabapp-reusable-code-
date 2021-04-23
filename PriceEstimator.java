package com.selvasankari;


public class PriceEstimator {
	public static float billAmount(String cabType,float distance)
	{
		//allocate price based on cab type
		float price=0;
		float amount;
		int type=0;
		if(cabType.equalsIgnoreCase("MICRO"))
		{
			type= 1;
		}
		else if(cabType.equalsIgnoreCase("MINI"))
		{
			type= 2;
		}
		else if(cabType.equalsIgnoreCase("PRIME"))
		{
			type= 3;
		}
			
		switch(type)
		{
		case 1: price=10; amount=price*distance; return amount;
		case 2 : price=15; amount=price*distance; return amount;
		case 3: price=20; amount=price*distance; return amount;
		default :
		break;
		}
		return 0;
	}
}
