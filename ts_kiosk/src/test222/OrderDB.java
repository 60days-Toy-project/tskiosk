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
   private final String SELECT = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where time in (select min(time) from OrderList group by orderNum)";
   private final String NUMSELECT = "select max(orderNum) from OrderList";
   private final String OrderSELECT = "select pName, quantity, price from OrderList where orderNum = ?";
   
   private final String SEARCH_cId = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where cId = ? and time in (select min(time) from OrderList group by orderNum)";
   private final String SEARCH_status = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where status = ? and time in (select min(time) from OrderList group by orderNum)";
   
   private final String COUNTSELECT = "select count(pName) FROM OrderList where orderNum=?";
   
   private final String ChangeStatus = "update OrderList set status='주문접수' where ordernum=?"; //주문대기->주문접수로 바꿈
   private final String CompleteStatus = "update OrderList set status='주문완료' where ordernum=?"; //주문접수->주문완료로 바꿈
   
   private static OrderDB instance = new OrderDB();
   public static int cpname;
   public static String [][] order_info = new String [20][3];
  

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
         stmt.setString(7, mdto.getStatus());
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
            ordermakeTable.model.addRow(new Object[] {
                  res.getInt("orderNum"), res.getString("cId"),
                  res.getString("pName"), res.getInt("totalQ"), 
                  res.getInt("totalP"), res.getString("time"),
                  res.getString("status") });
         }
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
   }
   
   
   public int searchorder(String field, String st) {// 검색

      conn = Database.getConnection();

      try {
         if (field == "cId") {
            stmt = conn.prepareStatement(SEARCH_cId);
         } else if (field == "status") {
            stmt = conn.prepareStatement(SEARCH_status);
         } 

         stmt.setString(1, st);

         res = stmt.executeQuery();
         while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
            
            ordermakeTable.model.addRow(new Object[] {res.getInt("orderNum"), res.getString("cId"),
                  res.getString("pName"), res.getInt("totalQ"), 
                  res.getInt("totalP"), res.getString("time"),
                  res.getString("status") });
            System.out.println(res.getInt("orderNum"));
            System.out.println(res.getString("cId"));
            System.out.println(res.getString("pName"));
            System.out.println( res.getInt("totalQ"));
            System.out.println( res.getInt("totalP"));
            System.out.println( res.getString("time"));
            System.out.println( res.getString("status"));
         }
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
   }
   
   
   public int countpName (int st) {
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(COUNTSELECT);
         stmt.setInt(1, st);
         
         res = stmt.executeQuery();
         while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
            
            cpname = res.getInt(1); //첫 번째 칸의 값 +1
            System.out.println("메뉴갯수는"+cpname);
            
         }
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
      
   }
   
   public int printOrder(int st) { //영수증 출력 함수
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(OrderSELECT);
         stmt.setInt(1, st);
                  
         res = stmt.executeQuery();
         for (int i=0; i<cpname; i++) { 
            while (res.next()) {
              
               order_info [i][0] = res.getString(1);
               System.out.println(i+order_info[i][0]);
               order_info [i][1] =  Integer.toString(res.getInt(2));
               System.out.println(i+order_info[i][1]);
               order_info[i][2] =  Integer.toString(res.getInt(3));
               System.out.println(i+order_info[i][2]);
               i++;
               
            }
         }
         
         OrderReceipt orc = new OrderReceipt();
         orc.printReceipt();
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
   }
   
   public int changeStatus (int st) { //주문대기->주문접수
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(ChangeStatus);
         stmt.setInt(1, st);
         
         stmt.executeUpdate();
        
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
      
   }
   
   public int completeStatus (int st) { //주문접수->주문완료
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(CompleteStatus);
         stmt.setInt(1, st);
         
         stmt.executeUpdate();
         
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
      
   }
   
   
   
   public int selectONum() { //orderNum을 구하는 함수
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(NUMSELECT);
         res = stmt.executeQuery();
         while (res.next()) { // 각각 값을 가져와서 테이블값들을 추가
            creditCardScreen.ONum = res.getInt(1)+1; //첫 번째 칸의 값 +1
            creditCardScreen cs = new creditCardScreen();
            cs.pushONum(creditCardScreen.ONum);
            
         }
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
   }
   
   



}
