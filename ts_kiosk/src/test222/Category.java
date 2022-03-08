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
	public Category() {
		this.setTitle("No Title");

	}

	public Category(String title) {
		createFrame(title);
		JTabbedPane pane = createTabbedPane(); //탭 패널
		JPanel pn = createPanel(); //장바구니 패널
		//this.add(pane, BorderLayout.CENTER);
		this.add(pane);
		this.add(pn);
	}
	
	
	public JPanel createPanel() {//반으로 쪼개놓은거 스플릿팬 적용 가능한지 나중에 시도
		JPanel pn = new JPanel();
		pn.setLayout(null);
		
		Orderpan sc = new Orderpan();
		sc.Orderpan();
		
		sc.setSize(550,800);
		sc.setLocation(555,50);
		pn.add(sc);

		return pn;
		
	}

	public JTabbedPane createTabbedPane() {

		// 탭 만들기
		JTabbedPane pane = new JTabbedPane();
		JTabbedPane pane2 = new JTabbedPane();
		JTabbedPane pane3 = new JTabbedPane();
		JTabbedPane pane4 = new JTabbedPane();
		JTabbedPane pane5 = new JTabbedPane();
		JTabbedPane pane6 = new JTabbedPane();
		JTabbedPane pane7 = new JTabbedPane();
		JTabbedPane pane8 = new JTabbedPane();

		JPanel jp1 = new JPanel();
		jp1.setLayout(null); // 배치관리자 설정 안함 -> 절대 위치 사용하기 위해서!!!
		jp1.setBackground(Color.GRAY);
		
		pane.setLocation(5, 3);
		pane.setSize(550, 800);
		
		pane.addTab("커피&음료", pane2);
		pane2.add("에스프레소 베리에이이션", new Panelcoff());
		pane2.addTab("티 베리에이션", new Panelcoff());
		pane2.addTab("음료", new JLabel("하이"));

		pane.addTab("아이스크림&빙수", pane3);
		pane3.addTab("아이스크림", new JLabel("하이"));
		pane3.addTab("빙수", new JLabel("하이"));

		pane.addTab("케이크", pane4);
		pane4.addTab("홀케이크", new JLabel("하이"));
		pane4.addTab("쇼트케이크", new JLabel("하이"));
		pane4.addTab("디저트", new JLabel("하이"));

		pane.addTab("델리", pane5);
		pane5.addTab("샌드위치", new JLabel("하이"));
		pane5.addTab("샐러드", new JLabel("하이"));
		pane5.addTab("기타", new JLabel("하이"));

		pane.addTab("빵", pane6);
		pane6.addTab("빵", new JLabel("하이"));
		pane6.addTab("양과자류", new JLabel("하이"));

		pane.addTab("상품", pane7);
		pane7.addTab("초콜릿", new JLabel("하이"));
		pane7.addTab("과자", new JLabel("하이"));
		pane7.addTab("상품세트", new JLabel("하이"));

		pane.addTab("MD", pane7);
		pane8.addTab("원두", new JLabel("하이"));
		pane8.addTab("원두, 티 가공상품", new JLabel("하이"));
		pane8.addTab("상시MD", new JLabel("하이"));
		pane8.addTab("시즌MD", new JLabel("하이"));
		pane8.addTab("MD선물세트", new JLabel("하이"));


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
class Orderpan extends JPanel{ // 장바구니 담을 패널
	public String Result="";
	
	public void Orderpan() {

		Cart csCart = new Cart();
		setLayout(null);
		csCart.setSize(555,800);
		csCart.setLocation(1,1);
		
		add(csCart);
	
	}
}

class Panelcoff extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[15];
	String[] menu = { "아메리카노", "카페라떼", "카페모카", "카라멜마끼아또", "카푸치노", "바닐라카페라떼", "숏카페라떼", "롱블랙", "에스프레소", "스패니쉬연유카페라떼",
			"아이스크림카페라떼", "달고나카페라떼", "콜드브루", "콜드브루라떼", "흑임자카페라떼" };
	int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000, 6500, 7000, 5500, 6000, 6500, 5500 };

	JTextField tq = new JTextField(30); //총 수량
	JTextField ts = new JTextField(40);	//총 가격

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
			ImageIcon[] img = new ImageIcon[15];
			img[0] = new ImageIcon("image/카페모카.jpg");
			img[1] = new ImageIcon("image/카페모카.jpg");
			img[2] = new ImageIcon("image/카페모카.jpg");
			img[3] = new ImageIcon("image/카페모카.jpg");
			img[4] = new ImageIcon("image/카페모카.jpg");
			img[5] = new ImageIcon("image/카페모카.jpg");
			img[6] = new ImageIcon("image/카페모카.jpg");
			img[7] = new ImageIcon("image/카페모카.jpg");
			img[8] = new ImageIcon("image/카페모카.jpg");
			img[9] = new ImageIcon("image/카페모카.jpg");
			img[10] = new ImageIcon("image/카페모카.jpg");
			img[11] = new ImageIcon("image/카페모카.jpg");
			img[12] = new ImageIcon("image/카페모카.jpg");
			img[13] = new ImageIcon("image/카페모카.jpg");
			img[14] = new ImageIcon("image/카페모카.jpg");

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
		setBackground(new Color(255, 255, 204));
		MenuBtn mbtn = new MenuBtn();// 메뉴버튼

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { //메뉴 버튼 누를 때 

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
