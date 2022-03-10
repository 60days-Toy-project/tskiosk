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
		JTabbedPane pane = createTabbedPane(); // �� �г�
		JPanel pn = createPanel(); // ��ٱ��� �г�
		// this.add(pane, BorderLayout.CENTER);
		this.add(pane);
		this.add(pn);
	}

	public JPanel createPanel() {// ������ �ɰ������� ���ø��� ���� �������� ���߿� �õ�
		JPanel pn = new JPanel();
		pn.setLayout(null);

		Orderpan sc = new Orderpan();
		sc.Orderpan();

		sc.setSize(550, 800);
		sc.setLocation(555, 50);
		pn.add(sc);

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
		jp1.setBackground(Color.GRAY);

		pane.setLocation(5, 3);
		pane.setSize(550, 800);

		pane.addTab("Ŀ��&����", pane2);
		pane2.add("���������� ���������̼�", new Panelcoff());
		pane2.addTab("Ƽ �������̼�", new Paneltea());
		pane2.addTab("����", new Paneldrink());

		pane.addTab("���̽�ũ��&����", pane3);
		pane3.addTab("���̽�ũ��", new Panelicecream());
		

		pane.addTab("����ũ", pane4);
		pane4.addTab("Ȧ����ũ", new JLabel("����"));
		pane4.addTab("��Ʈ����ũ", new JLabel("����"));
		pane4.addTab("����Ʈ", new JLabel("����"));


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
	public String Result = "";

	public void Orderpan() {

		Cart csCart = new Cart();
		setLayout(null);
		csCart.setSize(555, 800);
		csCart.setLocation(1, 1);

		add(csCart);

	}
}

class Panelcoff extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[15];
	String[] menu = { "�Ƹ޸�ī��", "ī���", "ī���ī", "ī��Ḷ���ƶ�", "�ٴҶ�ī���", "��ī���", "�պ�", "����������", "���дϽ�����ī���",
			"���̽�ũ��ī���", "�ް�ī���", "�ݵ���", "�ݵ����", "������ī���", "īǪġ��" };
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
			ImageIcon[] img = new ImageIcon[15];
			img[0] = new ImageIcon("image/�Ƹ޸�ī��.jpg");
			img[1] = new ImageIcon("image/ī���.jpg");
			img[2] = new ImageIcon("image/ī���ī.jpg");
			img[3] = new ImageIcon("image/ī��Ḷ���ƶ�.jpg");
			img[4] = new ImageIcon("image/�ٴҶ�ī���.jpg");
			img[5] = new ImageIcon("image/��ī���.jpg");
			img[6] = new ImageIcon("image/�պ�.jpg");
			img[7] = new ImageIcon("image/����������.jpg");
			img[8] = new ImageIcon("image/����Ͻ�����ī���.jpg");
			img[9] = new ImageIcon("image/���̽�ũ��ī���.jpg");
			img[10] = new ImageIcon("image/�ް�ī���.jpg");
			img[11] = new ImageIcon("image/�ݵ���.jpg");
			img[12] = new ImageIcon("image/�ݵ����.jpg");
			img[13] = new ImageIcon("image/������ī���.jpg");
			img[14] = new ImageIcon("image/īǪġ��.jpg");

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
	int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000, 6500, 6500 };

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
			ImageIcon[] img = { new ImageIcon("image/�ξ��ũƼ.jpg"), new ImageIcon("image/��Ƽ.jpg"),
					new ImageIcon("image/�׸�Ƽ��.jpg"), new ImageIcon("image/��׷���.jpg"),
					new ImageIcon("image/�������ڸ�Ƽ.jpg"), new ImageIcon("image/���ڷ���Ƽ.jpg"),
					new ImageIcon("image/�ױ۸����귺�۽�Ʈ.jpg"), new ImageIcon("image/������������.jpg"),
					new ImageIcon("image/ī����.jpg"), new ImageIcon("image/���ù�ƮƼ.jpg"), new ImageIcon("image/��Ʈ.jpg") };

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
		setBackground(new Color(255, 255, 204));
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

class Paneldrink extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[10];
	String[] menu = { "������", "��Ʈ����������", "�����ƿ��̵�", "�����Ⱑ���ֽ�", "ġ��ũ������⽦��ũ", "���׸��ƿ��̵�", "�ٴҶ��ũ����ũ", "����Ź����̵�",
			"����", "����������" };
	int[] price = { 4500, 5000, 5500, 5900, 6000, 5500, 5500, 6500, 5000, 6500 };

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
			ImageIcon[] img = { new ImageIcon("image/������.jpg"), new ImageIcon("image/��Ʈ����������.jpg"),
					new ImageIcon("image/�����ƿ��̵�.jpg"), new ImageIcon("image/�����Ⱑ���ֽ�.jpg"),
					new ImageIcon("image/ġ��ũ������⽦��ũ.jpg"), new ImageIcon("image/���׸��ƿ��̵�.jpg"),
					new ImageIcon("image/�ٴҶ��ũ����ũ.jpg"), new ImageIcon("image/����Ź����̵�.jpg"),
					new ImageIcon("image/����.jpg"), new ImageIcon("image/����������.jpg") };

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
		setBackground(new Color(255, 255, 204));
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
class Panelicecream extends JPanel {

	public int OPflag = 0;

	JButton[] MBtn = new JButton[4];
	String[] menu = { "��ũ����Ʈ��������", "�ٴҶ��������", "�ż���Ʈ���̽�ũ��", "�ܼ���Ʈ���̽�ũ��"};
	int[] price = { 4500, 5000, 5500, 5900 };

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
			ImageIcon[] img = { 
					new ImageIcon("image/��ũ����Ʈ��������.jpg"), new ImageIcon("image/�ٴҶ��������.jpg"),
					new ImageIcon("image/�ż���Ʈ���̽�ũ��.jpg"), new ImageIcon("image/�ܼ���Ʈ���̽�ũ��.jpg")};

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
		setBackground(new Color(255, 255, 204));
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
					ops.Icrcreamextra(menu[index], price[index]);

				}
			});
		}

	}

}
