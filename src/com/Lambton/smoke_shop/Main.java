/**
 * 
 */
package com.Lambton.smoke_shop;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.Scanner;

/**
 * @author Dhanush_Pissay , Yogesh_parihar , Marcelo_Goulart, Hosne
 * Java Team Project
 *
 */
public class Main {

	/**
	 * @param args
	 */

	public static Scanner sc  = new Scanner(System.in);
	static int price;
	static Items i = new Items();


	public static void main(String[] args)  {

		System.out.println("**********Welcome to Nerds Smoke Shop**********\n--------------------------------------------------\n        For a chiller tomorrow");
		System.out.println();
		System.out.println("Are you 19+?(Yes/No)");
		char choice = sc.next().charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			boolean flag = true;
			do {
				System.out.println("\n**********\nENTER YOUR CHOICE\n1.Flowers \n2.Pre Rolled \n3.Vapourisers \n4.Accesories\n5.Exit");
				int option = sc.nextInt();
				switch(option) {
				case 1:
				System.out.println("Flowers selected");
				i.display_Options(1);
				break;
				
				case 2:System.out.println("Pre Rolled selected");
				i.display_Options(2);
				break;
				
				case 3:System.out.println("Vapourisers selected");
				i.display_Options(3);
				
				break;
				case 4:System.out.println("Accesories selected");
				i.display_Options(4);
				
				break;
				case 5:
					flag = false;
					System.out.println("Thank you...Please visit again!!");
					break;
				default:
					System.out.println("INVALID CHOICE! ENTER AGAIN!");
				} 
			}while (flag);
		}
	
}
}


