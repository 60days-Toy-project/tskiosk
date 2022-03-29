package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin_signup extends JFrame {
	public void Admin_signup() {
		setTitle("관리자회원가입");
		
		JLabel title = new JLabel("관리자회원가입",JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new Font("함초롱바탕",Font.BOLD,25));
		
		JButton signup = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField id_num = new JTextField(13);//사번
		JTextField id = new JTextField(13);//아이디
		JTextField pw = new JTextField (13);//비밀번호
		JTextField name = new JTextField(13);//이름
		
		JButton Asearch = new JButton("조회");
		JLabel yes = new JLabel("존재하는 사번입니다");
		JLabel no = new JLabel("존재하지 않는 사번입니다");
		
		JPanel idnumPanel = new JPanel();
		idnumPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idnumPanel.add(new JLabel("사 번 : "));
		idnumPanel.add(id_num);
		idnumPanel.add(Asearch);//조회하기

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
		
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(5, 1));
		formPanel.add(idnumPanel);
		
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(namePanel);

		
		JPanel panel = new JPanel();
		panel.add(signup);
		panel.add(cancel);
		
		add(title, BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 400, 450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		//조회 버튼을 클릭했을 때
		Asearch.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				DAO dao = DAO.getInstance();
				
				
				System.out.println(id_num.getText());
				int result = dao.Admin_searchIDNUM((String)id_num.getText());
				
				if (result==1) {
					System.out.println(id_num.getText());
					JOptionPane.showMessageDialog(null, "조회 완료");
					
				}else {
	                JOptionPane.showMessageDialog(null, "조회 실패");
	                dispose();
	            }
			}
			
		});
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO dto = new DTO();

				dto.setAid(id.getText());
				dto.setApassword(pw.getText());
				dto.setAname(name.getText());
				dto.setAidnum(id_num.getText());
				
				DAO dao = DAO.getInstance();
				int result = dao.Admin_insertMember(dto);
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
