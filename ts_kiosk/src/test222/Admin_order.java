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

      this.setTitle("�ֹ�����");
      this.setSize(960, 800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   public JPanel OmakePanel() {// ������ �ɰ������� ���ø��� ���� �������� ���߿� �õ�
      JPanel pn = new JPanel();
      pn.setLayout(null);

      tablePan.setSize(1200, 800);
      tablePan.setLocation(1, 1);
      pn.add(tablePan);

      return pn;

   }

}

class OTablepane extends JPanel { // ��ٱ��� ���� �г�
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
   // DB���� ���� ȭ������ ���̺� �� ��������(select) , �����ϱ�(insert), �����ϱ�(update), �����ϱ�(delete)

   
   public static int ordernum;
   
   private JFrame f1;
   JPanel jp1 = new JPanel();

   private static final long serialVersionUID = 1L;
   
   private JButton jbtnAllRow = null; //�� ��ü����
   private JButton jbtnComplete = new JButton("�ֹ��Ϸ�"); // �ֹ��Ϸ� ��ư
   private JTable table;
   private JScrollPane scrollPane; // ���̺� ��ũ�ѹ� �ڵ����� �����ǰ� �ϱ�

   
   private JComboBox<String> cbbsearch;
   private static String comboNames[] = { "�ֹ��� ID", "�ֹ�����"};
   private JTextField search = new JTextField(13);
   private JButton jBtnSearch = new JButton("�˻�");
   private String Content; // �˻� ī�װ� id cname gender ���� ��Ʈ��
   
   private JLabel backimgLabel = new JLabel();// ��ǰ ����
   private ImageIcon bicon;

   private static String colNames[] = {"��ȣ", "�ֹ���ID", "�޴�", "�Ѽ���", "�ѱݾ�","�ֹ��ð�","�ֹ�����"}; // ���̺� �÷� ����
   static DefaultTableModel model = new DefaultTableModel(colNames, 0); // ���̺� ������ �� ��ü ����

   public ordermakeTable(JFrame f1) {

      this.f1 = f1;
      setLayout(null); // ���̾ƿ� ��ġ������ ����
      
      jp1.setLayout(null);
      jp1.setLocation(1,1);
      jp1.setSize(960,800);
      
      bicon = new ImageIcon("image/icon/backspace.png");
      backimgLabel.setIcon(bicon);
      backimgLabel.setBounds(5, 5, 45, 45);
      jp1.add(backimgLabel);
      backimgLabel.addMouseListener((MouseListener) new BackSpace()); // ���̺� ���콺������ ����
      
      JLabel optionOrder = new JLabel("�ֹ� ��ȸ");

      optionOrder.setBounds(0, 0, 960, 60);
      optionOrder.setForeground(new Color(255, 255, 255));
      optionOrder.setBackground(new Color(255, 0, 102));
      optionOrder.setOpaque(true);
      optionOrder.setHorizontalAlignment(JLabel.CENTER);
      optionOrder.setFont(new Font("���ʷչ���", Font.BOLD, 30));
      jp1.add(optionOrder);// ������Ʈ �����̳ʿ� �ø�
      
            
      JPanel searchpan = new JPanel(); //�˻� �г�
      searchpan.setLocation(130, 100);
      searchpan.setSize(350, 60);
      JPanel ssspan = new JPanel();//�˻� ������Ʈ ���� �г�
      ssspan.setLayout(new FlowLayout(FlowLayout.LEFT));
      
      jBtnSearch.setBorderPainted(false);
      jBtnSearch.setBackground(new Color(255, 0, 102));
      jBtnSearch.setForeground(Color.WHITE);
      jBtnSearch.setFont(new Font("SansSerif", Font.BOLD, 16));
   

      cbbsearch = new JComboBox(comboNames); //�޺��ڽ�
      cbbsearch.setBackground(Color.WHITE);
      ssspan.add(cbbsearch);//�޺��ڽ�
      ssspan.add(search); //�ؽ�Ʈ�ʵ�
      ssspan.add(jBtnSearch);//�˻� ��ư
      searchpan.add(ssspan);
      searchpan.setBackground(Color.WHITE);
      ssspan.setBackground(Color.WHITE);
      
      

      jBtnSearch.addActionListener(new ActionListener() { //�˻� ��ư ������ �� //////������ ���µ� �˻��ȵȴ� �쾯
         public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
            DefaultTableModel model2 = (DefaultTableModel) table.getModel();

            if (cbbsearch.getSelectedItem().toString().equals("�ֹ��� ID")) {
               Content = "cId";
               
            } else if (cbbsearch.getSelectedItem().toString().equals("�ֹ�����")) {
               Content = "status";
               
            }
            
            model2.setRowCount(0); // ��ü ���̺� ȭ���� ������
            
            System.out.println("�̰Ŵ�" + Content);
            System.out.println((String)search.getText());
            OrderDB odb = OrderDB.getInstance();
            int result = odb.searchorder(Content,(String)search.getText()) ;
            if (result == -1) { //�˻� ��� ���� �� 
               JOptionPane.showMessageDialog(null, "�ش系���� �����ϴ�");

            }            
         }
      });

   

      table = new JTable(model); // ���̺� �𵨰�ü ����
      table.setRowHeight(50);
      table.getTableHeader().setFont(new Font("����ü", Font.BOLD, 15));
      table.getColumnModel().getColumn(0).setPreferredWidth(180); // JTable �� �÷� ���� ����
      table.getColumnModel().getColumn(1).setPreferredWidth(280);
      table.getColumnModel().getColumn(2).setPreferredWidth(280);
      table.getColumnModel().getColumn(3).setPreferredWidth(280);
      table.getColumnModel().getColumn(4).setPreferredWidth(280);
      table.getColumnModel().getColumn(5).setPreferredWidth(370);
      table.getColumnModel().getColumn(6).setPreferredWidth(280);

      table.addMouseListener((MouseListener) new JTableMouseListener()); // ���̺� ���콺������ ����

      scrollPane = new JScrollPane(table); // ���̺� ��ũ�� ����� �ϱ�
      scrollPane.setSize(800, 450);
      scrollPane.setLocation(70, 180);
      
      /*
      jbtnComplete.addActionListener(new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent e) {
            JTable jtable = (JTable) e.getSource();
            int row = jtable.getSelectedRow(); // ���õ� ���̺��� �ప
            String status = (String) model.getValueAt(row, 6);
            if (status.equals("�ֹ����")) {
               JOptionPane.showMessageDialog(null, "�ֹ��� ���� �������� �ʾҽ��ϴ�.");
            }
            else if (status.equals("�ֹ�����")) {
               int onumber = (int)model.getValueAt(row, 0);
               OrderDB odb = new OrderDB();
               odb.completeStatus(onumber);
               JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ�.");
            }
            else if (status.equals("�ֹ��Ϸ�")) {
               JOptionPane.showMessageDialog(null, "�̹� �Ϸ�� �ֹ��Դϴ�.");
            }
         }
      });
      */
      
      
      //jbtnComplete.setSize(200,40);
      //jbtnComplete.setLocation(670,680);

      jp1.add(searchpan);
      //jp1.add(jbtnComplete);
      jp1.add(scrollPane);
      jp1.setBackground(Color.WHITE);
      add(jp1);
      initialize();
      select();

   }

   private class JTableMouseListener implements MouseListener { // ���콺�� ��������Ȯ���ϱ�
      public void mouseClicked(java.awt.event.MouseEvent e) { // ���õ� ��ġ�� ���� ���

         JTable jtable = (JTable) e.getSource();
         int row = jtable.getSelectedRow(); // ���õ� ���̺��� �ప
         int col = jtable.getSelectedColumn(); // ���õ� ���̺��� ����

         ordernum = (int) model.getValueAt(row, 0);
          String cid = (String) model.getValueAt(row, 1);
          int totalq = (int) model.getValueAt(row, 3);
          int totalp = (int) model.getValueAt(row, 4);
          String status = (String) model.getValueAt(row, 6);
          System.out.println("���´¿�" + status);
         System.out.println(ordernum);
         if(e.getClickCount() == 1) { // ���� ���� Ŭ������ �� ������ �������� ����
            System.out.println("����Ŭ��");
            OrderReceipt orc = new OrderReceipt();
            orc.pushorderinfo(ordernum, cid, totalq, totalp, status);
            System.out.println("���´� " +status);
            
            
                     
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
   private class BackSpace implements MouseListener { //�ڷΰ��� Ŭ�� �̺�Ʈ
      public void mouseClicked(java.awt.event.MouseEvent e) { 
         
         int result = JOptionPane.showConfirmDialog(null,"�ڷ� ���ðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
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
   private void select() { // ���̺� ���̱� ���� �˻�

      OrderDB odb = OrderDB.getInstance();
       odb.selectmeber();

   }

   private void initialize() { // �׼��̺�Ʈ�� ��ư ������Ʈ ����
      
      
      jbtnAllRow = new JButton();
      jbtnAllRow.addActionListener(new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent e) {
            System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
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
      jbtnAllRow.setText("���ΰ�ħ");
      jp1.add(jbtnAllRow);
      
   }
   
   

}