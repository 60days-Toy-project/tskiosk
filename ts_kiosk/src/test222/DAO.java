package test222;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;


//데이터베이스 접근
public class DAO {

	private Connection conn=null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	
	private final String LOGIN = "select * from Customers where Id = ? and Pw = ? ";
	private final String INSERT = "insert into Customers(Id,Pw,Cname,gender,birth,email,tel)" + " values(?,?,?,?,?,?,?)";
	private final String NAME = "Select Cname from Customers where Id = ? and Pw=?";

	private static DAO instance =new DAO();
	
	public static DAO getInstance() {
		return instance;
	}
	
	public int idpw(String id, String passwd) {
		
		ArrayList<DTO> arr = new ArrayList<DTO>();
		//ArrayList arr2 = new ArrayList();
				
        DTO mDto = null;
		
		conn = Database.getConnection();
		try {
			stmt=conn.prepareStatement(LOGIN);
			
			stmt.setString(1, id);
			stmt.setString(2, passwd);
			
			res=stmt.executeQuery();
			if(res.next()) {
				 mDto = new DTO();
				 mDto.setId(res.getString("Id"));
				 mDto.setPassword(res.getString("Pw"));
	             mDto.setName(res.getString("Cname"));
	             mDto.setGender(res.getString("gender"));
	             mDto.setBirth(res.getString("birth"));
	             mDto.setEmail(res.getString("email"));
	             mDto.setTel(res.getString("tel"));
	                          	                 
	             arr.add(mDto); // mDto arr배열에 추가
	                       
	             String information = arr.toString(); //배열 String으로 변환하기
	             	            
	             String [] info = information.split("/"); // "/"를 기준으로 나누기
	             //System.out.println("나눈거"+Arrays.toString(info));
	             	            
	             String pname = info[1]; 
	             String pemail = info[2];
	             String ptel = info[3];
	             
	             //로그인 할 때 사용자 정보, 이메일, 전화번호 정보 넘기기
	             creditCardScreen ccs = new creditCardScreen();
	             ccs.pushname(pname, pemail, ptel);
	            
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
