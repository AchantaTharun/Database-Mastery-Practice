package com.metadata;


	
	import java.sql.Connection;
	import java.sql.DatabaseMetaData;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class Main {

	  public static void main(String[] args) throws Exception {
	    Connection conn = DatabaseUtil.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");
	    System.out.println("Got Connection.");
	    Statement st = conn.createStatement();
	   
	    ResultSet rs = null;
	    DatabaseMetaData meta = conn.getMetaData();
	    // The Oracle database stores its table names as Upper-Case,
	    // if you pass a table name in lowercase characters, it will not work.
	    // MySQL database does not care if table name is uppercase/lowercase.
	    //
	    rs = meta.getPrimaryKeys(null, null, "supplier");

	    java.util.List list = new java.util.ArrayList();
	    while (rs.next()) {
	      String columnName = rs.getString("COLUMN_NAME");
	      System.out.println("getPrimaryKeys(): columnName=" + columnName);
	    }

	    st.close();
	    conn.close();
	  }

	  

	}


