package com.selvasankari;

import com.pricecalculator.BillAmount;
import com.datetimevalidation.AvailableOrNot;
import java.util.Scanner;
//import com.pricecalculation.BillAmount;
 class CabBooking {

	public static int loginMobileNumberChecking()
	{
		//Getting mobile number		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		Long mobileNo=sc.nextLong();
		String mobileNum=String.valueOf(mobileNo);
		
		/*mobile number validation	
		mobile number is validation logic is done in another class*/
		
	    if((LoginPage.mobileNumber(mobileNum))== true)
	    	{
	    	      System.out.println("Mobilenumber is verified");
	    	      return 1;  //go to main function and return
	    	}
	    else
	    {
	    	System.out.println("Mobilenumber is Invalid");
	    	loginMobileNumberChecking();   //if mobile number is not valid call the same function to reenter
	    	return 0;
	    }
	}
	public static int loginPasswordChecking()
	{
		Scanner sc=new Scanner(System.in);
	    //Getting password
		System.out.println("Enter the Password:");
		String password = sc.next();
		
		//password validation
		if(LoginPage.passWord(password) == true)
		{
			System.out.println("Password is verified");
		    return 1; //go to main function and return 
		}
		else
		{
			System.out.println("Password is Invalid");
			loginPasswordChecking();  //if password is not valid call the same function to reenter
			return 0;
		}
	}
    public static String cabTypeSelection()
    {
    	Scanner sc=new Scanner(System.in);
		//getting cab details
		System.out.println("Enter the cabtype MINI(Rs:10)/MICRO(Rs:15)/PRIME(Rs:20) :");
		String cabType=sc.next();
		
		//cabType validation
		if((CabTypes.selectCab(cabType)==1))
		{
			System.out.println("Cab Type is booked");
			return cabType; //go to main function and return cabtype
		}
		else
		{
			System.out.println("Cab Type is not available");
			cabTypeSelection();  //if cab type is not available call the same function to reenter
			return cabType;
		}
		
    }
    public static String dateTimeValidation()
    {    	
    	Scanner sc=new Scanner(System.in);
    	
        //Date & Time Validation
    	//get the date of journey
    	System.out.println("Enter the journey date [*yyyy-mm-dd] : ");
        String traveldate=sc.next();   //yyyy-mm-dd
    			
        //get the time of journey
    	System.out.println("Enter the journey time [*HH : MM : SS] : ");
    	String traveltime=sc.next();   //HH : MM : SS

    	String msg=AvailableOrNot.pickUpTimeDate(traveltime,traveldate);    	
    	if(msg=="Available")
    	{
    		System.out.println("Your travel Time and Date is booked");
    		return traveltime;
    	}
    	else
    	{
    		dateTimeValidation(); //if date &time is not available call the same function to reenter
    		return traveltime;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		loginMobileNumberChecking(); 
		loginPasswordChecking(); 
		final String cabType=cabTypeSelection();

		
		//cab price 
		float price=PriceEstimator.CabTypePrice(cabType);
		System.out.println(price+" Rupees per km");
		
		//get the distance in kilometer from user
		System.out.println("Enter the distance in Km:");
		float distance = sc.nextInt();	
		//calculation of bill amount
		float amount=BillAmount.amountPerKm(distance, price);
		
		//GST calculation
		double totalgst=GstCalculation.gst(amount, distance);
		System.out.println("Fare with GST: "+totalgst);
		
		String travelTime=dateTimeValidation();
		double peakHoursRate=0;
		//Peak hours extra rate
		if((PeakHours.excessRate(travelTime))==1)
		{
			double peakHoursRate0=(distance*1.25f)/100 ;   //1.25 % for one kilometer
			peakHoursRate=peakHoursRate0 + totalgst ;
			System.out.println("Total Fare after addition of peakhour Rate : "+peakHoursRate);
		}
		else
		{
			peakHoursRate=totalgst;
		}
        
		//Senior Citizen discount 
		System.out.println("Enter the Date Of Birth [*yyyy-mm-dd] : ");
		String dobstr=sc.next();   //yyyy-mm-dd
		
		if((SeniorCitizen.finalAmountCalculation(dobstr))==1)
		{
			double finalAmount=(50*peakHoursRate)/100;
			System.out.println("Your Final Amount is : "+finalAmount);
		}
		else
		{
			System.out.println("Your Final Amount is : "+peakHoursRate);
		}
        sc.close();
	}
	

}
