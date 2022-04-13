package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	static JTextField name = new JTextField(13);//이름
	public void Admin_signup() {
		

		setTitle("관리자 회원가입");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel adsignup = new JLabel("관리자 회원가입");

		adsignup.setForeground(new Color(255, 255, 255));
		adsignup.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.add(adsignup);// 컴포넌트 컨테이너에 올림

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));
		
	
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
		
		JTextField id_num = new JTextField(13);//사번
		JTextField id = new JTextField(13);//아이디
		JTextField pw = new JTextField (13);//비밀번호
		
		
		
		JButton Asearch = new JButton("조회");
		
		JLabel yes = new JLabel("존재하는 사번입니다");
		JLabel no = new JLabel("올바르지 않은 사번입니다");
		yes.setForeground(Color.BLUE);
		yes.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		no.setForeground(Color.RED);
		no.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JPanel yespanel = new JPanel();
		JPanel nopanel = new JPanel();
		
		
		JPanel idnumPanel = new JPanel();
		idnumPanel.setBounds(30,20,300,40);
		idnumPanel.add(new JLabel("사        번 : "));
		idnumPanel.add(id_num);
		idnumPanel.add(Asearch);//조회하기
		idnumPanel.setBackground(new Color(250, 250, 249));
		jp1.add(idnumPanel);

		yespanel.setBounds(99,55,150,30);
		yespanel.add(yes);
		yespanel.setBackground(new Color(250, 250, 249));
		jp1.add(yespanel);		
        nopanel.setBounds(99, 55, 150, 30);
        nopanel.add(no);
        nopanel.setBackground(new Color(250, 250, 249));
		jp1.add(nopanel);

		yespanel.setVisible(false);
        nopanel.setVisible(false);
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(1,80,300,50);
		idPanel.add(new JLabel("아 이 디   : "));
		idPanel.add(id);
		idPanel.setBackground(new Color(250, 250, 249));
		jp1.add(idPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(1,130,300,50);
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pw);
		pwPanel.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(1,180,300,50);
		namePanel.add(new JLabel("이        름 : "));
		namePanel.add(name);		
		name.setEditable(false); // 텍스트 필드 수정 못학=도록
		namePanel.setBackground(new Color(250, 250, 249));

		jp1.add(namePanel);
		
		//버튼 판넬
		JPanel panel = new JPanel();
		panel.add(signup);
		panel.add(cancel);
		panel.setBackground(new Color(250, 250, 249));

		
		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 400, 450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		//조회 버튼을 클릭했을 때
		Asearch.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				Admin_DAO ad = Admin_DAO.ADgetInstance();
				
				System.out.println(id_num.getText());
				String IDNUM =id_num.getText();
								
				int result = ad.Admin_searchIDNUM(IDNUM);
				
				if (result==1) {
					JOptionPane.showMessageDialog(null, "조회 완료");
					nopanel.setVisible(false);
					yespanel.setVisible(true);
					

				}else {
	                JOptionPane.showMessageDialog(null, "조회 실패");
	                yespanel.setVisible(false);
	                nopanel.setVisible(true);
				}
			}
			
		});
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO adto = new DTO();

				adto.setAid(id.getText());
				adto.setApassword(pw.getText());
				adto.setAname(name.getText());
				adto.setAidnum(id_num.getText());
				
				Admin_DAO ad = Admin_DAO.ADgetInstance();
				int result = ad.Admin_insertMember(adto);
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
