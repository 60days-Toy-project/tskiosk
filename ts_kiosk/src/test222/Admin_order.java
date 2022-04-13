package test222;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;





public class Admin_order extends JFrame {
   private JPanel tablePan = new OTablepane(this);

   public Admin_order() {
      OmakeFrame();
      JPanel pn = OmakePanel();
      this.add(pn);
   }

   void OmakeFrame() {

      this.setTitle("주문관리");
      this.setSize(960, 800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   public JPanel OmakePanel() {
      JPanel pn = new JPanel();
      pn.setLayout(null);

      tablePan.setSize(1200, 800);
      tablePan.setLocation(1, 1);
      pn.add(tablePan);

      return pn;

   }

}

class OTablepane extends JPanel { // 장바구니 담을 패널
   private JFrame f;
   public String Result = "";

   public OTablepane(JFrame f) {
      this.f = f;
      ordermakeTable orderTable = new ordermakeTable(f);
      setLayout(null);
      orderTable.setSize(1200, 800);
      orderTable.setLocation(1, 1);

      add(orderTable);

   }
}

class ordermakeTable extends JPanel {
   // DB에서 스윙 화면으로 테이블 값 가져오기(select) , 저장하기(insert), 수정하기(update), 삭제하기(delete)

   
   public static int ordernum;
   
   private JFrame f1;
   JPanel jp1 = new JPanel();

   private static final long serialVersionUID = 1L;
   
   private JButton jbtnAllRow = null; //고객 전체보기
   private JButton jbtnComplete = new JButton("주문완료"); // 주문완료 버튼
   private JTable table;
   private JScrollPane scrollPane; // 테이블 스크롤바 자동으로 생성되게 하기

   
   private JComboBox<String> cbbsearch;
   private static String comboNames[] = { "주문자 ID", "주문상태"};
   private JTextField search = new JTextField(13);
   private JButton jBtnSearch = new JButton("검색");
   private String Content; // 검색 카테고리 id cname gender 담을 스트링
   
   private JLabel backimgLabel = new JLabel();// 제품 사진
   private ImageIcon bicon;

   private static String colNames[] = {"번호", "주문자ID", "메뉴", "총수량", "총금액","주문시간","주문상태"}; // 테이블 컬럼 값들
   static DefaultTableModel model = new DefaultTableModel(colNames, 0); // 테이블 데이터 모델 객체 생성

   public ordermakeTable(JFrame f1) {

      this.f1 = f1;
      setLayout(null); // 레이아웃 배치관리자 삭제
      
      jp1.setLayout(null);
      jp1.setLocation(1,1);
      jp1.setSize(960,800);
      
      bicon = new ImageIcon("image/icon/backspace.png");
      backimgLabel.setIcon(bicon);
      backimgLabel.setBounds(5, 5, 45, 45);
      jp1.add(backimgLabel);
      backimgLabel.addMouseListener((MouseListener) new BackSpace()); // 테이블에 마우스리스너 연결
      
      JLabel optionOrder = new JLabel("주문 조회");

      optionOrder.setBounds(0, 0, 960, 60);
      optionOrder.setForeground(new Color(255, 255, 255));
      optionOrder.setBackground(new Color(255, 0, 102));
      optionOrder.setOpaque(true);
      optionOrder.setHorizontalAlignment(JLabel.CENTER);
      optionOrder.setFont(new Font("함초롱바탕", Font.BOLD, 30));
      jp1.add(optionOrder);// 컴포넌트 컨테이너에 올림
      
            
      JPanel searchpan = new JPanel(); //검색 패널
      searchpan.setLocation(130, 100);
      searchpan.setSize(350, 60);
      JPanel ssspan = new JPanel();//검색 컴포넌트 넣을 패널
      ssspan.setLayout(new FlowLayout(FlowLayout.LEFT));
      
      jBtnSearch.setBorderPainted(false);
      jBtnSearch.setBackground(new Color(255, 0, 102));
      jBtnSearch.setForeground(Color.WHITE);
      jBtnSearch.setFont(new Font("SansSerif", Font.BOLD, 16));
   

      cbbsearch = new JComboBox(comboNames); //콤보박스
      cbbsearch.setBackground(Color.WHITE);
      ssspan.add(cbbsearch);//콤보박스
      ssspan.add(search); //텍스트필드
      ssspan.add(jBtnSearch);//검색 버튼
      searchpan.add(ssspan);
      searchpan.setBackground(Color.WHITE);
      ssspan.setBackground(Color.WHITE);
      
      

      jBtnSearch.addActionListener(new ActionListener() { 
         public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
            DefaultTableModel model2 = (DefaultTableModel) table.getModel();

            if (cbbsearch.getSelectedItem().toString().equals("주문자 ID")) {
               Content = "cId";
               
            } else if (cbbsearch.getSelectedItem().toString().equals("주문상태")) {
               Content = "status";
               
            }
            
            model2.setRowCount(0); // 전체 테이블 화면을 지워줌
            
            System.out.println("이거는" + Content);
            System.out.println((String)search.getText());
            OrderDB odb = OrderDB.getInstance();
            int result = odb.searchorder(Content,(String)search.getText()) ;
            if (result == -1) { //검색 결과 없을  
               JOptionPane.showMessageDialog(null, "해당내용이 없습니다");

            }            
         }
      });

   

      table = new JTable(model); // 테이블에 모델객체 삽입
      table.setRowHeight(50);
      table.getTableHeader().setFont(new Font("굴림체", Font.BOLD, 15));
      table.getColumnModel().getColumn(0).setPreferredWidth(180); // JTable 의 컬럼 길이 조절
      table.getColumnModel().getColumn(1).setPreferredWidth(280);
      table.getColumnModel().getColumn(2).setPreferredWidth(280);
      table.getColumnModel().getColumn(3).setPreferredWidth(280);
      table.getColumnModel().getColumn(4).setPreferredWidth(280);
      table.getColumnModel().getColumn(5).setPreferredWidth(370);
      table.getColumnModel().getColumn(6).setPreferredWidth(280);

      table.addMouseListener((MouseListener) new JTableMouseListener()); // 테이블에 마우스리스너 연결

      scrollPane = new JScrollPane(table); // 테이블에 스크롤 생기게 하기
      scrollPane.setSize(800, 450);
      scrollPane.setLocation(70, 180);
      
     
      jp1.add(searchpan);
      //jp1.add(jbtnComplete);
      jp1.add(scrollPane);
      jp1.setBackground(Color.WHITE);
      add(jp1);
      initialize();
      select();

   }

   private class JTableMouseListener implements MouseListener { // 마우스로 눌려진값확인하기
      public void mouseClicked(java.awt.event.MouseEvent e) { // 선택된 위치의 값을 출력

         JTable jtable = (JTable) e.getSource();
         int row = jtable.getSelectedRow(); // 선택된 테이블의 행값
         int col = jtable.getSelectedColumn(); // 선택된 테이블의 열값

         ordernum = (int) model.getValueAt(row, 0);
          String cid = (String) model.getValueAt(row, 1);
          int totalq = (int) model.getValueAt(row, 3);
          int totalp = (int) model.getValueAt(row, 4);
          String status = (String) model.getValueAt(row, 6);
          
        
         if(e.getClickCount() == 1) { 
            
            OrderReceipt orc = new OrderReceipt();
            orc.pushorderinfo(ordernum, cid, totalq, totalp, status);
                     
                     
            OrderDB odb = new OrderDB();
            odb.countpName(ordernum);
            odb.printOrder(ordernum);
            
         }

      }

      public void mouseEntered(java.awt.event.MouseEvent e) {
      }

      public void mouseExited(java.awt.event.MouseEvent e) {
      }

      public void mousePressed(java.awt.event.MouseEvent e) {
      }

      public void mouseReleased(java.awt.event.MouseEvent e) {
      }
   }
   private class BackSpace implements MouseListener { //뒤로가기 클릭 이벤트
      public void mouseClicked(java.awt.event.MouseEvent e) { 
         
         int result = JOptionPane.showConfirmDialog(null,"뒤로 가시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
         if(result==JOptionPane.YES_OPTION) {
            Admin_main admain = new Admin_main();
            admain.adminmain();
            f1.setVisible(false);
         }
         
      }

      public void mouseEntered(java.awt.event.MouseEvent e) {
      }

      public void mouseExited(java.awt.event.MouseEvent e) {
      }

      public void mousePressed(java.awt.event.MouseEvent e) {
      }

      public void mouseReleased(java.awt.event.MouseEvent e) {
      }
   }
   private void select() { // 테이블에 보이기 위해 검색

      OrderDB odb = OrderDB.getInstance();
       odb.selectmeber();

   }

   private void initialize() { // 액션이벤트와 버튼 컴포넌트 설정
      
      
      jbtnAllRow = new JButton();
      jbtnAllRow.addActionListener(new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent e) {
            System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
            DefaultTableModel model2 = (DefaultTableModel) table.getModel();

            model2.setRowCount(0);
            select();
         }
      });
      jbtnAllRow.setBounds(700, 100, 150, 50);
      jbtnAllRow.setBorderPainted(false);
      jbtnAllRow.setBackground(new Color(255, 0, 102));
      jbtnAllRow.setForeground(Color.WHITE);
      jbtnAllRow.setFont(new Font("SansSerif", Font.BOLD, 16));
      jbtnAllRow.setText("새로고침");
      jp1.add(jbtnAllRow);
      
   }
   
   

}
