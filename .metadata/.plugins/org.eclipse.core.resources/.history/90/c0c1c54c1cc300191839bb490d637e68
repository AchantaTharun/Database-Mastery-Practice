

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
 * Servlet implementation class delEmp
 */
@WebServlet("/delEmp")
public class delEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delEmp() {
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
        int e=Integer.parseInt(empno);
 try{   
    		
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		    
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");  
			 
			Statement stmt=con.createStatement();  
			 int rs=0;
			 rs=stmt.executeUpdate("delete from emp_test where empno='"+e+"'");    
			if(rs==0) {
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
	        	rd.include(request, response);
				out.println("Delete Failed");
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
	        	rd.include(request, response);
				out.println("Deleted");
				
			}
			con.close();  
			 
			}catch(Exception e1){ System.out.println(e1);}  
			  out.println("<br><br><a href='home.html'>back</a>");
	}

}
