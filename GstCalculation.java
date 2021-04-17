package com.selvasankari;

public class GstCalculation {
	public static double gst(float total,float distance)
	{
		//calculation of GST 
		float gst=(total*7)/100;
		float totalgst = gst+total;
		return totalgst;
	}
}
