package test222;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Login extends JFrame {

	public void Loginscreen() {
		setTitle("�α���");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));
		

		JLabel login = new JLabel("LOGIN");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(login);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250,250,249));
		
		JTextField id = new JTextField(12);
		JPasswordField pw = new JPasswordField(12);
		
		JLabel findid = new JLabel("<html><body><U>|   i  d  ã�� |  </U></body></html>");
		findid.setFont(new Font("���� ���", Font.BOLD, 15));
		JLabel findpw = new JLabel("<html><body><U> ��й�ȣ ã��   |  </U></body></html>");
		findpw.setFont(new Font("���� ���", Font.BOLD, 15));
		JLabel signup = new JLabel("<html><body><U>  ȸ �� �� ��   |  </U></body></html>");
		signup.setFont(new Font("���� ���", Font.BOLD, 15));
		findid.setForeground(Color.GRAY);
		findpw.setForeground(Color.GRAY);
		signup.setForeground(Color.GRAY);
		
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(10,60,250,50);
		idPanel.add(new JLabel("�� �� ��   : "));
		idPanel.add(id);
		idPanel.setBackground(new Color(250,250,249));
		jp1.add(idPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(10,110,250,50);
		pwPanel.add(new JLabel("��й�ȣ : "));
		pwPanel.add(pw);
		pwPanel.setBackground(new Color(250,250,249));
		jp1.add(pwPanel);
		
		JPanel findPanel = new JPanel();
		findPanel.add(findid);
		findPanel.add(findpw);
		findPanel.add(signup);
		findPanel.setBounds(20,200,300,40);
		findPanel.setBackground(new Color(250,250,249));
		jp1.add(findPanel);


		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("�α���");
	
		buttonPanel.add(jLogin);
		jLogin.setPreferredSize(new Dimension(90, 90));
		jLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		jLogin.setForeground(Color.WHITE);
		jLogin.setBackground(Color.GRAY);
		buttonPanel.setBackground(new Color(250,250,249));
		buttonPanel.setBounds(260,50,100,100);
		jp1.add(buttonPanel);

		// jp1.add(findPanel);
		//JPanel jp2 = new JPanel();
		//jp2.setLayout(new FlowLayout());
		//jp2.add(jp1);

		setLayout(new BorderLayout());

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(300, 200, 400, 350);

		setResizable(false); // ȭ�� ũ�� �����ϴ� �۾�

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// ȸ������ Ŭ������ ��
		signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //���콺 Ŭ���̺�Ʈ���� ������ ���� ������
				Signup SU = new Signup();
				SU.SignupScreen();

				dispose();
            }          
        });
		
		findid.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //���콺 Ŭ���̺�Ʈ���� ������ ���� ������
        		Find_IDPW fi = new Find_IDPW();
        		fi.findID();
        		dispose();
            }          
        });
		
		findpw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //���콺 Ŭ���̺�Ʈ���� ������ ���� ������
        		Find_IDPW fi = new Find_IDPW();
        		fi.findPW();
        		dispose();
            }          
        });

	      Action loginok = new AbstractAction() { //�������� �� �α��εǰ� �ϱ�
	          public void actionPerformed(ActionEvent arg0) {
	      		String indexid = (String)id.getText();

				char[] g_pwd = pw.getPassword();
				String indexpw = String.valueOf(g_pwd);
				
				DAO dao = DAO.getInstance();
				Admin_DAO Adao = Admin_DAO.ADgetInstance();
				
				int result = dao.idpw(indexid, indexpw);
				
				
				if (result == 1) { // �α��� ������ ùȭ�� �ҷ�����
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");

					FirstScreen fs = new FirstScreen();
					fs.disScreen();

					dispose();// ���� â ����
				} else if (result != 1) {
					int result2 = Adao.Admin_idpw(indexid, indexpw);
					if (result2 == 2) {
						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");

						Admin_main ad = new Admin_main();
						ad.adminmain();

						dispose();// ���� â ����
					}else {
						JOptionPane.showMessageDialog(null, "�α��� ����");
					}

				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
	        
	           
	           
	          }
	       };
	           
	      KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
	      id.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
	      id.getActionMap().put("ENTER", loginok);
	      pw.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
	      pw.getActionMap().put("ENTER", loginok);


		// �α��� ��ư�� Ŭ������ ��

		jLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String indexid = (String)id.getText();

				char[] g_pwd = pw.getPassword();
				String indexpw = String.valueOf(g_pwd);
				
				DAO dao = DAO.getInstance();
				Admin_DAO Adao = Admin_DAO.ADgetInstance();
				
				int result = dao.idpw(indexid, indexpw);
				
				
				if (result == 1) { // �α��� ������ ùȭ�� �ҷ�����
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");

					FirstScreen fs = new FirstScreen();
					fs.disScreen();

					dispose();// ���� â ����
				} else if (result != 1) {
					int result2 = Adao.Admin_idpw(indexid, indexpw);
					if (result2 == 2) {
						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");

						Admin_main ad = new Admin_main();
						ad.adminmain();

						dispose();// ���� â ����
					}else {
						JOptionPane.showMessageDialog(null, "�α��� ����");
					}

				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
			}

		});

	}

}
