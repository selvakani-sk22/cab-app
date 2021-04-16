/**
 * 
 */
package com.selv2619;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * @author selv2619
 *
 */
public class seatBooking {

	/**
	 * @param args
	 */
	public static int loginValidation(String num1) {
		// TODO Auto-generated method stub
		int validType;
		if((num1.length()==10 || num1.length()==8) && num1!="0") 
		{
			validType=1;
		}
		else
		{
			validType=0;
		}
		return validType;
	}
	public static void printBillAmount(double amount)
	{
		System.out.println("Your Bill Amount is " +amount+" Rs/-");  //Display Bill amount
	}
	public static void main(String[] args) {
		System.out.println("***Sathyam Cinemas***");
		System.out.println("    ***LOGIN PAGE***");
		System.out.println("Enter Mobile Number : ");
		Scanner obj=new Scanner(System.in);  //Object creation for scanner
		Long mobileNo=obj.nextLong();  //Getting mobile number
		String mobileNoString=String.valueOf(mobileNo);
		int validation=loginValidation(mobileNoString);
		if(validation==1)
		{
			System.out.println("Enter Your 8digit Password : ");
			int pswd=obj.nextInt();  //Getting 8digit Password
			String pswdString=String.valueOf(pswd);
			validation=loginValidation(pswdString);
			if(validation==1)
			{
				System.out.println("Logged In Successfully...!Welcome to OLA Cabs...!");
				
				//level 2 Display Seat types
				System.out.println("****Ticket Types**** ");
				System.out.println("1.Platinum (Rs 550/ticket)\n 2.Gold(Rs 350/ticket)\n 3.Silver(Rs 200/ticket)");
				
				//Level 3 & 4 Price Estimation with GST
				System.out.println("Give us your choice to enjoy Cinema : ");
				String seatType=obj.next();  //Getting the Cab Type
				System.out.println("No.Of Tickets : ");
				int noOfTickets=obj.nextInt();  //Getting No. Of Tickets
				int amount=0;
				double amountGst;
				if(seatType.equalsIgnoreCase("PlATiNum"))
				{
					amount=noOfTickets*550;    //Calculating Amount for No.Of Kms with respective amount
				}
				else if(seatType.equalsIgnoreCase("GolD"))
				{
					 amount=noOfTickets*350;  
				}
				else if(seatType.equalsIgnoreCase("sIlVeR"))
				{
					amount=noOfTickets*200;
				}
				else
				{
					System.out.println("Please Select the seat type that we have....");
				}
				double amountD=amount;
				double gst=amountD*0.07;  //calculating GST
				amountGst=amountD+gst;  //Adding amount and GST
			    printBillAmount(amountGst);
				//Level 5 - Booking
				
				System.out.println("Enter Show Date(yyyy-mm-dd) : ");  
				String date=obj.next();        //Getting journey date as string
				LocalDate dateOfShow=LocalDate.parse(date);
				System.out.println("Show Time : 1.10:30\n\t 2.14:30\n\t 3.18:30\n\t 4.20:30");
				System.out.println("Enter Show Time(hh:mm) : ");
				String time=obj.next();        //Getting Show Time
				LocalTime showTime=LocalTime.parse(time);
				int hour=showTime.getHour();
				System.out.println("Your Show Date : " +dateOfShow);
				System.out.println("Your Show Time : "+hour);
				
			}
			else
			{
				System.out.println("Check Your Password Has 8 Digits and should not be 0");
			}
			
		}
		else
		{
			System.out.println("Please Check Your Mobile Number...");
		}

		

	}

}
