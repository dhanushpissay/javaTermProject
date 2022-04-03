package com.Lambton.smoke_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String JdbcURL = "jdbc:mysql://localhost:3306/smoke_shop";
	static String Username = "root";
	static String password = "Danny@7871";
	String sql_Query;
	boolean b;


	static Connection con=null; 
	static Statement st = null; 
	static ResultSet rs=null;

	static {
		try 
		{ 
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection getDBConnection(Connection con) throws SQLException {
		con = DriverManager.getConnection(JdbcURL, Username, password);
		return con;
	}


	public static void cleanUp (ResultSet rs)
	{
		try {
			if(rs!=null)
			{
				rs.close();
			
			}
			if(st!=null)
			{
				st.close();
				
			}
			if(con!=null)
			{
				con.close();
			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}



	/*
	 * public static Statement dBPull() { try {
	 * 
	 * con = getDBConnection(con); st = con.createStatement(); } catch (SQLException
	 * e) { e.printStackTrace(); } return st; }
	 */



	public static ResultSet Query_Execution(String sql_Query)
	{
		boolean b = false;

		try {

			con = getDBConnection(con); 
			st = con.createStatement();
			b = st.execute(sql_Query);
		} 

		catch (SQLException e) {

			e.printStackTrace();
		} 


		if(b== true)			//select query 
		{

			try {

				rs = st.getResultSet();

			} 

			catch (SQLException e) {

				e.printStackTrace();
			}
			return rs;

		}


		else
		{
			NS_Query(st);
		}
		return rs;

	}


	public static int NS_Query(Statement st)
	{
		int rowCount = 0;
		try {
			rowCount = st.getUpdateCount();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println("The number of records effected is:"+rowCount);
		return rowCount;
	}
}


