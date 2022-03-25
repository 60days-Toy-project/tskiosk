package test222;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
public class Admin_order {
	
	public void orderScreen() {
		
		JFrame fr = new JFrame("�ֹ� ����");
		
		fr.setSize(800, 900);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane().setLayout(null);

		JLabel lb = new JLabel("�ֹ� ����");
		fr.add(lb);
		lb.setBounds(0, 0, 800, 100);
		lb.setBackground(new Color(255, 0, 102));
		lb.setOpaque(true); // Opaque���� true�� �����ؾ� ������ ����ȴ�.
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setFont(new Font("SansSerif", Font.BOLD, 30));
		lb.setForeground(Color.WHITE);
	}	

}
*/


import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin_order extends JPanel {

	// DB���� ���� ȭ������ ���̺� �� ��������(select) , �����ϱ�(insert), �����ϱ�(update), �����ϱ�(delete)
	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null; // ���̺� ���� �߰� ��ư
	private JButton jBtnSaveRow = null; // ���̺� ���� ���� ��ư
	private JButton jBtnEditRow = null; // ���̺� ���� ���� ��ư
	private JButton jBtnDelRow = null; // ���̺� ���� ���� ��ư
	private JTable table;
	private JScrollPane scrollPane; // ���̺� ��ũ�ѹ� �ڵ����� �����ǰ� �ϱ�
	

	private static String colNames[] = { "��ȣ", "�ֹ���ID", "�޴�", "�Ѽ���", "�ѱݾ�","�ֹ��ð�","�ֹ�����" }; // ���̺� �÷� ����
	static DefaultTableModel model = new DefaultTableModel(colNames, 0); // ���̺� ������ �� ��ü ����


	public Admin_order() {
		setLayout(null); // ���̾ƿ� ��ġ������ ����
		
		JLabel lb = new JLabel("�ſ�ī�� ����");
		//panel.add(lb);
		lb.setBounds(0, 0, 800, 100);
		lb.setBackground(new Color(255, 0, 102));
		lb.setOpaque(true); // Opaque���� true�� �����ؾ� ������ ����ȴ�.
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setFont(new Font("SansSerif", Font.BOLD, 30));
		lb.setForeground(Color.WHITE);
		
		
		table = new JTable(model); // ���̺� �𵨰�ü ����
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("����ü", Font.BOLD, 15));
        table.getColumnModel().getColumn(0).setPreferredWidth(180);  //JTable �� �÷� ���� ����
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(2).setPreferredWidth(280);
        table.getColumnModel().getColumn(3).setPreferredWidth(280);
        table.getColumnModel().getColumn(4).setPreferredWidth(280);
        table.getColumnModel().getColumn(5).setPreferredWidth(280);
        table.getColumnModel().getColumn(6).setPreferredWidth(280);
        
        
		table.addMouseListener((MouseListener) new JTableMouseListener()); // ���̺� ���콺������ ����
		scrollPane = new JScrollPane(table); // ���̺� ��ũ�� ����� �ϱ�
		scrollPane.setSize(700, 250);
		scrollPane.setLocation(10, 10);
	
		add(scrollPane);
		initialize();
		select();

	}

	private class JTableMouseListener implements MouseListener { // ���콺�� ��������Ȯ���ϱ�
		public void mouseClicked(java.awt.event.MouseEvent e) { // ���õ� ��ġ�� ���� ���

			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow(); // ���õ� ���̺��� �ప
			int col = jtable.getSelectedColumn(); // ���õ� ���̺��� ����

			System.out.println(model.getValueAt(row, col)); // ���õ� ��ġ�� ���� ���� ���
			
			if(e.getClickCount() == 2) { // ���� ���� Ŭ������ �� ������ �������� ����
				
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

		// ���̺� ���� ���� �߰��ϴ� �κ�
		jBtnAddRow = new JButton();
		jBtnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				model2.addRow(new String[] { "", "", "", "", "" ,"",""}); // �����̺��� �ʱⰪ
			}
		});
		jBtnAddRow.setBounds(30, 270, 120, 25);
		jBtnAddRow.setText("�߰�");
		add(jBtnAddRow);

		// ���̺� ���� �����ϴ� �κ�
		jBtnSaveRow = new JButton();
		jBtnSaveRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				Order odto = new Order();
				
				odto.setOrderNum( (int)model2.getValueAt(row, 0));
				odto.setCustomerId( (String)model2.getValueAt(row, 1));
				odto.setProductName( (String)model2.getValueAt(row, 2));
				odto.setTotalQuantity( (int)model2.getValueAt(row, 3));
				odto.setTotalPrice( (int)model2.getValueAt(row, 4));
				//odto.setTime((String)model2.getValueAt(row, 5).toString());
				odto.setStatus( (int)model2.getValueAt(row, 6));
				
				OrderDB odb = OrderDB.getInstance();
				int result = odb.insertMember(odto);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");

				}
				model2.setRowCount(0); // ��ü ���̺� ȭ���� ������
				select(); // ���� �� �ٽ� ��ü ������ �޾ƿ�.
			}
		});
		
		
		jBtnSaveRow.setBounds(182, 270, 120, 25);
		jBtnSaveRow.setText("����");
		add(jBtnSaveRow);


		// ���õ� ���̺� ���� �����ϴ� �κ�
		jBtnDelRow = new JButton();
		jBtnDelRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // ���õ� ��ư�� �ؽ�Ʈ�� ���
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // ������ �ȵ� ���¸� -1����
				/*
				String query = "delete from user_info where id= ?";

				try {
					Class.forName(driver); // ����̹� �ε�
					con = DriverManager.getConnection(url, "aaaa", "aaaa"); // DB ����
					pstmt = con.prepareStatement(query);

					// ����ǥ�� 1�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
					pstmt.setString(1, (String) model2.getValueAt(row, 0));
					int cnt = pstmt.executeUpdate();
					// pstmt.executeUpdate(); create insert update delete
					// pstmt.executeQuery(); select
				} catch (Exception eeee) {
					System.out.println(eeee.getMessage());
				} finally {
					try {
						pstmt.close();
						con.close();
					} catch (Exception e2) {
					}
				}
				model2.removeRow(row); // ���̺� ���� ���� ����*/
			}
		});
		jBtnDelRow.setBounds(new Rectangle(320, 270, 120, 25));
		jBtnDelRow.setText("����");
		add(jBtnDelRow);
	}

	public static void main(String[] args) {

		Admin_order panel = new Admin_order();
	
		JFrame win = new JFrame();

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		win.add(panel);
		win.setSize(800, 900);
		win.setVisible(true);
	}
}

