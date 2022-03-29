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
		setTitle("������ȸ������");
		
		JLabel title = new JLabel("������ȸ������",JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new Font("���ʷչ���",Font.BOLD,25));
		
		JButton signup = new JButton("ȸ������");
		JButton cancel = new JButton("���");
		
		JTextField id_num = new JTextField(13);//���
		JTextField id = new JTextField(13);//���̵�
		JTextField pw = new JTextField (13);//��й�ȣ
		JTextField name = new JTextField(13);//�̸�
		
		JButton Asearch = new JButton("��ȸ");
		JLabel yes = new JLabel("�����ϴ� ����Դϴ�");
		JLabel no = new JLabel("�������� �ʴ� ����Դϴ�");
		
		JPanel idnumPanel = new JPanel();
		idnumPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idnumPanel.add(new JLabel("�� �� : "));
		idnumPanel.add(id_num);
		idnumPanel.add(Asearch);//��ȸ�ϱ�

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
		
		//��ȸ ��ư�� Ŭ������ ��
		Asearch.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				DAO dao = DAO.getInstance();
				
				
				System.out.println(id_num.getText());
				int result = dao.Admin_searchIDNUM((String)id_num.getText());
				
				if (result==1) {
					System.out.println(id_num.getText());
					JOptionPane.showMessageDialog(null, "��ȸ �Ϸ�");
					
				}else {
	                JOptionPane.showMessageDialog(null, "��ȸ ����");
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
