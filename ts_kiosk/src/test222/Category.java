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
      
            
      //�� �����
      JTabbedPane pane = new JTabbedPane();
      JTabbedPane pane2 = new JTabbedPane();
      JTabbedPane pane3 = new JTabbedPane();
      JTabbedPane pane4 = new JTabbedPane();
      JTabbedPane pane5 = new JTabbedPane();
      JTabbedPane pane6 = new JTabbedPane();
      JTabbedPane pane7 = new JTabbedPane();
      JTabbedPane pane8 = new JTabbedPane();
      
      JPanel jp1 = new JPanel();
      jp1.setLayout(null); //��ġ������ ���� ���� -> ���� ��ġ ����ϱ� ���ؼ�!!!            
      jp1.setBackground(Color.GRAY);
       
      pane.addTab("Ŀ��&����", pane2);
      pane2.add("���������� ���������̼�", new Panelcoff());
      pane2.addTab("Ƽ �������̼�", new Panelcoff());
      pane2.addTab("����", new JLabel("����"));
                 
            
      pane.addTab("���̽�ũ��&����", pane3);
      pane3.addTab("���̽�ũ��", new JLabel("����"));
      pane3.addTab("����", new JLabel("����"));
   
      pane.addTab("����ũ", pane4);
      pane4.addTab("Ȧ����ũ", new JLabel("����"));
      pane4.addTab("��Ʈ����ũ", new JLabel("����"));
      pane4.addTab("����Ʈ", new JLabel("����"));
      
      pane.addTab("����", pane5);
      pane5.addTab("������ġ", new JLabel("����"));
      pane5.addTab("������", new JLabel("����"));
      pane5.addTab("��Ÿ", new JLabel("����"));
      
      pane.addTab("��", pane6);
      pane6.addTab("��", new JLabel("����"));
      pane6.addTab("����ڷ�", new JLabel("����"));
      
      pane.addTab("��ǰ", pane7);
      pane7.addTab("���ݸ�", new JLabel("����"));
      pane7.addTab("����", new JLabel("����"));
      pane7.addTab("��ǰ��Ʈ", new JLabel("����"));
      
      pane.addTab("MD", pane7);
      pane8.addTab("����", new JLabel("����"));
      pane8.addTab("����, Ƽ ������ǰ", new JLabel("����"));
      pane8.addTab("���MD", new JLabel("����"));
      pane8.addTab("����MD", new JLabel("����"));
      pane8.addTab("MD������Ʈ", new JLabel("����"));
      
      
      //pane.addTab("Ŀ��&����", new JLabel("Tab menu 1"));
      //pane.addTab("���̽�ũ��&����", new JLabel("Tab menu 2"));
      //pane.addTab("����ũ", new JLabel("Tab menu 3"));
      //pane.addTab("����", new JLabel("Tab menu 4"));
      //pane.addTab("��ǰ", new JLabel("Tab menu 5"));
       /*
       ret_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               int result = JOptionPane.showConfirmDialog(null, "ó������ ���ư��ðڽ��ϱ�?",
                     "�˸�", JOptionPane.YES_NO_OPTION);
               if (result==JOptionPane.YES_OPTION) {
                  FirstScreen fs = new FirstScreen();
                  fs.disScreen();
                    setVisible(false); // â �Ⱥ��̰� �ϱ� 
                  
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
      String[] menu = { "�Ƹ޸�ī��", "ī���", "ī���ī", "ī��Ḷ���ƶ�", "īǪġ��", 
               "�ٴҶ�ī���", "��ī���", "�պ�", "����������", "���дϽ�����ī���",
               "���̽�ũ��ī���", "�ް�ī���", "�ݵ���", "�ݵ����", "������ī���"};
      int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000,
                    6500, 7000, 5500, 6000, 6500, 5500};
      
      JTextField tq = new JTextField(30);
      JTextField ts = new JTextField(40);

      

      JTextField t = new JTextField(10);

      JButton[] SBtn = new JButton[3];
      String[] Str = { "��ü����", "�����ϱ�", "ó������" };

      String[] ColName = { "�޴�", "����", "����", "�߰�", "����", "����" };

      String[][] Data;
      int count = 1;
      DefaultTableModel model = new DefaultTableModel(Data, ColName);
      JTable table = new JTable(model);

      Image[] icon = new Image[15];
      Image[] newimg = new Image[15];
      ImageIcon[] newicon = new ImageIcon[15];

      // ����
      class Screen extends JPanel {
         Screen() {
           
           
            setBackground(new Color(255, 255, 204));
            DefaultTableModel m = (DefaultTableModel) table.getModel();
            table.setRowHeight(40);
            table.getTableHeader().setFont(new Font("����ü", Font.BOLD, 15));
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
      
      //������ ���� �߰� ��ư
      class Plus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
          JButton plus;
           
          public Plus() {
             
              plus = new JButton("+");
              plus.addActionListener(e -> {
                 DefaultTableModel m = (DefaultTableModel) table.getModel();
                 int n = table.getSelectedRow();
                 //int q = (int) table.getValueAt(n, 1) +1 ; => String -> int ����ȯ ���������� ��� X
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
      
      
      //������ ���� ���� ��ư
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
      
      
      //������ �κ� ���� ��ư
      class Del extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
           JButton jb;
            
           public Del() {
              
               jb = new JButton("����");
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
            img[0] = new ImageIcon("image/ī���ī.jpg");
            img[1] = new ImageIcon("image/ī���ī.jpg");                                                                                 
            img[2] = new ImageIcon("image/ī���ī.jpg");
            img[3] = new ImageIcon("image/ī���ī.jpg");
            img[4] = new ImageIcon("image/ī���ī.jpg");
            img[5] = new ImageIcon("image/ī���ī.jpg");
            img[6] = new ImageIcon("image/ī���ī.jpg");
            img[7] = new ImageIcon("image/ī���ī.jpg");
            img[8] = new ImageIcon("image/ī���ī.jpg");
            img[9] = new ImageIcon("image/ī���ī.jpg");
            img[10] = new ImageIcon("image/ī���ī.jpg");
            img[11] = new ImageIcon("image/ī���ī.jpg");
            img[12] = new ImageIcon("image/ī���ī.jpg");
            img[13] = new ImageIcon("image/ī���ī.jpg");
            img[14] = new ImageIcon("image/ī���ī.jpg");
            
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
               SBtn[i].setFont(new Font("����ü", Font.BOLD, 15));
               add(SBtn[i]);
            }
         }
      }

    
      public Panelcoff() {
         setLayout(null);
         setBackground(new Color(255, 255, 204));
         MenuBtn mbtn = new MenuBtn();
         
         StrBtn sbtn = new StrBtn(); // ��ư�迭
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
         

         
         sbtn.setSize(455, 70); // ������ư
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
                  
                  
                   // Ŭ���� �� ���� �ݾ� �ٷ� ���ǰ� �ϱ� 
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
                     if (table.getValueAt(i, 0).equals("�Ƹ޸�ī��"))
                        cva += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("ī���"))
                        cvb += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("ī���ī"))
                        cvc += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("ī��Ḷ���ƶ�"))
                        cvd += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("īǪġ��"))
                        cve += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("�ٴҶ�ī���"))
                        cvf += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("��ī���"))
                        cvg += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("�պ�"))
                        cvh += (int) table.getValueAt(i, 1);
                     else if (table.getValueAt(i, 0).equals("����������"))
                        cvi += (int) table.getValueAt(i, 1);
                  }
*/
                  for (int i = 0; i < rowCont; i++)
                        quantity += (int) table.getValueAt(i, 1);
                  
                  for (int i = 0; i < rowCont; i++)
                     sum += (int) table.getValueAt(i, 2);

                  tq.setText(String.valueOf(" �� ���� : " + quantity + " �� " ));
                  ts.setText(String.valueOf(" �� �ݾ� : " + sum + " �� " ));
                  tq.setFont(new Font("����ü", Font.BOLD, 30));
                  ts.setFont(new Font("����ü", Font.BOLD, 30));
                  
               }
            });
         }
      
        
         SBtn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton MBtn = (JButton) e.getSource();
               DefaultTableModel m = (DefaultTableModel) table.getModel();

               m.setRowCount(0);
               tq.setText(String.valueOf(" �� ���� :  0 �� "));
               ts.setText(String.valueOf(" �� �ݾ� :  0 �� "));
            }
         });
          
         //���߿� â �߰� �ٲ� ��!
         SBtn[1].addActionListener(new ActionListener() { // ���� ��ư
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
                  if (table.getValueAt(i, 0).equals("�Ƹ޸�ī��"))
                     cva += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("ī���"))
                     cvb += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("ī���ī"))
                     cvc += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("ī��Ḷ���ƶ�"))
                     cvd += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("īǪġ��"))
                     cve += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("�ٴҶ�ī���"))
                     cvf += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("��ī���"))
                     cvg += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("�պ�"))
                     cvh += (int) table.getValueAt(i, 1);
                  else if (table.getValueAt(i, 0).equals("����������"))
                     cvi += (int) table.getValueAt(i, 1);
               }

               for (int i = 0; i < rowCont; i++)
                  sum += (int) table.getValueAt(i, 2);

               ts.setText(String.valueOf(" �� ���� : " + quantity + " �� \n" + " �� �ݾ� : " + sum + " �� "));
               ts.setFont(new Font("����ü", Font.BOLD, 40));
            
            }
         });
         
         SBtn[2].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  
                  int result = JOptionPane.showConfirmDialog(null, "ó������ ���ư��ðڽ��ϱ�?",
                        "�˸�", JOptionPane.YES_NO_OPTION);
                  if (result==JOptionPane.YES_OPTION) {
                     FirstScreen fs = new FirstScreen();
                     fs.disScreen();
                     setVisible(false); // â �Ⱥ��̰� �ϱ� 
                     
                  }
    
                  
               }
           });
          
       
         ;
      }

   
}

