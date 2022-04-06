package test222;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Cart extends JPanel {

	private JFrame mainf; //����������
	
	public String Result;
	
	public static int Cost_sum; //�� ����
	public static int Qty_sum; // �� ����
	
	
	public static String [][] orders = new String [30][3]; // �������� ���� ���� �ѱ�� 
	
	//public static String [] orders = {};
	
	String[] ColName = { "�޴�", "����", "����", "�߰�", "����", "����" };

	String[][] Data;
	int count = 1;

	public static JTable table;
	//private JTable table;
	
	
	
	public static DefaultTableModel model;

	static JTextField tqty = new JTextField(27); // �� ����
	static JTextField tprc = new JTextField(27); // �� ����

	JButton AlldelBtn = new JButton("��ü ����"); // ��ü ����
	JButton HomeBtn = new JButton("ó������"); // ó������
	JButton PayBtn = new JButton("�����ϱ�"); // ���� �ϱ�
	JPanel Btn = new JPanel();

	public Cart(JFrame mainf) {

		this.mainf = mainf;
		
		model = new DefaultTableModel(Data, ColName);
		table = new JTable(model);

		setBackground(new Color(255, 255, 204));
		// DefaultTableModel m = (DefaultTableModel) table.getModel();
		table.setRowHeight(50);
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

		tqty.setSize(455, 50);
		tqty.setText(String.valueOf(" �� ���� : "));
		tqty.setFont(new Font("����ü", Font.BOLD, 30));

		tprc.setSize(455, 50);
		tprc.setText(String.valueOf(" �� �ݾ� : "));
		tprc.setFont(new Font("����ü", Font.BOLD, 30));

		add(tqty);
		add(tprc);

		AlldelBtn.setPreferredSize(new Dimension(145, 50));
		AlldelBtn.setFont(new Font("����ü", Font.BOLD, 20));
		AlldelBtn.setForeground(Color.WHITE);
		AlldelBtn.setBackground(Color.GRAY);
		AlldelBtn.addActionListener(new AlldelBtnActionListener());

		PayBtn.setPreferredSize(new Dimension(145, 50));
		PayBtn.setFont(new Font("����ü", Font.BOLD, 20));
		PayBtn.setForeground(Color.WHITE);
		PayBtn.setBackground(new Color(255, 0, 102));
		PayBtn.addActionListener(new PayBtnActionListener());

		HomeBtn.setPreferredSize(new Dimension(145, 50));
		HomeBtn.setFont(new Font("����ü", Font.BOLD, 20));
		HomeBtn.setForeground(Color.WHITE);
		HomeBtn.setBackground(Color.GRAY);
		HomeBtn.addActionListener(new HomeBtnActionListener());
		
		Btn.setLocation(1, 90);
		Btn.setLayout(new GridLayout(1, 3, 15, 15));
		Btn.add(AlldelBtn);
		Btn.add(PayBtn);
		Btn.add(HomeBtn);
		Btn.setBackground(new Color(255, 255, 204));
		add(Btn);

	}
	class PayBtnActionListener implements ActionListener{ //�����ϱ� ��ư
		public void actionPerformed(ActionEvent e) {
			JButton MBtn = (JButton) e.getSource();

			payScreen ps = new payScreen();
			ps.disPayScreen(mainf,Cost_sum);
			
			int rows = table.getRowCount();
			creditCardScreen cs = new creditCardScreen();
			cs.pushrow(rows);
			
			for (int i=0; i<rows; i++) {
				orders[i][0] = table.getValueAt(i, 0).toString();
				System.out.println(orders[i][0]);
				orders[i][1] = table.getValueAt(i, 1).toString();
				System.out.println(orders[i][1]);
				orders[i][2] = table.getValueAt(i, 2).toString();
				System.out.println(orders[i][2]);
					//System.out.println(table.getValueAt(i, j));
				
				
			}
	
		}
	}
	class HomeBtnActionListener implements ActionListener{ // ó��ȭ��
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "ó������ ���ư��ðڽ��ϱ�?", "�˸�", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				//Btn.setVisible(false);
				FirstScreen fs = new FirstScreen();
				fs.disScreen();
				mainf.setVisible(false);

			}
		}
	}
	class AlldelBtnActionListener implements ActionListener{ //��� ����
		public void actionPerformed(ActionEvent e) {
			model.setRowCount(0);
			Qty_sum=0;
			Cost_sum=0;
			
			SetIndex();
		}
	}
	public static void SetIndex() { //���� �ݾ� �ؽ�Ʈ ����
		
		tqty.setText(String.valueOf(" �� ���� : " + Qty_sum + " �� " ));
		tqty.setFont(new Font("����ü", Font.BOLD, 30));
		creditCardScreen cs = new creditCardScreen();
		cs.pushTotalQ(Qty_sum);
		
		tprc.setText(String.valueOf(" �� �ݾ� : " + Cost_sum + " �� "));
		tprc.setFont(new Font("����ü", Font.BOLD, 30));
		cs.pushTotalP(Cost_sum);
	}

	// ������ ���� �߰� ��ư
	class Plus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton plus;

		public Plus() {

			plus = new JButton("+");
			plus.setBorderPainted(false);
			plus.setBackground(new Color(255, 0, 102));
			plus.setForeground(Color.WHITE);
			plus.setFont(new Font("SansSerif", Font.BOLD, 16));
			
			plus.addActionListener(e -> {

				int n = table.getSelectedRow();
				//int q = (int) table.getValueAt(n, 1) +1 ; => String -> int ����ȯ ���������� ��� X
				int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1))) + 1;
				int sp = Integer.parseInt(String.valueOf(table.getValueAt(n, 2)));
				String qs = String.valueOf(q);
				table.setValueAt(qs, n, 1);
				
				Qty_sum = Qty_sum+1;
				Cost_sum = Cost_sum +sp;
				
				SetIndex();

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

	// ������ ���� ���� ��ư
	class Minus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton minus;

		public Minus() {

			minus = new JButton("-");
			minus.setBorderPainted(false);
			minus.setBackground(new Color(255, 0, 102));
			minus.setForeground(Color.WHITE);
			minus.setFont(new Font("SansSerif", Font.BOLD, 16));
			
			minus.addActionListener(e -> {

				// DefaultTableModel m = (DefaultTableModel) table.getModel();
				int n = table.getSelectedRow();
				int qn = Integer.parseInt(String.valueOf(table.getValueAt(n, 1)));
				int sp = Integer.parseInt(String.valueOf(table.getValueAt(n, 2))); 
				
				if (qn == 1)
					model.removeRow(table.getSelectedRow());
				else {
					int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1))) - 1;
					String qs = String.valueOf(q);
					table.setValueAt(qs, n, 1);
				}
				
				Qty_sum = Qty_sum-1; //��ü �������� -1
				Cost_sum = Cost_sum - sp; //��ü ���ݿ��� �׸� ���ݸ�ŭ ���� 
				
				SetIndex();
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

	// ������ �κ� ���� ��ư
	class Del extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton delete;

		public Del() {

			delete = new JButton("����");
			delete.setBorderPainted(false);
			delete.setBackground(Color.GRAY);
			delete.setForeground(Color.WHITE);
			delete.setFont(new Font("SansSerif", Font.BOLD, 16));
			
			delete.addActionListener(e -> {
				/// JTableRemoveRow();
				// DefaultTableModel m = (DefaultTableModel) table.getModel();
				int n = table.getSelectedRow();
				int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1))); // ����
				int sp = Integer.parseInt(String.valueOf(table.getValueAt(n, 2)));  //����
				
				Qty_sum = Qty_sum-q;
				Cost_sum = Cost_sum - (sp* q);
				
				model.removeRow(table.getSelectedRow());
				SetIndex();
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return delete;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return delete;
		}
	}

}
