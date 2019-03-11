import java.sql.*;  


class MysqlCon{  
   
	final static String sql="select * from student";
	
	public static void main(String args[]){  
    
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{  
    
			Class.forName("com.mysql.jdbc.Driver");  
    
		    con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/mysql","root","root");  
    
			
    
			st=con.createStatement();  
    
			rs=st.executeQuery("select * from emp");  
   
			while(rs.next())  
    
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
      
   
		}catch(ClassNotFoundException cnf){ 
			cnf.printStackTrace();
			
		}  catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
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
