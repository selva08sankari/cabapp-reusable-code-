package com.selvasankari;

import java.time.LocalDate;

public class SeniorCitizen {
	public static int finalAmountCalculation(String dob)
	{
        //check the person who travel is senior citizen or not
		LocalDate dateOfBirth = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		int dobYear=dateOfBirth.getYear();
		int currentYear=currentDate.getYear();
		int age=currentYear-dobYear;
		if(age>=60)
		{
			System.out.println("Your age is : "+age+"\n       Special Discount(50%) for senior Citizen");
			return age;
		}
		else
		{
			System.out.println("Your not a senior so no discount for senior citizen");
			return 0;
		}
		//Scanner.close();
	}

}
