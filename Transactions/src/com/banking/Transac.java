package com.banking;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Transac")
public class Transac extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	
	
    
    public Transac() {
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
		
		
		Connection con = null;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String toname= request.getParameter("tname");
		String pword =request.getParameter("pword");
		String am = request.getParameter("am");
		String to = request.getParameter("to");
		String fromname= request.getParameter("fname");
		String from= request.getParameter("from");
		int a=Integer.parseInt(from);
		int amount =Integer.parseInt(am);
		
		int toacc = Integer.parseInt(to);
		int r=0;
		try {
			
			con = DatabaseUtil.getConnection();
			
			con.setAutoCommit(false);
			Statement stmt = con.createStatement(); 
			
			ResultSet rs = stmt.executeQuery("select * from acc where accno='"+a+"' and name = '"+fromname+"' and pword='"+pword+"'");
			String fn ="";
			  int nm=0;
      while(rs.next()) {
				
			fn=rs.getString("name");
               nm= rs.getInt("balance");
              
                
				
			}
     if(fn!="") {
         // int b= Integer.parseInt("nm");
          if(nm>=amount) {
           r=nm-amount;
          
          }
          else {
        	  out.println("not enough funds");
          }}else {
        	  out.println("user does not exist");
          }
          fn="";
          rs = stmt.executeQuery("select * from acc where accno='"+toacc+"' and name = '"+toname+"'");
          while(rs.next()) {
				
  			fn=rs.getString("name");
              nm= rs.getInt("balance");
             
               
				
			}
        //  int am2=Integer.parseInt(nm);
          int n=0;
          if(fn!="") {
         n =nm+amount;}
          else {
        	  out.println("user does not exist");
          }
          
          int i=stmt.executeUpdate("update acc set balance ='"+n+"' where accno='"+toacc+"' and name ='"+toname+"'");
          int j=stmt.executeUpdate("update acc set balance ='"+r+"' where accno='"+a+"' and name ='"+fromname+"'");
          int k=stmt.executeUpdate("insert into transactions(fname, tname, amount) values('"+fromname+"', '"+toname+"', '"+amount+"')");
          
          if(i !=0 && j!=0 && k!=0) {
        	  con.commit();
        	  out.println("changes commited, money sent");
        	  out.println("Money sent = "+amount);
          }else {
        	  con.rollback();
        	  out.println();
          }
          
			con.close();  
			
			
		}catch (Exception e) {
			try { con.rollback(); } catch (SQLException ignored) { } 
			out.println(e);
		}
		
		
	}

}
