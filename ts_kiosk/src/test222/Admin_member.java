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



public class Admin_member extends JFrame {
	private JPanel tablePan = new Tablepane(this);

	public Admin_member() {
		makeFrame();
		JPanel pn = makePanel();
		this.add(pn);
	}

	void makeFrame() {

		this.setTitle("ȸ������");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JPanel makePanel() {// ������ �ɰ������� ���ø��� ���� �������� ���߿� �õ�
		JPanel pn = new JPanel();
		pn.setLayout(null);

		tablePan.setSize(1200, 800);
		tablePan.setLocation(1, 1);
		pn.add(tablePan);

		return pn;

	}

}

class Tablepane extends JPanel { // ��ٱ��� ���� �г�
	private JFrame f;
	public String Result = "";

	public Tablepane(JFrame f) {
		this.f = f;
		makeTable mtTable = new makeTable(f);
		setLayout(null);
		mtTable.setSize(1200, 800);
		mtTable.setLocation(1, 1);

		add(mtTable);

	}
}

class makeTable extends JPanel {
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

	private JTextField id = new JTextField(13);// ���̵�
	private JTextField pw = new JTextField(13);// ��й�ȣ
	private JTextField name = new JTextField(13);// �̸�
	private JTextField birth = new JTextField(13);// �������
	private JTextField tel = new JTextField(13);// ��ȭ��ȣ
	private JTextField email = new JTextField(13);// �̸���
	private JTextField gender = new JTextField(13);
	
	private JLabel backimgLabel = new JLabel();// ��ǰ ����
	private ImageIcon bicon;
	
	private JComboBox<String> cbbsearch;
	private static String comboNames[] = { "���̵�", "�̸�", "����" };
	private JTextField search = new JTextField(13);
	private JButton jBtnSearch = new JButton("�˻�");
	private String Content; // �˻� ī�װ� id cname gender ���� ��Ʈ��

	private static String colNames[] = { "Id", "Pw", "name", "gender", "birth", "email", "tel" }; // ���̺� �÷� ����
	static DefaultTableModel model = new DefaultTableModel(colNames, 0); // ���̺� ������ �� ��ü ����

	public makeTable(JFrame f1) {

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
		
		
		JLabel optionOrder = new JLabel("ȸ�� ��ȸ");

		optionOrder.setBounds(0, 0, 1200, 60);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("���ʷչ���", Font.BOLD, 30));
		jp1.add(optionOrder);// ������Ʈ �����̳ʿ� �ø�
		
		JPanel infopan = new JPanel();
		infopan.setLayout(new GridLayout(7,2,5,5));
		
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
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				if (cbbsearch.getSelectedItem().toString() == "���̵�") {
					Content = "Id";
					
				} else if (cbbsearch.getSelectedItem().toString() == "�̸�") {
					Content = "Cname";
					
				} else if (cbbsearch.getSelectedItem().toString() == "����") {
					Content = "gender";
					
				}
								
				model2.setRowCount(0); // ��ü ���̺� ȭ���� ������
				
				System.out.println(Content);
				
				DAO dao = DAO.getInstance();
				int result = dao.searchmember(Content,(String)search.getText()) ;
				if (result == -1) { //�˻� ��� ���� �� 
					JOptionPane.showMessageDialog(null, "�ش系���� �����ϴ�");

				}				
			}
		});

		infopan.add(new JLabel("���̵� : "));
		infopan.add(id);
		
		infopan.add(new JLabel("��й�ȣ : "));
		infopan.add(pw);
		
		infopan.add(new JLabel("��  ��  : "));
		infopan.add(name);
		
		infopan.add(new JLabel("�ĳ���� : "));
		infopan.add(birth);
		
		infopan.add(new JLabel("��  ��  : "));
		infopan.add(gender);
		
		infopan.add(new JLabel("��ȭ��ȣ : "));
		infopan.add(tel);
		
		infopan.add(new JLabel("e-mail : "));
		infopan.add(email);

		infopan.setBackground(Color.white);
		infopan.setLocation(30, 75);
		infopan.setSize(350, 450);
		// emailPanel.setBounds(20,650, 150, 60);

		table = new JTable(model); // ���̺� �𵨰�ü ����
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("����ü", Font.BOLD, 15));
		table.getColumnModel().getColumn(0).setPreferredWidth(180); // JTable �� �÷� ���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(280);
		table.getColumnModel().getColumn(3).setPreferredWidth(280);
		table.getColumnModel().getColumn(4).setPreferredWidth(280);
		table.getColumnModel().getColumn(5).setPreferredWidth(280);
		table.getColumnModel().getColumn(6).setPreferredWidth(280);

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
		select();

	}

	private class JTableMouseListener implements MouseListener { // ���콺�� ��������Ȯ���ϱ�
		public void mouseClicked(java.awt.event.MouseEvent e) { // ���õ� ��ġ�� ���� ���

			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow(); // ���õ� ���̺��� �ప
			int col = jtable.getSelectedColumn(); // ���õ� ���̺��� ����

			id.setText((String) model.getValueAt(row, 0));
			pw.setText((String) model.getValueAt(row, 1));
			name.setText((String) model.getValueAt(row, 2));
			gender.setText((String) model.getValueAt(row, 3));
			birth.setText((String) model.getValueAt(row, 4));
			email.setText((String) model.getValueAt(row, 5));
			tel.setText((String) model.getValueAt(row, 6));

			System.out.println(model.getValueAt(row, col)); // ���õ� ��ġ�� ���� ���� ���

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

		DAO mdao = DAO.getInstance();
		mdao.selectmeber();
	}

	private void initialize() { // �׼��̺�Ʈ�� ��ư ������Ʈ ����
		
		
		// ���̺� ���� ���� �߰��ϴ� �κ�
		jBtnAddRow = new JButton();
		jBtnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				model2.addRow(new String[] { "", "", "", "", "", "", "" }); // �����̺��� �ʱⰪ
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
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				DTO mdto = new DTO();

				mdto.setId((String) id.getText());
				mdto.setPassword((String) pw.getText());
				mdto.setName((String) name.getText());
				mdto.setGender((String) gender.getText());
				mdto.setBirth((String) birth.getText());
				mdto.setEmail((String) email.getText());
				mdto.setTel((String) tel.getText());

				DAO dao = DAO.getInstance();
				int result = dao.insertMember(mdto);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model2.setRowCount(0); // ��ü ���̺� ȭ���� ������
				select(); // ���� �� �ٽ� ��ü ������ �޾ƿ�.
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
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����

				DTO mdto = new DTO();

				mdto.setId((String) id.getText());
				mdto.setPassword((String) pw.getText());
				mdto.setName((String) name.getText());
				mdto.setGender((String) gender.getText());
				mdto.setBirth((String) birth.getText());
				mdto.setEmail((String) email.getText());
				mdto.setTel((String) tel.getText());

				DAO dao = DAO.getInstance();
				int result = dao.updateMeber(mdto);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model2.setRowCount(0); // ��ü ���̺� ȭ���� ������
				select(); // ���� �Ĵٽ� ��ü ������ �޾ƿ�.
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
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				String sid = id.getText();
				DAO dao = DAO.getInstance();
				int result = dao.deletemember(sid);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model2.setRowCount(0);
				select();
			}
		});
		jBtnDelRow.setBounds(730, 680, 200, 40);
		jBtnDelRow.setText("����");
		jp1.add(jBtnDelRow);
		
		jbtnAllRow = new JButton();
		jbtnAllRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				model2.setRowCount(0);
				select();
			}
		});
		jbtnAllRow.setBounds(960, 680, 200, 40);
		jbtnAllRow.setText("��ü ����");
		jp1.add(jbtnAllRow);
		
	}

}
