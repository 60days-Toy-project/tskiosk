package test222;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDB {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet res = null;

	private final String INSERT = "insert into OrderList(orderNum,cId,pName,quantity,price,time,status, totalQ, totalP)"
			+ " values(?,?,?,?,?,?, ?, ?, ?)";
	private final String NAME = "Select Cname from OrderList where Id = ? and Pw=?";
	//private final String SELECT = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList";
	private final String SELECT = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where time in (select min(time) from OrderList group by orderNum)";
	
	
	private static OrderDB instance = new OrderDB();

	public static OrderDB getInstance() {
		return instance;
	}


	public int insertMember(Order mdto) { //새로 추가

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(INSERT);

			stmt.setInt(1, mdto.getOrderNum());
			stmt.setString(2, mdto.getCustomerId());
			stmt.setString(3, mdto.getProductName());
			stmt.setInt(4, mdto.getQuantity());
			stmt.setInt(5, mdto.getPrice());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			//stmt.setTimestamp(6, date);
			stmt.setString(6, mdto.getTime().toString());
			stmt.setInt(7, mdto.getStatus());
			stmt.setInt(8, mdto.getTotalQuantity());
			stmt.setInt(9, mdto.getTotalPrice());
			
			int r = stmt.executeUpdate();
			if(r==1) {
				System.out.println("주문 db저장 성공");
				return 1;
			}else {
				System.out.println("db 저장 실패");
			}

			//return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int selectmeber() { //Customers 테이블 항목 전체 불러오기

		conn = Database.getConnection();

		try {
			stmt = conn.prepareStatement(SELECT);
			res = stmt.executeQuery();
			while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
				Admin_order.model.addRow(new Object[] {
						res.getInt("orderNum"), res.getString("cId"),
						res.getString("pName"), res.getInt("totalQ"), 
						res.getInt("totalP"), res.getString("time"),
						res.getInt("status") });
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}