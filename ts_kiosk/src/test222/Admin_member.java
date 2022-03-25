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

		this.setTitle("회원관리");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JPanel makePanel() {// 반으로 쪼개놓은거 스플릿팬 적용 가능한지 나중에 시도
		JPanel pn = new JPanel();
		pn.setLayout(null);

		tablePan.setSize(1200, 800);
		tablePan.setLocation(1, 1);
		pn.add(tablePan);

		return pn;

	}

}

class Tablepane extends JPanel { // 장바구니 담을 패널
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
	// DB에서 스윙 화면으로 테이블 값 가져오기(select) , 저장하기(insert), 수정하기(update), 삭제하기(delete)

	private JFrame f1;
	JPanel jp1 = new JPanel();

	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null; // 테이블 한줄 추가 버튼
	private JButton jBtnSaveRow = null; // 테이블 한줄 저장 버튼
	private JButton jBtnEditRow = null; // 테이블 한줄 저장 버튼
	private JButton jBtnDelRow = null; // 테이블 한줄 삭제 벅튼
	private JButton jbtnAllRow = null; //고객 전체보기
	private JTable table;
	private JScrollPane scrollPane; // 테이블 스크롤바 자동으로 생성되게 하기

	private JTextField id = new JTextField(13);// 아이디
	private JTextField pw = new JTextField(13);// 비밀번호
	private JTextField name = new JTextField(13);// 이름
	private JTextField birth = new JTextField(13);// 생년월일
	private JTextField tel = new JTextField(13);// 전화번호
	private JTextField email = new JTextField(13);// 이메일
	private JTextField gender = new JTextField(13);
	
	private JLabel backimgLabel = new JLabel();// 제품 사진
	private ImageIcon bicon;
	
	private JComboBox<String> cbbsearch;
	private static String comboNames[] = { "아이디", "이름", "성별" };
	private JTextField search = new JTextField(13);
	private JButton jBtnSearch = new JButton("검색");
	private String Content; // 검색 카테고리 id cname gender 담을 스트링

	private static String colNames[] = { "Id", "Pw", "name", "gender", "birth", "email", "tel" }; // 테이블 컬럼 값들
	static DefaultTableModel model = new DefaultTableModel(colNames, 0); // 테이블 데이터 모델 객체 생성

	public makeTable(JFrame f1) {

		this.f1 = f1;
		setLayout(null); // 레이아웃 배치관리자 삭제
		
		jp1.setLayout(null);
		jp1.setLocation(1,1);
		jp1.setSize(1200,800);
		
		bicon = new ImageIcon("image/icon/backspace.png");
		backimgLabel.setIcon(bicon);
		backimgLabel.setBounds(5, 5, 45, 45);
		jp1.add(backimgLabel);
		backimgLabel.addMouseListener((MouseListener) new BackSpace()); // 테이블에 마우스리스너 연결
		
		
		JLabel optionOrder = new JLabel("회원 조회");

		optionOrder.setBounds(0, 0, 1200, 60);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("함초롱바탕", Font.BOLD, 30));
		jp1.add(optionOrder);// 컴포넌트 컨테이너에 올림
		
		JPanel infopan = new JPanel();
		infopan.setLayout(new GridLayout(7,2,5,5));
		
		JPanel searchpan = new JPanel(); //검색 패널
		searchpan.setLocation(450, 600);
		searchpan.setSize(300, 60);
		JPanel ssspan = new JPanel();//검색 컴포넌트 넣을 패널
		ssspan.setLayout(new FlowLayout(FlowLayout.LEFT));

		cbbsearch = new JComboBox(comboNames); //콤보박스
		ssspan.add(cbbsearch);//콤보박스
		ssspan.add(search); //텍스트필드
		ssspan.add(jBtnSearch);//검색 버튼
		searchpan.add(ssspan);
		searchpan.setBackground(Color.WHITE);
		ssspan.setBackground(Color.WHITE);

		jBtnSearch.addActionListener(new ActionListener() { //검색 버튼 눌렀을 떄
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				if (cbbsearch.getSelectedItem().toString() == "아이디") {
					Content = "Id";
					
				} else if (cbbsearch.getSelectedItem().toString() == "이름") {
					Content = "Cname";
					
				} else if (cbbsearch.getSelectedItem().toString() == "성별") {
					Content = "gender";
					
				}
								
				model2.setRowCount(0); // 전체 테이블 화면을 지워줌
				
				System.out.println(Content);
				
				DAO dao = DAO.getInstance();
				int result = dao.searchmember(Content,(String)search.getText()) ;
				if (result == -1) { //검색 결과 없을 떄 
					JOptionPane.showMessageDialog(null, "해당내용이 없습니다");

				}				
			}
		});

		infopan.add(new JLabel("아이디 : "));
		infopan.add(id);
		
		infopan.add(new JLabel("비밀번호 : "));
		infopan.add(pw);
		
		infopan.add(new JLabel("이  름  : "));
		infopan.add(name);
		
		infopan.add(new JLabel("셍년월일 : "));
		infopan.add(birth);
		
		infopan.add(new JLabel("성  별  : "));
		infopan.add(gender);
		
		infopan.add(new JLabel("전화번호 : "));
		infopan.add(tel);
		
		infopan.add(new JLabel("e-mail : "));
		infopan.add(email);

		infopan.setBackground(Color.white);
		infopan.setLocation(30, 75);
		infopan.setSize(350, 450);
		// emailPanel.setBounds(20,650, 150, 60);

		table = new JTable(model); // 테이블에 모델객체 삽입
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("굴림체", Font.BOLD, 15));
		table.getColumnModel().getColumn(0).setPreferredWidth(180); // JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(280);
		table.getColumnModel().getColumn(3).setPreferredWidth(280);
		table.getColumnModel().getColumn(4).setPreferredWidth(280);
		table.getColumnModel().getColumn(5).setPreferredWidth(280);
		table.getColumnModel().getColumn(6).setPreferredWidth(280);

		table.addMouseListener((MouseListener) new JTableMouseListener()); // 테이블에 마우스리스너 연결

		scrollPane = new JScrollPane(table); // 테이블에 스크롤 생기게 하기
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

	private class JTableMouseListener implements MouseListener { // 마우스로 눌려진값확인하기
		public void mouseClicked(java.awt.event.MouseEvent e) { // 선택된 위치의 값을 출력

			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow(); // 선택된 테이블의 행값
			int col = jtable.getSelectedColumn(); // 선택된 테이블의 열값

			id.setText((String) model.getValueAt(row, 0));
			pw.setText((String) model.getValueAt(row, 1));
			name.setText((String) model.getValueAt(row, 2));
			gender.setText((String) model.getValueAt(row, 3));
			birth.setText((String) model.getValueAt(row, 4));
			email.setText((String) model.getValueAt(row, 5));
			tel.setText((String) model.getValueAt(row, 6));

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
	private class BackSpace implements MouseListener { //뒤로가기 클릭 이벤트
		public void mouseClicked(java.awt.event.MouseEvent e) { 
			
			int result = JOptionPane.showConfirmDialog(null,"뒤로 가시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
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
				model2.addRow(new String[] { "", "", "", "", "", "", "" }); // 새테이블의 초기값
			}
		});

		jBtnAddRow.setBounds(10, 680, 200, 40);
		jBtnAddRow.setText("추가");
		jp1.add(jBtnAddRow);

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
					JOptionPane.showMessageDialog(null, "저장 완료");

				}
				model2.setRowCount(0); // 전체 테이블 화면을 지워줌
				select(); // 저장 후 다시 전체 값들을 받아옴.
			}
		});

		jBtnSaveRow.setBounds(250, 680, 200, 40);
		jBtnSaveRow.setText("저장");
		jp1.add(jBtnSaveRow);

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
					JOptionPane.showMessageDialog(null, "저장 완료");

				}
				model2.setRowCount(0); // 전체 테이블 화면을 지워줌
				select(); // 수정 후다시 전체 값들을 받아옴.
			}
		});
		jBtnEditRow.setBounds(490, 680, 200, 40);
		jBtnEditRow.setText("수정");
		jp1.add(jBtnEditRow);

		// 선택된 테이블 한줄 삭제하는 부분
		jBtnDelRow = new JButton();
		jBtnDelRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				int row = table.getSelectedRow();
				if (row < 0)
					return; // 선택이 안된 상태면 -1리턴
				String sid = id.getText();
				DAO dao = DAO.getInstance();
				int result = dao.deletemember(sid);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "삭제 완료");

				}
				model2.setRowCount(0);
				select();
			}
		});
		jBtnDelRow.setBounds(730, 680, 200, 40);
		jBtnDelRow.setText("삭제");
		jp1.add(jBtnDelRow);
		
		jbtnAllRow = new JButton();
		jbtnAllRow.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(e.getActionCommand()); // 선택된 버튼의 텍스트값 출력
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();

				model2.setRowCount(0);
				select();
			}
		});
		jbtnAllRow.setBounds(960, 680, 200, 40);
		jbtnAllRow.setText("전체 보기");
		jp1.add(jbtnAllRow);
		
	}

}
