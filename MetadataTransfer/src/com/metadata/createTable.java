package com.metadata;

import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createTable")
public class createTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public createTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter out =response.getWriter();
		String newname=request.getParameter("name");
        
        String someName = request.getParameter("s1");
        
      //  out.println("<br>"+someName);
        try {
      	  
      	  Connection con=DatabaseUtil.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "1234");
      	  
      	  Statement stmt=con.createStatement();  
      	
      	  ResultSet rs =stmt.executeQuery("select * from metadata where tname='"+someName+"'");
      //	  String tname="";
      	
      	  String cNames="";
      	
      	  String cTypes="";
      	 
      	  String cSizes="";
      	
      	  
      	  while(rs.next()) {
      	//	  tname=rs.getString("tname");
      		 
      		  cNames=rs.getString("cnames");
      		  cTypes=rs.getString("ctypes");
      		  
      		  cSizes=rs.getString("csizes");
      	  }
      	
      	  
      	  cNames=cNames.substring(0,cNames.length()-1);
      	
      	  cTypes =cTypes.substring(0,cTypes.length()-1);
      	
      	  cSizes =cSizes.substring(0,cSizes.length()-1);

      	 
      	 
      	      //	  out.println(tname);
//      	 out.println(cNames);
//      	 out.println(cTypes);
//      	 out.println(cSizes);


      	 
      	 
      	 String names[]=cNames.split(",");
      	 String types[]=cTypes.split(",");
      	 String sizes[] =cSizes.split(",");
      	 
      	 int low=0;
      	 int high=names.length-1;
      	
      	 
      	 while(low<high) {
      		
      		 
      		 String temp1=names[low];
      		 String temp2 =types[low];
      		 String temp3 =sizes[low];
      		 names[low]=names[high];
      		 names[high]=temp1;
      		 types[low]=types[high];
      		types[high]=temp2;
      		 sizes[low]=sizes[high];
      		sizes[high]=temp3;
      		 low++; high--;
      	
      	 
      	 }
      
      	 
      	 String sql="";
      
      	 
      	 for(int i=0;i<names.length;i++) {
      		
      		 if(types[i].toUpperCase().equals("DATE") || types[i].toUpperCase().equals("NUMBER")) {
      			sql=sql+names[i]+" "+types[i]+",";
      		
      		 }else {
      		
      			 sql=sql+names[i]+" "+types[i]+"("+sizes[i]+")"+",";
      		
      		 }
      	
      	 }
      
      	 
      	 
      	 sql=sql.substring(0,sql.length()-1);
      	 sql="create table "+newname+" ("+sql+")";
      	 out.println("SQL for creating table :<br>");
      	 out.println("<br>"+sql+"<br><br>");
     
      	 
      	 
      	 
      	 
      	 Connection con2=DatabaseUtil.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");
  	  
  	//  Statement stmt2=con2.createStatement(); 
  	
      	 PreparedStatement stmt2 = con2.prepareStatement(sql);
  
      	 boolean i=stmt2.execute(sql);
  	  
  	
      	 if(i==false) {
  		
      		 out.println("<br>table created success");
  	
      	 }else {
  		  
      		 out.println("<br> table creation failed");
  	
      	 }
      	 
      	  
      	
      	 
      	 
        }catch(Exception e) {
      	
        	out.println("<br>"+e);
       
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
