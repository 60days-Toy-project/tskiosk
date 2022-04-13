package test222;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Category extends JFrame {

	private JPanel orderPan = new Orderpan(this);

	public Category() {
		this.setTitle("No Title");

	}

	public Category(String title) {
		createFrame(title);
		JTabbedPane pane = createTabbedPane(); // 탭 패널
		JPanel pn = createPanel(); // 장바구니 패널
		// this.add(pane, BorderLayout.CENTER);

		this.add(pane);
		this.add(pn);
	}

	public JPanel createPanel() {// 반으로 쪼개놓은거 스플릿팬 적용 가능한지 나중에 시도
		JPanel pn = new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(250, 250, 249));
		orderPan.setSize(550, 800);
		orderPan.setLocation(555, 50);
		pn.add(orderPan);

		return pn;

	}

	public JTabbedPane createTabbedPane() {

		// 탭 만들기
		JTabbedPane pane = new JTabbedPane();
		JTabbedPane pane2 = new JTabbedPane();
		JTabbedPane pane3 = new JTabbedPane();
		JTabbedPane pane4 = new JTabbedPane();

		JPanel jp1 = new JPanel();
		jp1.setLayout(null); // 배치관리자 설정 안함 -> 절대 위치 사용하기 위해서!!!
		jp1.setBackground(new Color(250, 250, 249));

		pane.setLocation(5, 3);
		pane.setSize(550, 800);
		pane.addTab("커피&음료", pane2);
		pane2.add("에스프레소 베리에이이션", new Panelcoff());
		pane2.addTab("티 베리에이션", new Paneltea());
		pane2.addTab("음료", new Paneldrink());

		pane.addTab("아이스크림&빙수", pane3);
		pane3.addTab("아이스크림", new Panelicecream());

		pane.addTab("케이크", pane4);
		pane4.addTab("홀케이크", new Panelwholecake());
		pane4.addTab("쇼트케이크", new Panelshortcake());
		pane4.addTab("디저트", new Paneldessert());

		return pane;
	}

	void createFrame(String title) {

		this.setTitle(title);
		this.setSize(1105, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class Orderpan extends JPanel { // 장바구니 담을 패널
	private JFrame f;
	public String Result = "";

	public Orderpan(JFrame f) {
		this.f = f;
		Cart csCart = new Cart(f);
		setLayout(null);
		csCart.setSize(555, 800);
		csCart.setLocation(1, 1);

		add(csCart);

	}
}

class Panelcoff extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[15];
	String[] menu = { "아메리카노", "카페라떼", "카페모카", "카라멜마끼아또", "바닐라카페라떼", "숏카페라떼", "롱블랙", "에스프레소", "스페니쉬연유카페라떼", "아이스크림카페라떼",
			"달고나카페라떼", "콜드브루", "콜드브루라떼", "흑임자카페라떼", "카푸치노" };
	int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000, 6500, 7000, 5500, 6000, 6500, 5500 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);

	Image[] icon = new Image[15];
	Image[] newimg = new Image[15];
	ImageIcon[] newicon = new ImageIcon[15];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel njp2 = new JPanel();
			njp2.setLayout(new GridLayout(5, 3, 3, 3));
			setLayout(new GridLayout(1, 1));
			njp2.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/drink/아메리카노.jpg"), new ImageIcon("image/menu/drink/카페라떼.jpg"),
					new ImageIcon("image/menu/drink/카페모카.jpg"), new ImageIcon("image/menu/drink/카라멜마끼아또.jpg"),
					new ImageIcon("image/menu/drink/바닐라카페라떼.jpg"), new ImageIcon("image/menu/drink/숏카페라떼.jpg"),
					new ImageIcon("image/menu/drink/롱블랙.jpg"), new ImageIcon("image/menu/drink/에스프레소.jpg"),
					new ImageIcon("image/menu/drink/스페니쉬연유카페라떼.jpg"), new ImageIcon("image/menu/drink/아이스크림카페라떼.jpg"),
					new ImageIcon("image/menu/drink/달고나카페라떼.jpg"), new ImageIcon("image/menu/drink/콜드브루.jpg"),
					new ImageIcon("image/menu/drink/콜드브루라떼.jpg"), new ImageIcon("image/menu/drink/흑임자카페라떼.jpg"),
					new ImageIcon("image/menu/drink/카푸치노.jpg")};

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				njp2.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(njp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Panelcoff() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;

					OptionSelction ops = new OptionSelction();
					ops.extra(menu[index], price[index]);

				}
			});
		}

	}

}

class Paneltea extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[11];
	String[] menu = { "로얄밀크티", "블랙티", "그린티라떼", "얼그레이", "오렌지자몽티", "유자레몬티", "잉글리쉬브렉퍼스트", "제주유기농녹차", "카모마일", "애플민트티",
			"민트" };
	int[] price = { 5500, 5100, 5100, 5200, 6100, 6100, 5100, 4800, 5100, 5100, 6100 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);
	Image[] icon = new Image[11];
	Image[] newimg = new Image[11];
	ImageIcon[] newicon = new ImageIcon[11];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel tjp = new JPanel();
			tjp.setLayout(new GridLayout(5, 3, 3, 3));
			setLayout(new GridLayout(1, 1));
			tjp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/drink/로얄밀크티.jpg"), new ImageIcon("image/menu/drink/블랙티.jpg"),
					new ImageIcon("image/menu/drink/그린티라떼.jpg"), new ImageIcon("image/menu/drink/얼그레이.jpg"),
					new ImageIcon("image/menu/drink/오렌지자몽티.jpg"), new ImageIcon("image/menu/drink/유자레몬티.jpg"),
					new ImageIcon("image/menu/drink/잉글리쉬브렉퍼스트.jpg"), new ImageIcon("image/menu/drink/제주유기농녹차.jpg"),
					new ImageIcon("image/menu/drink/카모마일.jpg"), new ImageIcon("image/menu/drink/애플민트티.jpg"), new ImageIcon("image/menu/drink/민트.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				tjp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(tjp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Paneltea() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;

					OptionSelction ops = new OptionSelction();
					ops.extra2(menu[index], price[index]);

				}
			});
		}

	}

}

class Paneldrink extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[10];
	String[] menu = { "고구마라떼", "민트초코프라페", "복숭아에이드", "생딸기가득주스", "치즈크럼블딸기쉐이크", "샹그리아에이드", "바닐라밀크쉐이크", "레몬셔벗에이드", "쑥라떼",
			"망고프라페" };
	int[] price = { 5200, 5800, 6000, 6000, 6300, 6000, 5600, 6500, 5500, 5500 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);

	Image[] icon = new Image[10];
	Image[] newimg = new Image[10];
	ImageIcon[] newicon = new ImageIcon[10];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel djp = new JPanel();
			djp.setLayout(new GridLayout(4, 3, 3, 3));
			setLayout(new GridLayout(1, 1));
			djp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/drink/고구마라떼.jpg"), new ImageIcon("image/menu/drink/민트초코프라페.jpg"),
					new ImageIcon("image/menu/drink/복숭아에이드.jpg"), new ImageIcon("image/menu/drink/생딸기가득주스.jpg"),
					new ImageIcon("image/menu/drink/치즈크럼블딸기쉐이크.jpg"), new ImageIcon("image/menu/drink/샹그리아에이드.jpg"),
					new ImageIcon("image/menu/drink/바닐라밀크쉐이크.jpg"), new ImageIcon("image/menu/drink/레몬셔벗에이드.jpg"),
					new ImageIcon("image/menu/drink/쑥라떼.jpg"), new ImageIcon("image/menu/drink/망고프라페.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				djp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(djp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Paneldrink() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;

					OptionSelction ops = new OptionSelction();
					ops.extra2(menu[index], price[index]);

				}
			});
		}

	}

}

class Panelicecream extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[4];
	String[] menu = { "밀크소프트아포가토", "바닐라아포가토", "컵소프트아이스크림", "콘소프트아이스크림" };
	int[] price = { 5500, 5500, 3500, 3500 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);

	Image[] icon = new Image[4];
	Image[] newimg = new Image[4];
	ImageIcon[] newicon = new ImageIcon[4];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel ijp = new JPanel();
			ijp.setLayout(new GridLayout(2, 3, 3, 3));
			setLayout(new GridLayout(1, 1));
			ijp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/icecream/밀크소프트아포가토.jpg"), 
					new ImageIcon("image/menu/icecream/바닐라아포가토.jpg"), new ImageIcon("image/menu/icecream/컵소프트아이스크림.jpg"), 
					new ImageIcon("image/menu/icecream/콘소프트아이스크림.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				ijp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(ijp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Panelicecream() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();

					OptionSelction ops = new OptionSelction();
					ops.Icecreamextra(menu[index], price[index]);

				}
			});
		}

	}

}

class Panelwholecake extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[13];
	String[] menu = { "스트로베리치즈바스켓", "생딸기가득타르트", "트리플베리생크림", "마스카포네생크림(믹스드베리)", "스트로베리초콜릿생크림", "마스카포네티라미수", "뉴욕치즈",
			"트리플쇼콜라무스", "몽블랑보늬밤케이크", "퀸즈캐롯", "파티팩티라미수", "파티팩아이스박스", "파티팩스트로베리초콜릿생크림" };
	int[] price = { 36000, 38000, 33000, 34000, 35000, 35000, 35000, 34000, 34000, 34000, 36600, 36600, 37800 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);
	Image[] icon = new Image[13];
	Image[] newimg = new Image[13];
	ImageIcon[] newicon = new ImageIcon[13];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel wjp = new JPanel();
			wjp.setLayout(new GridLayout(7, 2, 3, 3));
			setLayout(new GridLayout(1, 1));
			wjp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/cake/스트로베리치즈바스켓.jpg"),
					new ImageIcon("image/menu/cake/생딸기가득타르트.jpg"), new ImageIcon("image/menu/cake/트리플베리생크림.jpg"),
					new ImageIcon("image/menu/cake/마스카포네생크림(믹스드베리).jpg"),
					new ImageIcon("image/menu/cake/스트로베리초콜릿생크림.jpg"), new ImageIcon("image/menu/cake/마스카포네티라미수.jpg"),
					new ImageIcon("image/menu/cake/뉴욕치즈.jpg"), new ImageIcon("image/menu/cake/트리플쇼콜라무스.jpg"),
					new ImageIcon("image/menu/cake/몽블랑보늬밤케이크.jpg"), new ImageIcon("image/menu/cake/퀸즈캐롯.jpg"),
					new ImageIcon("image/menu/cake/파티팩티라미수.jpg"), new ImageIcon("image/menu/cake/파티팩아이스박스.jpg"),
					new ImageIcon("image/menu/cake/파티팩스트로베리초콜릿생크림.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				wjp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(wjp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Panelwholecake() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;

					OptionSelction ops = new OptionSelction();
					ops.Cakeextra(menu[index], price[index]);

				}
			});
		}

	}

}

class Panelshortcake extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[13];
	String[] menu = { "딸기생크림치즈수플레", "밀크생크림초콜릿수플레", "P.생딸기가득타르트", "떠먹는스트로베리초콜릿생크림", "떠먹는아이스박스", "떠먹는고구마밀크생크림",
			"생크림소프트쉬폰", "P.트리플베리생크림", "P.레드벨벳", "P.퀸즈캐롯", "P.클래식가토쇼콜라", "P.모어댄쿠키앤크림", "P.그뤼에르치즈무스" };
	int[] price = { 9500, 9500, 7500, 6300, 6100, 6100, 6500, 6200, 6500, 6500, 6500, 5900, 6200 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);
	Image[] icon = new Image[13];
	Image[] newimg = new Image[13];
	ImageIcon[] newicon = new ImageIcon[13];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel sjp = new JPanel();
			sjp.setLayout(new GridLayout(7, 2, 3, 3));
			setLayout(new GridLayout(1, 1));
			sjp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/cake/딸기생크림치즈수플레.jpg"),
					new ImageIcon("image/menu/cake/밀크생크림초콜릿수플레.jpg"), new ImageIcon("image/menu/cake/P.생딸기가득타르트.jpg"),
					new ImageIcon("image/menu/cake/떠먹는스트로베리초콜릿생크림.jpg"), new ImageIcon("image/menu/cake/떠먹는아이스박스.jpg"),
					new ImageIcon("image/menu/cake/떠먹는고구마밀크생크림.jpg"), new ImageIcon("image/menu/cake/생크림소프트쉬폰.jpg"),
					new ImageIcon("image/menu/cake/P.트리플베리생크림.jpg"), new ImageIcon("image/menu/cake/P.레드벨벳.jpg"),
					new ImageIcon("image/menu/cake/P.퀸즈캐롯.jpg"), new ImageIcon("image/menu/cake/P.클래식가토쇼콜라.jpg"),
					new ImageIcon("image/menu/cake/P.모어댄쿠키앤크림.jpg"), new ImageIcon("image/menu/cake/P.그뤼에르치즈무스.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				sjp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(sjp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Panelshortcake() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;

					OptionSelction ops = new OptionSelction();
					ops.ShorCakeextra(menu[index], price[index]);

				}
			});
		}

	}

}

class Paneldessert extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[14];
	String[] menu = { "딸기바닐라프로즌케이크", "아이스박스프로즌케이크", "초콜릿크로캉롱슈", "바닐라크로캉롱슈", "크렘슈(초콜릿)", "크렘슈(바닐라)", "투썸마카롱세트(6개입)",
			"투썸마카롱세트(12개입)", "벨지안초콜릿마카롱", "마다가스카르바닐라마카롱", "망고트로피컬마카롱", "피스타치오마카롱", "블루베리마카롱", "산딸기마카롱" };
	int[] price = { 3500, 3500, 4700, 4700, 5100, 5100, 14500, 28000, 2200, 2200, 2200, 2200, 2200, 2200 };

	JTextField tq = new JTextField(30); // 총 수량
	JTextField ts = new JTextField(40); // 총 가격

	JTextField t = new JTextField(10);
	Image[] icon = new Image[14];
	Image[] newimg = new Image[14];
	ImageIcon[] newicon = new ImageIcon[14];

	class MenuBtn extends JPanel {
		MenuBtn() {
			JPanel dejp = new JPanel();
			dejp.setLayout(new GridLayout(7, 2, 3, 3));
			setLayout(new GridLayout(1, 1));
			dejp.setBackground(Color.WHITE);
			setBackground(Color.WHITE);
			ImageIcon[] img = { new ImageIcon("image/menu/cake/딸기바닐라프로즌케이크.jpg"),
					new ImageIcon("image/menu/cake/아이스박스프로즌케이크.jpg"), new ImageIcon("image/menu/cake/초콜릿크로캉롱슈.jpg"),
					new ImageIcon("image/menu/cake/바닐라크로캉롱슈.jpg"), new ImageIcon("image/menu/cake/크렘슈(초콜릿).jpg"),
					new ImageIcon("image/menu/cake/크렘슈(바닐라).jpg"), new ImageIcon("image/menu/cake/투썸마카롱세트(6개입).jpg"),
					new ImageIcon("image/menu/cake/투썸마카롱세트(12개입).jpg"), new ImageIcon("image/menu/cake/벨지안초콜릿마카롱.jpg"),
					new ImageIcon("image/menu/cake/마다가스카르바닐라마카롱.jpg"), new ImageIcon("image/menu/cake/망고트로피컬마카롱.jpg"),
					new ImageIcon("image/menu/cake/피스타치오마카롱.jpg"), new ImageIcon("image/menu/cake/블루베리마카롱.jpg"),
					new ImageIcon("image/menu/cake/산딸기마카롱.jpg") };

			for (int i = 0; i < img.length; i++) {
				icon[i] = img[i].getImage();
				newimg[i] = icon[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				newicon[i] = new ImageIcon(newimg[i]);
			}
			for (int i = 0; i < MBtn.length; i++) {
				MBtn[i] = new JButton(menu[i], newicon[i]);
				MBtn[i].setVerticalTextPosition(JButton.BOTTOM);
				MBtn[i].setHorizontalTextPosition(JButton.CENTER);

				MBtn[i].setBorderPainted(true);
				MBtn[i].setContentAreaFilled(false);
				dejp.add(MBtn[i]);
			}
			JScrollPane scrollSingle = new JScrollPane(dejp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

			add(scrollSingle);
		}
	}

	public Paneldessert() {
		setLayout(null);
		setBackground(new Color(250, 250, 249));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // 메뉴 버튼 누를 때

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton) e.getSource();
					int quantity = 0;
					int sum = 0;
					
					
					OptionSelction ops = new OptionSelction();
					ops.Dessertextra(menu[index], price[index]);

				}
			});
		}

	}

}
