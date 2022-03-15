package test222;

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

public class Admin_member extends JPanel {

	// DB에서 스윙 화면으로 테이블 값 가져오기(select) , 저장하기(insert), 수정하기(update), 삭제하기(delete)
	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null; // 테이블 한줄 추가 버튼
	private JButton jBtnSaveRow = null; // 테이블 한줄 저장 버튼
	private JButton jBtnEditRow = null; // 테이블 한줄 저장 버튼
	private JButton jBtnDelRow = null; // 테이블 한줄 삭제 벅튼
	private JTable table;
	private JScrollPane scrollPane; // 테이블 스크롤바 자동으로 생성되게 하기
	

	private static String colNames[] = { "Id", "Pw", "name", "gender", "birth","email","tel" }; // 테이블 컬럼 값들
	static DefaultTableModel model = new DefaultTableModel(colNames, 0); // 테이블 데이터 모델 객체 생성


	public Admin_member() {
		setLayout(null); // 레이아웃 배치관리자 삭제
		
		
		table = new JTable(model); // 테이블에 모델객체 삽입
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("굴림체", Font.BOLD, 15));
        table.getColumnModel().getColumn(0).setPreferredWidth(180);  //JTable 의 컬럼 길이 조절
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(2).setPreferredWidth(280);
        table.getColumnModel().getColumn(3).setPreferredWidth(280);
        table.getColumnModel().getColumn(4).setPreferredWidth(280);
        table.getColumnModel().getColumn(5).setPreferredWidth(280);
        table.getColumnModel().getColumn(6).setPreferredWidth(280);
        
        
		table.addMouseListener((MouseListener) new JTableMouseListener()); // 테이블에 마우스리스너 연결
		scrollPane = new JScrollPane(table); // 테이블에 스크롤 생기게 하기
		scrollPane.setSize(700, 250);
		scrollPane.setLocation(10, 10);
	
		add(scrollPane);
		initialize();
		select();

	}

	private class JTableMouseListener implements MouseListener { // 마우스로 눌려진값확인하기
		public void mouseClicked(java.awt.event.MouseEvent e) { // 선택된 위치의 값을 출력

			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow(); // 선택된 테이블의 행값
			int col = jtable.getSelectedColumn(); // 선택된 테이블의 열값

			System.out.println(model.getValueAt(row, col)); // 선택된 위치의 값을 얻어내서 출력

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

		DAO mdao = DAO.getInstance();
		mdao.selectmeber();
	}

	private void initialize() { // 액션이벤트와 버튼 컴포넌트 설정

		// 테이블 새로 한줄 추가하는 부분
		jBtnAddRow = new JButton();
		jBtnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				model2.addRow(new String[] { "", "", "", "", "" ,"",""}); // 새테이블의 초기값
			}
		});
		jBtnAddRow.setBounds(30, 270, 120, 25);
		jBtnAddRow.setText("추가");
		add(jBtnAddRow);

		// 테이블 새로 저장하는 부분
		jBtnSaveRow = new JButton();
		jBtnSaveRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // 선택이 안된 상태면 -1리턴
				DTO mdto = new DTO();
				
				mdto.setId( (String)model2.getValueAt(row, 0));
				mdto.setPassword( (String)model2.getValueAt(row, 1));
				mdto.setName( (String)model2.getValueAt(row, 2));
				mdto.setGender( (String)model2.getValueAt(row, 3));
				mdto.setBirth( (String)model2.getValueAt(row, 4));
				mdto.setEmail( (String)model2.getValueAt(row, 5));
				mdto.setTel( (String)model2.getValueAt(row, 6));
				
				DAO dao = DAO.getInstance();
				int result = dao.insertMember(mdto);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "저장 완료");

				}
				model2.setRowCount(0); // 전체 테이블 화면을 지워줌
				select(); // 저장 후 다시 전체 값들을 받아옴.
			}
		});
		
		
		jBtnSaveRow.setBounds(182, 270, 120, 25);
		jBtnSaveRow.setText("저장");
		add(jBtnSaveRow);

		// 선택된 테이블 한줄 수정하는 부분
		jBtnEditRow = new JButton();
		jBtnEditRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // 선택이 안된 상태면 -1리턴


				DTO mdto = new DTO();
				
				mdto.setId( (String)model2.getValueAt(row, 0));
				mdto.setPassword( (String)model2.getValueAt(row, 1));
				mdto.setName( (String)model2.getValueAt(row, 2));
				mdto.setGender( (String)model2.getValueAt(row, 3));
				mdto.setBirth( (String)model2.getValueAt(row, 4));
				mdto.setEmail( (String)model2.getValueAt(row, 5));
				mdto.setTel( (String)model2.getValueAt(row, 6));
				
				DAO dao = DAO.getInstance();
				int result = dao.updateMeber(mdto);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "저장 완료");

				}
				model2.setRowCount(0); // 전체 테이블 화면을 지워줌
				select(); // 수정 후다시 전체 값들을 받아옴.
			}
		});
		jBtnEditRow.setBounds(182, 270, 120, 25);
		jBtnEditRow.setText("수정");
		add(jBtnEditRow);

		// 선택된 테이블 한줄 삭제하는 부분
		jBtnDelRow = new JButton();
		jBtnDelRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if (row < 0)
					return; // 선택이 안된 상태면 -1리턴
				/*
				String query = "delete from user_info where id= ?";

				try {
					Class.forName(driver); // 드라이버 로딩
					con = DriverManager.getConnection(url, "aaaa", "aaaa"); // DB 연결
					pstmt = con.prepareStatement(query);

					// 물음표가 1개 이므로 4개 각각 입력해줘야한다.
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
				model2.removeRow(row); // 테이블 상의 한줄 삭제*/
			}
		});
		jBtnDelRow.setBounds(new Rectangle(320, 270, 120, 25));
		jBtnDelRow.setText("삭제");
		add(jBtnDelRow);
	}

	public static void main(String[] args) {

		Admin_member panel = new Admin_member();
	
		JFrame win = new JFrame();

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		win.add(panel);
		win.setSize(800, 700);
		win.setVisible(true);
	}
}
