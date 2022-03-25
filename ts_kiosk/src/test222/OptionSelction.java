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

	int quncount = 1; // + - 버튼 누를때 수량
	int bcount = 0;
	int scount = 0;

	String temper;
	String Size;
	String TakeOut;

	/*
	String qcandle; // 초 (필요없음 용)
	String qbigcandle; // 큰 초
	String qsmallcandle; // 작은 초
	String qfirecr;
	String qknife;
*/
	int qcandle; // 초 (필요없음 용)
	int qbigcandle; // 큰 초
	int qsmallcandle; // 작은 초
	int qfirecr;
	int qknife;
	
	String dmenu;// 음료 메뉴
	int dprice;// 음료 가격

	String imenu;// 음료 외 메뉴
	int iprice;// 음료 외 가격

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

	/* String imgmenu, int imgprice 인자 */
	public void extra(String imgmenu, int imgprice) {

		// setLayout(null);
		dmenu = imgmenu;
		dprice = imgprice;

		setTitle("옵션 선택");

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);

		JPanel title = new JPanel();

		JLabel optionOrder = new JLabel("옵션 선택");

		optionOrder.setBounds(0, 0, 800, 100);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("함초롱바탕", Font.BOLD, 30));
		jp1.add(optionOrder);// 컴포넌트 컨테이너에 올림

		JButton cancelbtn = new JButton("이전");
		cancelbtn.setPreferredSize(new Dimension(180, 50));
		cancelbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setBackground(Color.GRAY);

		JButton addbtn = new JButton("담기");
		addbtn.setPreferredSize(new Dimension(180, 50));
		addbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(new Color(255, 0, 102));

		JLabel imgLabel = new JLabel();// 제품 사진

		// 아이콘 생성
		ImageIcon icon = new ImageIcon("image/" + imgmenu + ".jpg");
		imgLabel.setIcon(icon);

		// 라벨 설정(크기, 정렬...)
		imgLabel.setBounds(50, 120, 260, 260);

		// 프레임에 컴포넌트 추가
		// getContentPane().add(imgLabel);
		jp1.add(imgLabel);

		// 제품 이름
		JLabel menuname = new JLabel(imgmenu);

		menuname.setBounds(80, 300, 220, 220);

		menuname.setHorizontalAlignment(JLabel.CENTER);
		menuname.setFont(new Font("SansSerif", Font.PLAIN, 25));

		jp1.add(menuname);

		String topirce = Integer.toString(imgprice);
		JLabel price = new JLabel(topirce + "원");
		price.setFont(new Font("SansSerif", Font.BOLD, 30));
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setBounds(80, 390, 220, 220);

		jp1.add(price);

		JPanel jpQuanty = new JPanel(); // - 수량 +
		// jpQuanty.setLayout(null);

		jpQuanty.setLayout(new FlowLayout(FlowLayout.CENTER));

		JTextField textcount = new JTextField(5);// 수량 기본값 1

		String toquncount = Integer.toString(quncount);
		textcount.setText(toquncount);
		textcount.setBackground(Color.WHITE);
		textcount.setEditable(false); // 텍스트 필드 수정 못학=도록

		JButton btnminus = new JButton("-");

		JButton btnplus = new JButton("+");

		jpQuanty.setBounds(50, 520, 260, 260);

		jpQuanty.add(btnminus);
		jpQuanty.add(textcount);
		jpQuanty.add(btnplus);

		jp1.add(jpQuanty);

		// 옵션 선택 토글 버튼들

		ImageIcon ice = new ImageIcon("image/icon_ice.png");
		ImageIcon hot = new ImageIcon("image/icon_hot.png");
		ImageIcon regular = new ImageIcon("image/icon_Regular.png");
		ImageIcon large = new ImageIcon("image/icon_Large.png");
		ImageIcon mug = new ImageIcon("image/icon_mug.png");
		ImageIcon takeaway = new ImageIcon("image/icon_takeaway.png");

		// 선택 안되어있을때 회색 아이콘 이미지
		ImageIcon gice = new ImageIcon("image/icon_gice.png");
		ImageIcon ghot = new ImageIcon("image/icon_ghot.png");
		ImageIcon gregular = new ImageIcon("image/icon_gRegular.png");
		ImageIcon glarge = new ImageIcon("image/icon_gLarge.png");
		ImageIcon gmug = new ImageIcon("image/icon_gmug.png");
		ImageIcon gtakeaway = new ImageIcon("image/icon_gtakeaway.png");

		JToggleButton jtbice = new JToggleButton("차갑게", gice);
		JToggleButton jtbhot = new JToggleButton("뜨겁게", ghot);
		JToggleButton jtbregular = new JToggleButton("레귤러", gregular);
		JToggleButton jtblarge = new JToggleButton("라지", glarge);
		JToggleButton jtbmug = new JToggleButton("매장이용", gmug);
		JToggleButton jtbtakeaway = new JToggleButton("포장", gtakeaway);

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

		jtbhot.setBackground(Color.WHITE);
		jtbhot.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbhot.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbhot.setSelectedIcon(hot);
		jtbhot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temper = "H";
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
				TakeOut = "매장 이용";
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
				TakeOut = "포장";
			}

		});

		ButtonGroup bg1 = new ButtonGroup();
		ButtonGroup bg2 = new ButtonGroup();
		ButtonGroup bg3 = new ButtonGroup();

		bg1.add(jtbice);
		bg1.add(jtbhot);
		bg2.add(jtbregular);
		bg2.add(jtblarge);
		bg3.add(jtbmug);
		bg3.add(jtbtakeaway);

		JPanel text1 = new JPanel();
		text1.add(new JLabel("1.온도"));
		text1.setLayout(new FlowLayout(FlowLayout.LEFT));
		text1.setBounds(400, 130, 70, 30);
		jp1.add(text1);

		JPanel text2 = new JPanel();
		text2.setLayout(new FlowLayout(FlowLayout.LEFT));
		text2.add(new JLabel("2.사이즈"));
		text2.setBounds(400, 320, 70, 30);
		jp1.add(text2);

		JPanel text3 = new JPanel();
		text3.setLayout(new FlowLayout(FlowLayout.LEFT));
		text3.add(new JLabel("3.포장"));
		text3.setBounds(400, 520, 70, 30);
		jp1.add(text3);

		JPanel ice1 = new JPanel();
		ice1.add(jtbice);
		ice1.add(jtbhot);
		ice1.setLayout(new FlowLayout(FlowLayout.LEFT));
		ice1.setBounds(400, 150, 300, 150);
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
				// Cart co = new Cart();
				// co.Carts(imgmenu, imgprice, quncount, temper, Size, TakeOut);
				// co.setData();
				String[] newMenu = new String[3];
				newMenu[0] = temper + "/" + imgmenu + "(" + Size + ")";
				newMenu[1] = Integer.toString(quncount);
				newMenu[2] = Integer.toString(imgprice);

				Cart.model.addRow(newMenu);
				Cart.Qty_sum += quncount;
				Cart.Cost_sum += imgprice * quncount;
				Cart.SetIndex();

				dispose();

			}

		});
	}

	public void Icrcreamextra(String imgmenu, int imgprice) {

		// setLayout(null);
		imenu = imgmenu;
		iprice = imgprice;

		setTitle("옵션 선택");

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);

		JPanel title = new JPanel();

		JLabel optionOrder = new JLabel("옵션 선택");

		optionOrder.setBounds(0, 0, 800, 100);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("함초롱바탕", Font.BOLD, 30));
		jp1.add(optionOrder);// 컴포넌트 컨테이너에 올림

		JButton cancelbtn = new JButton("이전");
		cancelbtn.setPreferredSize(new Dimension(180, 50));
		cancelbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setBackground(Color.GRAY);

		JButton addbtn = new JButton("담기");
		addbtn.setPreferredSize(new Dimension(180, 50));
		addbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(new Color(255, 0, 102));

		JLabel imgLabel = new JLabel();// 제품 사진

		// 아이콘 생성
		ImageIcon icon = new ImageIcon("image/" + imgmenu + ".jpg");
		imgLabel.setIcon(icon);

		// 라벨 설정(크기, 정렬...)
		imgLabel.setBounds(50, 120, 260, 260);

		// 프레임에 컴포넌트 추가
		// getContentPane().add(imgLabel);
		jp1.add(imgLabel);

		// 제품 이름
		JLabel menuname = new JLabel(imgmenu);

		menuname.setBounds(80, 300, 220, 220);

		menuname.setHorizontalAlignment(JLabel.CENTER);
		menuname.setFont(new Font("SansSerif", Font.PLAIN, 25));

		jp1.add(menuname);

		String topirce = Integer.toString(imgprice);
		JLabel price = new JLabel(topirce + "원");
		price.setFont(new Font("SansSerif", Font.BOLD, 30));
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setBounds(80, 390, 220, 220);

		jp1.add(price);

		JPanel jpQuanty = new JPanel(); // - 수량 +
		// jpQuanty.setLayout(null);

		jpQuanty.setLayout(new FlowLayout(FlowLayout.CENTER));

		JTextField textcount = new JTextField(5);// 수량 기본값 1

		String toquncount = Integer.toString(quncount);
		textcount.setText(toquncount);
		textcount.setBackground(Color.WHITE);
		textcount.setEditable(false); // 텍스트 필드 수정 못학=도록

		JButton btnminus = new JButton("-");

		JButton btnplus = new JButton("+");

		jpQuanty.setBounds(50, 520, 260, 260);

		jpQuanty.add(btnminus);
		jpQuanty.add(textcount);
		jpQuanty.add(btnplus);

		jp1.add(jpQuanty);

		// 옵션 선택 토글 버튼들

		ImageIcon mug = new ImageIcon("image/icon_mug.png");
		ImageIcon takeaway = new ImageIcon("image/icon_takeaway.png");

		// 선택 안되어있을때 회색 아이콘 이미지

		ImageIcon gmug = new ImageIcon("image/icon_gmug.png");
		ImageIcon gtakeaway = new ImageIcon("image/icon_gtakeaway.png");

		JToggleButton jtbmug = new JToggleButton("매장이용", gmug);
		JToggleButton jtbtakeaway = new JToggleButton("포장", gtakeaway);

		jtbmug.setBackground(Color.WHITE);
		jtbmug.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbmug.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbmug.setSelectedIcon(mug);
		jtbmug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TakeOut = "매장이용";
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
				TakeOut = "포장";
			}

		});

		ButtonGroup bg3 = new ButtonGroup();

		bg3.add(jtbmug);
		bg3.add(jtbtakeaway);

		JPanel text3 = new JPanel();
		text3.setLayout(new FlowLayout(FlowLayout.LEFT));
		text3.add(new JLabel("1.포장"));
		text3.setBounds(400, 220, 70, 30);
		jp1.add(text3);

		JPanel takeout = new JPanel();
		takeout.setLayout(new FlowLayout(FlowLayout.LEFT));
		takeout.add(jtbmug);
		takeout.add(jtbtakeaway);
		takeout.setBounds(400, 280, 300, 150);
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
				// Cart co = new Cart();
				// co.Carts(imgmenu, imgprice, quncount, temper, Size, TakeOut);
				// co.setData();
				String[] putMenu = new String[3];
				putMenu[0] = imgmenu;
				putMenu[1] = Integer.toString(quncount);
				putMenu[2] = Integer.toString(imgprice);

				Cart.model.addRow(putMenu);
				Cart.Qty_sum += quncount;
				Cart.Cost_sum += imgprice * quncount;
				Cart.SetIndex();

				dispose();

			}

		});
	}

	public void Cakeextra(String imgmenu, int imgprice) {

		// setLayout(null);
		dmenu = imgmenu;
		dprice = imgprice;

		setTitle("옵션 선택");

		JPanel jp1 = new JPanel();
		jp1.setLayout(null);

		JPanel title = new JPanel();

		JLabel optionOrder = new JLabel("옵션 선택");

		optionOrder.setBounds(0, 0, 800, 100);
		optionOrder.setForeground(new Color(255, 255, 255));
		optionOrder.setBackground(new Color(255, 0, 102));
		optionOrder.setOpaque(true);
		optionOrder.setHorizontalAlignment(JLabel.CENTER);
		optionOrder.setFont(new Font("함초롱바탕", Font.BOLD, 30));
		jp1.add(optionOrder);// 컴포넌트 컨테이너에 올림

		JButton cancelbtn = new JButton("이전");
		cancelbtn.setPreferredSize(new Dimension(180, 50));
		cancelbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		cancelbtn.setForeground(Color.WHITE);
		cancelbtn.setBackground(Color.GRAY);

		JButton addbtn = new JButton("담기");
		addbtn.setPreferredSize(new Dimension(180, 50));
		addbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
		addbtn.setForeground(Color.WHITE);
		addbtn.setBackground(new Color(255, 0, 102));

		JLabel imgLabel = new JLabel();// 제품 사진

		// 아이콘 생성
		ImageIcon icon = new ImageIcon("image/menu/cake/" + imgmenu + ".jpg");
		imgLabel.setIcon(icon);

		// 라벨 설정(크기, 정렬...)
		imgLabel.setBounds(50, 120, 260, 260);

		// 프레임에 컴포넌트 추가
		// getContentPane().add(imgLabel);
		jp1.add(imgLabel);

		// 제품 이름
		JLabel menuname = new JLabel(imgmenu);

		menuname.setBounds(80, 300, 220, 220);

		menuname.setHorizontalAlignment(JLabel.CENTER);
		menuname.setFont(new Font("SansSerif", Font.PLAIN, 25));

		jp1.add(menuname);

		String topirce = Integer.toString(imgprice);
		JLabel price = new JLabel(topirce + "원");
		price.setFont(new Font("SansSerif", Font.BOLD, 30));
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setBounds(80, 390, 220, 220);

		jp1.add(price);

		JPanel jpQuanty = new JPanel(); // - 수량 +
		// jpQuanty.setLayout(null);

		jpQuanty.setLayout(new FlowLayout(FlowLayout.CENTER));

		JTextField textcount = new JTextField(5);// 수량 기본값 1

		String toquncount = Integer.toString(quncount);
		textcount.setText(toquncount);
		textcount.setBackground(Color.WHITE);
		textcount.setEditable(false); // 텍스트 필드 수정 못학=도록

		JButton btnminus = new JButton("-");

		JButton btnplus = new JButton("+");

		jpQuanty.setBounds(50, 520, 260, 260);

		jpQuanty.add(btnminus);
		jpQuanty.add(textcount);
		jpQuanty.add(btnplus);

		jp1.add(jpQuanty);

		// 옵션 선택 토글 버튼들

		ImageIcon candle = new ImageIcon("image/icon_candle.png");
		ImageIcon firecracker = new ImageIcon("image/icon_firecracker.png");
		ImageIcon knife = new ImageIcon("image/icon_knife.png");
		ImageIcon no1 = new ImageIcon("image/icon_x1.png");
		ImageIcon no2 = new ImageIcon("image/icon_x2.png");
		ImageIcon no3 = new ImageIcon("image/icon_x3.png");

		// 선택 안되어있을때 회색 아이콘 이미지
		ImageIcon gcandle = new ImageIcon("image/icon_gcandle.png");
		ImageIcon gfirecracker = new ImageIcon("image/icon_gfirecracker.png");
		ImageIcon gknife = new ImageIcon("image/icon_gknife.png");
		ImageIcon gno1 = new ImageIcon("image/icon_gx1.png");
		ImageIcon gno2 = new ImageIcon("image/icon_gx2.png");
		ImageIcon gno3 = new ImageIcon("image/icon_gx3.png");

		JToggleButton jtbcandle = new JToggleButton("초", gcandle);
		JToggleButton jtbfirecracker = new JToggleButton("폭죽", gfirecracker);
		JToggleButton jtbknife = new JToggleButton("빵칼", gknife);
		JToggleButton jtbno1 = new JToggleButton("필요없음", gno1);
		JToggleButton jtbno2 = new JToggleButton("필요없음", gno2);
		JToggleButton jtbno3 = new JToggleButton("필요없음", gno3);

		jtbcandle.setBackground(Color.WHITE);
		jtbcandle.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbcandle.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbcandle.setSelectedIcon(candle);

		JLabel bcandle = new JLabel("큰 초");
		JLabel scandle = new JLabel("작은 초");
		JButton btnminus1 = new JButton("-");
		JTextField bccount = new JTextField(5);// 수량 기본값 1
		JButton btnplus1 = new JButton("+");
		JPanel jpqcandle = new JPanel();
		JTextField sccount = new JTextField(5);// 수량 기본값 1
		JButton btnminus2 = new JButton("-");

		JButton btnplus2 = new JButton("+");

		jtbcandle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// JLabel bcandle = new JLabel("큰 초");
				// JPanel jpqcandle = new JPanel(); // - 수량 +
				// jpQuanty.setLayout(null);

				jpqcandle.setLayout(new FlowLayout(FlowLayout.CENTER));

				// JTextField bccount = new JTextField(5);// 수량 기본값 1

				String strbccount = Integer.toString(bcount);
				bccount.setText(strbccount);
				bccount.setBackground(Color.WHITE);
				bccount.setEditable(false); // 텍스트 필드 수정 못학=도록

				// JButton btnminus1 = new JButton("-");

				// JButton btnplus1 = new JButton("+");

				////
				// JTextField sccount = new JTextField(5);// 수량 기본값 1

				String strsccount = Integer.toString(scount);
				sccount.setText(strsccount);
				sccount.setBackground(Color.WHITE);
				sccount.setEditable(false); // 텍스트 필드 수정 못학=도록

				// JButton btnminus2 = new JButton("-");

				// JButton btnplus2 = new JButton("+");


				jpqcandle.setBounds(500, 300, 200, 240);

				jpqcandle.setBounds(500, 310, 200, 240);


				jpqcandle.add(bcandle);
				jpqcandle.add(btnminus1);
				jpqcandle.add(bccount);
				jpqcandle.add(btnplus1);

				jpqcandle.add(scandle);
				jpqcandle.add(btnminus2);
				jpqcandle.add(sccount);
				jpqcandle.add(btnplus2);

				jp1.add(jpqcandle);
				// jp1.add(bcandle);
				
				bcandle.setVisible(true);
				btnminus1.setVisible(true);
				bccount.setVisible(true);
				btnplus1.setVisible(true);
				scandle.setVisible(true);
				btnminus2.setVisible(true);
				sccount.setVisible(true);
				btnplus2.setVisible(true);
				
				//jpqcandle.setVisible(true);
				// bcandle.setBounds(700, 150, 100, 100);
				// bcandle.setFont(new Font("SansSerif", Font.BOLD, 13));

			}

		});

		jtbno1.setBackground(Color.WHITE);
		jtbno1.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbno1.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbno1.setSelectedIcon(no1);
		jtbno1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// bcandle.setVisible(false);
				// jpqcandle.setVisible(false);
				bcandle.setVisible(false);
				btnminus1.setVisible(false);
				bccount.setVisible(false);
				btnplus1.setVisible(false);
				scandle.setVisible(false);
				btnminus2.setVisible(false);
				sccount.setVisible(false);
				btnplus2.setVisible(false);
				// bcount = 0;
				// scount = 0;
				
				//qcandle = "필요없음";
				qcandle = 0;

			}

		});

		jtbfirecracker.setBackground(Color.WHITE);
		jtbfirecracker.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbfirecracker.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbfirecracker.setSelectedIcon(firecracker);
		jtbfirecracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//qfirecr = "2";
				qfirecr = 2;
			}

		});

		jtbno2.setBackground(Color.WHITE);
		jtbno2.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbno2.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbno2.setSelectedIcon(no2);
		jtbno2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//qfirecr = "필요없음";
				qfirecr = 0;
			}

		});

		jtbknife.setBackground(Color.WHITE);
		jtbknife.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbknife.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbknife.setSelectedIcon(knife);
		jtbknife.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//qknife = "1";
				qknife = 1;
			}

		});

		jtbno3.setBackground(Color.WHITE);
		jtbno3.setHorizontalTextPosition(SwingConstants.CENTER);
		jtbno3.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtbno3.setSelectedIcon(no3);
		jtbno3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//qknife = "필요없음";
				qknife = 0;
			}

		});

		ButtonGroup bg1 = new ButtonGroup();
		ButtonGroup bg2 = new ButtonGroup();
		ButtonGroup bg3 = new ButtonGroup();

		bg1.add(jtbno1);
		bg1.add(jtbcandle);

		bg2.add(jtbno2);
		bg2.add(jtbfirecracker);

		bg3.add(jtbno3);
		bg3.add(jtbknife);

		JPanel text1 = new JPanel();
		text1.add(new JLabel("1.초"));
		text1.setLayout(new FlowLayout(FlowLayout.LEFT));
		text1.setBounds(400, 110, 70, 30);
		jp1.add(text1);

		JPanel text2 = new JPanel();
		text2.setLayout(new FlowLayout(FlowLayout.LEFT));
		text2.add(new JLabel("2.폭죽"));
		text2.setBounds(400, 390, 70, 30);
		jp1.add(text2);

		JPanel text3 = new JPanel();
		text3.setLayout(new FlowLayout(FlowLayout.LEFT));
		text3.add(new JLabel("3.칼"));
		text3.setBounds(400, 580, 70, 30);
		jp1.add(text3);

		JPanel jpcandle = new JPanel();
		jpcandle.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpcandle.add(jtbno1);
		jpcandle.add(jtbcandle);
		jpcandle.setBounds(400, 140, 300, 150);
		jp1.add(jpcandle);

		JPanel firecr = new JPanel();
		firecr.setLayout(new FlowLayout(FlowLayout.LEFT));
		firecr.add(jtbno2);
		firecr.add(jtbfirecracker);

		firecr.setBounds(400, 420, 300, 150);

		firecr.setBounds(400, 410, 300, 150);

		jp1.add(firecr);

		JPanel jpknife = new JPanel();
		jpknife.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpknife.add(jtbno3);
		jpknife.add(jtbknife);

		jpknife.setBounds(400, 610, 300, 150);

		jpknife.setBounds(400, 600, 300, 150);

		jp1.add(jpknife);

		JPanel panel = new JPanel();
		panel.add(cancelbtn);
		panel.add(addbtn);

		// add(title, BorderLayout.NORTH);

		add(jp1);
		add(panel, BorderLayout.SOUTH);

		setBounds(400, 0, 300, 350);


		setSize(850, 900);  // 전체 사이즈

		setSize(800, 900);

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
		//////
		btnplus1.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bcount += 1;
				String strsbcount = Integer.toString(bcount);
				bccount.setText(strsbcount);

			}

		});

		btnminus1.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (bcount > 0) {
					bcount -= 1;
				} else {
					bcount = 1;
				}

				String strbccount = Integer.toString(bcount);
				bccount.setText(strbccount);

			}

		});

		btnplus2.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				scount += 1;
				String strsccount = Integer.toString(scount);
				sccount.setText(strsccount);

			}

		});

		btnminus2.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (scount > 0) {
					scount -= 1;
				} else {
					scount = 1;
				}

				String strsccount = Integer.toString(scount);
				sccount.setText(strsccount);

			}

		});
		//////

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
				// Cart co = new Cart();
				// co.Carts(imgmenu, imgprice, quncount, temper, Size, TakeOut);
				// co.setData();
				String[] newMenu = new String[3];
				newMenu[0] = imgmenu;
				newMenu[1] = Integer.toString(quncount);
				newMenu[2] = Integer.toString(imgprice);

				String[] bcandle = new String[3];
				bcandle[0] = "큰초";
				bcandle[1] = Integer.toString(bcount);
				//bcandle[2] = "0원";
				bcandle[2] = Integer.toString(0);
				
				String[] scandle = new String[3];
				scandle[0] = "작은초";
				scandle[1] = Integer.toString(scount);
				//scandle[2] = 0+"원";
				scandle[2] = Integer.toString(0);

				String[] candle = new String[3];
				candle[0] = "초";
				//candle[1] = qcandle;
				candle[1] = Integer.toString(qcandle);
				//candle[2] = "0원";
				candle[2] = Integer.toString(0);
				
				String[] firecracker = new String[3];
				firecracker[0] = "폭죽";
				//firecracker[1] = qfirecr;
				//firecracker[2] = "0원";
				firecracker[1] = Integer.toString(qfirecr);
				firecracker[2] = Integer.toString(0);

				String[] knife = new String[3];
				knife[0] = "칼";
				//knife[1] = qknife;
				//knife[2] = "0원";
				knife[1] = Integer.toString(qknife);
				knife[2] = Integer.toString(0);

				Cart.model.addRow(newMenu);
				Cart.Qty_sum += quncount;
				Cart.Cost_sum += imgprice * quncount;
				Cart.SetIndex();

				if (jtbcandle.isSelected()) {

					Cart.model.addRow(bcandle);
					Cart.model.addRow(scandle);
				} else if (jtbno1.isSelected()) {
					Cart.model.addRow(candle);
				}
				// Cart.model.addRow(bcandle);
				// Cart.model.addRow(scandle);

				Cart.model.addRow(firecracker);
				Cart.model.addRow(knife);

				dispose();

			}

		});
	}
}
