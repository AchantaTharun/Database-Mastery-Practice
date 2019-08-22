package sp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FuncCall")
public class FuncCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FuncCall() {
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
        PrintWriter out=response.getWriter();
        int id=0;
        String s=request.getParameter("id");
        id=Integer.parseInt(s);
        try {
        	Connection con = null;		
        	con=DatabaseUtil.getConnection();
    		 
 			
        CallableStatement cStmt = con.prepareCall("{? = call max_sal(?)}");
        
        cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
        
        cStmt.setInt(2, id);
        cStmt.executeUpdate();
        
        int maxSal = cStmt.getInt(1);
        
        out.println("Max sal of Dept "+id+" is = "+ maxSal);
        
        
        
        
        }catch(Exception e) {
        	out.println(e);
        }
	}

}
