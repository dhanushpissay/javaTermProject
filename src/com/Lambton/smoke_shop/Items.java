package com.Lambton.smoke_shop;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Items {

	Scanner sc1 = new Scanner(System.in);
	Accessories ac = new Accessories();
	Customer c = new Customer();


	public static ResultSet rs1 ;
	private Statement st1;
	String sql_Query;


	private String flowers;
	private String pre_Rolls;
	private String vapes;
	private String Accessories;

	private static int quantity;



	private static double price;
	static Object userInput;



	private String item_Code;
	private static String item;


	private static void setPrice(double price2, Customer cnew) {
		cnew.cart_Total = cnew.cart_Total+price2;
		System.out.println("Sucessfully  added to cart...\nCart Total is:"+cnew.cart_Total);

	}

	public static void setItem(String item2, Customer cnew) {
		cnew.items_Bought.add(item2);
		//System.out.println("Item Bought by customer:");
		cnew.printItems();
	}

	private String getFlowers()   {
		//System.out.println("FLowers before taking user value:"+flowers);
		System.out.println("Enter the code of the product you want to buy");
		flowers = sc1.next().toUpperCase();
		//System.out.println("FLowers after taking user value:"+flowers);
		return flowers;

	}

	public String getPre_Rolls() {

		//System.out.println("Pre_Rolls before taking user value:"+pre_Rolls);
		System.out.println("Enter the code of the product you want to buy");
		pre_Rolls = sc1.next().toUpperCase();
		//System.out.println("pre_Rolls after taking user value:"+pre_Rolls);
		return pre_Rolls;
	}

	public String getVapes() {
		//System.out.println("Vapes before taking user value:"+vapes);
		System.out.println("Enter the code of the product you want to buy");
		vapes = sc1.next().toUpperCase();
		//System.out.println("Vapes after taking user value:"+vapes);
		return vapes;
	}





	private void setFlowers(int quantity) {

		sql_Query =String.format("UPDATE flowers SET STOCK=STOCK-%d WHERE SERIAL_NUMBER=('%s')",quantity,flowers);
		rs1 = DB_Connection.Query_Execution(sql_Query);
		try {
			if((rs1.next())!=true)
			{
				this.flowers = null;
			}
			//System.out.println("FLowers after setFLowers():"+flowers);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	public void setPre_Rolls(int quantity) {
		sql_Query =String.format("UPDATE PREROLLS SET STOCK=STOCK-%d WHERE SERIAL_NUMBER=('%s')",quantity,pre_Rolls);
		rs1 = DB_Connection.Query_Execution(sql_Query);
		try {
			if((rs1.next())!=true)
			{
				this.pre_Rolls = null;
			}
			//System.out.println("FLowers after setPre_Rolls():"+pre_Rolls);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void setVapes(int quantity2) {
		sql_Query =String.format("UPDATE VAPES SET STOCK=STOCK-%d WHERE SERIAL_NUMBER=('%s')",quantity,quantity2);
		rs1 = DB_Connection.Query_Execution(sql_Query);
		try {
			if((rs1.next())!=true)
			{
				this.vapes = null;
			}
			//System.out.println("Vaopes after setVapes():"+vapes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer buyFlowers(Customer cnew)
	{


		item_Code = getFlowers();
		System.out.println("Enter the quantity of the product "+item_Code +" you want to buy");
		quantity = sc1.nextInt();
		sql_Query =String.format("SELECT price , PROD_NAME FROM flowers WHERE SERIAL_NUMBER=('%s')",item_Code);
		cnew = getItems(sql_Query, quantity , cnew);
		//cnew.items_Bought.add(Accessories)
		setFlowers(quantity);
		return cnew;
	}




	public Customer buyPre_Rolls(Customer cnew)
	{


		item_Code = getPre_Rolls();
		System.out.println("Enter the quantity of the product "+item_Code +" you want to buy");
		quantity = sc1.nextInt();
		System.out.println(quantity);
		sql_Query =String.format("SELECT PRICE , PROD_NAME FROM PREROLLS  WHERE SERIAL_NUMBER=('%s')",item_Code);
		cnew = getItems(sql_Query, quantity , cnew);
		//cnew.items_Bought.add(Accessories)
		setVapes(quantity);
		return cnew;
	}

	public Customer buyVapes(Customer cnew)
	{
		item_Code = getVapes();
		System.out.println("Enter the quantity of the product "+item_Code +" you want to buy");
		quantity = sc1.nextInt();
		System.out.println(quantity);
		sql_Query =String.format("SELECT PRICE , PROD_NAME FROM VAPES  WHERE SERIAL_NUMBER=('%s')",item_Code);
		cnew = getItems(sql_Query, quantity , cnew);
		//cnew.items_Bought.add(Accessories)
		setVapes(quantity);
		return cnew;

	}






	public double display_Table(int i,Object obj) {

		Customer cnew = (Customer)obj;
		switch (i) {
		case 1:
			sql_Query = "select * from Flowers";
			rs1 = DB_Connection.Query_Execution(sql_Query);
			diaplay_Flowers_Table(rs1);
			cnew = buyFlowers(cnew);
			more_Options(cnew);
			break;


		case 2:
			sql_Query = "select * from PREROLLS";
			rs1 = DB_Connection.Query_Execution(sql_Query);
			diaplay_PreRolls_Table(rs1);
			cnew = buyPre_Rolls(cnew);
			more_Options(cnew);
			break;


		case 3:
			sql_Query = "select * from VAPES";
			rs1 = DB_Connection.Query_Execution(sql_Query);
			diaplay_VAPES_Tables(rs1);
			cnew = buyVapes(cnew);
			more_Options(cnew);
			break;


		case 4:
			ac.create();
			ac.display();




			break;

		default:System.out.println("");
		}
		return price;

	}



	public static void diaplay_Flowers_Table(ResultSet rs1) {



		try {


			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
			System.out.println("| S_NUM |       BRAND          |       PROD_NAME       |         POTENCY      |    THC   |  CBD   |          PLANT_TYPE     | PRICE | STOCK |");
			System.out.println("|===========================================================================================================================================|");
			while(rs1.next()) {
				System.out.println("| "+rs1.getString(1)+"   | "+rs1.getString(2)+" |   "+rs1.getString(3)+   "      |"+rs1.getString(4)+"    | "+rs1.getInt(5)+"       |"+rs1.getInt(6)+"       |"+rs1.getString(7)+"     | "+rs1.getInt(8)+"    |"+rs1.getInt(9)+"     |"); 
			} 

			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}

		finally
		{
			DB_Connection.cleanUp(rs1);
		}

	}


	public static void diaplay_PreRolls_Table(ResultSet rs1) {
		try {


			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
			System.out.println("| S_NUM |       BRAND          |       PROD_NAME       |         POTENCY      |    THC   |  CBD   |          PLANT_TYPE     | PRICE | STOCK |");
			System.out.println("|===========================================================================================================================================|");
			while(rs1.next()) {
				System.out.println("| "+rs1.getString(1)+"|"+rs1.getString(2)+"    |"+rs1.getString(3)+"   |"+rs1.getString(4)+"   | "+rs1.getInt(5)+"       |"+rs1.getInt(6)+"       |"+rs1.getString(7)+"    | "+rs1.getInt(8)+"    |"+rs1.getInt(9)+"     |"); 
			} 

			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}

		finally
		{
			DB_Connection.cleanUp(rs1);
		}

	}

	public static void diaplay_VAPES_Tables(ResultSet rs1) {
		try {


			System.out.println("+---------+----------------------+-----------------------------+------------------------+--------------+----------------------+-------------------+----------------------+---------+-------+");
			System.out.println("|  S_NUM  |       BRAND          |          PROD_NAME          |      MATERIAL_TYPE     |BATTERY_TYPE  | HEATING_ELEMENT_TYPE |RECHARGABLE_BATTERY|  REMOVABLE_BATTERY   |   PRICE | STOCK |");
			System.out.println("|==========================================================================================================================================================================================|");
			while(rs1.next()) {
				System.out.println("| "+rs1.getString(1)+"   | "+rs1.getString(2)+" |   "+rs1.getString(3)+   "      |"+rs1.getString(4)+"    | "+rs1.getInt(5)+"          |"+rs1.getString(6)+"               |"+rs1.getString(7)+"              | "+rs1.getString(8)+"                |"+rs1.getInt(9)+"       |"+rs1.getInt(10)+"     |"); 
			} 

			System.out.println("+---------+----------------------+-----------------------------+------------------------+--------------+----------------------+-------------------+----------------------+---------+-------+");
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}

		finally
		{
			DB_Connection.cleanUp(rs1);
		}

	}


	public static void diaplsy_ACCESSORIES_Table(ResultSet rs1) {
		try {


			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
			System.out.println("| S_NUM |       BRAND          |       PROD_NAME       |         POTENCY      |    THC   |  CBD   |          PLANT_TYPE     | PRICE | STOCK |");
			System.out.println("|===========================================================================================================================================|");
			while(rs1.next()) {
				System.out.println("| "+rs1.getString(1)+"   | "+rs1.getString(2)+" |   "+rs1.getString(3)+   "      |"+rs1.getString(4)+"    | "+rs1.getInt(5)+"       |"+rs1.getInt(6)+"       |"+rs1.getString(7)+"     | "+rs1.getInt(8)+"    |"+rs1.getInt(9)+"     |"); 
			} 

			System.out.println("+-------+----------------------+-----------------------+----------------------+----------+--------+-------------------------+-------+-------+");
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}

		finally
		{
			DB_Connection.cleanUp(rs1);
		}

	}




	public void display_Options(int i)
	{
		System.out.print("\n1.Would you like to buy?(Yes/No)");
		char choice = sc1.next().charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			Object obj = c.collect_Details();
			display_Table(i, obj);
		}


	}

	public  static Customer getItems(String sql_Query,int quantity, Customer cnew){
		rs1 = DB_Connection.Query_Execution(sql_Query);
		try {
			while(rs1.next())
			{
				price = rs1.getInt("Price");
				price = price * quantity;
				item = rs1.getString("PROD_NAME");
				//System.out.println(price);
			}

			setItem(item,cnew);
			setPrice(price,cnew);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnew;

	}


	public void more_Options(Customer cnew)
	{
		System.out.println("\nWould you like to buy more items??(Yes/No)");
		char more_products = sc1.next().charAt(0);
		if (more_products == 'Y' || more_products == 'y')
		{
			System.out.println("Sure Let me Help you");
			System.out.println("\n**********\nENTER YOUR CHOICE\n1.Flowers \n2.Pre Rolled \n3.Vapourisers \n4.Accesories\n5.Exit");
			int option = sc1.nextInt();
			display_Table(option,cnew);

		}

		else
		{
			System.out.println("Your total is "+cnew.cart_Total +" CAD"+"\nWould you like to print yout reciept?");
			more_products = sc1.next().charAt(0);
			if (more_products == 'Y' || more_products == 'y')
			{
				
			}
			
			else {
				System.out.println("Thank you for shopping with us");
				cnew.printItems();
				cnew.printTotal();
				System.out.println("");
				System.out.println("kindly pay at counter\n Please vist again");
				System.exit(0);
			}
		}



	}



}


