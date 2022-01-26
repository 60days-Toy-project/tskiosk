package test222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Category extends JFrame {
	public Category() {
		this.setTitle("No Title");
		
		
	}
	
	public Category(String title) {
		createFrame(title);
		JTabbedPane pane = createTabbedPane();
		//this.add(pane, BorderLayout.CENTER);
		this.add(pane);
	}
	

	
	public JTabbedPane createTabbedPane() {
		
				
		//�� �����
		JTabbedPane pane = new JTabbedPane();
		JTabbedPane pane2 = new JTabbedPane();
		JTabbedPane pane3 = new JTabbedPane();
		JTabbedPane pane4 = new JTabbedPane();
		JTabbedPane pane5 = new JTabbedPane();
		JTabbedPane pane6 = new JTabbedPane();
		JTabbedPane pane7 = new JTabbedPane();
		JTabbedPane pane8 = new JTabbedPane();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null); //��ġ������ ���� ���� -> ���� ��ġ ����ϱ� ���ؼ�!!!				
		jp1.setBackground(Color.GRAY);
		
		//Ŀ��&���� ��ư ����
		ImageIcon icon1 = new ImageIcon("image/�ݵ���.jpg");
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu1 = new JButton("�ݵ���", new ImageIcon(changeImg1));
				
		ImageIcon icon2 = new ImageIcon("image/ī���.jpg");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu2 = new JButton("ī���", new ImageIcon(changeImg2));
				
		ImageIcon icon3 = new ImageIcon("image/ī���ī.jpg");
		Image img3 = icon3.getImage();
		Image changeImg3 = img3.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu3 = new JButton("ī���ī", new ImageIcon(changeImg3));
		
		ImageIcon icon4 = new ImageIcon("image/�ް���.jpg");
		Image img4 = icon4.getImage();
		Image changeImg4 = img4.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu4 = new JButton("�ް���", new ImageIcon(changeImg4));
		
		ImageIcon icon5 = new ImageIcon("image/���̽�ũ��ī���.jpg");
		Image img5 = icon5.getImage();
		Image changeImg5 = img5.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu5 = new JButton("���̽�ũ��ī���", new ImageIcon(changeImg5));
		
		
		
						
		//JButton coffee_menu1 = new JButton("ī���", new ImageIcon("image/ī���.jpg"));
		
		coffee_menu1.setVerticalTextPosition(JButton.BOTTOM);
        coffee_menu1.setHorizontalTextPosition(JButton.CENTER);
        coffee_menu2.setVerticalTextPosition(JButton.BOTTOM);
        coffee_menu2.setHorizontalTextPosition(JButton.CENTER);
        coffee_menu3.setVerticalTextPosition(JButton.BOTTOM);
        coffee_menu3.setHorizontalTextPosition(JButton.CENTER);
        coffee_menu4.setVerticalTextPosition(JButton.BOTTOM);
        coffee_menu4.setHorizontalTextPosition(JButton.CENTER);
        coffee_menu5.setVerticalTextPosition(JButton.BOTTOM);
        coffee_menu5.setHorizontalTextPosition(JButton.CENTER);
       
        
        //�ֹ���ư, ó������ ���ư��� ��ư
		JButton order_btn=new JButton("�ֹ��ϱ�"); //�ֹ� ��ư
		JButton ret_btn=new JButton("ó������"); // ó������ ���ư��� ��ư
		JButton left_btn = new JButton(new ImageIcon("image/left.jpg"));
		JButton right_btn = new JButton(new ImageIcon("image/right.jpg"));
		
		coffee_menu1.setBounds(10,10, 130, 190);
		coffee_menu2.setBounds(150,10, 130, 190);
		coffee_menu3.setBounds(290,10, 130, 190);
		coffee_menu4.setBounds(10,210, 130, 190);
		coffee_menu5.setBounds(10,410, 130, 190);
		
		
	    order_btn.setBounds(440, 710, 130, 30);
	    ret_btn.setBounds(480,745,90,30);
	    left_btn.setBounds(150,700,70,70);
	    right_btn.setBounds(250,700,70,70);
	    
	    jp1.add(coffee_menu1);
	    jp1.add(coffee_menu2);
	    jp1.add(coffee_menu3);
	    jp1.add(coffee_menu4);
	    jp1.add(coffee_menu5);
	    
		jp1.add(order_btn); 
		jp1.add(ret_btn);
		jp1.add(left_btn);
		jp1.add(right_btn);
		/////////////////////////////////
		pane.addTab("Ŀ��&����", pane2);
		pane2.add("���������� ���������̼�", jp1);
		//pane2.addTab("���������� �������̼�", new JLabel("����"));
		pane2.addTab("Ƽ �������̼�", new JLabel("����"));
		pane2.addTab("����", new JLabel("����"));
			        
				
		pane.addTab("���̽�ũ��&����", pane3);
		pane3.addTab("���̽�ũ��", new JLabel("����"));
		pane3.addTab("����", new JLabel("����"));
	
		pane.addTab("����ũ", pane4);
		pane4.addTab("Ȧ����ũ", new JLabel("����"));
		pane4.addTab("��Ʈ����ũ", new JLabel("����"));
		pane4.addTab("����Ʈ", new JLabel("����"));
		
		pane.addTab("����", pane5);
		pane5.addTab("������ġ", new JLabel("����"));
		pane5.addTab("������", new JLabel("����"));
		pane5.addTab("��Ÿ", new JLabel("����"));
		
		pane.addTab("��", pane6);
		pane6.addTab("��", new JLabel("����"));
		pane6.addTab("����ڷ�", new JLabel("����"));
		
		pane.addTab("��ǰ", pane7);
		pane7.addTab("���ݸ�", new JLabel("����"));
		pane7.addTab("����", new JLabel("����"));
		pane7.addTab("��ǰ��Ʈ", new JLabel("����"));
		
		pane.addTab("MD", pane7);
		pane8.addTab("����", new JLabel("����"));
		pane8.addTab("����, Ƽ ������ǰ", new JLabel("����"));
		pane8.addTab("���MD", new JLabel("����"));
		pane8.addTab("����MD", new JLabel("����"));
		pane8.addTab("MD������Ʈ", new JLabel("����"));
		
		
		//pane.addTab("Ŀ��&����", new JLabel("Tab menu 1"));
		//pane.addTab("���̽�ũ��&����", new JLabel("Tab menu 2"));
		//pane.addTab("����ũ", new JLabel("Tab menu 3"));
		//pane.addTab("����", new JLabel("Tab menu 4"));
		//pane.addTab("��ǰ", new JLabel("Tab menu 5"));
		
	    ret_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int result = JOptionPane.showConfirmDialog(null, "ó������ ���ư��ðڽ��ϱ�?",
            			"�˸�", JOptionPane.YES_NO_OPTION);
            	if (result==JOptionPane.YES_OPTION) {
            		FirstScreen fs = new FirstScreen();
            		fs.disScreen();
                    setVisible(false); // â �Ⱥ��̰� �ϱ� 
            		
            	}
           		 		
            	
            }
        });
	    
	             
	
		
		return pane;
	}
	

		  
	void createFrame(String title) {
		
		this.setTitle(title);
		this.setSize(600,900);
		//this.setContentPane(new Category());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.setLayout(new BorderLayout());
		this.setVisible(true);
	}


}
