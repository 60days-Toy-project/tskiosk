package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_main extends JFrame{
	
	public void adminmain() {
		
		setTitle("������ ������");
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(Color.white);
		
		JLabel imgLabel = new JLabel();// ��ǰ ����

		// ������ ����
		ImageIcon icon = new ImageIcon("image/coffee640300.jpg");
		imgLabel.setIcon(icon);

		// �� ����(ũ��, ����...)
		imgLabel.setBounds(1, 1, 640, 380);

		jp1.add(imgLabel);
		
		JButton memberbtn = new JButton("<html><body>ȸ��<br>����</body></html>");//�ٹٲ�"\n"�ȸ��� html�ۿ���...
		memberbtn.setPreferredSize(new Dimension(200, 210));
		memberbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		memberbtn.setForeground(Color.WHITE);
		memberbtn.setBackground(new Color(240, 0, 98));

		JButton productbtn = new JButton("<html><body>��ǰ<br>����</body></html>");
		productbtn.setPreferredSize(new Dimension(200, 210));
		productbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		productbtn.setForeground(Color.WHITE);
		productbtn.setBackground(new Color(240, 0, 98));
		
		JButton ordertbtn = new JButton("<html><body>�ֹ�<br>����</body></html>");
		ordertbtn.setPreferredSize(new Dimension(200,210));
		ordertbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		ordertbtn.setForeground(Color.WHITE);
		ordertbtn.setBackground(new Color(240, 0, 98));
		
		JPanel btnset = new JPanel();
		btnset.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnset.setBounds(1,370,640, 310);
		btnset.add(memberbtn);
		btnset.add(productbtn);
		btnset.add(ordertbtn);
		jp1.add(btnset);
		
		memberbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin_member adm = new Admin_member();
			}
			
		});


	
		add(jp1);

		setBounds(400, 0, 300, 350);
		setSize(640, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
