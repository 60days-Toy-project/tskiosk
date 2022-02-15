package test222;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Category extends JFrame {
   public Category() {
      this.setTitle("No Title");
      
      
   }
   
   public Category(String title) {
      createFrame(title);
      JTabbedPane pane = createTabbedPane();
      //this.add(pane, BorderLayout.CENTER);
      this.add(pane);
   }
 
  
   public JTabbedPane createTabbedPane() {
      
            
      //탭 만들기
      JTabbedPane pane = new JTabbedPane();
      JTabbedPane pane2 = new JTabbedPane();
      JTabbedPane pane3 = new JTabbedPane();
      JTabbedPane pane4 = new JTabbedPane();
      JTabbedPane pane5 = new JTabbedPane();
      JTabbedPane pane6 = new JTabbedPane();
      JTabbedPane pane7 = new JTabbedPane();
      JTabbedPane pane8 = new JTabbedPane();
      
      JPanel jp1 = new JPanel();
      jp1.setLayout(null); //배치관리자 설정 안함 -> 절대 위치 사용하기 위해서!!!            
      jp1.setBackground(Color.GRAY);
       
      pane.addTab("커피&음료", pane2);
      pane2.add("에스프레소 베리에이이션", new Panelcoff());
      pane2.addTab("티 베리에이션", new Panelcoff());
      pane2.addTab("음료", new JLabel("하이"));
                 
            
      pane.addTab("아이스크림&빙수", pane3);
      pane3.addTab("아이스크림", new JLabel("하이"));
      pane3.addTab("빙수", new JLabel("하이"));
   
      pane.addTab("케이크", pane4);
      pane4.addTab("홀케이크", new JLabel("하이"));
      pane4.addTab("쇼트케이크", new JLabel("하이"));
      pane4.addTab("디저트", new JLabel("하이"));
      
      pane.addTab("델리", pane5);
      pane5.addTab("샌드위치", new JLabel("하이"));
      pane5.addTab("샐러드", new JLabel("하이"));
      pane5.addTab("기타", new JLabel("하이"));
      
      pane.addTab("빵", pane6);
      pane6.addTab("빵", new JLabel("하이"));
      pane6.addTab("양과자류", new JLabel("하이"));
      
      pane.addTab("상품", pane7);
      pane7.addTab("초콜릿", new JLabel("하이"));
      pane7.addTab("과자", new JLabel("하이"));
      pane7.addTab("상품세트", new JLabel("하이"));
      
      pane.addTab("MD", pane7);
      pane8.addTab("원두", new JLabel("하이"));
      pane8.addTab("원두, 티 가공상품", new JLabel("하이"));
      pane8.addTab("상시MD", new JLabel("하이"));
      pane8.addTab("시즌MD", new JLabel("하이"));
      pane8.addTab("MD선물세트", new JLabel("하이"));
      
      
      //pane.addTab("커피&음료", new JLabel("Tab menu 1"));
      //pane.addTab("아이스크립&빙수", new JLabel("Tab menu 2"));
      //pane.addTab("케이크", new JLabel("Tab menu 3"));
      //pane.addTab("델리", new JLabel("Tab menu 4"));
      //pane.addTab("상품", new JLabel("Tab menu 5"));
       /*
       ret_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               int result = JOptionPane.showConfirmDialog(null, "처음으로 돌아가시겠습니까?",
                     "알림", JOptionPane.YES_NO_OPTION);
               if (result==JOptionPane.YES_OPTION) {
                  FirstScreen fs = new FirstScreen();
                  fs.disScreen();
                    setVisible(false); // 창 안보이게 하기 
                  
               }
                        
               
            }
        });
       */
                
   
      
      return pane;
   }
   

        
   void createFrame(String title) {
      
      this.setTitle(title);
      this.setSize(1100,800);
      //this.setContentPane(new Category());
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //this.setLayout(new BorderLayout());
      this.setVisible(true);
   }


}

class Panelcoff extends JPanel{
   JButton[] MBtn = new JButton[15];
      String[] menu = { "아메리카노", "카페라떼", "카페모카", "카라멜마끼아또", "카푸치노", 
               "바닐라카페라떼", "숏카페라떼", "롱블랙", "에스프레소", "스패니쉬연유카페라떼",
               "아이스크림카페라떼", "달고나카페라떼", "콜드브루", "콜드브루라떼", "흑임자카페라떼"};
      int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000,
                    6500, 7000, 5500, 6000, 6500, 5500};
      
      JTextField tq = new JTextField(30);
      JTextField ts = new JTextField(40);

      

      JTextField t = new JTextField(10);

      JButton[] SBtn = new JButton[3];
      String[] Str = { "전체삭제", "결제하기", "처음으로" };

      String[] ColName = { "메뉴", "수량", "가격", "추가", "감소", "삭제" };

      String[][] Data;
      int count = 1;
      DefaultTableModel model = new DefaultTableModel(Data, ColName);
      JTable table = new JTable(model);

      Image[] icon = new Image[15];
      Image[] newimg = new Image[15];
      ImageIcon[] newicon = new ImageIcon[15];

      // 구현
      class Screen extends JPanel {
         Screen() {
           
           
            setBackground(new Color(255, 255, 204));
            DefaultTableModel m = (DefaultTableModel) table.getModel();
            table.setRowHeight(40);
            table.getTableHeader().setFont(new Font("굴림체", Font.BOLD, 15));
            table.getTableHeader().setBackground(Color.white);
            table.setBackground(Color.orange);
            table.setGridColor(Color.white);
            table.setSelectionBackground(Color.YELLOW);
            
            table.getColumnModel().getColumn(3).setCellRenderer(new Plus());
            table.getColumnModel().getColumn(3).setCellEditor(new Plus());
            table.getColumnModel().getColumn(4).setCellRenderer(new Minus());
            table.getColumnModel().getColumn(4).setCellEditor(new Minus());
            table.getColumnModel().getColumn(5).setCellRenderer(new Del());
            table.getColumnModel().getColumn(5).setCellEditor(new Del());
            
           
            
            add(new JScrollPane(table));
         }
      }
      
      //포스기 수량 추가 버튼
      class Plus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
          JButton plus;
           
          public Plus() {
             
              plus = new JButton("+");
              plus.addActionListener(e -> {
                 DefaultTableModel m = (DefaultTableModel) table.getModel();
                 int n = table.getSelectedRow();
                 //int q = (int) table.getValueAt(n, 1) +1 ; => String -> int 형변환 에러때문에 사용 X
                 int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1)))+1;
                 String qs = String.valueOf(q);
                 table.setValueAt(qs,n,1);
                   
              });
          }
   
          @Override
          public Object getCellEditorValue() {
              return null;
          }
   
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                  int row, int column) {
              return plus;
          }
   
          @Override
          public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                  int column) {
              return plus;
          }
      }
      
      
      //포스기 수량 감소 버튼
      class Minus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
          JButton minus;
          
          public Minus() {
             
              minus = new JButton("-");
              minus.addActionListener(e -> {
                  
                 DefaultTableModel m = (DefaultTableModel) table.getModel();
                 int n = table.getSelectedRow();
                 int qn = Integer.parseInt(String.valueOf(table.getValueAt(n, 1)));
                 if (qn ==1)
                	 m.removeRow(table.getSelectedRow());
                 else {
                	int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1)))-1;
                    String qs = String.valueOf(q);
                    table.setValueAt(qs,n,1);
                        
                 }
               
              });
          }
   
          @Override
          public Object getCellEditorValue() {
              return null;
          }
   
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                  int row, int column) {
              return minus;
          }
   
          @Override
          public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                  int column) {
              return minus;
          }
      }
      
      
      //포스기 부분 삭제 버튼
      class Del extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
           JButton jb;
            
           public Del() {
              
               jb = new JButton("삭제");
               jb.addActionListener(e -> {
                   ///JTableRemoveRow();
                  DefaultTableModel m = (DefaultTableModel) table.getModel();
                  m.removeRow(table.getSelectedRow());
                    
               });
           }
    
           @Override
           public Object getCellEditorValue() {
               return null;
           }
    
           @Override
           public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                   int row, int column) {
               return jb;
           }
    
           @Override
           public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                   int column) {
               return jb;
           }
       }
      
      
   
      
      class MenuBtn extends JPanel {
         MenuBtn() {
            setLayout(new GridLayout(5, 3, 3, 3));
            setBackground(Color.WHITE);
            ImageIcon[] img = new ImageIcon[15];
            img[0] = new ImageIcon("image/카페모카.jpg");
            img[1] = new ImageIcon("image/카페모카.jpg");                                                                                 
            img[2] = new ImageIcon("image/카페모카.jpg");
            img[3] = new ImageIcon("image/카페모카.jpg");
            img[4] = new ImageIcon("image/카페모카.jpg");
            img[5] = new ImageIcon("image/카페모카.jpg");
            img[6] = new ImageIcon("image/카페모카.jpg");
            img[7] = new ImageIcon("image/카페모카.jpg");
            img[8] = new ImageIcon("image/카페모카.jpg");
            img[9] = new ImageIcon("image/카페모카.jpg");
            img[10] = new ImageIcon("image/카페모카.jpg");
            img[11] = new ImageIcon("image/카페모카.jpg");
            img[12] = new ImageIcon("image/카페모카.jpg");
            img[13] = new ImageIcon("image/카페모카.jpg");
            img[14] = new ImageIcon("image/카페모카.jpg");
            
            for (int i = 0; i < img.length; i++) {
               icon[i] = img[i].getImage();
               newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
               newicon[i] = new ImageIcon(newimg[i]);
            }
            for (int i = 0; i < MBtn.length; i++) {
               MBtn[i] = new JButton(menu[i], newicon[i]);
               MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
               MBtn[i].setHorizontalTextPosition(JButton.CENTER);

               MBtn[i].setBorderPainted(true);
               MBtn[i].setContentAreaFilled(false);
               add(MBtn[i]);
               
            }
            
         }
      }



      class StrBtn extends JPanel {
         StrBtn() {
            setBackground(Color.WHITE);
            setLayout(new GridLayout(1, 4, 3, 3));

            for (int i = 0; i < Str.length; i++) {
               SBtn[i] = new JButton(Str[i]);
               SBtn[i].setFont(new Font("굴림체", Font.BOLD, 15));
               add(SBtn[i]);
            }
         }
      }

    
      public Panelcoff() {
         setLayout(null);
         setBackground(new Color(255, 255, 204));
         MenuBtn mbtn = new MenuBtn();
         
         StrBtn sbtn = new StrBtn(); // 버튼배열
         Screen sc = new Screen();

         tq.setSize(455, 50);
         tq.setLocation(580, 433);
         add(tq);
         ts.setSize(455, 50);
         ts.setLocation(580, 483);
         add(ts);

         sc.setSize(600, 600);
         sc.setLocation(510, 1);
         add(sc);
         

         mbtn.setSize(500, 800);
         mbtn.setLocation(5, 5);
         add(mbtn);
         

         
         sbtn.setSize(455, 70); // 결제버튼
         sbtn.setLocation(577, 610);
         add(sbtn);

         for (int i = 0; i < MBtn.length; i++) {
            final int index = i;
            MBtn[i].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  JButton MBtn = (JButton) e.getSource();
                  DefaultTableModel m = (DefaultTableModel) table.getModel();
                  
                  int rowCont = table.getRowCount();
                  //int colCount = table.getColumnCount();
                  //int row = table.getSelectedRow();
                  //int col = table.getSelectedColumn();

                  //Object value = table.getValueAt(row, col);
                  /*
                  if (rowCont == 0)
                     m.addRow(new Object[] { menu[index], count, price[index] });
                  else {
                     for (int i = 0; i < rowCont; i++)
                        if (table.getValueAt(i, 0).equals(e.getSource()))
                           table.setValueAt(table.getValueAt(i,1)+1,i,1);
                         
                  }
                  */      
                  
                   m.addRow(new Object[] { menu[index], count, price[index] });
                  
                  
                   // 클릭할 때 마다 금액 바로 계산되게 하기 
                  //int rowCont = table.getRowCount();

                  int cva = 0;
                  int cvb = 0;
                  int cvc = 0;
                  int cvd = 0;
                  int cve = 0;
                  int cvf = 0;
                  int cvg = 0;
                  int cvh = 0;
                  int cvi = 0;
                  
                  int quantity=1;
                  int sum=0;
                    /*
                  for (int i = 0; i < rowCont; i++) {
                     if (table.getValueAt(i, 0).equals("아메리카노"))
                        cva += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("카페라떼"))
                        cvb += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("카페모카"))
                        cvc += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("카라멜마끼아또"))
                        cvd += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("카푸치노"))
                        cve += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("바닐라카페라떼"))
                        cvf += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("숏카페라떼"))
                        cvg += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("롱블랙"))
                        cvh += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("에스프레소"))
                        cvi += (int) table.getValueAt(i, 1);
                  }
*/
                  for (int i = 0; i < rowCont; i++)
                        quantity += (int) table.getValueAt(i, 1);
                  
                  for (int i = 0; i < rowCont; i++)
                     sum += (int) table.getValueAt(i, 2);

                  tq.setText(String.valueOf(" 총 수량 : " + quantity + " 개 " ));
                  ts.setText(String.valueOf(" 총 금액 : " + sum + " 원 " ));
                  tq.setFont(new Font("굴림체", Font.BOLD, 30));
                  ts.setFont(new Font("굴림체", Font.BOLD, 30));
                  
               }
            });
         }
      
        
         SBtn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton MBtn = (JButton) e.getSource();
               DefaultTableModel m = (DefaultTableModel) table.getModel();

               m.setRowCount(0);
               tq.setText(String.valueOf(" 총 수량 :  0 개 "));
               ts.setText(String.valueOf(" 총 금액 :  0 원 "));
            }
         });
          
         //나중에 창 뜨게 바꿀 것!
         SBtn[1].addActionListener(new ActionListener() { // 결제 버튼
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton MBtn = (JButton) e.getSource();
               int rowCont = table.getRowCount();

               int cva = 0;
               int cvb = 0;
               int cvc = 0;
               int cvd = 0;
               int cve = 0;
               int cvf = 0;
               int cvg = 0;
               int cvh = 0;
               int cvi = 0;
               
               int quantity=0;
               int sum=0;

               for (int i = 0; i < rowCont; i++) {
                  if (table.getValueAt(i, 0).equals("아메리카노"))
                     cva += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("카페라떼"))
                     cvb += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("카페모카"))
                     cvc += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("카라멜마끼아또"))
                     cvd += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("카푸치노"))
                     cve += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("바닐라카페라떼"))
                     cvf += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("숏카페라떼"))
                     cvg += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("롱블랙"))
                     cvh += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("에스프레소"))
                     cvi += (int) table.getValueAt(i, 1);
               }

               for (int i = 0; i < rowCont; i++)
                  sum += (int) table.getValueAt(i, 2);

               ts.setText(String.valueOf(" 총 수량 : " + quantity + " 개 \n" + " 총 금액 : " + sum + " 원 "));
               ts.setFont(new Font("굴림체", Font.BOLD, 40));
            
            }
         });
         
         SBtn[2].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  
                  int result = JOptionPane.showConfirmDialog(null, "처음으로 돌아가시겠습니까?",
                        "알림", JOptionPane.YES_NO_OPTION);
                  if (result==JOptionPane.YES_OPTION) {
                     FirstScreen fs = new FirstScreen();
                     fs.disScreen();
                     setVisible(false); // 창 안보이게 하기 
                     
                  }
    
                  
               }
           });
          
       
         ;
      }

   
}

