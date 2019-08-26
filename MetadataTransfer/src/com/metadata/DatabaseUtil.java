package com.metadata;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseUtil {

	
	public static Connection getConnection() throws SQLException {
       
		Connection con = null;
		
		try {
		
		
 
        Class.forName("oracle.jdbc.driver.OracleDriver");  
	    
		 con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");  
		}catch(Exception e) {
			System.out.println(e);
		}
        return con;
    }
}
