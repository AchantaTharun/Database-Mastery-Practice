package com.metadata;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseUtil {
	private static String driver="";
	private static String url="";
	private static String user="";
	private static String pword="";
	
	
	public static Connection getConnection(String d, String ur, String u, String p) throws SQLException {
       
		Connection con = null;
		
		driver=d;
		url=ur;
		user=u;
		pword=p;
		
		
		
		try {
		
		
 
        Class.forName(driver);  
	    
		 con=DriverManager.getConnection(  
		url,user,pword);  
		}catch(Exception e) {
			System.out.println(e);
		}
        return con;
    }
}
