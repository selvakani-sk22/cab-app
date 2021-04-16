/**
 * 
 */
package com.selv2619;

import java.time.*;
import java.util.*;

/**
 * @author selv2619
 *
 */
public class olaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Level 1 - Login Page
		System.out.println("***Welcome to OLA Cabs***");
		System.out.println("    ***LOGIN PAGE***");
		System.out.println("Enter Mobile Number : ");
		Scanner obj=new Scanner(System.in);  //Object creation for scanner
		Long mobileNo=obj.nextLong();  //Getting mobile number
		String mobileNoString=String.valueOf(mobileNo);
		if(mobileNoString.length()==10)  //Check Mobile No has 10digits
		{
			System.out.println("Enter Your 8digit Password : ");
			int pswd=obj.nextInt();  //Getting 8digit Password
			String pswdString=String.valueOf(pswd);
			if(pswdString.length()==8)
			{
				System.out.println("You have Sccessfully Logged in....!");
				//Level 2 - Cab Type
				System.out.println("Welcome To OLA Cabs"); // Showing Cab Types
				System.out.println("Types Of Cars We have provided for You....");
				System.out.println("1.Micro (Rs.10/km)\n2.Mini (Rs.15/km)\n3.Prime (Rs.20/km)");
				
			//Level 3 &  4 - Price Estimation with GST
				double amountGst=0;
				System.out.println("Please Give us your choice....");
				System.out.println("Your preference is : ");
				String cabType=obj.next();  //Getting the Cab Type
				System.out.println("No.Of Kilometers : ");
				int noOfKms=obj.nextInt();  //Getting No. Of Kms
				float km=noOfKms;     //Converting No.Of.Kms from Integer to float
				if(cabType.equalsIgnoreCase("MiCrO"))
				{
					
					float amount=km*10;    //Calculating Amount for No.Of Kms with respective amount
					double gst=amount*0.07;  //calculating GST
					amountGst=amount+gst;  //Adding amount and GST
					
				}
				else if(cabType.equalsIgnoreCase("mini"))
				{
					float amount=km*15;
					double gst=amount*0.07;
					amountGst=amount+gst;  
				}
				else if(cabType.equalsIgnoreCase("pRimE"))
				{
					float amount=km*20;
					double gst=amount*0.07;
					amountGst=amount+gst;
				}
				else
				{
					System.out.println("Please Select the cab type that we have....");
				}
				
				System.out.println("Your Bill Amount is " +amountGst+" Rs/-"); //Display Bill amount
			//Level 5 - Booking
				
				System.out.println("Enter Your Journey Date(yyyy-mm-dd) : ");  
				String date=obj.next();        //Getting journey date as string
				LocalDate dateOfJourney=LocalDate.parse(date);
				System.out.println("Enter PickUp Time(hh:mm) : ");
				String time=obj.next();        //Getting Pick Up Time
				LocalTime pickUpTime=LocalTime.parse(time);
				int hour=pickUpTime.getHour();
				System.out.println("Journey Date : " +dateOfJourney);
				System.out.println("Pick Up Time : "+hour);
				
			//level 6 - Peek Hours
				
				if(hour>=17 && hour<=19)
				{
					System.out.println("Your Pick Up Timing is Peek Hour....");
					double peekHourCharge=km*0.0125;
					double amount2=amountGst+peekHourCharge;
					System.out.println("So Your Bill Amount is " +amount2);
				}
				else
				{
					System.out.println("Bill Amount : " +amountGst +" Rs/-");
					
				}
				
			//level 7 - Senior Citizen
				double amountSenior=amountGst;
				System.out.println("Enter Your Date Of Birth : ");
				String dob=obj.next();
				LocalDate dateOfBirth=LocalDate.parse(dob);
				LocalDate today=LocalDate.now();
				Period period=Period.between(dateOfBirth, today);
				int age=period.getYears();
				System.out.println("Your Age is " +age);
				if(age>=60)
				{
					amountSenior=amountGst*0.5;
					System.out.println("Your Age is Greater than 60...So You have 50% Offer...!");
				}
				
				System.out.println("Bill Amount : " +amountSenior+ " Rs/-");
				System.out.println("Be Safe....Be Happy....");
			}

			else
			{
				System.out.println("Check Your Password");
			}
		}
		else
		{
			System.out.println("Oops...Check Your Mobile Number...!");
		}

	}
}
