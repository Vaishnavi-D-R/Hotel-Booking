package com.mindtree.hotelbookingapp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/hotels";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "mysqlroot";
	private static final String driverName="com.mysql.cj.jdbc.Driver";
	

	public Connection getMyConnection(){
		Connection con = null;
		try {
			Class.forName(driverName);
			try {
				con=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Cannot connect to database");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Class not found");
		}
		return con;
		//Connection con = null;
	     //String url = "jdbc:mysql://localhost:3306/hotels"; 
	     //String username = "root"; 
	     //String password = "mysqlroot";  
	    // try 
	     //{
	        /* try 
	         {
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	         } 
	         catch (ClassNotFoundException e)
	         {
	            System.out.println("Cannot connect to database");;
	         } */
	     //    con = DriverManager.getConnection(url, username, password); 
	       //  System.out.println("Printing connection object "+con);
	  //   } 
	    // catch (SQLException e) 
	     //{
	       // System.out.println("Hey cannot cannect to database");;
	     //}
	  //   return con; 
	 }
	
	public void closeResource(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResource(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void closeResource(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
