package test222;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Signup extends JFrame {

	public void SignupScreen() {
		setTitle("회원가입");
		
		JLabel title = new JLabel("회원가입",JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new Font("함초롱바탕",Font.BOLD,25));
		
		JButton signup = new JButton("회원가입");
		JButton Adminsignup = new JButton("관리자 회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField id = new JTextField(13);//아이디
		JTextField  pw = new JTextField (13);//비밀번호
		JTextField name = new JTextField(13);//이름
		JTextField birth = new JTextField(13);//생년월일
		JTextField tel = new JTextField(13);//전화번호
		JTextField email = new JTextField (13);//이메일
		
		JRadioButton gender1 = new JRadioButton("여성");
		JRadioButton gender2 = new JRadioButton("남성");
		
		ButtonGroup bg= new ButtonGroup();
		bg.add(gender1);
		bg.add(gender2);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이 름 : "));
		namePanel.add(name);		
		
		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		birthPanel.add(new JLabel("생년월일(8자) : "));
		birthPanel.add(birth);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		radioPanel.add(new JLabel("성별 : "));
		radioPanel.add(gender1);
		radioPanel.add(gender2);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telPanel.add(new JLabel("전화번호 : "));
		telPanel.add(tel);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		emailPanel.add(new JLabel("e-mail : "));
		emailPanel.add(email);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(7, 1));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(namePanel);
		formPanel.add(birthPanel);		
		formPanel.add(radioPanel);	
		formPanel.add(telPanel);	
		formPanel.add(emailPanel);	
		
		JPanel panel = new JPanel();
		panel.add(Adminsignup);
		panel.add(signup);
		panel.add(cancel);
		
		add(title, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 400, 450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		//회원가입 버튼을 클릭했을 때
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO dto = new DTO();
/*				JTextField id = new JTextField(13);//아이디
				JPasswordField  pw = new JPasswordField (13);//비밀번호
				JTextField name = new JTextField(13);//이름
				JTextField birth = new JTextField(13);//생년월일
				JTextField tel = new JTextField(13);//전화번호
				JTextField email = new JTextField (13);//이메일

	*/
				dto.setId(id.getText());
				dto.setPassword(pw.getText());
				dto.setName(name.getText());
				dto.setBirth(birth.getText());
				dto.setEmail(email.getText());
				dto.setTel(tel.getText());
				if(gender1.isSelected()) {
					dto.setGender(gender1.getText());
				} else {
					dto.setGender(gender2.getText());
				}
				
				DAO dao = DAO.getInstance();
				int result = dao.insertMember(dto);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "회원등록 완료");
				    Login LG =  new Login();
				    LG.Loginscreen();
	                dispose();
				}else {
	                JOptionPane.showMessageDialog(null, "회원동록 실패");
	      	      	Login LG =  new Login();
	      	      	LG.Loginscreen();
	                dispose();
	            }
			}
			
		});
		//관리자 회원가입
		Adminsignup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
				Login LG =  new Login();
			    LG.Loginscreen();
				dispose();
			}
			
		});
		
	}
}
