package test222;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Signup extends JFrame {

	public void SignupScreen() {
		setTitle("ȸ������");
		
		JLabel title = new JLabel("ȸ������",JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new Font("���ʷչ���",Font.BOLD,25));
		
		JButton signup = new JButton("ȸ������");
		JButton Adminsignup = new JButton("������ ȸ������");
		JButton cancel = new JButton("���");
		
		JTextField id = new JTextField(13);//���̵�
		JTextField  pw = new JTextField (13);//��й�ȣ
		JTextField name = new JTextField(13);//�̸�
		JTextField birth = new JTextField(13);//�������
		JTextField tel = new JTextField(13);//��ȭ��ȣ
		JTextField email = new JTextField (13);//�̸���
		
		JRadioButton gender1 = new JRadioButton("����");
		JRadioButton gender2 = new JRadioButton("����");
		
		ButtonGroup bg= new ButtonGroup();
		bg.add(gender1);
		bg.add(gender2);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("���̵� : "));
		idPanel.add(id);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("��й�ȣ : "));
		pwPanel.add(pw);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("�� �� : "));
		namePanel.add(name);		
		
		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		birthPanel.add(new JLabel("�������(8��) : "));
		birthPanel.add(birth);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		radioPanel.add(new JLabel("���� : "));
		radioPanel.add(gender1);
		radioPanel.add(gender2);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telPanel.add(new JLabel("��ȭ��ȣ : "));
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
		
		//ȸ������ ��ư�� Ŭ������ ��
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO dto = new DTO();
/*				JTextField id = new JTextField(13);//���̵�
				JPasswordField  pw = new JPasswordField (13);//��й�ȣ
				JTextField name = new JTextField(13);//�̸�
				JTextField birth = new JTextField(13);//�������
				JTextField tel = new JTextField(13);//��ȭ��ȣ
				JTextField email = new JTextField (13);//�̸���

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
					JOptionPane.showMessageDialog(null, "ȸ����� �Ϸ�");
				    Login LG =  new Login();
				    LG.Loginscreen();
	                dispose();
				}else {
	                JOptionPane.showMessageDialog(null, "ȸ������ ����");
	      	      	Login LG =  new Login();
	      	      	LG.Loginscreen();
	                dispose();
	            }
			}
			
		});
		//������ ȸ������
		Adminsignup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin_signup AS = new Admin_signup();
				AS.Admin_signup();
				dispose();
			}
			
		});
		
		// ��� ��ư�� Ŭ������ �� �̺�Ʈ ó��
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
