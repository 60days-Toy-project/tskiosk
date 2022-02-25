package test222;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

//�����ϱ� ��ư ������ ������ ����â ȭ��
public class payScreen {
	
	public void disPayScreen(int sum) {
		
		int discount = 0;
		int pay = 0;
		int receive = sum-discount-pay;
	
		JFrame fr = new JFrame("����â");
	    fr.setSize(800, 900);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.getContentPane().setLayout(null);
        
        JLabel lb = new JLabel("��������� �������ּ���.");
      	fr.add(lb);
		lb.setBounds(0, 0, 800, 100);
		lb.setBackground(new Color(255,0,102));
        lb.setOpaque(true); //Opaque���� true�� �����ؾ� ������ ����ȴ�.
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setFont(new Font("SansSerif", Font.BOLD, 30));
        lb.setForeground(Color.WHITE);
        
        JLabel lb2 = new JLabel("��ü�ݾ�");
      	fr.add(lb2);
		lb2.setBounds(50, 150, 100, 50);
		lb2.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		String total =  Integer.toString(sum);
		JLabel total_won = new JLabel(total + "��");
		fr.add(total_won);
		total_won.setBounds(40,190,200,50);
		total_won.setFont(new Font("SansSerif", Font.BOLD, 30));
		total_won.setForeground(new Color(255,0,102));
		
		/* ���̳ʽ� ������ ����
		ImageIcon min = new ImageIcon("image/minus.png");
        Image minimg = min.getImage();
        Image newminimg = minimg.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon newiconm = new ImageIcon(newminimg);
        JButton minbtn = new JButton(newiconm);
        fr.add(minbtn);
        minbtn.setBounds(170, 180, 35, 35);
        minbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        minbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
		*/
		
		/*���̳ʽ� ���� ����
		JLabel minus = new JLabel("-");
		fr.add(minus);
		minus.setBounds(170,180,200,50);
		minus.setFont(new Font("SansSerif", Font.BOLD, 30));
		minus.setForeground(Color.BLACK);
		*/
		
		JLabel discm = new JLabel("���αݾ�");
      	fr.add(discm);
		discm.setBounds(230, 150, 100, 50);
		discm.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		String discmon =  Integer.toString(discount);
		JLabel disc_won = new JLabel(discmon + "��");
		fr.add(disc_won);
		disc_won.setBounds(220,190,200,50);
		disc_won.setFont(new Font("SansSerif", Font.BOLD, 30));
		disc_won.setForeground(new Color(255,0,102));
		
		JLabel paym = new JLabel("�����ݾ�");
      	fr.add(paym);
		paym.setBounds(430, 150, 100, 50);
		paym.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		String paymon =  Integer.toString(pay);
		JLabel pay_won = new JLabel(paymon + "��");
		fr.add(pay_won);
		pay_won.setBounds(420,190,200,50);
		pay_won.setFont(new Font("SansSerif", Font.BOLD, 30));
		pay_won.setForeground(new Color(255,0,102));
		
		JLabel receivem = new JLabel("�����ݾ�");
      	fr.add(receivem);
      	receivem.setBounds(630, 150, 100, 50);
      	receivem.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		String receivemon =  Integer.toString(receive);
		JLabel receive_won = new JLabel(receivemon + "��");
		fr.add(receive_won);
		receive_won.setBounds(620,190,200,50);
		receive_won.setFont(new Font("SansSerif", Font.BOLD, 30));
		receive_won.setForeground(new Color(255,0,102));
		
        
        ImageIcon cardpay = new ImageIcon("image/cardpay.png");
        Image cmg = cardpay.getImage();
        Image newcmg = cmg.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(newcmg);
        JButton cardbtn = new JButton(newicon);
        fr.add(cardbtn);
        cardbtn.setBounds(100, 300, 170, 180);
        cardbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        cardbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
        
        ImageIcon mc = new ImageIcon("image/mobilecoupon.png");
        Image mcimg = mc.getImage();
        Image newmcmg = mcimg.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon newicon2 = new ImageIcon(newmcmg);
        JButton mcbtn = new JButton(newicon2);
        fr.add(mcbtn);
        mcbtn.setBounds(300, 300, 170, 180);
        mcbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        mcbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
        
        ImageIcon gc = new ImageIcon("image/giftcard.png");
        Image gcimg = gc.getImage();
        Image newmgcimg = gcimg.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon newicon3 = new ImageIcon(newmgcimg);
        JButton gcbtn = new JButton(newicon3);
        fr.add(gcbtn);
        gcbtn.setBounds(500, 300, 170, 180);
        gcbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        gcbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
        
        ImageIcon kp = new ImageIcon("image/kakaopay.png");
        Image kpimg = kp.getImage();
        Image newkpimg = kpimg.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon newicon4 = new ImageIcon(newkpimg);
        JButton kpbtn = new JButton(newicon4);
        fr.add(kpbtn);
        kpbtn.setBounds(100, 500, 170, 180);
        kpbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        kpbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
        
        ImageIcon bc = new ImageIcon("image/barcode.png");
        Image bcimg = bc.getImage();
        Image newbcimg = bcimg.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon newicon5 = new ImageIcon(newbcimg);
        JButton bcbtn = new JButton(newicon5);
        fr.add(bcbtn);
        bcbtn.setBounds(300, 500, 170, 180);
        bcbtn.setBorderPainted(false); //��ư �ܰ��� ���ֱ�
        bcbtn.setContentAreaFilled(false); //��ư ���뿵�� ä��� ���ֱ�
        
        JButton cancelbtn = new JButton("���");
        fr.add(cancelbtn);
        cancelbtn.setBounds(300,750,180,50);
        cancelbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.setBackground(Color.GRAY);
        
        
        
        fr.setVisible(true);
        
      //��ư ����� �������� Ȯ���غ����� �س����� �Ű�XX!!!
        cardbtn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
            	//new TableRowHeaderTest();
            	//new Category(new Pos()));
                //frm.setVisible(false); // â �Ⱥ��̰� �ϱ� 
            	creditCardScreen cs = new creditCardScreen();
                cs.disCreditCardScreen(receive);
                //fr.setVisible(false); // â �Ⱥ��̰� �ϱ� 
            }
        });
        
        //����ϱ� ��ư
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fr.setVisible(false); // â �Ⱥ��̰� �ϱ� 
            }
        });
        
  	}

}
