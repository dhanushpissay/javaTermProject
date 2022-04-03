package com.Lambton.smoke_shop;

public class Accessories {

	String [][] arr=new String[5][5];
	public void create() {

		//arr[0][0]="Sr.NO";
		arr[0][0]="1";
		arr[1][0]="2";
		arr[2][0]="3";
		arr[3][0]="4";
		arr[4][0]="5";
		//arr[0][1]="Name";
		arr[0][1]="T-shirts";
		arr[1][1]="Rolling paper";
		arr[2][1]="Hats";
		arr[3][1]="Lighters";
		arr[4][1]="Ash Tray";
		//arr[0][2]="Description";
		arr[0][2]="T-shirt with Logo";
		arr[1][2]="RAW rolling paper";
		arr[2][2]="Hats with logo";
		arr[3][2]="Lightesr";
		arr[4][2]="AshTry with logo";
		//arr[0][3]="Price(CAD)";
		arr[0][3]="25";
		arr[1][3]="5";
		arr[2][3]="20";
		arr[3][3]="3";
		arr[4][3]="15";
		//arr[0][4]="Stock";
		arr[0][4]="10";
		arr[1][4]="10";
		arr[2][4]="10";
		arr[3][4]="10";
		arr[4][4]="10";

	}

	public static void printRow(String[] row) {
		for (String i : row) {
			System.out.printf("%18s", i);
			
			System.out.print("|");
		}
		System.out.println("");
	}

	public void display()
	{
		System.out.println("+-----------------+------------------+-------------------+------------------+-----------------+");
		System.out.println("|     Sr.NO       |      Name        |    Description    |    Price(CAD)    |      Stock      |");
		System.out.println("|=============================================================================================|");
		//System.out.println("       Sr.NO|             Name|      Description|       Price(CAD)|            Stock|");
		for(String[] row : arr) {
			printRow(row);
		}
		System.out.println("+-----------------+------------------+-------------------+------------------+-----------------+");
	}

	}
