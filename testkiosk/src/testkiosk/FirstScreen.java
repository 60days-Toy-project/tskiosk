package testkiosk;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FirstScreen {
	public void disScreen() {
		JFrame frm = new JFrame("TwoSome Kiosk");
		 
        // 프레임 크기 설정
        frm.setSize(600, 900);
 
        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
 
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
 
        ImageIcon icon = new ImageIcon("image/ts1.jpg");
		Image im = icon.getImage();
		im=im.getScaledInstance(600,300,Image.SCALE_SMOOTH);
		icon = new ImageIcon(im);
		
		JLabel label = new JLabel(icon);
		frm.add(label);
		label.setBounds(0,0,600,300);
		        
        // 버튼 생성
        JButton btn1 = new JButton("주문을 하시려면 화면을 터치해주세요.");
       
 
        // ★ 버튼 위치와 크기 설정
        btn1.setBounds(0, 300, 600, 300);
        btn1.setBackground(Color.PINK); 
 
        // ★ 프레임에다가 버튼 추가
        frm.getContentPane().add(btn1);
        
        ImageIcon icon2 = new ImageIcon("image/ts3.jpg");
		Image im2 = icon2.getImage();
		im2=im2.getScaledInstance(600,300,Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(im2);
		
		JLabel label2 = new JLabel(icon2);
		frm.add(label2);
		label2.setBounds(0,600,600,300);
        
 
        // 프레임이 보이도록 설정
        frm.setVisible(true);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Category("A TWOSOME PLACE");
                frm.setVisible(false); // 창 안보이게 하기 
            }
        });
        
       
 
	}



}
