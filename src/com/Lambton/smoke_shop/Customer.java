package com.Lambton.smoke_shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
public static Scanner sc1 = new Scanner(System.in);
	
	private String fname;
	private String lname;
	private String age;
	public double cart_Total;
	ArrayList<String> items_Bought = new ArrayList<String>();
	public String sql_query;

	
	public void printItems() {
		System.out.println("Entered print items");
		 for(int i = 0 ; i <items_Bought.size();i++)
		 {
			 System.out.println(items_Bought.get(i));
		 }
		System.out.println("");
	}
	
	public void printTotal()
	{
		System.out.println("--------------------------------------------");
		System.out.println("Total value of cart is: "+cart_Total +" CAD");
		System.out.println("--------------------------------------------");
	}
	
	
	public Customer(String fname2, String lname2) {
		// TODO Auto-generated constructor stub
		this.fname = fname2;
		this.lname = lname2;
		System.out.println("Welcome:"+this.fname+" "+this.lname);
		return;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public static Customer collect_Details()
	{
		System.out.println("Please provide Following Details");
		System.out.println("Customer's First Name");
		String fname = sc1.next();
		System.out.println("Customer's Last Name");
		String lname = sc1.next();
		System.out.println("Customer's Age");
		int age = sc1.nextInt();
		System.out.println("Customer's City");
		String city = sc1.next();
		Customer c11 = new Customer(fname,lname);
		return c11;

}



	
}
