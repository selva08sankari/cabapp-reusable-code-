package com.selvasankari;

import com.pricecalculator.BillAmount;
import com.datetimevalidation.AvailableOrNot;
import java.util.Scanner;

class CabBooking {

	public static int loginMobileNumberChecking() {
		// Getting mobile number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Mobile Number:");
		Long mobileNo = sc.nextLong();
		String mobileNum = String.valueOf(mobileNo);

		/*
		 * mobile number validation mobile number is validation logic is done in another
		 * class
		 */

		if (LoginPage.mobileNumber(mobileNum)) {
			System.out.println("Mobilenumber is verified");
			return 1; // go to main function and return
		} else {
			System.out.println("Mobilenumber is Invalid");
			loginMobileNumberChecking(); // if mobile number is not valid call the same function to reenter
			return 0;
		}
	}

	public static int loginPasswordChecking() {
		Scanner sc = new Scanner(System.in);
		// Getting password
		System.out.println("Enter the Password:");
		String password = sc.next();

		// password validation
		if (LoginPage.passWord(password)) {
			System.out.println("Password is verified");
			return 1; // go to main function and return
		} else {
			System.out.println("Password is Invalid");
			loginPasswordChecking(); // if password is not valid call the same function to reenter
			return 0;
		}
	}

	public static String cabTypeSelection() {
		Scanner sc = new Scanner(System.in);
		// getting cab details
		System.out.println("Enter the cabtype MICRO(Rs:10 per km)/MINI(Rs:15 per km)/PRIME(Rs:20 per km) :");
		String cabType = sc.next();

		// cabType validation
		if ((CabTypes.selectCab(cabType))) {
			System.out.println("Cab Type is booked" + cabType);
			return cabType; // go to main function and return cabtype
		} else {
			System.out.println("Cab Type is not available");
			cabTypeSelection(); // if cab type is not available call the same function to reenter
			return cabType;
		}

	}

	public static String dateTimeValidation() {
		Scanner sc = new Scanner(System.in);

		// Date & Time Validation
		// get the date of journey
		System.out.println("Enter the journey date [*yyyy-mm-dd] : ");
		String traveldate = sc.next(); // yyyy-mm-dd

		// get the time of journey
		System.out.println("Enter the journey time [*HH : MM : SS] : ");
		String traveltime = sc.next(); // HH : MM : SS

		String msg = AvailableOrNot.pickUpTimeDate(traveltime, traveldate);
		if (msg.equals("Available")) {
			System.out.println("Your travel Time and Date is booked");
			return traveltime;
		} else {
			dateTimeValidation(); // if date &time is not available call the same function to reenter
			return traveltime;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		loginMobileNumberChecking();
		loginPasswordChecking();
		final String cabType = cabTypeSelection();

		// get the distance in kilometer from user
		System.out.println("Enter the distance in Km:");
		float distance = sc.nextFloat();

		// cab price
		float amount = PriceEstimator.billAmount(cabType, distance);
		System.out.println("Your billamount is: " + amount);

		// GST calculation
		double totalGst = GstCalculation.gst(amount, distance);
		System.out.println("Fare with GST: " + totalGst);

		String travelTime = dateTimeValidation();
		double peakHoursRate = 0;
		// Peak hours rate calculation
		if ((PeakHours.peakHoursCharges(travelTime)) == 1) {
			double peakHoursamount = (distance * 1.25f) / 100; // 1.25 % for one kilometer
			peakHoursRate = peakHoursamount + totalGst;
			System.out.println("Total Fare after the addition of peakhour Rate : " + peakHoursRate);
		} else {
			peakHoursRate = totalGst;
		}

		// Senior Citizen discount
		System.out.println("Enter the Date Of Birth [*yyyy-mm-dd] : ");
		String dob = sc.next(); // yyyy-mm-dd

		if ((SeniorCitizen.finalAmountCalculation(dob)) == 1) {
			double finalAmount = (50 * peakHoursRate) / 100; // 50% discount for senior citizen
			System.out.println("Your Final Amount is : " + finalAmount);
		} else {
			System.out.println("Your Final Amount is : " + peakHoursRate);
		}
		sc.close();
	}

}
