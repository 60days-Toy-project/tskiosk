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
		
				
		//탭 만들기
		JTabbedPane pane = new JTabbedPane();
		JTabbedPane pane2 = new JTabbedPane();
		JTabbedPane pane3 = new JTabbedPane();
		JTabbedPane pane4 = new JTabbedPane();
		JTabbedPane pane5 = new JTabbedPane();
		JTabbedPane pane6 = new JTabbedPane();
		JTabbedPane pane7 = new JTabbedPane();
		JTabbedPane pane8 = new JTabbedPane();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null); //배치관리자 설정 안함 -> 절대 위치 사용하기 위해서!!!				
		jp1.setBackground(Color.GRAY);
		
		//커피&음료 버튼 생성
		ImageIcon icon1 = new ImageIcon("image/콜드브루.jpg");
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu1 = new JButton("콜드브루", new ImageIcon(changeImg1));
				
		ImageIcon icon2 = new ImageIcon("image/카페라떼.jpg");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu2 = new JButton("카페라떼", new ImageIcon(changeImg2));
				
		ImageIcon icon3 = new ImageIcon("image/카페모카.jpg");
		Image img3 = icon3.getImage();
		Image changeImg3 = img3.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu3 = new JButton("카페모카", new ImageIcon(changeImg3));
		
		ImageIcon icon4 = new ImageIcon("image/달고나라떼.jpg");
		Image img4 = icon4.getImage();
		Image changeImg4 = img4.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu4 = new JButton("달고나라떼", new ImageIcon(changeImg4));
		
		ImageIcon icon5 = new ImageIcon("image/아이스크림카페라떼.jpg");
		Image img5 = icon5.getImage();
		Image changeImg5 = img5.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		JButton coffee_menu5 = new JButton("아이스크림카페라떼", new ImageIcon(changeImg5));
		
		
		
						
		//JButton coffee_menu1 = new JButton("카페라떼", new ImageIcon("image/카페라떼.jpg"));
		
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
       
        
        //주문버튼, 처음으로 돌아가기 버튼
		JButton order_btn=new JButton("주문하기"); //주문 버튼
		JButton ret_btn=new JButton("처음으로"); // 처음으로 돌아가기 버튼
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
		pane.addTab("커피&음료", pane2);
		pane2.add("에스프레소 베리에이이션", jp1);
		//pane2.addTab("에스프레소 베리에이션", new JLabel("하이"));
		pane2.addTab("티 베리에이션", new JLabel("하이"));
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
		
		
		//pane.addTab("커피&음료", new JLabel("Tab menu 1"));
		//pane.addTab("아이스크립&빙수", new JLabel("Tab menu 2"));
		//pane.addTab("케이크", new JLabel("Tab menu 3"));
		//pane.addTab("델리", new JLabel("Tab menu 4"));
		//pane.addTab("상품", new JLabel("Tab menu 5"));
		
	    ret_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int result = JOptionPane.showConfirmDialog(null, "처음으로 돌아가시겠습니까?",
            			"알림", JOptionPane.YES_NO_OPTION);
            	if (result==JOptionPane.YES_OPTION) {
            		FirstScreen fs = new FirstScreen();
            		fs.disScreen();
                    setVisible(false); // 창 안보이게 하기 
            		
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
