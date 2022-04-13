package test222;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class OrderReceipt {
   
   static int onumber;
   static String cusid;
   static int tquantity;
   static int tprice;
   static String ostatus;
   
   //private static String colNames[] = {"제품명", "수량", "금액"}; // 테이블 컬럼 값들
   private static String colNames[] = {"", "", ""}; // 테이블 컬럼 값들
   //static DefaultTableModel model = new DefaultTableModel(colNames, 0); // 테이블 데이터 모델 객체 생성
   public static String[][] oinfo = new String [20][3];

   
   public void pushorderinfo(int onum, String cid, int totalq, int totalp, String status) { //주문번호, 주문자id, 총수량, 총액 받아오기
      onumber = onum;
      cusid = cid;
      tquantity = totalq;
      tprice = totalp;
      ostatus = status;
   }
   
   
   public void printReceipt() {
      
      JFrame fr = new JFrame("영수증");
      
      fr.setSize(800, 1000);
      fr.setLocationRelativeTo(null);
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.getContentPane().setLayout(null);
      fr.setBackground(Color.WHITE);
      
      JLabel lb = new JLabel("영수증");
      fr.add(lb);
      lb.setBounds(0, 0, 800, 100);
      lb.setBackground(new Color(255, 0, 102));
      lb.setOpaque(true); // Opaque값을 true로 설정해야 배경색이 적용된다.
      lb.setHorizontalAlignment(JLabel.CENTER);
      lb.setFont(new Font("SansSerif", Font.BOLD, 30));
      lb.setForeground(Color.WHITE);
      
      JLabel jlonum = new JLabel("주문 번호 : ");
      fr.add(jlonum);
      jlonum.setBounds(40, 120, 100, 100);
      jlonum.setFont(new Font("SansSerif", Font.BOLD, 16));
      
      JLabel onum = new JLabel(onumber + "");
      fr.add(onum);
      onum.setBounds(140, 145, 200, 50);
      onum.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jlcid = new JLabel("주문자 ID : ");
      fr.add(jlcid);
      jlcid.setBounds(40, 160, 150, 100);
      jlcid.setFont(new Font("SansSerif", Font.BOLD, 16));
      
      JLabel cid = new JLabel(cusid + "");
      fr.add(cid);
      cid.setBounds(140, 175, 400, 70);
      cid.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jlline1 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline1);
      jlline1.setBounds(40, 190, 3000, 100);
      jlline1.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltitle = new JLabel("                            제품명                             |           수량           |               가격           ");
      fr.add(jltitle);
      jltitle.setBounds(40, 210, 3000, 100);
      jltitle.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jlline2 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline2);
      jlline2.setBounds(40, 230, 3000, 100);
      jlline2.setFont(new Font("SansSerif", Font.BOLD, 18));

      DefaultTableModel model = new DefaultTableModel(OrderDB.order_info, colNames); // 테이블 데이터 모델 객체 생성
       JTable otable = new JTable(model);
       otable.setBounds(40,300,650,430);
       
       DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
       celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
       
       otable.setRowHeight(50);
      otable.setFont(new Font("굴림체", Font.BOLD, 15));
       otable.getColumnModel().getColumn(0).setPreferredWidth(390); // JTable 의 컬럼 길이 조절
       otable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);  // 가운데 정렬
      otable.getColumnModel().getColumn(1).setPreferredWidth(180);
      otable.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
      otable.getColumnModel().getColumn(2).setPreferredWidth(200);
      otable.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
      
      //otable.setShowHorizontalLines(false); // 테이블 선 안보이게 하기
      //otable.setShowVerticalLines(false); // 테이블 선 안보이게 하기
      
      otable.setBackground(new Color(238,238,238));
      
   
      JScrollPane scroll = new JScrollPane(otable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scroll.setSize(700, 430);
       scroll.setLocation(40, 300);
      
      fr.add(scroll);
      
            
      JLabel jlline3 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline3);
      jlline3.setBounds(40, 700, 3000, 100);
      jlline3.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalq = new JLabel("총 수량 : ");
      fr.add(jltotalq);
      jltotalq.setBounds(500, 740, 150, 100);
      jltotalq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tq = new JLabel(tquantity + "개");
      fr.add(tq);
      tq.setBounds(600, 755, 400, 70);
      tq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalp = new JLabel("총액 : ");
      fr.add(jltotalp);
      jltotalp.setBounds(500, 770, 150, 100);
      jltotalp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tp = new JLabel(tprice + "원");
      fr.add(tp);
      tp.setBounds(600, 785, 400, 70);
      tp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      
      JLabel jlline4 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline4);
      jlline4.setBounds(40, 800, 3000, 100);
      jlline4.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JButton recbtn = new JButton("주문접수");
      JButton complbtn = new JButton("주문완료");
      
      if (ostatus.equals("주문대기")) {
         //JButton recbtn = new JButton("주문접수"); //주문접수 버튼 -> 주문대기 상태에서 주문접수로 바뀜
         fr.add(recbtn);
         recbtn.setBounds(400, 870, 150, 50);
         recbtn.setBorderPainted(false);
         recbtn.setBackground(new Color(255, 0, 102));
         recbtn.setForeground(Color.WHITE);
         recbtn.setFont(new Font("SansSerif", Font.BOLD, 18));
         
        
      }
      else if (ostatus.equals("주문접수")) {
         //JButton complbtn = new JButton("주문완료");
         fr.add(complbtn);
         complbtn.setBounds(400, 870, 150, 50);
         complbtn.setBorderPainted(false);
         complbtn.setBackground(new Color(255, 0, 102));
         complbtn.setForeground(Color.WHITE);
         complbtn.setFont(new Font("SansSerif", Font.BOLD, 18));
         
      }
            
      JButton closebtn = new JButton("닫기"); //주문접수 버튼
      fr.add(closebtn);
      closebtn.setBounds(580, 870, 150,50);
      closebtn.setBorderPainted(false);
      closebtn.setBackground(new Color(255, 0, 102));
      closebtn.setForeground(Color.WHITE);
      closebtn.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      
      recbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.changeStatus(onumber);
            JOptionPane.showMessageDialog(null, "주문이 접수되었습니다.");

         }
      });
      
      complbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.completeStatus(onumber);
            JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
   
         }
      });
      
      closebtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            fr.setVisible(false); // 창 안보이게 하기
         }
      });
      
      // 프레임이 보이도록 설정
        fr.setVisible(true);


      
   }

}
