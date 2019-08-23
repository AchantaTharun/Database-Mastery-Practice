package com.banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Initial
 */
@WebServlet("/Initial")
public class Initial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 

    public Initial() {
        super();
        // TODO Auto-generated constructor stub
    }
    
private ConnectionPool pool;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			pool = new ConnectionPool("jdbc:oracle:thin:@192.168.4.187:1521:db122", "xxsplashtesting", "xxsplashtesting", "oracle.jdbc.driver.OracleDriver", 10, 5);
			}
		catch (Exception e) {
			throw new UnavailableException(this, "Couldn't create connection pool");
			} }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
        Connection con = null;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		try {
			
			con = pool.getConnection();
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs = stmt.executeQuery("select 4 from dual");
			
			while(rs.next()) {
				out.println(rs.getString(1));
			}
			
			
		}catch (Exception e) {
			out.println(e);
		}
	}

}
