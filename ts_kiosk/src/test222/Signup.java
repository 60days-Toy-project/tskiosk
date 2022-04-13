package test222;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Signup extends JFrame {

	public void SignupScreen() {
		setTitle("회원가입");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel adsignup = new JLabel("회원가입");

		adsignup.setForeground(new Color(255, 255, 255));
		adsignup.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(adsignup);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JButton check = new JButton("중복조회");
		check.setFont(new Font("SansSerif", Font.BOLD, 13));
		check.setForeground(Color.WHITE);
		check.setBackground(Color.GRAY);
		
		JButton signup = new JButton("회원가입");
		signup.setPreferredSize(new Dimension(150, 60));
		signup.setFont(new Font("SansSerif", Font.BOLD, 15));
		signup.setForeground(Color.WHITE);
		signup.setBackground(new Color(255, 0, 102));
		
		JButton cancel = new JButton("취소");
		cancel.setPreferredSize(new Dimension(150, 60));
		cancel.setFont(new Font("SansSerif", Font.BOLD, 15));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.GRAY);
		
		
		JLabel yes = new JLabel("사용 가능한 id 입니다");
		JLabel no = new JLabel("사용 불가능한 id 입니다");
		yes.setForeground(new Color(102, 204, 0));
		yes.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		no.setForeground(Color.RED);
		no.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		JLabel admin = new JLabel("<html><body><U> ■ 관리자   회원가입  </U></body></html>");
		admin.setForeground(Color.BLUE);
		admin.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		JPanel adminPanel  = new JPanel();
		adminPanel.setBounds(1,3,140,30);
		adminPanel.add(admin);
		adminPanel.setBackground(new Color(250, 250, 249));

		jp1.add(adminPanel);
		
		JTextField id = new JTextField(13);// 아이디
		JTextField pw = new JTextField(13);// 비밀번호
		JTextField name = new JTextField(13);// 이름
		JTextField birth = new JTextField(13);// 생년월일
		JTextField tel = new JTextField(13);// 전화번호
		JTextField email = new JTextField(13);// 이메일

		JRadioButton gender1 = new JRadioButton("여성");
		JRadioButton gender2 = new JRadioButton("남성");
		gender1.setBackground(new Color(250, 250, 249));
		gender2.setBackground(new Color(250, 250, 249));


		ButtonGroup bg = new ButtonGroup();
		bg.add(gender1);
		bg.add(gender2);

		JPanel idPanel = new JPanel();
		idPanel.setBounds(110, 50, 350, 30);
		idPanel.add(new JLabel("아   이   디   : "));
		idPanel.add(id);
		idPanel.add(check);
		idPanel.setBackground(new Color(250, 250, 249));
		jp1.add(idPanel);
		
		JPanel yesPanel = new JPanel();
		yesPanel.add(yes);
		yesPanel.setBounds(170, 80, 200, 20);
		yesPanel.setVisible(false);
		yesPanel.setBackground(new Color(250, 250, 249));
		jp1.add(yesPanel);
		JPanel noPanel = new JPanel();
		noPanel.add(no);
		noPanel.setBounds(178, 80, 200, 20);
		noPanel.setVisible(false);
		noPanel.setBackground(new Color(250, 250, 249));
		jp1.add(noPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(118, 110, 250, 30);
		pwPanel.add(new JLabel("비밀번호  :  "));
		pwPanel.add(pw);
		pw.setEditable(false); 
		pwPanel.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(120, 170, 250, 30);
		namePanel.add(new JLabel("이      름   :  "));
		namePanel.add(name);
		name.setEditable(false); 
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel birthPanel = new JPanel();
		birthPanel.setBounds(81, 230, 300, 30);
		birthPanel.add(new JLabel("생년월일(8자)  : "));
		birthPanel.add(birth);
		birth.setEditable(false); 
		birthPanel.setBackground(new Color(250, 250, 249));
		jp1.add(birthPanel);

		JPanel radioPanel = new JPanel();
		radioPanel.setBounds(85, 290, 300, 30);
		radioPanel.add(new JLabel("성   별   :  "));
		radioPanel.add(gender1);
		radioPanel.add(gender2);
		radioPanel.setBackground(new Color(250, 250, 249));
		jp1.add(radioPanel);

		JPanel telPanel = new JPanel();
		telPanel.setBounds(120, 350, 250, 30);
		telPanel.add(new JLabel("전 화 번 호 : "));
		telPanel.add(tel);
		tel.setEditable(false); 
		telPanel.setBackground(new Color(250, 250, 249));
		jp1.add(telPanel);

		JPanel emailPanel = new JPanel();
		emailPanel.setBounds(128, 410, 250, 30);
		emailPanel.add(new JLabel("e - mail : "));
		emailPanel.add(email);
		email.setEditable(false); 
		emailPanel.setBackground(new Color(250, 250, 249));

		jp1.add(emailPanel);


		
		JPanel panel = new JPanel();
		panel.add(signup);
		panel.add(cancel);
		panel.setBackground(new Color(250, 250, 249));
		panel.setBounds(100, 250, 310, 70);

		
		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		setBounds(200, 200, 550, 650);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		
		//중복조회 버튼을 클릭했을 때
		check.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String checkid = id.getText();
				System.out.println(checkid);

				DAO dao = DAO.getInstance();
				int result = dao.checkID(checkid);
				if ( result == 1) {		
					System.out.println(checkid);
					yesPanel.setVisible(true);
					noPanel.setVisible(false);
					
					pw.setEditable(true); 
					name.setEditable(true); 
					birth.setEditable(true); 
					tel.setEditable(true); 
					email.setEditable(true); 

					
				} else {
					noPanel.setVisible(true);
					yesPanel.setVisible(false);
					
					pw.setEditable(false); 
					name.setEditable(false); 
					birth.setEditable(false); 
					tel.setEditable(false); 
					email.setEditable(false); 

				}
			}

		});

		// 회원가입 버튼을 클릭했을 때
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO dto = new DTO();
				/*
				 * JTextField id = new JTextField(13);//아이디 JPasswordField pw = new
				 * JPasswordField (13);//비밀번호 JTextField name = new JTextField(13);//이름
				 * JTextField birth = new JTextField(13);//생년월일 JTextField tel = new
				 * JTextField(13);//전화번호 JTextField email = new JTextField (13);//이메일
				 * 
				 */
				dto.setId(id.getText());
				dto.setPassword(pw.getText());
				dto.setName(name.getText());
				dto.setBirth(birth.getText());
				dto.setEmail(email.getText());
				dto.setTel(tel.getText());
				if (gender1.isSelected()) {
					dto.setGender(gender1.getText());
				} else {
					dto.setGender(gender2.getText());
				}

				DAO dao = DAO.getInstance();
				int result = dao.insertMember(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "회원등록 완료");
					Login LG = new Login();
					LG.Loginscreen();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원동록 실패");
					Login LG = new Login();
					LG.Loginscreen();
					dispose();
				}
			}

		});
		
		// 관리자 회원가입
		admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //마우스 클릭이벤트에서 동작할 내용 재정의
    			Admin_signup AS = new Admin_signup();
				AS.Admin_signup();
				dispose();
            }          
        });


		// 취소 버튼을 클릭했을 때 이벤트 처리
		cancel.addActionListener(new java.awt.event.ActionListener() {

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
