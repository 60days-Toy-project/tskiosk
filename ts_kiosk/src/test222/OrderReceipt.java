package test222;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

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
   
   private static String colNames[] = {"��ǰ��", "����", "�ݾ�"}; // ���̺� �÷� ����
   //static DefaultTableModel model = new DefaultTableModel(colNames, 0); // ���̺� ������ �� ��ü ����
   //private JTable table;
   //private JScrollPane scrollPane; // ���̺� ��ũ�ѹ� �ڵ����� �����ǰ� �ϱ�
   public static String[][] oinfo = new String [20][3];

   
   public void pushorderinfo(int onum, String cid, int totalq, int totalp, String status) { //�ֹ���ȣ, �ֹ���id, �Ѽ���, �Ѿ� �޾ƿ���
      onumber = onum;
      cusid = cid;
      tquantity = totalq;
      tprice = totalp;
      ostatus = status;
      if(onumber==1) {
         int j=2; 
         System.out.println("tttttttt" + j);
         }
      if(cusid.equals("set1")) {
         System.out.println("�̰���������������������������");
      }
      if(ostatus=="�ֹ����") {
         int i=1;
         System.out.println("jjjj"+i);
      }
      ostatus = status;
   }
   
   
   public void printReceipt() {
      
      JFrame fr = new JFrame("������");
      
      fr.setSize(800, 1000);
      fr.setLocationRelativeTo(null);
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.getContentPane().setLayout(null);
      fr.setBackground(Color.WHITE);
      
      JLabel lb = new JLabel("������");
      fr.add(lb);
      lb.setBounds(0, 0, 800, 100);
      lb.setBackground(new Color(255, 0, 102));
      lb.setOpaque(true); // Opaque���� true�� �����ؾ� ������ ����ȴ�.
      lb.setHorizontalAlignment(JLabel.CENTER);
      lb.setFont(new Font("SansSerif", Font.BOLD, 30));
      lb.setForeground(Color.WHITE);
      
      JLabel jlonum = new JLabel("�ֹ� ��ȣ : ");
      fr.add(jlonum);
      jlonum.setBounds(40, 120, 100, 100);
      jlonum.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel onum = new JLabel(onumber + "");
      fr.add(onum);
      onum.setBounds(120, 145, 200, 50);
      onum.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel jlcid = new JLabel("�ֹ��� ID : ");
      fr.add(jlcid);
      jlcid.setBounds(40, 160, 150, 100);
      jlcid.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel cid = new JLabel(cusid + "");
      fr.add(cid);
      cid.setBounds(120, 175, 400, 70);
      cid.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel jlline1 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline1);
      jlline1.setBounds(40, 190, 3000, 100);
      jlline1.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltitle = new JLabel("                            ��ǰ��                             |           ����           |               ����           ");
      fr.add(jltitle);
      jltitle.setBounds(40, 210, 3000, 100);
      jltitle.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jlline2 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline2);
      jlline2.setBounds(40, 230, 3000, 100);
      jlline2.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      ///JPanel jpinfo = new JPanel();
      //fr.add(jpinfo);
      ///jpinfo.setBounds(40,300, 700, 430);
/*      
      int m = OrderDB.order_info.length; 
      int n = OrderDB.order_info[0].length; 
      for (int i = 0; i < m; i++)   { 
         for (int j = 0; j < n; j++) { 
            System.out.print("üũ"+OrderDB.order_info[i][j] + "\t"); 
         } 
         System.out.println();
      }

   */
   
      /////��ũ���� ����ħ����
      DefaultTableModel model = new DefaultTableModel(OrderDB.order_info, colNames); // ���̺� ������ �� ��ü ����
       JTable otable = new JTable(model);
       otable.setBounds(40,300,650,430);
       
       DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
       celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // ��� ����
              
       otable.setRowHeight(50);
      otable.setFont(new Font("����ü", Font.BOLD, 15));
       otable.getColumnModel().getColumn(0).setPreferredWidth(330); // JTable �� �÷� ���� ����
       otable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);  // ��� ����
      otable.getColumnModel().getColumn(1).setPreferredWidth(160);
      otable.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
      otable.getColumnModel().getColumn(2).setPreferredWidth(200);
      otable.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
      
      otable.setShowHorizontalLines(false); // ���̺� �� �Ⱥ��̰� �ϱ�
      otable.setShowVerticalLines(false); // ���̺� �� �Ⱥ��̰� �ϱ�
      //otable.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
      JScrollPane scroll = new JScrollPane(otable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      //scroll.getVerticalScrollBar().setUnitIncrement(16);
       
      scroll.setSize(650,430);
      scroll.setLocation(70, 300);
      scroll.setBorder(null);
      
      fr.add(scroll);
      
      ///jpinfo.add(otable);
      ///jpinfo.add(scroll);
      //jpinfo.setBackground(Color.WHITE);
      ////fr.add(jpinfo);
      
      
      ///// ��ǰ��, ����, ���� ���� �г� -> ��ũ�� ���� �� �� 
      /*
      JPanel jpinfo = new JPanel();
      fr.add(jpinfo);
      jpinfo.setBounds(40, 250, 3000, 430);
      
      
      
      JScrollPane scrollSingle = new JScrollPane(jpinfo, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

      fr.add(scrollSingle);
      */
      //////////////////////////////////////////////////////////////
      
      JLabel jlline3 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline3);
      jlline3.setBounds(40, 700, 3000, 100);
      jlline3.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalq = new JLabel("�� ���� : ");
      fr.add(jltotalq);
      jltotalq.setBounds(500, 740, 150, 100);
      jltotalq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tq = new JLabel(tquantity + "��");
      fr.add(tq);
      tq.setBounds(600, 755, 400, 70);
      tq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalp = new JLabel("�Ѿ� : ");
      fr.add(jltotalp);
      jltotalp.setBounds(500, 770, 150, 100);
      jltotalp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tp = new JLabel(tprice + "��");
      fr.add(tp);
      tp.setBounds(600, 785, 400, 70);
      tp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      
      JLabel jlline4 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline4);
      jlline4.setBounds(40, 800, 3000, 100);
      jlline4.setFont(new Font("SansSerif", Font.BOLD, 18));
      
   /*
      JButton recbtn = new JButton("�ֹ�����"); //�ֹ����� ��ư -> �ֹ���� ���¿��� �ֹ������� �ٲ�
      fr.add(recbtn);
      recbtn.setBounds(400, 870, 150, 50);
      recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
      JButton complbtn = new JButton("�ֹ��Ϸ�");
      fr.add(complbtn);
      complbtn.setBounds(400, 870, 150, 50);
      recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
   */
      JButton recbtn = new JButton("�ֹ�����");
      JButton complbtn = new JButton("�ֹ��Ϸ�");
      
      if (ostatus.equals("�ֹ����")) {
         //JButton recbtn = new JButton("�ֹ�����"); //�ֹ����� ��ư -> �ֹ���� ���¿��� �ֹ������� �ٲ�
         fr.add(recbtn);
         recbtn.setBounds(400, 870, 150, 50);
         recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
         
         OrderDB odb = new OrderDB();
         odb.changeStatus(onumber);
         System.out.println("����Ȱ̤���---");
         //JOptionPane.showMessageDialog(null, "�ֹ��� �����Ǿ����ϴ�.");
      }
      else if (ostatus.equals("�ֹ�����")) {
         //JButton complbtn = new JButton("�ֹ��Ϸ�");
         fr.add(complbtn);
         complbtn.setBounds(400, 870, 150, 50);
         complbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
         
      }
      else if (ostatus.equals("�ֹ��Ϸ�")) {
         //JOptionPane.showMessageDialog(null, "�̹� �Ϸ�� �ֹ��Դϴ�.");
      }
      
      JButton closebtn = new JButton("�ݱ�"); //�ֹ����� ��ư
      fr.add(closebtn);
      closebtn.setBounds(580, 870, 150,50);
      closebtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
      
      recbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.changeStatus(onumber);
            JOptionPane.showMessageDialog(null, "�ֹ��� �����Ǿ����ϴ�.");
/*
            if (ostatus.equals("�ֹ����")) {
               OrderDB odb = new OrderDB();
               odb.changeStatus(onumber);
               System.out.println("����Ȱ̤���---");
               JOptionPane.showMessageDialog(null, "�ֹ��� �����Ǿ����ϴ�.");
            }
            else if (ostatus.equals("�ֹ�����")) {
               JOptionPane.showMessageDialog(null, "�̹� ������ �ֹ��Դϴ�.");
            }
            else if (ostatus.equals("�ֹ��Ϸ�")) {
               JOptionPane.showMessageDialog(null, "�̹� �Ϸ�� �ֹ��Դϴ�.");
            }
   */      
         }
      });
      
      complbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.completeStatus(onumber);
            JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ�.");
   
         }
      });
      
      closebtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            fr.setVisible(false); // â �Ⱥ��̰� �ϱ�
         }
      });
      
      // �������� ���̵��� ����
        fr.setVisible(true);


      
   }

}