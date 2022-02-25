package test222;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

public class creditCardScreen {
	
	class BoundDocument extends PlainDocument {
		protected int charLimit;
		protected JTextComponent textComp;
		public BoundDocument(int charLimit) { this.charLimit = charLimit; }
		public BoundDocument(int charLimit, JTextComponent textComp) { this.charLimit = charLimit; this.textComp = textComp; }

		public void insertString (int offs, String str, AttributeSet a) throws BadLocationException
		{
		if (textComp.getText().getBytes().length + str.getBytes().length <= charLimit) { super.insertString(offs, str, a); }
		}
		}
	
	
public void disCreditCardScreen(int receive) {
		
		
		JFrame fr = new JFrame("�ſ�ī�� ����");
	    fr.setSize(800, 900);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.getContentPane().setLayout(null);
              
        JLabel lb = new JLabel("�ſ�ī�� ����");
      	fr.add(lb);
		lb.setBounds(0, 0, 800, 100);
		lb.setBackground(new Color(255,0,102));
        lb.setOpaque(true); //Opaque���� true�� �����ؾ� ������ ����ȴ�.
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setFont(new Font("SansSerif", Font.BOLD, 30));
        lb.setForeground(Color.WHITE);
        
                 
        JLabel name = new JLabel("������ ����");
        fr.add(name);
        name.setBounds(40, 120, 100, 100);
        name.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        JLabel cardcom = new JLabel("ī��縦 �������ּ���");
        fr.add(cardcom);
        cardcom.setBounds(40, 220, 150, 100);
        cardcom.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        //ī��� �޺��ڽ�
        String bank [] = {"KB����ī��", "����ī��", "�ϳ�ī��", "�Ե�ī��", "BCī��", 
        		"NH����ī��","�Ｚī��", "����ī��"};
        JComboBox CCom = new JComboBox(bank);
        fr.add(CCom);
        CCom.setPreferredSize(new Dimension(400,15));
        CCom.setBounds(350, 240,400,70);
        
        JLabel cardnum = new JLabel("ī�� ��ȣ�� �Է����ּ���");
        fr.add(cardnum);
        cardnum.setBounds(40, 320, 160, 100);
        cardnum.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        JTextField cnum1 = new JTextField();
        fr.add(cnum1);
        cnum1.setBounds(380,320,60,30);
        cnum1.setDocument(new BoundDocument(4,cnum1));
        
        /*
        JFormattedTextField cnum = new JFormattedTextField(new NumberFormatter());
        cnum.setBounds(380, 400, 60, 30);
        cnum.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent ke) {
        		if(((JFormattedTextField)ke.getSource()).getText().length()>3)
        			ke.consume();
        	}
        });
        fr.add(cnum);
        */
        
        JLabel jl1 = new JLabel("-");
        fr.add(jl1);
        jl1.setBounds(453, 320, 30, 30);
        jl1.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JTextField cnum2 = new JTextField();
        fr.add(cnum2);
        cnum2.setBounds(470, 320, 60, 30);
        cnum2.setDocument(new BoundDocument(4,cnum2));
        JLabel jl2 = new JLabel("-");
        fr.add(jl2);
        jl2.setBounds(543, 320, 30, 30);
        jl2.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JTextField cnum3 = new JTextField();
        fr.add(cnum3);
        cnum3.setBounds(560,320,60,30);
        cnum3.setDocument(new BoundDocument(4,cnum3));
        JLabel jl3 = new JLabel("-");
        fr.add(jl3);
        jl3.setBounds(633, 320, 30, 30);
        jl3.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JTextField cnum4 = new JTextField();
        fr.add(cnum4);
        cnum4.setBounds(650,320,60,30);
        cnum4.setDocument(new BoundDocument(4,cnum4));
                
        JLabel num = new JLabel("����ó");
        fr.add(num);
        num.setBounds(40, 420, 150, 100);
        num.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        JLabel email = new JLabel("�̸���");
        fr.add(email);
        email.setBounds(40, 520, 150, 100);
        email.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        JLabel money = new JLabel("�� �����ݾ�");
        fr.add(money);
        money.setBounds(40, 620, 150, 100);
        money.setFont(new Font("SansSerif", Font.BOLD, 13));
        
        String receivemon =  Integer.toString(receive);
		JLabel receive_won = new JLabel(receivemon + "��");
		fr.add(receive_won);
		receive_won.setBounds(500,650,200,50);
		receive_won.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton okBtn = new JButton("������û");
		fr.add(okBtn);
		okBtn.setBounds(200, 770, 130, 40);
		okBtn.setFont(new Font("SanSerif", Font.BOLD,13));
		
		JButton closeBtn = new JButton("�ݱ�");
		fr.add(closeBtn);
		closeBtn.setBounds(450, 770, 130, 40);
		closeBtn.setFont(new Font("SanSerif", Font.BOLD,13));
		
                
        
        fr.setVisible(true);
        
        //������û ��ư
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               int result = JOptionPane.showConfirmDialog(null, "������ �Ϸ�Ǿ����ϴ�.",
                     "�˸�", JOptionPane.YES_NO_OPTION);
               if (result==JOptionPane.YES_OPTION) {
                  FirstScreen fs = new FirstScreen();
                  fs.disScreen();
                  fr.setVisible(false); // â �Ⱥ��̰� �ϱ� 
                  
               }
 
               
            }
        });
        
        //�ݱ� ��ư
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fr.setVisible(false); // â �Ⱥ��̰� �ϱ� 
            }
        });
     
        
  	}
	
}
