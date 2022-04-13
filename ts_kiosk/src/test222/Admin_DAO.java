package test222;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_DAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;

	private final String ADMIN_IDNUM = "select Aname,Agender from Admin where Aid_number = ?";

	private final String ADMIN_INSERT = "insert into Members(Aid_num,Aid,Apw,Aname)" + " values(?,?,?,?)";
	private final String ADMIN_LOGIN = "select * from Members where Aid = ? and Apw = ? ";

	private static Admin_DAO instance = new Admin_DAO();

	public static Admin_DAO ADgetInstance() {
		return instance;
	}

	///// ������ �α���
	public int Admin_idpw(String id, String passwd) {

		conn = Database.getConnection();
		
		try {
			stmt = conn.prepareStatement(ADMIN_LOGIN);

			stmt.setString(1, id);
			stmt.setString(2, passwd);
			res = stmt.executeQuery();
			
			if(res.next()) {
				
				return 2;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int Admin_searchIDNUM(String id_num) {
		
		conn = Database.getConnection();

		try {

			stmt = conn.prepareStatement(ADMIN_IDNUM);
			stmt.setString(1, id_num);
			System.out.println(id_num+"��� ");

			res = stmt.executeQuery();
			if(res.next()) {
				Admin_signup.name.setText(res.getString("Aname"));
				return 1;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	
	}

	public int Admin_insertMember(DTO mdto) { // ���� �߰�

		conn = Database.getConnection();
		System.out.println("�� �𸣴°ž�~ ");
		
		try {
			stmt = conn.prepareStatement(ADMIN_INSERT);

			stmt.setString(1, mdto.getAidnum());
			stmt.setString(2, mdto.getAid());
			stmt.setString(3, mdto.getApassword());
			stmt.setString(4, mdto.getAname());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
