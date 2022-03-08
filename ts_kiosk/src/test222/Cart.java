package test222;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Cart extends JPanel {

	public String Result;
	
	public static int Cost_sum; //총 가격
	public static int Qty_sum; // 총 수량

	String[] ColName = { "메뉴", "수량", "가격", "추가", "감소", "삭제" };

	String[][] Data;
	int count = 1;

	private JTable table;
	public static DefaultTableModel model;

	static JTextField tqty = new JTextField(27); // 총 수량
	static JTextField tprc = new JTextField(27); // 총 가격

	JButton AlldelBtn = new JButton("전체 삭제"); // 전체 삭제
	JButton HomeBtn = new JButton("처음으로"); // 처음으로
	JButton PayBtn = new JButton("결제하기"); // 결제 하기
	JPanel Btn = new JPanel();

	public Cart() {

		model = new DefaultTableModel(Data, ColName);
		table = new JTable(model);

		setBackground(new Color(255, 255, 204));
		// DefaultTableModel m = (DefaultTableModel) table.getModel();
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

		tqty.setSize(455, 50);
		tqty.setText(String.valueOf(" 총 수량 : "));
		tqty.setFont(new Font("굴림체", Font.BOLD, 30));

		tprc.setSize(455, 50);
		tprc.setText(String.valueOf(" 총 금액 : "));
		tprc.setFont(new Font("굴림체", Font.BOLD, 30));

		add(tqty);
		add(tprc);

		AlldelBtn.setPreferredSize(new Dimension(145, 50));
		AlldelBtn.setFont(new Font("굴림체", Font.BOLD, 20));
		AlldelBtn.setForeground(Color.WHITE);
		AlldelBtn.setBackground(Color.GRAY);
		AlldelBtn.addActionListener(new AlldelBtnActionListener());

		
		PayBtn.setPreferredSize(new Dimension(145, 50));
		PayBtn.setFont(new Font("굴림체", Font.BOLD, 20));
		PayBtn.setForeground(Color.WHITE);
		PayBtn.setBackground(new Color(255, 0, 102));
		PayBtn.addActionListener(new PayBtnActionListener());

		HomeBtn.setPreferredSize(new Dimension(145, 50));
		HomeBtn.setFont(new Font("굴림체", Font.BOLD, 20));
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
	class PayBtnActionListener implements ActionListener{ //결제하기 버튼
		public void actionPerformed(ActionEvent e) {
			JButton MBtn = (JButton) e.getSource();

			payScreen ps = new payScreen();
			ps.disPayScreen(Cost_sum);
		}
	}
	class HomeBtnActionListener implements ActionListener{ // 처음화면
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "처음으로 돌아가시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				FirstScreen fs = new FirstScreen();
				fs.disScreen();

			}
		}
	}
	class AlldelBtnActionListener implements ActionListener{ //모두 삭제
		public void actionPerformed(ActionEvent e) {
			model.setRowCount(0);
			Qty_sum=0;
			Cost_sum=0;
			
			SetIndex();
		}
	}
	public static void SetIndex() { //수량 금액 텍스트 세팅
		
		tqty.setText(String.valueOf(" 총 수량 : " + Qty_sum + " 개 " ));
		tqty.setFont(new Font("굴림체", Font.BOLD, 30));
		
		tprc.setText(String.valueOf(" 총 금액 : " + Cost_sum + " 원 "));
		tprc.setFont(new Font("굴림체", Font.BOLD, 30));
	}

	// 포스기 수량 추가 버튼
	class Plus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton plus;

		public Plus() {

			plus = new JButton("+");
			plus.addActionListener(e -> {

				int n = table.getSelectedRow();
				//int q = (int) table.getValueAt(n, 1) +1 ; => String -> int 형변환 에러때문에 사용 X
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

	// 포스기 수량 감소 버튼
	class Minus extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton minus;

		public Minus() {

			minus = new JButton("-");
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
				
				Qty_sum = Qty_sum-1; //전체 수량에서 -1
				Cost_sum = Cost_sum - sp; //전체 가격에서 항목 가격만큼 빼기 
				
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

	// 포스기 부분 삭제 버튼
	class Del extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public Del() {

			jb = new JButton("삭제");
			jb.addActionListener(e -> {
				/// JTableRemoveRow();
				// DefaultTableModel m = (DefaultTableModel) table.getModel();
				int n = table.getSelectedRow();
				int q = Integer.parseInt(String.valueOf(table.getValueAt(n, 1))); // 수량
				int sp = Integer.parseInt(String.valueOf(table.getValueAt(n, 2)));  //가격
				
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
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return jb;
		}
	}

}
