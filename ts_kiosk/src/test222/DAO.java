package test222;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;

//데이터베이스 접근
public class DAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private final String LOGIN = "select * from Customers where Id = ? and Pw = ? ";

	private final String NAME = "Select Cname from Customers where Id = ? and Pw=?";

	// idpw 찾기
	private final String FIND_id = "select Id from Customers where Cname = ? and tel=?";
	private final String FIND_pw = "select * from Customers where Id= ? and tel= ?";
	private final String RESET_pw = "UPDATE Customers SET Pw= ? where Id = ?";

	// 고객 정보 DB
	private final String CHECK = "select * from Customers where Id = ?";
	private final String INSERT = "insert into Customers(Id,Pw,Cname,gender,birth,email,tel)"
			+ " values(?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE Customers SET Pw=?,Cname=?, gender=?, birth=?, email=?, tel=? "
			+ "where Id=?";
	private final String SELECT = "select Id, Pw, Cname, gender, birth, email,tel from Customers";
	private final String DELETE = "delete from  Customers where id= ?";
	private final String SEARCH_id = "select * from Customers where Id = ?";
	private final String SEARCH_name = "select * from Customers where Cname = ?";
	private final String SEARCH_gender = "select * from Customers where gender = ?";

	// 메뉴 정보 DB
	private final String MINSERT = "insert into product(Category,Sub,Subkey,Qty,Price,Realeasedate)"
			+ " values(?,?,?,?,?,?)";

	private final String MUPDATE = "UPDATE product SET Category=?, Sub=?, Qty=?, Price=?, Realeasedate=? "
			+ "where Subkey=?";
	private final String MSELECT = "select * from product";
	private final String MDELETE = "delete from product where Sub= ?";
	private final String MSEARCH_category = "select * from product where Category = ?";
	private final String MSEARCH_sub = "select * from product where Sub = ?";
	private final String MSEARCH_subkey = "select * from product where Subkey = ?";
	private final String MSEARCH_price = "select * from product where Price = ?";

	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	public int idpw(String id, String passwd) {

		ArrayList<DTO> arr = new ArrayList<DTO>();

		// ArrayList arr2 = new ArrayList();

		DTO mDto = null;

		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement(LOGIN);

			stmt.setString(1, id);
			stmt.setString(2, passwd);

			res = stmt.executeQuery();
			if (res.next()) {
				mDto = new DTO();
				mDto.setId(res.getString("Id"));
				mDto.setPassword(res.getString("Pw"));
				mDto.setName(res.getString("Cname"));
				mDto.setGender(res.getString("gender"));
				mDto.setBirth(res.getString("birth"));
				mDto.setEmail(res.getString("email"));
				mDto.setTel(res.getString("tel"));

				arr.add(mDto); // mDto arr배열에 추가

				String information = arr.toString(); // 배열 String으로 변환하기

				String[] info = information.split("/"); // "/"를 기준으로 나누기
				// System.out.println("나눈거"+Arrays.toString(info));

				String pid = info[1];
				String pname = info[2];
				String pemail = info[3];
				String ptel = info[4];

				// 로그인 할 때 사용자 정보, 이메일, 전화번호 정보 넘기기
				creditCardScreen ccs = new creditCardScreen();
				ccs.pushname(pid, pname, pemail, ptel);

				return 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	///////// 아이디 찾기
	public int findID(String name, String tel) {
		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(FIND_id);

			stmt.setString(1, name);
			stmt.setString(2, tel);

			res = stmt.executeQuery();

			if (res.next()) {
				
				Find_IDPW.fid=res.getString("Id");
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}
	//비밀번호 바꾸기 전 개인정보 맞나 확인
	public int findPW(String id, String tel) {
		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(FIND_pw);

			stmt.setString(1, id);
			stmt.setString(2, tel);

			res = stmt.executeQuery();

			if (res.next()) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int resetPW(DTO fdto) { // 비밀번호 재설정 업데이트

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(RESET_pw);

			stmt.setString(1, fdto.getPassword());
			stmt.setString(2, fdto.getId());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	//////////////////// 고객

	public int checkID(String checkid) { //아이디 중복 조회

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(CHECK);

			stmt.setString(1, checkid);
			res = stmt.executeQuery();

			if (res.next()) {
				return -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public int insertMember(DTO mdto) { // 새로 추가

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updateMeber(DTO mdto) { // 고객정보 수정 후 업데이트

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(UPDATE);

			stmt.setString(1, mdto.getPassword());
			stmt.setString(2, mdto.getName());
			stmt.setString(3, mdto.getGender());
			stmt.setString(4, mdto.getBirth());
			stmt.setString(5, mdto.getEmail());
			stmt.setString(6, mdto.getTel());
			stmt.setString(7, mdto.getId());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int selectmeber() { // Customers 테이블 항목 전체 불러오기

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(SELECT);
			res = stmt.executeQuery();
			while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
				makeTable.model.addRow(new Object[] { res.getString("Id"), res.getString("Pw"), res.getString("Cname"),
						res.getString("gender"), res.getString("birth"), res.getString("email"),
						res.getString("tel") });
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deletemember(String id) {// 고객 정보 삭제

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, id);
			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int searchmember(String field, String st) {// 검색

		conn = Database.getConnection();

		try {
			if (field == "Id") {
				stmt = conn.prepareStatement(SEARCH_id);
			} else if (field == "Cname") {
				stmt = conn.prepareStatement(SEARCH_name);
			} else if (field == "gender") {
				stmt = conn.prepareStatement(SEARCH_gender);
			}

			stmt.setString(1, st);

			res = stmt.executeQuery();
			while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
				makeTable.model.addRow(new Object[] { res.getString("Id"), res.getString("Pw"), res.getString("Cname"),
						res.getString("gender"), res.getString("birth"), res.getString("email"),
						res.getString("tel") });
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	///////////////////////////// 메뉴 관련

	public int insertmenu(Admin_DTO adto) { // 새로 추가

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(MINSERT);

			stmt.setString(1, adto.getCategory());
			stmt.setString(2, adto.getSub());
			stmt.setString(3, adto.getSubkey());
			stmt.setString(4, adto.getQty());
			stmt.setString(5, adto.getPrice());
			stmt.setString(6, adto.getRdate());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updatemenu(Admin_DTO adto) { // 메뉴 수정 후 업데이트

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(MUPDATE);

			stmt.setString(1, adto.getCategory());
			stmt.setString(2, adto.getSub());
			stmt.setString(3, adto.getQty());
			stmt.setString(4, adto.getPrice());
			stmt.setString(5, adto.getRdate());
			stmt.setString(6, adto.getSubkey());

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int selectmenu() { // product 테이블 항목 전체 불러오기

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(MSELECT);
			res = stmt.executeQuery();
			while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
				menumakeTable.m
						.addRow(new Object[] { res.getString("Category"), res.getString("Sub"), res.getString("Subkey"),
								res.getString("Qty"), res.getString("Price"), res.getString("Realeasedate") });
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deletemenu(String sub) {// 메뉴 정보 삭제

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(MDELETE);
			stmt.setString(1, sub);

			stmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int searchmenu(String field, String str) {// 검색

		conn = Database.getConnection();

		try {

			if (field == "Category") {
				stmt = conn.prepareStatement(MSEARCH_category);
			} else if (field == "Sub") {
				stmt = conn.prepareStatement(MSEARCH_sub);
			} else if (field == "Subkey") {
				stmt = conn.prepareStatement(MSEARCH_subkey);
			} else if (field == "Price") {
				stmt = conn.prepareStatement(MSEARCH_price);
			}

			stmt.setString(1, str);

			res = stmt.executeQuery();

			while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
				menumakeTable.m
						.addRow(new Object[] { res.getString("Category"), res.getString("Sub"), res.getString("Subkey"),
								res.getString("Qty"), res.getString("Price"), res.getString("Realeasedate") });
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
