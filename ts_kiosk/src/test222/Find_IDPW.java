package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Find_IDPW extends JFrame {

	private String cnum;// 인증번호
	static String fid;

	public String getnum() {
		return cnum;
	}

	public void setnum(String cnum) {
		this.cnum = cnum;
	}

	public String getid() {
		return fid;
	}

	public void setid(String fid) {
		this.fid = fid;
	}

	public void findID() {

		setTitle("아이디 찾기");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("아이디 찾기");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(login);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField name = new JTextField(13);// 이름
		JTextField tel = new JTextField(13);// 전화번호
		JTextField certification_num = new JTextField(13);// 인증번호
		certification_num.setEditable(false); // 텍스트 필드 수정 못하도록

		JButton sendnum = new JButton("인증번호 발송");
		sendnum.setForeground(Color.WHITE);
		sendnum.setBackground(Color.GRAY);

		JButton OK = new JButton("확인");
		OK.setForeground(Color.WHITE);
		OK.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>처음으로<br>돌아가기</body></html>");
		JButton gotoFindpw = new JButton("비밀번호 찾기");

		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("이  름  : "));
		namePanel.add(name);
		namePanel.setBounds(100, 40, 250, 50);
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel telPanel = new JPanel();
		telPanel.add(new JLabel("휴대전화  : "));
		telPanel.add(tel);
		telPanel.add(sendnum);
		telPanel.setBounds(76, 100, 400, 50);
		telPanel.setBackground(new Color(250, 250, 249));
		jp1.add(telPanel);

		JPanel cernum = new JPanel();
		cernum.add(new JLabel("인증번호(6자리) : "));
		cernum.add(certification_num);
		cernum.add(OK);
		cernum.setBackground(new Color(250, 250, 249));
		cernum.setBounds(55, 160, 350, 50);
		jp1.add(cernum);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(gotoLogin);
		buttonPanel.add(gotoFindpw);
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);
		gotoFindpw.setPreferredSize(new Dimension(150, 60));
		gotoFindpw.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoFindpw.setForeground(Color.WHITE);
		gotoFindpw.setBackground(Color.GRAY);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 인증번호 발송 버튼
		sendnum.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO fdao = DAO.getInstance();

				int result = fdao.findID((String) name.getText(), (String) tel.getText());
				if (result == 1) {

					certification_num.setEditable(true);
					int min = 100000;
					int max = 999999;
					int random = (int) (Math.random() * (max - min + 1) + min);
					setnum(String.valueOf(random));
					System.out.println(random);
					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("굴림", java.awt.Font.BOLD, 30));
					JOptionPane.showMessageDialog(null, random);

				} else {
					JOptionPane.showMessageDialog(null, "잘못된 정보");

				}

			}

		});
		// 다음 버튼
		OK.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String incnum = getnum();
				String indexnum = (String) certification_num.getText();

				if (indexnum.equals(incnum)) {
					System.out.println((String) certification_num.getText());

					String infid = getid();
					System.out.println(infid);

					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("굴림", java.awt.Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, "아이디는 " + infid + "입니다");

				} else {
					JOptionPane.showMessageDialog(null, "틀린 인증번호입니다. 다시 입력하세요");

				}

			}

		});

		// 로그인 하러가기
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});
		// 비밀번호 창 띄우기
		gotoFindpw.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Find_IDPW fi = new Find_IDPW();
				fi.findPW();
				dispose();

			}

		});

	}

	public void findPW() {

		setTitle("비밀번호 찾기");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("비밀번호 찾기");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(login);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField id = new JTextField(13);// 아이디
		JTextField tel = new JTextField(13);// 전화번호
		JTextField certification_num = new JTextField(13);// 인증번호
		certification_num.setEditable(false); // 텍스트 필드 수정 못하도록

		JButton sendnum = new JButton("인증번호 발송");
		sendnum.setForeground(Color.WHITE);
		sendnum.setBackground(Color.GRAY);

		JButton OK = new JButton("확인");
		OK.setForeground(Color.WHITE);
		OK.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>처음으로<br>돌아가기</body></html>");
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);
		
		JButton gotofindid = new JButton("아이디 찾기");
		gotofindid.setPreferredSize(new Dimension(150, 60));
		gotofindid.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotofindid.setForeground(Color.WHITE);
		gotofindid.setBackground(Color.GRAY);
		
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("아이디 : "));
		namePanel.add(id);
		namePanel.setBounds(100, 40, 250, 50);
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel telPanel = new JPanel();
		telPanel.add(new JLabel("휴대전화  : "));
		telPanel.add(tel);
		telPanel.add(sendnum);
		telPanel.setBounds(76, 100, 400, 50);
		telPanel.setBackground(new Color(250, 250, 249));
		jp1.add(telPanel);

		JPanel cernum = new JPanel();
		cernum.add(new JLabel("인증번호(6자리) : "));
		cernum.add(certification_num);
		cernum.add(OK);
		cernum.setBackground(new Color(250, 250, 249));
		cernum.setBounds(55, 160, 350, 50);
		jp1.add(cernum);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(gotoLogin);
		buttonPanel.add(gotofindid);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 인증번호 발송 버튼
		sendnum.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO fdao = DAO.getInstance();

				int result = fdao.findPW((String) id.getText(), (String) tel.getText());
				if (result == 1) {

					certification_num.setEditable(true);
					int min = 100000;
					int max = 999999;
					int random = (int) (Math.random() * (max - min + 1) + min);
					setnum(String.valueOf(random));
					System.out.println(random);
					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("굴림", java.awt.Font.BOLD, 30));
					JOptionPane.showMessageDialog(null, random);

				} else {
					JOptionPane.showMessageDialog(null, "잘못된 정보");

				}

			}

		});
		// 인증번호 확인 버튼
		OK.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String incnum = getnum();
				String indexnum = (String) certification_num.getText();

				if (indexnum.equals(incnum)) {
					System.out.println((String) certification_num.getText());

					Find_IDPW fi = new Find_IDPW();
					fi.resetPW((String) id.getText());

				} else {
					JOptionPane.showMessageDialog(null, "틀린 인증번호입니다." + "다시 입력하세요");

				}

			}

		});
		// 처음 로그인 창으로 돌아가기 버튼
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});
		//아이디 찾으러 가는 버튼
		gotofindid.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Find_IDPW fi = new Find_IDPW();
				fi.findID();
				dispose();
			}

		});

	}

	public void resetPW(String userid) {

		setTitle("비밀번호 재설정");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("비밀번호 재설정");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(login);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField newpw1 = new JTextField(13);// 새로운 비밀번호
		JTextField newpw2 = new JTextField(13);// 비밀번호 확인

		JButton Set = new JButton("재설정");
		Set.setPreferredSize(new Dimension(150, 60));
		Set.setFont(new Font("SansSerif", Font.BOLD, 15));
		Set.setForeground(Color.WHITE);
		Set.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>처음으로<br>돌아가기</body></html>");
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);

		JPanel pwPanel1 = new JPanel();
		pwPanel1.add(new JLabel("새로운 비밀번호 : "));
		pwPanel1.add(newpw1);
		pwPanel1.setBounds(80, 70, 400, 50);
		pwPanel1.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel1);

		JPanel pwPanel2 = new JPanel();
		pwPanel2.add(new JLabel("새로운 비밀번호 확인 : "));
		pwPanel2.add(newpw2);
		pwPanel2.setBounds(71, 130, 400, 50);
		pwPanel2.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel2);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Set);
		buttonPanel.add(gotoLogin);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 비밀번호 재설정하기
		Set.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String pw1 = newpw1.getText();
				String pw2 = newpw2.getText();

				System.out.println(pw1 + "\n" + pw2);

				if (pw1.equals(pw2)) {

					DTO fdto = new DTO();
					fdto.setId(userid);
					fdto.setPassword(pw1);

					DAO fdao = DAO.getInstance();
					int result = fdao.resetPW(fdto);

					if (result == 1) {
						javax.swing.UIManager.put("OptionPane.messageFont",
								new java.awt.Font("굴림", java.awt.Font.BOLD, 20));
						JOptionPane.showMessageDialog(null, "<html><body>비밀번호 재설정이<br> 완료되었습니다.</body></html>");
						Login LG = new Login();
						LG.Loginscreen();
						dispose();
					}

				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");

				}

			}

		});

		// 처음으로 돌아가기 버튼
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});

	}
}
