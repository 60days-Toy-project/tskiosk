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
   //private final String SELECT = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList";
   private final String NUMSELECT = "select max(orderNum) from OrderList";
   private final String OrderSELECT = "select pName, quantity, price from OrderList where orderNum = ?";
   
   private final String SEARCH_cId = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where cId = ? and time in (select min(time) from OrderList group by orderNum)";
   //private final String SEARCH_cId = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where cId = ?";
   private final String SEARCH_status = "select orderNum, cId, pName, totalQ, totalP, time, status from OrderList where status = ? and time in (select min(time) from OrderList group by orderNum)";
   
   private final String COUNTSELECT = "select count(pName) FROM OrderList where orderNum=?";
   
   private final String ChangeStatus = "update OrderList set status='�ֹ�����' where ordernum=?"; //�ֹ����->�ֹ������� �ٲ�
   private final String CompleteStatus = "update OrderList set status='�ֹ��Ϸ�' where ordernum=?"; //�ֹ�����->�ֹ��Ϸ�� �ٲ�
   
   private static OrderDB instance = new OrderDB();
   //public static String order_info;
   public static int cpname;
   public static String [][] order_info = new String [20][3];
   
   //public static String order_info;
   

   public static OrderDB getInstance() {
      return instance;
   }


   public int insertMember(Order mdto) { //���� �߰�

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
            System.out.println("�ֹ� db���� ����");
            return 1;
         }else {
            System.out.println("db ���� ����");
         }

         //return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
   }
   
   
   public int selectmeber() { //Customers ���̺� �׸� ��ü �ҷ�����

      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(SELECT);
         res = stmt.executeQuery();
         while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
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
   
   
   public int searchorder(String field, String st) {// �˻�

      conn = Database.getConnection();

      try {
         if (field == "cId") {
            stmt = conn.prepareStatement(SEARCH_cId);
         } else if (field == "status") {
            stmt = conn.prepareStatement(SEARCH_status);
         } 

         stmt.setString(1, st);

         res = stmt.executeQuery();
         while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
            
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
         while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
            
            cpname = res.getInt(1); //ù ��° ĭ�� �� +1
            System.out.println("�޴�������"+cpname);
            
         }
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
      
   }
   
   public int printOrder(int st) { //������ ��� �Լ�
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(OrderSELECT);
         stmt.setInt(1, st);
                  
         res = stmt.executeQuery();
         for (int i=0; i<cpname; i++) { //�̰� ������ ŷ���� ����� ����� �� ��!...........
            while (res.next()) {
               System.out.println("��"+cpname);
               order_info [i][0] = res.getString(1);
               System.out.println(i+order_info[i][0]);
               order_info [i][1] =  Integer.toString(res.getInt(2));
               System.out.println(i+order_info[i][1]);
               order_info[i][2] =  Integer.toString(res.getInt(3));
               System.out.println(i+order_info[i][2]);
               i++;
               
            }
         }
         //while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
            //Admin_order.ordernum = res.getInt(1)+1; //ù ��° ĭ�� �� +1
            //order_info = "," + res.getString(1)+ "," + res.getInt(2) + "," + res.getInt(3);
            //order_info = "," + res.getString(1)+ "," + res.getInt(2) + "," + res.getInt(3);
            //System.out.println(order_info);
            /*
            for (int i=0; i<cpname; i++) {
               System.out.println("��"+cpname);
               order_info [i][0] = res.getString(1);
               System.out.println(i+order_info[i][0]);
               order_info [i][1] =  Integer.toString(res.getInt(2));
               System.out.println(i+order_info[i][1]);
               order_info[i][2] =  Integer.toString(res.getInt(3));
               System.out.println(i+order_info[i][2]);
               
            }
            */
            //System.out.println(order_info);
            //System.out.println("/" + res.getString(1)+ "/" + res.getInt(2) + "/" + res.getInt(3));
            //System.out.println(res.getString(1));
            //System.out.println(res.getInt(2));
            //System.out.println(res.getInt(3));
            
         //} 
         OrderReceipt orc = new OrderReceipt();
         orc.printReceipt();
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
   }
   
   public int changeStatus (int st) { //�ֹ����->�ֹ�����
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(ChangeStatus);
         stmt.setInt(1, st);
         
         stmt.executeUpdate();
         //res = stmt.executeQuery();
         //while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
            
            
         //}
         
         return 1;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      
      
   }
   
   public int completeStatus (int st) { //�ֹ�����->�ֹ��Ϸ�
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
   
   
   
   public int selectONum() { //orderNum�� ���ϴ� �Լ�
      conn = Database.getConnection();

      try {
         stmt = conn.prepareStatement(NUMSELECT);
         res = stmt.executeQuery();
         while (res.next()) { // ���� ���� �����ͼ� ���̺����� �߰�
            creditCardScreen.ONum = res.getInt(1)+1; //ù ��° ĭ�� �� +1
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