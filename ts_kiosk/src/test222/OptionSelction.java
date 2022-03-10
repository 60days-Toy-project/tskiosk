package test222;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;



public class OptionSelction extends JFrame {




	public String Result;


	int quncount = 1; // + - ��ư ������ ����

	String temper;
	String Size;
	String TakeOut;

	String menu;
	int price;

	/*
	 * public void getInfo(String menu, int price) { imgmenu = menu; imgprice =
	 * price; }
	 */

	/*
	 * public void methodTest() {
	 * 
	 * Result = getResult(menu, price, quncount, temper, Size, TakeOut); }
	 */

	public String getResult(String menu, int price, int count, String tmeper, String Size, String takeout) {
		String result = "";

		int cost = price * count;

		result = menu + "," + cost + "," + count + "," + tmeper + "," + Size + "," + takeout;

		return result;

	}

	/* String imgmenu, int imgprice ���� */
	public void extra(String imgmenu, int imgprice) {

		// setLayout(null);
		menu = imgmenu;
		price = imgprice;

		setTitle("�ɼ� ����");

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);

		JPanel title = new JPanel();

		JLabel optionOrder = new JLabel("�ɼ� ����");

		optionOrder.setBounds(0, 0, 800, 100);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("���ʷչ���", Font.BOLD, 30));
		jp1.add(optionOrder);// ������Ʈ �����̳ʿ� �ø�

		JButton cancelbtn = new JButton("����");
		cancelbtn.setPreferredSize(new Dimension(180, 50));
		cancelbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setBackground(Color.GRAY);

		JButton addbtn = new JButton("���");
		addbtn.setPreferredSize(new Dimension(180, 50));
		addbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(new Color(255, 0, 102));

		JLabel imgLabel = new JLabel();// ��ǰ ����

		// ������ ����
		ImageIcon icon = new ImageIcon("image/" + imgmenu + ".jpg");
		imgLabel.setIcon(icon);

		// �� ����(ũ��, ����...)
		imgLabel.setBounds(50, 120, 260, 260);

		// �����ӿ� ������Ʈ �߰�
		// getContentPane().add(imgLabel);
		jp1.add(imgLabel);

		// ��ǰ �̸�
		JLabel menuname = new JLabel(imgmenu);

		menuname.setBounds(80, 300, 220, 220);

		menuname.setHorizontalAlignment(JLabel.CENTER);
		menuname.setFont(new Font("SansSerif", Font.PLAIN, 25));

		jp1.add(menuname);

		String topirce = Integer.toString(imgprice);
		JLabel price = new JLabel(topirce + "��");
		price.setFont(new Font("SansSerif", Font.BOLD, 30));
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setBounds(80, 390, 220, 220);

		jp1.add(price);

		JPanel jpQuanty = new JPanel(); // - ���� +
		// jpQuanty.setLayout(null);

		jpQuanty.setLayout(new FlowLayout(FlowLayout.CENTER));

		JTextField textcount = new JTextField(5);// ���� �⺻�� 1

		String toquncount = Integer.toString(quncount);
		textcount.setText(toquncount);
		textcount.setBackground(Color.WHITE);
		textcount.setEditable(false); // �ؽ�Ʈ �ʵ� ���� ����=����

		JButton btnminus = new JButton("-");

		JButton btnplus = new JButton("+");

		jpQuanty.setBounds(50, 520, 260, 260);

		jpQuanty.add(btnminus);
		jpQuanty.add(textcount);
		jpQuanty.add(btnplus);

		jp1.add(jpQuanty);

		// �ɼ� ���� ��� ��ư��

		ImageIcon ice = new ImageIcon("image/icon_ice.png");
		ImageIcon regular = new ImageIcon("image/icon_Regular.png");
		ImageIcon large = new ImageIcon("image/icon_Large.png");
		ImageIcon mug = new ImageIcon("image/icon_mug.png");
		ImageIcon takeaway = new ImageIcon("image/icon_takeaway.png");

		// ���� �ȵǾ������� ȸ�� ������ �̹���
		ImageIcon gice = new ImageIcon("image/icon_gice.png");
		ImageIcon gregular = new ImageIcon("image/icon_gRegular.png");
		ImageIcon glarge = new ImageIcon("image/icon_gLarge.png");
		ImageIcon gmug = new ImageIcon("image/icon_gmug.png");
		ImageIcon gtakeaway = new ImageIcon("image/icon_gtakeaway.png");

		JToggleButton jtbice = new JToggleButton("���̽�", gice);
		JToggleButton jtbregular = new JToggleButton("���ַ�", gregular);
		JToggleButton jtblarge = new JToggleButton("����", glarge);
		JToggleButton jtbmug = new JToggleButton("�ӱ���", gmug);
		JToggleButton jtbtakeaway = new JToggleButton("��ȸ����", gtakeaway);

		jtbice.setBackground(Color.WHITE);
		jtbice.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbice.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbice.setSelectedIcon(ice);
		jtbice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temper = "I";
			}

		});

		jtbregular.setBackground(Color.WHITE);
		jtbregular.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbregular.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbregular.setSelectedIcon(regular);
		jtbregular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Size = "R";
			}

		});

		jtblarge.setBackground(Color.WHITE);
		jtblarge.setHorizontalTextPosition(SwingConstants.CENTER);
		jtblarge.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtblarge.setSelectedIcon(large);
		jtblarge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Size = "L";
			}

		});

		jtbmug.setBackground(Color.WHITE);
		jtbmug.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbmug.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbmug.setSelectedIcon(mug);
		jtbmug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TakeOut = "�ӱ���";
			}

		});

		jtbtakeaway.setBackground(Color.WHITE);
		jtbtakeaway.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbtakeaway.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbtakeaway.setSelectedIcon(takeaway);
		jtbtakeaway.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TakeOut = "��ȸ����";
			}

		});

		ButtonGroup bg1 = new ButtonGroup();
		ButtonGroup bg2 = new ButtonGroup();
		ButtonGroup bg3 = new ButtonGroup();

		bg1.add(jtbice);
		bg2.add(jtbregular);
		bg2.add(jtblarge);
		bg3.add(jtbmug);
		bg3.add(jtbtakeaway);

		JPanel text1 = new JPanel();
		text1.add(new JLabel("1.���̽�"));
		text1.setLayout(new FlowLayout(FlowLayout.LEFT));
		text1.setBounds(400, 130, 70, 30);
		jp1.add(text1);

		JPanel text2 = new JPanel();
		text2.setLayout(new FlowLayout(FlowLayout.LEFT));
		text2.add(new JLabel("2.������"));
		text2.setBounds(400, 320, 70, 30);
		jp1.add(text2);

		JPanel text3 = new JPanel();
		text3.setLayout(new FlowLayout(FlowLayout.LEFT));
		text3.add(new JLabel("3.����"));
		text3.setBounds(400, 520, 70, 30);
		jp1.add(text3);

		JPanel ice1 = new JPanel();
		ice1.add(jtbice);
		ice1.setLayout(new FlowLayout(FlowLayout.LEFT));
		ice1.setBounds(400, 150, 150, 150);
		jp1.add(ice1);

		JPanel cupsize = new JPanel();
		cupsize.setLayout(new FlowLayout(FlowLayout.LEFT));
		cupsize.add(jtbregular);
		cupsize.add(jtblarge);
		cupsize.setBounds(400, 350, 300, 150);
		jp1.add(cupsize);

		JPanel takeout = new JPanel();
		takeout.setLayout(new FlowLayout(FlowLayout.LEFT));
		takeout.add(jtbmug);
		takeout.add(jtbtakeaway);
		takeout.setBounds(400, 550, 300, 150);
		jp1.add(takeout);

		JPanel panel = new JPanel();
		panel.add(cancelbtn);
		panel.add(addbtn);

		// add(title, BorderLayout.NORTH);

		add(jp1);
		add(panel, BorderLayout.SOUTH);

		setBounds(400, 0, 300, 350);

		setSize(800, 830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		btnplus.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quncount += 1;
				String toquncount = Integer.toString(quncount);
				textcount.setText(toquncount);

			}

		});

		btnminus.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (quncount > 1) {
					quncount -= 1;
				} else {
					quncount = 1;
				}

				String toquncount = Integer.toString(quncount);
				textcount.setText(toquncount);

			}

		});

		cancelbtn.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dispose();
			}

		});
		addbtn.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Cart co = new Cart();
				//co.Carts(imgmenu, imgprice, quncount, temper, Size, TakeOut);
				//co.setData();
				String[] newMenu = new String[3];
                newMenu[0] = temper+"/"+imgmenu+"("+Size+")";
                newMenu[1] = Integer.toString(quncount);
                newMenu[2] = Integer.toString(imgprice);
                
				Cart.model.addRow(newMenu);
				Cart.Qty_sum += quncount;
				Cart.Cost_sum += imgprice*quncount;
				Cart.SetIndex();
				
				
				dispose();

			}

		});
	}

}
