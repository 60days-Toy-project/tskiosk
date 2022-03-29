package test222;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




public class OrderReceipt {
   
   static int onumber;
   static String cusid;
   static int tquantity;
   static int tprice;
   static String ostatus;
   
   private static String colNames[] = {"薦念誤", "呪勲", "榎衝"}; // 砺戚鷺 鎮軍 葵級
   //static DefaultTableModel model = new DefaultTableModel(colNames, 0); // 砺戚鷺 汽戚斗 乞季 梓端 持失
   //private JTable table;
   //private JScrollPane scrollPane; // 砺戚鷺 什滴継郊 切疑生稽 持失鞠惟 馬奄
   public static String[][] oinfo = new String [20][3];

   
   public void pushorderinfo(int onum, String cid, int totalq, int totalp, String status) { //爽庚腰硲, 爽庚切id, 恥呪勲, 恥衝 閤焼神奄
      onumber = onum;
      cusid = cid;
      tquantity = totalq;
      tprice = totalp;
      ostatus = status;
      if(onumber==1) {
         int j=2; 
         System.out.println("tttttttt" + j);
         }
      if(cusid.equals("set1")) {
         System.out.println("戚暗石毘せせせせせせせせせせせ");
      }
      if(ostatus=="爽庚企奄") {
         int i=1;
         System.out.println("jjjj"+i);
      }
      ostatus = status;
   }
   
   
   public void printReceipt() {
      
      JFrame fr = new JFrame("慎呪装");
      
      fr.setSize(800, 1000);
      fr.setLocationRelativeTo(null);
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.getContentPane().setLayout(null);
      fr.setBackground(Color.WHITE);
      
      JLabel lb = new JLabel("慎呪装");
      fr.add(lb);
      lb.setBounds(0, 0, 800, 100);
      lb.setBackground(new Color(255, 0, 102));
      lb.setOpaque(true); // Opaque葵聖 true稽 竺舛背醤 壕井事戚 旋遂吉陥.
      lb.setHorizontalAlignment(JLabel.CENTER);
      lb.setFont(new Font("SansSerif", Font.BOLD, 30));
      lb.setForeground(Color.WHITE);
      
      JLabel jlonum = new JLabel("爽庚 腰硲 : ");
      fr.add(jlonum);
      jlonum.setBounds(40, 120, 100, 100);
      jlonum.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel onum = new JLabel(onumber + "");
      fr.add(onum);
      onum.setBounds(120, 145, 200, 50);
      onum.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel jlcid = new JLabel("爽庚切 ID : ");
      fr.add(jlcid);
      jlcid.setBounds(40, 160, 150, 100);
      jlcid.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel cid = new JLabel(cusid + "");
      fr.add(cid);
      cid.setBounds(120, 175, 400, 70);
      cid.setFont(new Font("SansSerif", Font.BOLD, 13));
      
      JLabel jlline1 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline1);
      jlline1.setBounds(40, 190, 3000, 100);
      jlline1.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltitle = new JLabel("                            薦念誤                             |           呪勲           |               亜維           ");
      fr.add(jltitle);
      jltitle.setBounds(40, 210, 3000, 100);
      jltitle.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jlline2 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline2);
      jlline2.setBounds(40, 230, 3000, 100);
      jlline2.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      ///JPanel jpinfo = new JPanel();
      //fr.add(jpinfo);
      ///jpinfo.setBounds(40,300, 700, 430);
/*      
      int m = OrderDB.order_info.length; 
      int n = OrderDB.order_info[0].length; 
      for (int i = 0; i < m; i++)   { 
         for (int j = 0; j < n; j++) { 
            System.out.print("端滴"+OrderDB.order_info[i][j] + "\t"); 
         } 
         System.out.println();
      }

   */
   
      /////什滴継戚 貝軒徴ぞぞ
      DefaultTableModel model = new DefaultTableModel(OrderDB.order_info, colNames); // 砺戚鷺 汽戚斗 乞季 梓端 持失
       JTable otable = new JTable(model);
       otable.setBounds(40,300,650,430);
       
       DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
       celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 亜錘汽 舛慶
              
       otable.setRowHeight(50);
      otable.setFont(new Font("閏顕端", Font.BOLD, 15));
       otable.getColumnModel().getColumn(0).setPreferredWidth(330); // JTable 税 鎮軍 掩戚 繕箭
       otable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);  // 亜錘汽 舛慶
      otable.getColumnModel().getColumn(1).setPreferredWidth(160);
      otable.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
      otable.getColumnModel().getColumn(2).setPreferredWidth(200);
      otable.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
      
      otable.setShowHorizontalLines(false); // 砺戚鷺 識 照左戚惟 馬奄
      otable.setShowVerticalLines(false); // 砺戚鷺 識 照左戚惟 馬奄
      //otable.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
      JScrollPane scroll = new JScrollPane(otable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      //scroll.getVerticalScrollBar().setUnitIncrement(16);
       
      scroll.setSize(650,430);
      scroll.setLocation(70, 300);
      scroll.setBorder(null);
      
      fr.add(scroll);
      
      ///jpinfo.add(otable);
      ///jpinfo.add(scroll);
      //jpinfo.setBackground(Color.WHITE);
      ////fr.add(jpinfo);
      
      
      ///// 薦念誤, 呪勲, 亜維 床析 鳶確 -> 什滴継 級嬢亜惟 拝 依 
      /*
      JPanel jpinfo = new JPanel();
      fr.add(jpinfo);
      jpinfo.setBounds(40, 250, 3000, 430);
      
      
      
      JScrollPane scrollSingle = new JScrollPane(jpinfo, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollSingle.getVerticalScrollBar().setUnitIncrement(16);

      fr.add(scrollSingle);
      */
      //////////////////////////////////////////////////////////////
      
      JLabel jlline3 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline3);
      jlline3.setBounds(40, 700, 3000, 100);
      jlline3.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalq = new JLabel("恥 呪勲 : ");
      fr.add(jltotalq);
      jltotalq.setBounds(500, 740, 150, 100);
      jltotalq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tq = new JLabel(tquantity + "鯵");
      fr.add(tq);
      tq.setBounds(600, 755, 400, 70);
      tq.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel jltotalp = new JLabel("恥衝 : ");
      fr.add(jltotalp);
      jltotalp.setBounds(500, 770, 150, 100);
      jltotalp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      JLabel tp = new JLabel(tprice + "据");
      fr.add(tp);
      tp.setBounds(600, 785, 400, 70);
      tp.setFont(new Font("SansSerif", Font.BOLD, 18));
      
      
      JLabel jlline4 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
      fr.add(jlline4);
      jlline4.setBounds(40, 800, 3000, 100);
      jlline4.setFont(new Font("SansSerif", Font.BOLD, 18));
      
   /*
      JButton recbtn = new JButton("爽庚羨呪"); //爽庚羨呪 獄動 -> 爽庚企奄 雌殿拭辞 爽庚羨呪稽 郊会
      fr.add(recbtn);
      recbtn.setBounds(400, 870, 150, 50);
      recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
      JButton complbtn = new JButton("爽庚刃戟");
      fr.add(complbtn);
      complbtn.setBounds(400, 870, 150, 50);
      recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
   */
      JButton recbtn = new JButton("爽庚羨呪");
      JButton complbtn = new JButton("爽庚刃戟");
      
      if (ostatus.equals("爽庚企奄")) {
         //JButton recbtn = new JButton("爽庚羨呪"); //爽庚羨呪 獄動 -> 爽庚企奄 雌殿拭辞 爽庚羨呪稽 郊会
         fr.add(recbtn);
         recbtn.setBounds(400, 870, 150, 50);
         recbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
         
         OrderDB odb = new OrderDB();
         odb.changeStatus(onumber);
         System.out.println("叔楳吉位い汽---");
         //JOptionPane.showMessageDialog(null, "爽庚戚 羨呪鞠醸柔艦陥.");
      }
      else if (ostatus.equals("爽庚羨呪")) {
         //JButton complbtn = new JButton("爽庚刃戟");
         fr.add(complbtn);
         complbtn.setBounds(400, 870, 150, 50);
         complbtn.setFont(new Font("SansSerif", Font.BOLD, 15));
         
      }
      else if (ostatus.equals("爽庚刃戟")) {
         //JOptionPane.showMessageDialog(null, "戚耕 刃戟吉 爽庚脊艦陥.");
      }
      
      JButton closebtn = new JButton("丸奄"); //爽庚羨呪 獄動
      fr.add(closebtn);
      closebtn.setBounds(580, 870, 150,50);
      closebtn.setFont(new Font("SansSerif", Font.BOLD, 15));
      
      
      recbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.changeStatus(onumber);
            JOptionPane.showMessageDialog(null, "爽庚戚 羨呪鞠醸柔艦陥.");
/*
            if (ostatus.equals("爽庚企奄")) {
               OrderDB odb = new OrderDB();
               odb.changeStatus(onumber);
               System.out.println("叔楳吉位い汽---");
               JOptionPane.showMessageDialog(null, "爽庚戚 羨呪鞠醸柔艦陥.");
            }
            else if (ostatus.equals("爽庚羨呪")) {
               JOptionPane.showMessageDialog(null, "戚耕 羨呪吉 爽庚脊艦陥.");
            }
            else if (ostatus.equals("爽庚刃戟")) {
               JOptionPane.showMessageDialog(null, "戚耕 刃戟吉 爽庚脊艦陥.");
            }
   */      
         }
      });
      
      complbtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            OrderDB odb = new OrderDB();
            odb.completeStatus(onumber);
            JOptionPane.showMessageDialog(null, "爽庚戚 刃戟鞠醸柔艦陥.");
   
         }
      });
      
      closebtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            fr.setVisible(false); // 但 照左戚惟 馬奄
         }
      });
      
      // 覗傾績戚 左戚亀系 竺舛
        fr.setVisible(true);


      
   }

}