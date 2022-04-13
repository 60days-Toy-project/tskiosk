package test222;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;

//�����ͺ��̽� ����
public class DAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private final String LOGIN = "select * from Customers where Id = ? and Pw = ? ";

	private final String NAME = "Select Cname from Customers where Id = ? and Pw=?";

	// idpw ã��
	private final String FIND_id = "select Id from Customers where Cname = ? and tel=?";
	private final String FIND_pw = "select * from Customers where Id= ? and tel= ?";
	private final String RESET_pw = "UPDATE Customers SET Pw= ? where Id = ?";

	// �� ���� DB
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

	// �޴� ���� DB
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

				arr.add(mDto); // mDto arr�迭�� �߰�

				String information = arr.toString(); // �迭 String���� ��ȯ�ϱ�

				String[] info = information.split("/"); // "/"�� �������� ������
				// System.out.println("������"+Arrays.toString(info));

				String pid = info[1];
				String pname = info[2];
				String pemail = info[3];
				String ptel = info[4];

				// �α��� �� �� ����� ����, �̸���, ��ȭ��ȣ ���� �ѱ��
				creditCardScreen ccs = new creditCardScreen();
				ccs.pushname(pid, pname, pemail, ptel);

				return 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	///////// ���̵� ã��
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
	//��й�ȣ �ٲٱ� �� �������� �³� Ȯ��
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

	public int resetPW(DTO fdto) { // ��й�ȣ �缳�� ������Ʈ

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

	//////////////////// ��

	public int checkID(String checkid) { //���̵� �ߺ� ��ȸ

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
	
	public int insertMember(DTO mdto) { // ���� �߰�

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

	public int updateMeber(DTO mdto) { // ������ ���� �� ������Ʈ

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

	public int selectmeber() { // Customers ���̺� �׸� ��ü �ҷ�����

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(SELECT);
			res = stmt.executeQuery();
			while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
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

	public int deletemember(String id) {// �� ���� ����

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

	public int searchmember(String field, String st) {// �˻�

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
			while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
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

	///////////////////////////// �޴� ����

	public int insertmenu(Admin_DTO adto) { // ���� �߰�

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

	public int updatemenu(Admin_DTO adto) { // �޴� ���� �� ������Ʈ

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

	public int selectmenu() { // product ���̺� �׸� ��ü �ҷ�����

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(MSELECT);
			res = stmt.executeQuery();
			while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
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

	public int deletemenu(String sub) {// �޴� ���� ����

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

	public int searchmenu(String field, String str) {// �˻�

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

			while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
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
