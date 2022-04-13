package test222;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Login extends JFrame {

	public void Loginscreen() {
		setTitle("로그인");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));
		

		JLabel login = new JLabel("LOGIN");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(login);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250,250,249));
		
		JTextField id = new JTextField(12);
		JPasswordField pw = new JPasswordField(12);
		
		JLabel findid = new JLabel("<html><body><U>|   i  d  찾기 |  </U></body></html>");
		findid.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		JLabel findpw = new JLabel("<html><body><U> 비밀번호 찾기   |  </U></body></html>");
		findpw.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		JLabel signup = new JLabel("<html><body><U>  회 원 가 입   |  </U></body></html>");
		signup.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		findid.setForeground(Color.GRAY);
		findpw.setForeground(Color.GRAY);
		signup.setForeground(Color.GRAY);
		
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(10,60,250,50);
		idPanel.add(new JLabel("아 이 디   : "));
		idPanel.add(id);
		idPanel.setBackground(new Color(250,250,249));
		jp1.add(idPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(10,110,250,50);
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw);
		pwPanel.setBackground(new Color(250,250,249));
		jp1.add(pwPanel);
		
		JPanel findPanel = new JPanel();
		findPanel.add(findid);
		findPanel.add(findpw);
		findPanel.add(signup);
		findPanel.setBounds(20,200,300,40);
		findPanel.setBackground(new Color(250,250,249));
		jp1.add(findPanel);


		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("로그인");
	
		buttonPanel.add(jLogin);
		jLogin.setPreferredSize(new Dimension(90, 90));
		jLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		jLogin.setForeground(Color.WHITE);
		jLogin.setBackground(Color.GRAY);
		buttonPanel.setBackground(new Color(250,250,249));
		buttonPanel.setBounds(260,50,100,100);
		jp1.add(buttonPanel);

		// jp1.add(findPanel);
		//JPanel jp2 = new JPanel();
		//jp2.setLayout(new FlowLayout());
		//jp2.add(jp1);

		setLayout(new BorderLayout());

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(300, 200, 400, 350);

		setResizable(false); // 화면 크기 고정하는 작업

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 회원가입 클릭했을 때
		signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //마우스 클릭이벤트에서 동작할 내용 재정의
				Signup SU = new Signup();
				SU.SignupScreen();

				dispose();
            }          
        });
		
		findid.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //마우스 클릭이벤트에서 동작할 내용 재정의
        		Find_IDPW fi = new Find_IDPW();
        		fi.findID();
        		dispose();
            }          
        });
		
		findpw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //마우스 클릭이벤트에서 동작할 내용 재정의
        		Find_IDPW fi = new Find_IDPW();
        		fi.findPW();
        		dispose();
            }          
        });

	      Action loginok = new AbstractAction() { //엔터쳤을 때 로그인되게 하기
	          public void actionPerformed(ActionEvent arg0) {
	      		String indexid = (String)id.getText();

				char[] g_pwd = pw.getPassword();
				String indexpw = String.valueOf(g_pwd);
				
				DAO dao = DAO.getInstance();
				Admin_DAO Adao = Admin_DAO.ADgetInstance();
				
				int result = dao.idpw(indexid, indexpw);
				
				
				if (result == 1) { // 로그인 성공시 첫화면 불러오기
					JOptionPane.showMessageDialog(null, "로그인 완료");

					FirstScreen fs = new FirstScreen();
					fs.disScreen();

					dispose();// 현재 창 종료
				} else if (result != 1) {
					int result2 = Adao.Admin_idpw(indexid, indexpw);
					if (result2 == 2) {
						JOptionPane.showMessageDialog(null, "로그인 완료");

						Admin_main ad = new Admin_main();
						ad.adminmain();

						dispose();// 현재 창 종료
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}

				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
	        
	           
	           
	          }
	       };
	           
	      KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
	      id.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
	      id.getActionMap().put("ENTER", loginok);
	      pw.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
	      pw.getActionMap().put("ENTER", loginok);


		// 로그인 버튼을 클릭했을 때

		jLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String indexid = (String)id.getText();

				char[] g_pwd = pw.getPassword();
				String indexpw = String.valueOf(g_pwd);
				
				DAO dao = DAO.getInstance();
				Admin_DAO Adao = Admin_DAO.ADgetInstance();
				
				int result = dao.idpw(indexid, indexpw);
				
				
				if (result == 1) { // 로그인 성공시 첫화면 불러오기
					JOptionPane.showMessageDialog(null, "로그인 완료");

					FirstScreen fs = new FirstScreen();
					fs.disScreen();

					dispose();// 현재 창 종료
				} else if (result != 1) {
					int result2 = Adao.Admin_idpw(indexid, indexpw);
					if (result2 == 2) {
						JOptionPane.showMessageDialog(null, "로그인 완료");

						Admin_main ad = new Admin_main();
						ad.adminmain();

						dispose();// 현재 창 종료
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}

				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}

		});

	}

}
