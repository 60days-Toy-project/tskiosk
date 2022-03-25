package test222;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Admin_menu extends JFrame {
	
	private JPanel tablePan = new MTablepane(this);

	public Admin_menu() {
		MmakeFrame();
		JPanel pn = MmakePanel();
		this.add(pn);
	}

	void MmakeFrame() {

		this.setTitle("�޴���ȸ");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JPanel MmakePanel() {// ������ �ɰ������� ���ø��� ���� �������� ���߿� �õ�
		JPanel pn = new JPanel();
		pn.setLayout(null);

		tablePan.setSize(1200, 800);
		tablePan.setLocation(1, 1);
		pn.add(tablePan);

		return pn;

	}

}
class MTablepane extends JPanel { // ��ٱ��� ���� �г�
	private JFrame f;
	public String Result = "";

	public MTablepane(JFrame f) {
		this.f = f;
		menumakeTable menumtTable = new menumakeTable(f);
		setLayout(null);
		menumtTable.setSize(1200, 800);
		menumtTable.setLocation(1, 1);

		add(menumtTable);

	}
}
class menumakeTable extends JPanel {
	// DB���� ���� ȭ������ ���̺� �� ��������(select) , �����ϱ�(insert), �����ϱ�(update), �����ϱ�(delete)

	private JFrame f1;
	JPanel jp1 = new JPanel();

	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null; // ���̺� ���� �߰� ��ư
	private JButton jBtnSaveRow = null; // ���̺� ���� ���� ��ư
	private JButton jBtnEditRow = null; // ���̺� ���� ���� ��ư
	private JButton jBtnDelRow = null; // ���̺� ���� ���� ��ư
	private JButton jbtnAllRow = null; //�� ��ü����
	private JTable table;
	private JScrollPane scrollPane; // ���̺� ��ũ�ѹ� �ڵ����� �����ǰ� �ϱ�

	private JTextField category = new JTextField(20);//ī�װ�
	private JTextField sub = new JTextField(20);//�޴� �̸�
	private JTextField subkey = new JTextField(20);//�޴� ��ȣ
	private JTextField qty = new JTextField(20);// ����
	private JTextField price = new JTextField(20);// ����
	private JTextField rdate = new JTextField(20); // ������
	
	private JLabel imgLabel = new JLabel();// ��ǰ ����
	private ImageIcon icon;
	
	private JLabel backimgLabel = new JLabel();// ��ǰ ����
	private ImageIcon bicon;
	
	private JComboBox<String> cbbsearch;
	private static String comboNames[] = {"ī�װ�","�޴��̸�","�޴���ȣ", "����" };
	private JTextField search = new JTextField(13);
	private JButton jBtnSearch = new JButton("�˻�");
	private String Content; // �˻� ī�װ�
	
	
	private static String colNames[] = { "Category","Sub", "Subkey", "Qty", "Price", "Realeasedate" }; // ���̺� �÷� ����
	static DefaultTableModel m = new DefaultTableModel(colNames, 0); // ���̺� ������ �� ��ü ����

	public menumakeTable(JFrame f1)  {

		this.f1 = f1;
		setLayout(null); // ���̾ƿ� ��ġ������ ����
		
		jp1.setLayout(null);
		jp1.setLocation(1,1);
		jp1.setSize(1200,800);
		
		
		bicon = new ImageIcon("image/icon/backspace.png");
		backimgLabel.setIcon(bicon);
		backimgLabel.setBounds(5, 5, 45, 45);
		jp1.add(backimgLabel);
		backimgLabel.addMouseListener((MouseListener) new BackSpace()); // ���̺� ���콺������ ����
		
		
		JLabel optionOrder = new JLabel("�޴� ��ȸ");

		optionOrder.setBounds(0, 0, 1200, 60);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("���ʷչ���", Font.BOLD, 30));
		jp1.add(optionOrder);// ������Ʈ �����̳ʿ� �ø�
		

		
		JPanel infopan = new JPanel();
		infopan.setLayout(new GridLayout(6,2,5,5));
		
		JPanel searchpan = new JPanel(); //�˻� �г�
		searchpan.setLocation(450, 600);
		searchpan.setSize(300, 60);
		JPanel ssspan = new JPanel();//�˻� ������Ʈ ���� �г�
		ssspan.setLayout(new FlowLayout(FlowLayout.LEFT));

		cbbsearch = new JComboBox(comboNames); //�޺��ڽ�
		ssspan.add(cbbsearch);//�޺��ڽ�
		ssspan.add(search); //�ؽ�Ʈ�ʵ�
		ssspan.add(jBtnSearch);//�˻� ��ư
		searchpan.add(ssspan);
		searchpan.setBackground(Color.WHITE);
		ssspan.setBackground(Color.WHITE);

		jBtnSearch.addActionListener(new ActionListener() { //�˻� ��ư ������ ��
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				if (cbbsearch.getSelectedItem().toString() == "ī�װ�") {
					Content = "Category";
					
				} else if (cbbsearch.getSelectedItem().toString() == "�޴��̸�") {
					Content = "Sub";
				
				} else if (cbbsearch.getSelectedItem().toString() == "�޴���ȣ") {
					Content = "Subkey";
					
				} else if (cbbsearch.getSelectedItem().toString() == "����") {
					Content = "Price";
					
				}
								
				model1.setRowCount(0); // ��ü ���̺� ȭ���� ������
				
				System.out.println(Content+"222");
				
				DAO dao = DAO.getInstance();
				int result = dao.searchmenu(Content, (String)search.getText());
				if (result == -1) { //�˻� ��� ���� �� 
					JOptionPane.showMessageDialog(null, "�ش系���� �����ϴ�");

				}	
			}
		});


		// ������ ����
		icon = new ImageIcon("image/coffee500300.jpg");
		imgLabel.setIcon(icon);
		imgLabel.setBounds(30, 75, 200, 200);
		jp1.add(imgLabel);
		
		infopan.add(new JLabel("ī�װ� : "));
		infopan.add(category);
		
		infopan.add(new JLabel("�޴��̸� : "));
		infopan.add(sub);
		
		infopan.add(new JLabel("�޴���ȣ : "));
		infopan.add(subkey);
		
		infopan.add(new JLabel("��  ��  : "));
		infopan.add(qty);
		
		infopan.add(new JLabel("��  ��  : "));
		infopan.add(price);
		
		infopan.add(new JLabel("�� �� �� : "));
		infopan.add(rdate);
		
	

		infopan.setBackground(Color.white);
		infopan.setLocation(30, 300);
		infopan.setSize(350, 300);
		// emailPanel.setBounds(20,650, 150, 60);

		table = new JTable(m); // ���̺� �𵨰�ü ����
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("����ü", Font.BOLD, 15));
		table.getColumnModel().getColumn(0).setPreferredWidth(180); // JTable �� �÷� ���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(280);
		table.getColumnModel().getColumn(3).setPreferredWidth(280);
		table.getColumnModel().getColumn(4).setPreferredWidth(280);
		table.getColumnModel().getColumn(5).setPreferredWidth(280);

		table.addMouseListener((MouseListener) new JTableMouseListener()); // ���̺� ���콺������ ����

		scrollPane = new JScrollPane(table); // ���̺� ��ũ�� ����� �ϱ�
		scrollPane.setSize(700, 450);
		scrollPane.setLocation(450, 75);

		jp1.add(searchpan);
		jp1.add(infopan);
		jp1.add(scrollPane);
		jp1.setBackground(Color.WHITE);
		add(jp1);
		initialize();
		menuselect();

	}

	private class JTableMouseListener implements MouseListener { // ���콺�� ��������Ȯ���ϱ�
		public void mouseClicked(java.awt.event.MouseEvent e) { // ���õ� ��ġ�� ���� ���

			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow(); // ���õ� ���̺��� �ప
			int col = jtable.getSelectedColumn(); // ���õ� ���̺��� ����
			String imgpath;
			
			category.setText((String) m.getValueAt(row,0));
			sub.setText((String) m.getValueAt(row, 1));
			subkey.setText((String) m.getValueAt(row, 2));
			qty.setText((String) m.getValueAt(row, 3));
			price.setText((String) m.getValueAt(row, 4));
			rdate.setText((String) m.getValueAt(row, 5));
			
			imgpath="image/"+(String)m.getValueAt(row, 1)+".jpg";
			icon = new ImageIcon(imgpath);
			
			Image img = icon.getImage();
	        
	        // ����� Image�� ũ�� �����Ͽ� ���ο� Image ��ü ����
	    	Image resizeImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        
	        // ���ο� Image ��ü�� ImageIcon ��ü ����
	        ImageIcon updateIcon = new ImageIcon(resizeImg);
			imgLabel.setIcon(updateIcon);
			
			System.out.println(m.getValueAt(row, col)); // ���õ� ��ġ�� ���� ���� ���

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

	private void menuselect() { // ���̺� ���̱� ���� �˻�

		DAO menudao = DAO.getInstance();
		menudao.selectmenu();
	}


	private void initialize() { // �׼��̺�Ʈ�� ��ư ������Ʈ ����
		
		
		// ���̺� ���� ���� �߰��ϴ� �κ�
		jBtnAddRow = new JButton();
		jBtnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				model1.addRow(new String[] { "", "", "", "", "","" }); // �����̺��� �ʱⰪ
			}
		});

		jBtnAddRow.setBounds(10, 680, 200, 40);
		jBtnAddRow.setText("�߰�");
		jp1.add(jBtnAddRow);

		// ���̺� ���� �����ϴ� �κ�
		jBtnSaveRow = new JButton();
		jBtnSaveRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				Admin_DTO adto = new Admin_DTO();
				
				adto.setCategory((String) category.getText());
				adto.setSubkey((String) subkey.getText());
				adto.setQty((String) qty.getText());
				adto.setPrice((String) price.getText());
				adto.setRdate((String) rdate.getText());
				adto.setSub((String) sub.getText());

				DAO adao = DAO.getInstance();
				int result = adao.insertmenu(adto);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model1.setRowCount(0); // ��ü ���̺� ȭ���� ������
				menuselect(); // ���� �� �ٽ� ��ü ������ �޾ƿ�.
			}
		});

		jBtnSaveRow.setBounds(250, 680, 200, 40);
		jBtnSaveRow.setText("����");
		jp1.add(jBtnSaveRow);

		// ���õ� ���̺� ���� �����ϴ� �κ�
		jBtnEditRow = new JButton();
		jBtnEditRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����

				Admin_DTO adto = new Admin_DTO();
				
				adto.setCategory((String) category.getText());
				adto.setSubkey((String) subkey.getText());
				adto.setQty((String) qty.getText());
				adto.setPrice((String) price.getText());
				adto.setRdate((String) rdate.getText());
				adto.setSub((String) sub.getText());
			

				DAO dao = DAO.getInstance();
				int result = dao.updatemenu(adto);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model1.setRowCount(0); // ��ü ���̺� ȭ���� ������
				menuselect(); // ���� �Ĵٽ� ��ü ������ �޾ƿ�.
			}
		});
		jBtnEditRow.setBounds(490, 680, 200, 40);
		jBtnEditRow.setText("����");
		jp1.add(jBtnEditRow);

		// ���õ� ���̺� ���� �����ϴ� �κ�
		jBtnDelRow = new JButton();
		jBtnDelRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				String ssub = sub.getText();
				DAO dao = DAO.getInstance();
				int result = dao.deletemenu(ssub);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model1.setRowCount(0);
				menuselect();
			}
		});
		jBtnDelRow.setBounds(730, 680, 200, 40);
		jBtnDelRow.setText("����");
		jp1.add(jBtnDelRow);
		
		jbtnAllRow = new JButton();
		jbtnAllRow.addActionListener(new ActionListener() {//��ü���� ��ư
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����

				model1.setRowCount(0);
				menuselect();
			}
		});
		jbtnAllRow.setBounds(960, 680, 200, 40);
		jbtnAllRow.setText("��ü ����");
		jp1.add(jbtnAllRow);
		
	}

}

