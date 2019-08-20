

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class disEmp
 */
@WebServlet("/disEmp")
public class disEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public disEmp() {
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
        
        try{   
    		
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		    
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");  
			 
			Statement stmt=con.createStatement();  
			 
			ResultSet rs=stmt.executeQuery("select * from emp_test"); 
			
			 out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><th>Email</th><th>Job</th><th>Phone</th><tr>");
			while(rs.next()) {
				
				String n = rs.getString("empno");
                String nm = rs.getString("ename");
                int s = rs.getInt("sal"); 
                String mail=rs.getString("email");
                String job = rs.getString("job");
                String phno=rs.getString("phno");
				out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + mail + "</td><td>" + job + "</td><td>" + phno + "</td></tr>"); 
			}
			 out.println("</table>");
             out.println("</html></body>");
			con.close();  
			 
			}catch(Exception e){ System.out.println(e);}  
			  out.println("<br><br><a href='home.html'>back</a>");
		
	}

}
