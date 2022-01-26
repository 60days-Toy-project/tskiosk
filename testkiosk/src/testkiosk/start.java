package testkiosk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//sql 연결
		Connection conn = null;
	      // TODO Auto-generated method stub
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn=DriverManager.getConnection("jdbc:mysql://211.243.183.140:3306/twosome", "dev", "emb306");
	         System.out.println("success");
	         System.out.println("success");
	      }
	        catch(SQLException ex){ 
	            System.out.println("SQLException" + ex);
	            ex.printStackTrace();
	        }
	        catch(Exception ex){ 
	            System.out.println("Exception:" + ex);
	            ex.printStackTrace();
	        }   
	      
	    // 첫 화면 실행  
		FirstScreen fs = new FirstScreen();
		fs.disScreen();
	}

}
