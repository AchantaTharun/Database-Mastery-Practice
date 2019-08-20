package curd;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editEmp
 */
@WebServlet("/editEmp")
public class editEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String empno=request.getParameter("empno");
        int eno=Integer.parseInt(empno);
        String job=request.getParameter("job");
        String sal=request.getParameter("sal");
        
        int s=Integer.parseInt(sal);
        try{   
        	Connection con=DatabaseUtil.getConnection();
			Statement stmt=con.createStatement();  
			 int rs=0;
			 rs=stmt.executeUpdate("update emp_test set job='"+job+"', sal ='"+s+"' where empno='"+eno+"'");    
			if(rs==0) {
				RequestDispatcher rd=request.getRequestDispatcher("edit.html");
	        	rd.include(request, response);
				out.println("Update Failed");
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("edit.html");
	        	rd.include(request, response);
				out.println("Update success");
			}
			con.close();  
			 
			}catch(Exception e){ System.out.println(e);}  
			  out.println("<br><br><a href='home.html'>back</a>");
		
	}

}
