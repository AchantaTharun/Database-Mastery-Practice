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
		              
		String tname=request.getParameter("tname");
		             
		// tname="emp";
		              
		try {
		            	  
		            	  
				Connection con=DatabaseUtil.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");
		            	 
				String sql="select * from "+tname;
		            	  
				PreparedStatement stmt = con.prepareStatement(sql);
		            	 
				out.println("<br> Table name: "+tname+"<br>");
		            	  
				ResultSet rs =stmt.executeQuery();
		            	  
				DatabaseMetaData metadata = con.getMetaData();
		            	    
		            	
		              
		            
				String cNames="";
		            	
				String cTypes="";
		                
				String cSizes ="";
		            	   
				ResultSetMetaData rsmd=rs.getMetaData();
		            	    
		            	   
				int columnCount = rsmd.getColumnCount();
		            	   
				for(int i=1 ; i<=columnCount ; i++) {
		            	    	
					cNames=rsmd.getColumnLabel(i)+","+cNames;
		            	    	
					cTypes= rsmd.getColumnTypeName(i)+","+cTypes;
		            	    	
					cSizes =  rsmd.getColumnDisplaySize(i)+ ","+cSizes;
		            	    	
					out.println("Column Type: [" +  rsmd.getColumnTypeName(i) + "]; Name: [" + rsmd.getColumnLabel(i) + "]; size: [" + rsmd.getColumnDisplaySize(i) + "]");
		            	        
					out.println("<br>");
		            	   
				}
				
				//out.println(metadata.getPrimaryKeys(null, null, tname));
				ResultSet PK = metadata.getPrimaryKeys(null,null, tname);
				out.println("------------PRIMARY KEYS-------------");
				while(PK.next())
				{
				    out.println("===" + PK.getString(4));
				}
				
		            	  
				// out.println(cNames);
		            	  
				
		            	   
				//storing the metadata in MySql database
		            	    
				Connection con2 =DatabaseUtil.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "1234");
		            	   
				Statement stmt2=con2.createStatement();
		            	    
				int i=stmt2.executeUpdate("insert into metadata(tname, cnames, ctypes, csizes) values('"+tname+"','"+cNames+"','"+cTypes+"', '"+cSizes+"')");
		            	    
		            	    if(i==1) {
		            	    	
		            	    	out.println("<br>Data saved Success<br>");
		            	    	
		            	    	
		            	    	out.println("<br><form action='createTable' method='get'>Enter name of new table<input type='text' name='name'><input type='hidden' name='s1' value ='"+tname+"'><input type='submit' value='create tabel'></form><br>");
		            	    }else {
		            	   
		            	    	out.println("<br> Data not saved<br>");
		            	   
		            	    }
		            	    
		              }catch(Exception e) {
		            	
		            	  out.println(e.fillInStackTrace());
		              }
		
		
	}

}
