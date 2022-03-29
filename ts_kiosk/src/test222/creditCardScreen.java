package test222;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	
	private JFrame mainf;//카테고리메인창 프레임
	private JFrame payscreenf; //결제창 프레임
	
	static String PId;
	static String PName; // 결제자 이름
	static String PEmail; // 결제자 이메일
	static String PTel; // 결제자 전화 번호
	
	static int lastrow; //필요한 행의 수 만큼만 출력하기 위함
	
	static int totalQ;
	static int totalP;
	static int ONum = 1;
	

	class BoundDocument extends PlainDocument {
		protected int charLimit;
		protected JTextComponent textComp;

		public BoundDocument(int charLimit) {
			this.charLimit = charLimit;
		}

		public BoundDocument(int charLimit, JTextComponent textComp) {
			this.charLimit = charLimit;
			this.textComp = textComp;
		}

		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			if (textComp.getText().getBytes().length + str.getBytes().length <= charLimit) {
				super.insertString(offs, str, a);
			}
		}
	}

	public void pushname(String id, String name, String email, String tel) {

		PId = id;
		PName = name;
		PEmail = email;
		PTel = tel;
	}
	
	public void pushrow (int row) {
		lastrow = row;
	}
	
	public void pushTotalQ (int totalq) {
		totalQ = totalq;
	}
	
	public void pushTotalP (int totalp) {
		totalP = totalp;
	}

	public void disCreditCardScreen(JFrame mainf, JFrame payscreenf, int receive) {
		this.mainf= mainf;
		this.payscreenf= payscreenf;
		JFrame fr = new JFrame("신용카드 결제");
		
		fr.setSize(800, 900);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane().setLayout(null);

		JLabel lb = new JLabel("신용카드 결제");
		fr.add(lb);
		lb.setBounds(0, 0, 800, 100);
		lb.setBackground(new Color(255, 0, 102));
		lb.setOpaque(true); // Opaque값을 true로 설정해야 배경색이 적용된다.
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setFont(new Font("SansSerif", Font.BOLD, 30));
		lb.setForeground(Color.WHITE);

		JLabel names = new JLabel("결제자 성명");
		fr.add(names);
		names.setBounds(40, 120, 100, 100);
		names.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel pname = new JLabel(PName + "");
		fr.add(pname);
		pname.setBounds(500, 150, 200, 50);
		pname.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel cardcom = new JLabel("카드사를 선택해주세요");
		fr.add(cardcom);
		cardcom.setBounds(40, 220, 150, 100);
		cardcom.setFont(new Font("SansSerif", Font.BOLD, 13));

		// 카드사 콤보박스
		String bank[] = { "KB국민카드", "신한카드", "하나카드", "롯데카드", "BC카드", "NH농협카드", "삼성카드", "현대카드" };

		ImageIcon[] card = { new ImageIcon("image/card/kbcard.png"), new ImageIcon("image/card/shcard.png"),
				new ImageIcon("image/card/hncard.png"), new ImageIcon("image/card/ltcard.png"),
				new ImageIcon("image/card/bccard.png"), new ImageIcon("image/card/nhcard.png"),
				new ImageIcon("image/card/samsungcard.png"), new ImageIcon("image/card/hdcard.png") };

		JLabel cardimgLabel = new JLabel();

		JComboBox CCom = new JComboBox(bank);
		fr.add(CCom);
		CCom.setPreferredSize(new Dimension(400, 15));
		CCom.setBounds(350, 240, 400, 70);
		CCom.setSelectedIndex(0);
		cardimgLabel.setIcon(card[0]);
		fr.add(cardimgLabel);
		cardimgLabel.setBounds(450, 300, 280, 180);

		// 카드사 선택에 따라 이미지가 바뀜
		CCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jc = (JComboBox) e.getSource(); // 콤보박스 값 알아내기
				int index = jc.getSelectedIndex();
				cardimgLabel.setIcon(card[index]); // 인덱스의 이미지를 이미지 레이블에 출력
				fr.add(cardimgLabel);
				cardimgLabel.setBounds(450, 300, 280, 180);
			}
		});

		JLabel cardnum = new JLabel("카드 번호를 입력해주세요");
		fr.add(cardnum);
		cardnum.setBounds(40, 320, 160, 100);
		cardnum.setFont(new Font("SansSerif", Font.BOLD, 13));

		JTextField cnum1 = new JTextField();
		fr.add(cnum1);
		cnum1.setBounds(380, 320, 60, 30);
		cnum1.setDocument(new BoundDocument(4, cnum1));

		KeyListener keyListener1 = new KeyListener() {

			public void keyPressed(KeyEvent keyEvent) {
			}

			public void keyReleased(KeyEvent keyEvent) { // 키가 눌렸을 때

				String data = cnum1.getText();
				System.out.println(data);
				for (int i = 0; i < data.length(); i++) {
					char c = data.charAt(i);
					if (c < 48 || c > 57) {// 숫자가 아닌 경우
						JOptionPane.showMessageDialog(null, "숫자만 입력가능합니다.");
						cnum1.setText(""); // 텍스트필드 초기화
						break;
					}
				}
			}

			public void keyTyped(KeyEvent keyEvent) {

			}
		};

		cnum1.addKeyListener(keyListener1);

		JLabel jl1 = new JLabel("-");
		fr.add(jl1);
		jl1.setBounds(453, 320, 30, 30);
		jl1.setFont(new Font("SansSerif", Font.BOLD, 14));

		JTextField cnum2 = new JTextField();
		fr.add(cnum2);
		cnum2.setBounds(470, 320, 60, 30);
		cnum2.setDocument(new BoundDocument(4, cnum2));
		JLabel jl2 = new JLabel("-");
		fr.add(jl2);
		jl2.setBounds(543, 320, 30, 30);
		jl2.setFont(new Font("SansSerif", Font.BOLD, 14));

		KeyListener keyListener2 = new KeyListener() {

			public void keyPressed(KeyEvent keyEvent) {
			}

			public void keyReleased(KeyEvent keyEvent) {

				String data = cnum2.getText();
				System.out.println(data);
				for (int i = 0; i < data.length(); i++) {
					char c = data.charAt(i);
					if (c < 48 || c > 57) {// 숫자가 아닌 경우
						JOptionPane.showMessageDialog(null, "숫자만 입력가능합니다.");
						cnum2.setText("");
						break;
					}
				}
			}

			public void keyTyped(KeyEvent keyEvent) {

			}
		};

		cnum2.addKeyListener(keyListener2);

		JTextField cnum3 = new JTextField();
		fr.add(cnum3);
		cnum3.setBounds(560, 320, 60, 30);
		cnum3.setDocument(new BoundDocument(4, cnum3));
		JLabel jl3 = new JLabel("-");
		fr.add(jl3);
		jl3.setBounds(633, 320, 30, 30);
		jl3.setFont(new Font("SansSerif", Font.BOLD, 14));

		KeyListener keyListener3 = new KeyListener() {

			public void keyPressed(KeyEvent keyEvent) {
			}

			public void keyReleased(KeyEvent keyEvent) {

				String data = cnum3.getText();
				System.out.println(data);
				for (int i = 0; i < data.length(); i++) {
					char c = data.charAt(i);
					if (c < 48 || c > 57) {// 숫자가 아닌 경우
						JOptionPane.showMessageDialog(null, "숫자만 입력가능합니다.");
						cnum3.setText("");
						break;
					}
				}
			}

			public void keyTyped(KeyEvent keyEvent) {

			}
		};

		cnum3.addKeyListener(keyListener3);

		JTextField cnum4 = new JTextField();
		fr.add(cnum4);
		cnum4.setBounds(650, 320, 60, 30);
		cnum4.setDocument(new BoundDocument(4, cnum4));

		KeyListener keyListener4 = new KeyListener() {

			public void keyPressed(KeyEvent keyEvent) {
			}

			public void keyReleased(KeyEvent keyEvent) {

				String data = cnum4.getText();
				System.out.println(data);
				for (int i = 0; i < data.length(); i++) {
					char c = data.charAt(i);
					if (c < 48 || c > 57) {// 숫자가 아닌 경우
						JOptionPane.showMessageDialog(null, "숫자만 입력가능합니다.");
						cnum4.setText("");
						break;
					}
				}
			}

			public void keyTyped(KeyEvent keyEvent) {

			}
		};

		cnum4.addKeyListener(keyListener4);

		JLabel num = new JLabel("연락처");
		fr.add(num);
		num.setBounds(40, 420, 150, 100);
		num.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel ptel = new JLabel(PTel + "");
		fr.add(ptel);
		ptel.setBounds(500, 450, 200, 50);
		ptel.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel email = new JLabel("이메일");
		fr.add(email);
		email.setBounds(40, 520, 150, 100);
		email.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel pemail = new JLabel(PEmail + "");
		fr.add(pemail);
		pemail.setBounds(500, 550, 230, 50);
		pemail.setFont(new Font("SansSerif", Font.BOLD, 13));

		JLabel money = new JLabel("총 결제금액");
		fr.add(money);
		money.setBounds(40, 620, 150, 100);
		money.setFont(new Font("SansSerif", Font.BOLD, 13));

		String receivemon = Integer.toString(receive);
		JLabel receive_won = new JLabel(receivemon + "원");
		fr.add(receive_won);
		receive_won.setBounds(500, 650, 200, 50);
		receive_won.setFont(new Font("SansSerif", Font.BOLD, 13));

		JButton okBtn = new JButton("결제요청");
		fr.add(okBtn);
		okBtn.setBounds(200, 770, 130, 40);
		okBtn.setFont(new Font("SanSerif", Font.BOLD, 13));

		JButton closeBtn = new JButton("닫기");
		fr.add(closeBtn);
		closeBtn.setBounds(450, 770, 130, 40);
		closeBtn.setFont(new Font("SanSerif", Font.BOLD, 13));

		fr.setVisible(true);

		// 결제요청 버튼
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
				FirstScreen fs = new FirstScreen();
				fs.disScreen();
				mainf.setVisible(false);
				payscreenf.setVisible(false);
				fr.setVisible(false); // 창 안보이게 하기
				
				///////결제 완료 후에
				/*
				for (int i = 0; i < lastrow; i++) {
		            for (int j = 0; j < 3; j++) {
		                System.out.println(Cart.orders[i][j]); // 열 출력
		            }
		            System.out.println(); // 행 출력
		        }
				*/
				Order order = new Order();
				for (int i = 0; i < lastrow; i++) {
					order.setOrderNum(ONum);
					order.setCustomerId(PId);
					order.setProductName(Cart.orders[i][0]); // 열 출력
					order.setQuantity(Integer.parseInt(Cart.orders[i][1]));
					order.setPrice(Integer.parseInt(Cart.orders[i][2]));
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					order.setTime(date);
					order.setStatus("주문대기");
					order.setTotalQuantity(totalQ);
					order.setTotalPrice(totalP);
					
					OrderDB odb = OrderDB.getInstance();
					int result = odb.insertMember(order);
					if (result==1) {
						JOptionPane.showMessageDialog(null, "주민기록 등록 완료");
					    //dispose();
					}else {
		                JOptionPane.showMessageDialog(null, "주민기록 등록 실패");
		      	      	 //dispose();
		            }
						            
		            System.out.println(); // 행 출력
		        }
				
				
			}
		});

		// 닫기 버튼
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				fr.setVisible(false); // 창 안보이게 하기
			}
		});

	}

}
