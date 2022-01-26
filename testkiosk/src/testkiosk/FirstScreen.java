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
		 
        // ������ ũ�� ����
        frm.setSize(600, 900);
 
        // �������� ȭ�� ����� ��ġ
        frm.setLocationRelativeTo(null);
 
        // �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // ���̾ƿ� ����
        frm.getContentPane().setLayout(null);
 
        ImageIcon icon = new ImageIcon("image/ts1.jpg");
		Image im = icon.getImage();
		im=im.getScaledInstance(600,300,Image.SCALE_SMOOTH);
		icon = new ImageIcon(im);
		
		JLabel label = new JLabel(icon);
		frm.add(label);
		label.setBounds(0,0,600,300);
		        
        // ��ư ����
        JButton btn1 = new JButton("�ֹ��� �Ͻ÷��� ȭ���� ��ġ���ּ���.");
       
 
        // �� ��ư ��ġ�� ũ�� ����
        btn1.setBounds(0, 300, 600, 300);
        btn1.setBackground(Color.PINK); 
 
        // �� �����ӿ��ٰ� ��ư �߰�
        frm.getContentPane().add(btn1);
        
        ImageIcon icon2 = new ImageIcon("image/ts3.jpg");
		Image im2 = icon2.getImage();
		im2=im2.getScaledInstance(600,300,Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(im2);
		
		JLabel label2 = new JLabel(icon2);
		frm.add(label2);
		label2.setBounds(0,600,600,300);
        
 
        // �������� ���̵��� ����
        frm.setVisible(true);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Category("A TWOSOME PLACE");
                frm.setVisible(false); // â �Ⱥ��̰� �ϱ� 
            }
        });
        
       
 
	}



}
