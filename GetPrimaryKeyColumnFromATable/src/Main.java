import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

public static void main(String a[]){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DatabaseUtil.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@192.168.4.187:1521:db122","xxsplashtesting","xxsplashtesting");
			String query = "insert into survey (supp_id,supp_n, contact_n) values (?,?,?)";
			pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,  8);
			pstmt.setString(2, "nnn");
			pstmt.setString(3, "ccc");
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			while(rs != null && rs.next()){
				System.out.println("Generated Emp Id: "+rs.getInt(1));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception ex){}
		}
	}



}
