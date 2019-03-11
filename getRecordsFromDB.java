import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class student {

	final static String sql="select * from student";

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//get connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vaibhavraj");
		
		//create statement
		
		st=con.createStatement();
		
		//create ResultSet obj
		
		rs=st.executeQuery(sql);
		
		while(rs.next()) {
		
			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3));
		
			
		}
		
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(con!=null) {
				con.close();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(st!=null) {
					st.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
