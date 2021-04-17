package com.pricecalculator;

public class BillAmount {
	public static float amountPerKm(float distance,float price)
	{
		//calculation of amount based on distance
		float amount=distance*price;
		return amount;
	}
}
