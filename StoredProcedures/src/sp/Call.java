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
        int id=7839;
        try {
        	Connection con = null;
    		
    		
    		
    		
     
            Class.forName("oracle.jdbc.driver.OracleDriver");  
    	    
    		 con=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");  
    		
    		 
    		 Statement stmt=con.createStatement();  
			 
 			ResultSet rs=stmt.executeQuery("select * from t"); 
 			while(rs.next()) {
 				 out.println(rs.getString("name"));
 			}
        CallableStatement cStmt = con.prepareCall("{call display_ename(?)}");
       cStmt.setInt(1,id);
       //cStmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        cStmt.executeUpdate();
       // String name = cStmt.getString(2);
       // out.println(name);
        }catch(Exception e) {
        	System.out.println(e);
        }

        
	}

}
