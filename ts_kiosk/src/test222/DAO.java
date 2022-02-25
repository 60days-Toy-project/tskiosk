package test222;

import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;


//데이터베이스 접근
public class DAO {

	private Connection conn=null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	
	private final String LOGIN = "select * from Customers where Id = ? and Pw = ? ";
	private final String INSERT = "insert into Customers(Id,Pw,Cname,gender,birth,email,tel)" + " values(?,?,?,?,?,?,?)";

	private static DAO instance =new DAO();
	
	public static DAO getInstance() {
		return instance;
	}
	
	public int idpw(String id, String passwd) {
		
		conn = Database.getConnection();
		try {
			stmt=conn.prepareStatement(LOGIN);
			
			stmt.setString(1, id);
			stmt.setString(2, passwd);
			
			res=stmt.executeQuery();
			if(res.next()) {
				return 1;
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int insertMember(DTO mdto) {

	    conn = Database.getConnection();

	    try {
	        stmt = conn.prepareStatement(INSERT);

	        stmt.setString(1, mdto.getId());
	        stmt.setString(2, mdto.getPassword());
	        stmt.setString(3, mdto.getName());
	        stmt.setString(4, mdto.getGender());
	        stmt.setString(5, mdto.getBirth());
	        stmt.setString(6, mdto.getEmail());
	        stmt.setString(7, mdto.getTel());
	        stmt.executeUpdate();
	        
	        return 1;

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	

	
	
}
