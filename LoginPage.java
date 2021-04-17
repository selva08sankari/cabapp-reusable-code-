package com.selvasankari;

public class LoginPage {
	public static Boolean mobileNumber(String mobileNum)
	{
		//validation of mobile number which has 10 digit or not
		//First number should not be 0 to 5
		if ((mobileNum.length()!=10) || (mobileNum.charAt(0)>='0' && mobileNum.charAt(0)<='5') )
		{
			return false;
            
		}
		else
		{		    	
			return true ;
		}
	}
	//validation of password which has 8 digit or not
	public static Boolean passWord(String password)
	{

		if(password.length()==8)
		{
			return true;
		}
		else
		{
			return false;
			
		}
	}
}
