package test222;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Signup extends JFrame {

	public void SignupScreen() {
		setTitle("ȸ������");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel adsignup = new JLabel("ȸ������");

		adsignup.setForeground(new Color(255, 255, 255));
		adsignup.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(adsignup);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JButton check = new JButton("�ߺ���ȸ");
		check.setFont(new Font("SansSerif", Font.BOLD, 13));
		check.setForeground(Color.WHITE);
		check.setBackground(Color.GRAY);
		
		JButton signup = new JButton("ȸ������");
		signup.setPreferredSize(new Dimension(150, 60));
		signup.setFont(new Font("SansSerif", Font.BOLD, 15));
		signup.setForeground(Color.WHITE);
		signup.setBackground(new Color(255, 0, 102));
		
		JButton cancel = new JButton("���");
		cancel.setPreferredSize(new Dimension(150, 60));
		cancel.setFont(new Font("SansSerif", Font.BOLD, 15));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.GRAY);
		
		
		JLabel yes = new JLabel("��� ������ id �Դϴ�");
		JLabel no = new JLabel("��� �Ұ����� id �Դϴ�");
		yes.setForeground(new Color(102, 204, 0));
		yes.setFont(new Font("���� ���", Font.PLAIN, 12));
		no.setForeground(Color.RED);
		no.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		JLabel admin = new JLabel("<html><body><U> �� ������   ȸ������  </U></body></html>");
		admin.setForeground(Color.BLUE);
		admin.setFont(new Font("���� ���", Font.BOLD, 15));
		JPanel adminPanel  = new JPanel();
		adminPanel.setBounds(1,3,140,30);
		adminPanel.add(admin);
		adminPanel.setBackground(new Color(250, 250, 249));

		jp1.add(adminPanel);
		
		JTextField id = new JTextField(13);// ���̵�
		JTextField pw = new JTextField(13);// ��й�ȣ
		JTextField name = new JTextField(13);// �̸�
		JTextField birth = new JTextField(13);// �������
		JTextField tel = new JTextField(13);// ��ȭ��ȣ
		JTextField email = new JTextField(13);// �̸���

		JRadioButton gender1 = new JRadioButton("����");
		JRadioButton gender2 = new JRadioButton("����");
		gender1.setBackground(new Color(250, 250, 249));
		gender2.setBackground(new Color(250, 250, 249));


		ButtonGroup bg = new ButtonGroup();
		bg.add(gender1);
		bg.add(gender2);

		JPanel idPanel = new JPanel();
		idPanel.setBounds(110, 50, 350, 30);
		idPanel.add(new JLabel("��   ��   ��   : "));
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
		pwPanel.add(new JLabel("��й�ȣ  :  "));
		pwPanel.add(pw);
		pw.setEditable(false); 
		pwPanel.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(120, 170, 250, 30);
		namePanel.add(new JLabel("��      ��   :  "));
		namePanel.add(name);
		name.setEditable(false); 
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel birthPanel = new JPanel();
		birthPanel.setBounds(81, 230, 300, 30);
		birthPanel.add(new JLabel("�������(8��)  : "));
		birthPanel.add(birth);
		birth.setEditable(false); 
		birthPanel.setBackground(new Color(250, 250, 249));
		jp1.add(birthPanel);

		JPanel radioPanel = new JPanel();
		radioPanel.setBounds(85, 290, 300, 30);
		radioPanel.add(new JLabel("��   ��   :  "));
		radioPanel.add(gender1);
		radioPanel.add(gender2);
		radioPanel.setBackground(new Color(250, 250, 249));
		jp1.add(radioPanel);

		JPanel telPanel = new JPanel();
		telPanel.setBounds(120, 350, 250, 30);
		telPanel.add(new JLabel("�� ȭ �� ȣ : "));
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
		
		//�ߺ���ȸ ��ư�� Ŭ������ ��
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

		// ȸ������ ��ư�� Ŭ������ ��
		signup.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DTO dto = new DTO();
				/*
				 * JTextField id = new JTextField(13);//���̵� JPasswordField pw = new
				 * JPasswordField (13);//��й�ȣ JTextField name = new JTextField(13);//�̸�
				 * JTextField birth = new JTextField(13);//������� JTextField tel = new
				 * JTextField(13);//��ȭ��ȣ JTextField email = new JTextField (13);//�̸���
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
					JOptionPane.showMessageDialog(null, "ȸ����� �Ϸ�");
					Login LG = new Login();
					LG.Loginscreen();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
					Login LG = new Login();
					LG.Loginscreen();
					dispose();
				}
			}

		});
		
		// ������ ȸ������
		admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //���콺 Ŭ���̺�Ʈ���� ������ ���� ������
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
				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});

	}
}
