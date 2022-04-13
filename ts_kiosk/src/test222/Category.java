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
		JTabbedPane pane = createTabbedPane(); // �� �г�
		JPanel pn = createPanel(); // ��ٱ��� �г�
		// this.add(pane, BorderLayout.CENTER);

		this.add(pane);
		this.add(pn);
	}

	public JPanel createPanel() {// ������ �ɰ������� ���ø��� ���� �������� ���߿� �õ�
		JPanel pn = new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(250, 250, 249));
		orderPan.setSize(550, 800);
		orderPan.setLocation(555, 50);
		pn.add(orderPan);

		return pn;

	}

	public JTabbedPane createTabbedPane() {

		// �� �����
		JTabbedPane pane = new JTabbedPane();
		JTabbedPane pane2 = new JTabbedPane();
		JTabbedPane pane3 = new JTabbedPane();
		JTabbedPane pane4 = new JTabbedPane();

		JPanel jp1 = new JPanel();
		jp1.setLayout(null); // ��ġ������ ���� ���� -> ���� ��ġ ����ϱ� ���ؼ�!!!
		jp1.setBackground(new Color(250, 250, 249));

		pane.setLocation(5, 3);
		pane.setSize(550, 800);
		pane.addTab("Ŀ��&����", pane2);
		pane2.add("���������� ���������̼�", new Panelcoff());
		pane2.addTab("Ƽ �������̼�", new Paneltea());
		pane2.addTab("����", new Paneldrink());

		pane.addTab("���̽�ũ��&����", pane3);
		pane3.addTab("���̽�ũ��", new Panelicecream());

		pane.addTab("����ũ", pane4);
		pane4.addTab("Ȧ����ũ", new Panelwholecake());
		pane4.addTab("��Ʈ����ũ", new Panelshortcake());
		pane4.addTab("����Ʈ", new Paneldessert());

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

class Orderpan extends JPanel { // ��ٱ��� ���� �г�
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
	String[] menu = { "�Ƹ޸�ī��", "ī���", "ī���ī", "ī��Ḷ���ƶ�", "�ٴҶ�ī���", "��ī���", "�պ�", "����������", "����Ͻ�����ī���", "���̽�ũ��ī���",
			"�ް�ī���", "�ݵ���", "�ݵ����", "������ī���", "īǪġ��" };
	int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000, 6500, 7000, 5500, 6000, 6500, 5500 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/drink/�Ƹ޸�ī��.jpg"), new ImageIcon("image/menu/drink/ī���.jpg"),
					new ImageIcon("image/menu/drink/ī���ī.jpg"), new ImageIcon("image/menu/drink/ī��Ḷ���ƶ�.jpg"),
					new ImageIcon("image/menu/drink/�ٴҶ�ī���.jpg"), new ImageIcon("image/menu/drink/��ī���.jpg"),
					new ImageIcon("image/menu/drink/�պ�.jpg"), new ImageIcon("image/menu/drink/����������.jpg"),
					new ImageIcon("image/menu/drink/����Ͻ�����ī���.jpg"), new ImageIcon("image/menu/drink/���̽�ũ��ī���.jpg"),
					new ImageIcon("image/menu/drink/�ް�ī���.jpg"), new ImageIcon("image/menu/drink/�ݵ���.jpg"),
					new ImageIcon("image/menu/drink/�ݵ����.jpg"), new ImageIcon("image/menu/drink/������ī���.jpg"),
					new ImageIcon("image/menu/drink/īǪġ��.jpg")};

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "�ξ��ũƼ", "��Ƽ", "�׸�Ƽ��", "��׷���", "�������ڸ�Ƽ", "���ڷ���Ƽ", "�ױ۸����귺�۽�Ʈ", "������������", "ī����", "���ù�ƮƼ",
			"��Ʈ" };
	int[] price = { 5500, 5100, 5100, 5200, 6100, 6100, 5100, 4800, 5100, 5100, 6100 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/drink/�ξ��ũƼ.jpg"), new ImageIcon("image/menu/drink/��Ƽ.jpg"),
					new ImageIcon("image/menu/drink/�׸�Ƽ��.jpg"), new ImageIcon("image/menu/drink/��׷���.jpg"),
					new ImageIcon("image/menu/drink/�������ڸ�Ƽ.jpg"), new ImageIcon("image/menu/drink/���ڷ���Ƽ.jpg"),
					new ImageIcon("image/menu/drink/�ױ۸����귺�۽�Ʈ.jpg"), new ImageIcon("image/menu/drink/������������.jpg"),
					new ImageIcon("image/menu/drink/ī����.jpg"), new ImageIcon("image/menu/drink/���ù�ƮƼ.jpg"), new ImageIcon("image/menu/drink/��Ʈ.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "������", "��Ʈ����������", "�����ƿ��̵�", "�����Ⱑ���ֽ�", "ġ��ũ������⽦��ũ", "���׸��ƿ��̵�", "�ٴҶ��ũ����ũ", "����Ź����̵�", "����",
			"����������" };
	int[] price = { 5200, 5800, 6000, 6000, 6300, 6000, 5600, 6500, 5500, 5500 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/drink/������.jpg"), new ImageIcon("image/menu/drink/��Ʈ����������.jpg"),
					new ImageIcon("image/menu/drink/�����ƿ��̵�.jpg"), new ImageIcon("image/menu/drink/�����Ⱑ���ֽ�.jpg"),
					new ImageIcon("image/menu/drink/ġ��ũ������⽦��ũ.jpg"), new ImageIcon("image/menu/drink/���׸��ƿ��̵�.jpg"),
					new ImageIcon("image/menu/drink/�ٴҶ��ũ����ũ.jpg"), new ImageIcon("image/menu/drink/����Ź����̵�.jpg"),
					new ImageIcon("image/menu/drink/����.jpg"), new ImageIcon("image/menu/drink/����������.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "��ũ����Ʈ��������", "�ٴҶ��������", "�ż���Ʈ���̽�ũ��", "�ܼ���Ʈ���̽�ũ��" };
	int[] price = { 5500, 5500, 3500, 3500 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/icecream/��ũ����Ʈ��������.jpg"), 
					new ImageIcon("image/menu/icecream/�ٴҶ��������.jpg"), new ImageIcon("image/menu/icecream/�ż���Ʈ���̽�ũ��.jpg"), 
					new ImageIcon("image/menu/icecream/�ܼ���Ʈ���̽�ũ��.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "��Ʈ�κ���ġ��ٽ���", "�����Ⱑ��Ÿ��Ʈ", "Ʈ���ú�����ũ��", "����ī���׻�ũ��(�ͽ��庣��)", "��Ʈ�κ������ݸ���ũ��", "����ī����Ƽ��̼�", "����ġ��",
			"Ʈ���ü��ݶ󹫽�", "��������̹�����ũ", "����ĳ��", "��Ƽ��Ƽ��̼�", "��Ƽ�Ѿ��̽��ڽ�", "��Ƽ�ѽ�Ʈ�κ������ݸ���ũ��" };
	int[] price = { 36000, 38000, 33000, 34000, 35000, 35000, 35000, 34000, 34000, 34000, 36600, 36600, 37800 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/cake/��Ʈ�κ���ġ��ٽ���.jpg"),
					new ImageIcon("image/menu/cake/�����Ⱑ��Ÿ��Ʈ.jpg"), new ImageIcon("image/menu/cake/Ʈ���ú�����ũ��.jpg"),
					new ImageIcon("image/menu/cake/����ī���׻�ũ��(�ͽ��庣��).jpg"),
					new ImageIcon("image/menu/cake/��Ʈ�κ������ݸ���ũ��.jpg"), new ImageIcon("image/menu/cake/����ī����Ƽ��̼�.jpg"),
					new ImageIcon("image/menu/cake/����ġ��.jpg"), new ImageIcon("image/menu/cake/Ʈ���ü��ݶ󹫽�.jpg"),
					new ImageIcon("image/menu/cake/��������̹�����ũ.jpg"), new ImageIcon("image/menu/cake/����ĳ��.jpg"),
					new ImageIcon("image/menu/cake/��Ƽ��Ƽ��̼�.jpg"), new ImageIcon("image/menu/cake/��Ƽ�Ѿ��̽��ڽ�.jpg"),
					new ImageIcon("image/menu/cake/��Ƽ�ѽ�Ʈ�κ������ݸ���ũ��.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "�����ũ��ġ����÷�", "��ũ��ũ�����ݸ����÷�", "P.�����Ⱑ��Ÿ��Ʈ", "���Դ½�Ʈ�κ������ݸ���ũ��", "���Դ¾��̽��ڽ�", "���Դ°�����ũ��ũ��",
			"��ũ������Ʈ����", "P.Ʈ���ú�����ũ��", "P.���座��", "P.����ĳ��", "P.Ŭ���İ�����ݶ�", "P.������Ű��ũ��", "P.�׷򿡸�ġ���" };
	int[] price = { 9500, 9500, 7500, 6300, 6100, 6100, 6500, 6200, 6500, 6500, 6500, 5900, 6200 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/cake/�����ũ��ġ����÷�.jpg"),
					new ImageIcon("image/menu/cake/��ũ��ũ�����ݸ����÷�.jpg"), new ImageIcon("image/menu/cake/P.�����Ⱑ��Ÿ��Ʈ.jpg"),
					new ImageIcon("image/menu/cake/���Դ½�Ʈ�κ������ݸ���ũ��.jpg"), new ImageIcon("image/menu/cake/���Դ¾��̽��ڽ�.jpg"),
					new ImageIcon("image/menu/cake/���Դ°�����ũ��ũ��.jpg"), new ImageIcon("image/menu/cake/��ũ������Ʈ����.jpg"),
					new ImageIcon("image/menu/cake/P.Ʈ���ú�����ũ��.jpg"), new ImageIcon("image/menu/cake/P.���座��.jpg"),
					new ImageIcon("image/menu/cake/P.����ĳ��.jpg"), new ImageIcon("image/menu/cake/P.Ŭ���İ�����ݶ�.jpg"),
					new ImageIcon("image/menu/cake/P.������Ű��ũ��.jpg"), new ImageIcon("image/menu/cake/P.�׷򿡸�ġ���.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
	String[] menu = { "����ٴҶ�����������ũ", "���̽��ڽ�����������ũ", "���ݸ�ũ��Ĳ�ս�", "�ٴҶ�ũ��Ĳ�ս�", "ũ����(���ݸ�)", "ũ����(�ٴҶ�)", "���渶ī�ռ�Ʈ(6����)",
			"���渶ī�ռ�Ʈ(12����)", "���������ݸ���ī��", "���ٰ���ī���ٴҶ�ī��", "����Ʈ�����ø�ī��", "�ǽ�Ÿġ����ī��", "��纣����ī��", "����⸶ī��" };
	int[] price = { 3500, 3500, 4700, 4700, 5100, 5100, 14500, 28000, 2200, 2200, 2200, 2200, 2200, 2200 };

	JTextField tq = new JTextField(30); // �� ����
	JTextField ts = new JTextField(40); // �� ����

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
			ImageIcon[] img = { new ImageIcon("image/menu/cake/����ٴҶ�����������ũ.jpg"),
					new ImageIcon("image/menu/cake/���̽��ڽ�����������ũ.jpg"), new ImageIcon("image/menu/cake/���ݸ�ũ��Ĳ�ս�.jpg"),
					new ImageIcon("image/menu/cake/�ٴҶ�ũ��Ĳ�ս�.jpg"), new ImageIcon("image/menu/cake/ũ����(���ݸ�).jpg"),
					new ImageIcon("image/menu/cake/ũ����(�ٴҶ�).jpg"), new ImageIcon("image/menu/cake/���渶ī�ռ�Ʈ(6����).jpg"),
					new ImageIcon("image/menu/cake/���渶ī�ռ�Ʈ(12����).jpg"), new ImageIcon("image/menu/cake/���������ݸ���ī��.jpg"),
					new ImageIcon("image/menu/cake/���ٰ���ī���ٴҶ�ī��.jpg"), new ImageIcon("image/menu/cake/����Ʈ�����ø�ī��.jpg"),
					new ImageIcon("image/menu/cake/�ǽ�Ÿġ����ī��.jpg"), new ImageIcon("image/menu/cake/��纣����ī��.jpg"),
					new ImageIcon("image/menu/cake/����⸶ī��.jpg") };

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
		MenuBtn mbtn = new MenuBtn();// �޴���ư

		mbtn.setSize(510, 650);
		mbtn.setLocation(5, 5);
		add(mbtn);
		for (int i = 0; i < MBtn.length; i++) {
			final int index = i;

			MBtn[i].addActionListener(new ActionListener() { // �޴� ��ư ���� ��

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
