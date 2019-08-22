package sp;

import java.io.*;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class call
 */
@WebServlet("/Call")
public class Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Call() {
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
        int id=0;
        String s=request.getParameter("id");
        id=Integer.parseInt(s);
        try {
        	Connection con = null;		
        	con=DatabaseUtil.getConnection();
    		 Statement stmt=con.createStatement();  
			 
 			
        CallableStatement cStmt = con.prepareCall("{call display_ename(?)}");
       cStmt.setInt(1,id);
       //cStmt.registerOutParameter(2, java.sql.Types.VARCHAR);
       
        cStmt.executeUpdate();
       // String name = cStmt.getString(2);
       // out.println("here is the name"+name);
        
        
        
        
        ResultSet rs=stmt.executeQuery("select * from testers"); 
			
			
			 out.println("<table border=1 width=20% height=20%>");
             out.println("<tr><th>Tester Name</th><tr>");
			while(rs.next()) {
				
				String n = rs.getString("name");
                
				out.println("<tr><td>" + n + "</td></tr>"); 
			}
			 out.println("</table>");
             out.println("</html></body>");
			
			out.println("new tester added");
			
        }catch(Exception e) {
        	System.out.println(e);
        }

        
	}

}
