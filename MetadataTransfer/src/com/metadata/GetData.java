package com.metadata;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		              response.setContentType("text/html");
		              PrintWriter out =response.getWriter();
		              
		              try {
		            	  
		            	  Connection con=DatabaseUtil.getConnection();
		            	  
		            	  Statement stmt=con.createStatement();  
		            	  
		            	  DatabaseMetaData metadata = con.getMetaData();
		            	    ResultSet resultSet = metadata.getColumns(null, null, "emp", null);
		            	    while (resultSet.next()) {
		            	      String name = resultSet.getString("COLUMN_NAME");
		            	      String type = resultSet.getString("TYPE_NAME");
		            	      int size = resultSet.getInt("COLUMN_SIZE");
		            	      out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
		            	  }
		            	  
		              }catch(Exception e) {
		            	  out.println(e);
		              }
		
		
	}

}
