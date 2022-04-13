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
	static JTextField name = new JTextField(13);//�̸�
	public void Admin_signup() {
		

		setTitle("������ ȸ������");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel adsignup = new JLabel("������ ȸ������");

		adsignup.setForeground(new Color(255, 255, 255));
		adsignup.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(adsignup);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));
		
	
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
		
		JTextField id_num = new JTextField(13);//���
		JTextField id = new JTextField(13);//���̵�
		JTextField pw = new JTextField (13);//��й�ȣ
		
		
		
		JButton Asearch = new JButton("��ȸ");
		
		JLabel yes = new JLabel("�����ϴ� ����Դϴ�");
		JLabel no = new JLabel("�ùٸ��� ���� ����Դϴ�");
		yes.setForeground(Color.BLUE);
		yes.setFont(new Font("���� ���", Font.PLAIN, 12));
		no.setForeground(Color.RED);
		no.setFont(new Font("���� ���", Font.PLAIN, 12));

		JPanel yespanel = new JPanel();
		JPanel nopanel = new JPanel();
		
		
		JPanel idnumPanel = new JPanel();
		idnumPanel.setBounds(30,20,300,40);
		idnumPanel.add(new JLabel("��        �� : "));
		idnumPanel.add(id_num);
		idnumPanel.add(Asearch);//��ȸ�ϱ�
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
		idPanel.add(new JLabel("�� �� ��   : "));
		idPanel.add(id);
		idPanel.setBackground(new Color(250, 250, 249));
		jp1.add(idPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(1,130,300,50);
		pwPanel.add(new JLabel("��й�ȣ : "));
		pwPanel.add(pw);
		pwPanel.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(1,180,300,50);
		namePanel.add(new JLabel("��        �� : "));
		namePanel.add(name);		
		name.setEditable(false); // �ؽ�Ʈ �ʵ� ���� ����=����
		namePanel.setBackground(new Color(250, 250, 249));

		jp1.add(namePanel);
		
		//��ư �ǳ�
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
		
		//��ȸ ��ư�� Ŭ������ ��
		Asearch.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				Admin_DAO ad = Admin_DAO.ADgetInstance();
				
				System.out.println(id_num.getText());
				String IDNUM =id_num.getText();
								
				int result = ad.Admin_searchIDNUM(IDNUM);
				
				if (result==1) {
					JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�");
					nopanel.setVisible(false);
					yespanel.setVisible(true);
					

				}else {
	                JOptionPane.showMessageDialog(null, "��ȸ ����");
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
