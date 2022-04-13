package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Find_IDPW extends JFrame {

	private String cnum;// ������ȣ
	static String fid;

	public String getnum() {
		return cnum;
	}

	public void setnum(String cnum) {
		this.cnum = cnum;
	}

	public String getid() {
		return fid;
	}

	public void setid(String fid) {
		this.fid = fid;
	}

	public void findID() {

		setTitle("���̵� ã��");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("���̵� ã��");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(login);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField name = new JTextField(13);// �̸�
		JTextField tel = new JTextField(13);// ��ȭ��ȣ
		JTextField certification_num = new JTextField(13);// ������ȣ
		certification_num.setEditable(false); // �ؽ�Ʈ �ʵ� ���� ���ϵ���

		JButton sendnum = new JButton("������ȣ �߼�");
		sendnum.setForeground(Color.WHITE);
		sendnum.setBackground(Color.GRAY);

		JButton OK = new JButton("Ȯ��");
		OK.setForeground(Color.WHITE);
		OK.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>ó������<br>���ư���</body></html>");
		JButton gotoFindpw = new JButton("��й�ȣ ã��");

		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("��  ��  : "));
		namePanel.add(name);
		namePanel.setBounds(100, 40, 250, 50);
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel telPanel = new JPanel();
		telPanel.add(new JLabel("�޴���ȭ  : "));
		telPanel.add(tel);
		telPanel.add(sendnum);
		telPanel.setBounds(76, 100, 400, 50);
		telPanel.setBackground(new Color(250, 250, 249));
		jp1.add(telPanel);

		JPanel cernum = new JPanel();
		cernum.add(new JLabel("������ȣ(6�ڸ�) : "));
		cernum.add(certification_num);
		cernum.add(OK);
		cernum.setBackground(new Color(250, 250, 249));
		cernum.setBounds(55, 160, 350, 50);
		jp1.add(cernum);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(gotoLogin);
		buttonPanel.add(gotoFindpw);
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);
		gotoFindpw.setPreferredSize(new Dimension(150, 60));
		gotoFindpw.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoFindpw.setForeground(Color.WHITE);
		gotoFindpw.setBackground(Color.GRAY);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// ������ȣ �߼� ��ư
		sendnum.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO fdao = DAO.getInstance();

				int result = fdao.findID((String) name.getText(), (String) tel.getText());
				if (result == 1) {

					certification_num.setEditable(true);
					int min = 100000;
					int max = 999999;
					int random = (int) (Math.random() * (max - min + 1) + min);
					setnum(String.valueOf(random));
					System.out.println(random);
					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("����", java.awt.Font.BOLD, 30));
					JOptionPane.showMessageDialog(null, random);

				} else {
					JOptionPane.showMessageDialog(null, "�߸��� ����");

				}

			}

		});
		// ���� ��ư
		OK.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String incnum = getnum();
				String indexnum = (String) certification_num.getText();

				if (indexnum.equals(incnum)) {
					System.out.println((String) certification_num.getText());

					String infid = getid();
					System.out.println(infid);

					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("����", java.awt.Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, "���̵�� " + infid + "�Դϴ�");

				} else {
					JOptionPane.showMessageDialog(null, "Ʋ�� ������ȣ�Դϴ�. �ٽ� �Է��ϼ���");

				}

			}

		});

		// �α��� �Ϸ�����
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});
		// ��й�ȣ â ����
		gotoFindpw.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Find_IDPW fi = new Find_IDPW();
				fi.findPW();
				dispose();

			}

		});

	}

	public void findPW() {

		setTitle("��й�ȣ ã��");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("��й�ȣ ã��");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(login);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField id = new JTextField(13);// ���̵�
		JTextField tel = new JTextField(13);// ��ȭ��ȣ
		JTextField certification_num = new JTextField(13);// ������ȣ
		certification_num.setEditable(false); // �ؽ�Ʈ �ʵ� ���� ���ϵ���

		JButton sendnum = new JButton("������ȣ �߼�");
		sendnum.setForeground(Color.WHITE);
		sendnum.setBackground(Color.GRAY);

		JButton OK = new JButton("Ȯ��");
		OK.setForeground(Color.WHITE);
		OK.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>ó������<br>���ư���</body></html>");
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);
		
		JButton gotofindid = new JButton("���̵� ã��");
		gotofindid.setPreferredSize(new Dimension(150, 60));
		gotofindid.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotofindid.setForeground(Color.WHITE);
		gotofindid.setBackground(Color.GRAY);
		
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("���̵� : "));
		namePanel.add(id);
		namePanel.setBounds(100, 40, 250, 50);
		namePanel.setBackground(new Color(250, 250, 249));
		jp1.add(namePanel);

		JPanel telPanel = new JPanel();
		telPanel.add(new JLabel("�޴���ȭ  : "));
		telPanel.add(tel);
		telPanel.add(sendnum);
		telPanel.setBounds(76, 100, 400, 50);
		telPanel.setBackground(new Color(250, 250, 249));
		jp1.add(telPanel);

		JPanel cernum = new JPanel();
		cernum.add(new JLabel("������ȣ(6�ڸ�) : "));
		cernum.add(certification_num);
		cernum.add(OK);
		cernum.setBackground(new Color(250, 250, 249));
		cernum.setBounds(55, 160, 350, 50);
		jp1.add(cernum);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(gotoLogin);
		buttonPanel.add(gotofindid);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// ������ȣ �߼� ��ư
		sendnum.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO fdao = DAO.getInstance();

				int result = fdao.findPW((String) id.getText(), (String) tel.getText());
				if (result == 1) {

					certification_num.setEditable(true);
					int min = 100000;
					int max = 999999;
					int random = (int) (Math.random() * (max - min + 1) + min);
					setnum(String.valueOf(random));
					System.out.println(random);
					javax.swing.UIManager.put("OptionPane.messageFont",
							new java.awt.Font("����", java.awt.Font.BOLD, 30));
					JOptionPane.showMessageDialog(null, random);

				} else {
					JOptionPane.showMessageDialog(null, "�߸��� ����");

				}

			}

		});
		// ������ȣ Ȯ�� ��ư
		OK.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String incnum = getnum();
				String indexnum = (String) certification_num.getText();

				if (indexnum.equals(incnum)) {
					System.out.println((String) certification_num.getText());

					Find_IDPW fi = new Find_IDPW();
					fi.resetPW((String) id.getText());

				} else {
					JOptionPane.showMessageDialog(null, "Ʋ�� ������ȣ�Դϴ�." + "�ٽ� �Է��ϼ���");

				}

			}

		});
		// ó�� �α��� â���� ���ư��� ��ư
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Login LG = new Login();
				LG.Loginscreen();
				dispose();
			}

		});
		//���̵� ã���� ���� ��ư
		gotofindid.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Find_IDPW fi = new Find_IDPW();
				fi.findID();
				dispose();
			}

		});

	}

	public void resetPW(String userid) {

		setTitle("��й�ȣ �缳��");
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 0, 102));

		JLabel login = new JLabel("��й�ȣ �缳��");

		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("���� ���", Font.BOLD, 30));
		title.add(login);// ������Ʈ �����̳ʿ� �ø�

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(250, 250, 249));

		JTextField newpw1 = new JTextField(13);// ���ο� ��й�ȣ
		JTextField newpw2 = new JTextField(13);// ��й�ȣ Ȯ��

		JButton Set = new JButton("�缳��");
		Set.setPreferredSize(new Dimension(150, 60));
		Set.setFont(new Font("SansSerif", Font.BOLD, 15));
		Set.setForeground(Color.WHITE);
		Set.setBackground(new Color(255, 0, 102));

		JButton gotoLogin = new JButton("<html><body>ó������<br>���ư���</body></html>");
		gotoLogin.setPreferredSize(new Dimension(150, 60));
		gotoLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		gotoLogin.setForeground(Color.WHITE);
		gotoLogin.setBackground(Color.GRAY);

		JPanel pwPanel1 = new JPanel();
		pwPanel1.add(new JLabel("���ο� ��й�ȣ : "));
		pwPanel1.add(newpw1);
		pwPanel1.setBounds(80, 70, 400, 50);
		pwPanel1.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel1);

		JPanel pwPanel2 = new JPanel();
		pwPanel2.add(new JLabel("���ο� ��й�ȣ Ȯ�� : "));
		pwPanel2.add(newpw2);
		pwPanel2.setBounds(71, 130, 400, 50);
		pwPanel2.setBackground(new Color(250, 250, 249));
		jp1.add(pwPanel2);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Set);
		buttonPanel.add(gotoLogin);
		buttonPanel.setBackground(new Color(250, 250, 249));
		buttonPanel.setBounds(100, 250, 310, 70);
		jp1.add(buttonPanel);

		add(title, BorderLayout.NORTH);
		add(jp1, BorderLayout.CENTER);

		setBounds(200, 200, 550, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// ��й�ȣ �缳���ϱ�
		Set.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String pw1 = newpw1.getText();
				String pw2 = newpw2.getText();

				System.out.println(pw1 + "\n" + pw2);

				if (pw1.equals(pw2)) {

					DTO fdto = new DTO();
					fdto.setId(userid);
					fdto.setPassword(pw1);

					DAO fdao = DAO.getInstance();
					int result = fdao.resetPW(fdto);

					if (result == 1) {
						javax.swing.UIManager.put("OptionPane.messageFont",
								new java.awt.Font("����", java.awt.Font.BOLD, 20));
						JOptionPane.showMessageDialog(null, "<html><body>��й�ȣ �缳����<br> �Ϸ�Ǿ����ϴ�.</body></html>");
						Login LG = new Login();
						LG.Loginscreen();
						dispose();
					}

				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�");

				}

			}

		});

		// ó������ ���ư��� ��ư
		gotoLogin.addActionListener(new java.awt.event.ActionListener() {

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
