package test222;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Login extends JFrame{

	public void Loginscreen() {
		setTitle("�α���");
		JPanel title = new JPanel();
		
		JLabel login = new JLabel("�α��� ȭ��");
		
		login.setForeground(new Color(5,0,153));
		login.setFont(new Font("���ʷչ���",Font.BOLD,25));
		title.add(login);//������Ʈ �����̳ʿ� �ø�
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 2));
		
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlID1 = new JLabel("���̵� : ", JLabel.CENTER);
		
		idPanel.add(jlID1);
		
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);
			
		idPanel2.add(jtf1);
		
		jp1.add(idPanel);
		jp1.add(idPanel2);
		
		
		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlPW2 = new JLabel("��й�ȣ : ", JLabel.CENTER);
		
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField jtf2 = new JPasswordField(10);
		
		pwdPanel.add(jlPW2);
		pwdPanel2.add(jtf2);
		
		jp1.add(pwdPanel);
		jp1.add(pwdPanel2);
		
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("�α���");
		
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton jsignup = new JButton("ȸ������");
		
		loginPanel.add(jLogin);
		joinPanel.add(jsignup);
		
		jp1.add(loginPanel);
		jp1.add(joinPanel);
		
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jp1);
		
		setLayout(new BorderLayout());
		
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		
		setBounds(200, 200, 300, 250);
		
		setResizable(false);  // ȭ�� ũ�� �����ϴ� �۾�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		// ȸ������ ��ư�� Ŭ������ �� �̺�Ʈ ó��
		jsignup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Signup SU =  new Signup();
				SU.SignupScreen();
				
				dispose();
			}
			
		});
		
		//�α��� ��ư�� Ŭ������ ��
		
		jLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String id = jtf1.getText();
				
				char[] g_pwd = jtf2.getPassword();
				String pw = String.valueOf(g_pwd);
				DAO dao = DAO.getInstance();
				int result = dao.idpw(id, pw);
				if (result==1) { //�α��� ������ ùȭ�� �ҷ�����
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
					
					FirstScreen fs = new FirstScreen();
					fs.disScreen();
					
					dispose();//���� â ����
				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
			}
			
		});		
		
	}
	
}
