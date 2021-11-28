import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WheelCricket extends JFrame implements ActionListener
{
   JLabel name, batsman, bowler, summary, b1Name, b2Name, bRemaining, targetLabel, chRemain, imgLabel, label;
   JPanel panel;
   JButton changeBtn, okBtn, exitBtn;
   int remain, run, wkt, tWkt, ch, tOver, target, num;
   String batName, bowlName;
   // String arr[] = new String []{"0", "1", "2", "4", "6", "Wide", "No ball", "Bold", "Stamping", "Caught", "Run out", "LBW"};
   //String arr[] = new String []{"0", "0", "0", "1", "1", "1", "2", "2", "4", "4", "6", "Wide", "No ball", "Bold", "Stamping", "Caught", "Caught", "Run out", "LBW"};
   String arr[] = new String []{"0", "0", "0", "1", "1", "1", "2", "2", "4", "4", "6", "Wide", "No ball", "Bold", "Stamping", "Caught", "Run out", "LBW", "0", "1", "1", "1", "1", "1", "1", "2", "2", "2", "2", "4", "4", "4", "6"};
   boolean flag, noFlag;
   ImageIcon img;
   Font myFont, myFont2, myFont3, myFont4, myFont5;
   Color myColor, myColor2;
   Random picker = new Random();
   JButton btnList[] = new JButton[200];

   public WheelCricket(String batName, String bowlName, int tWkt, int run, int wkt, int ballRemain, int ch, boolean flag, boolean noFlag, int tOver, int target)
   {
      super("Wheel Cricket");
      this.setSize(1280, 800);
      this.setUndecorated(true);

      this.myColor = new Color(160,255,0);
      //this.myColor2 = new Color(255, 255, 0);
      this.myFont = new Font("Cambria", Font.BOLD, 40);
      this.myFont2 = new Font("Cambria", Font.BOLD, 14);
      this.myFont3 = new Font("Cambria", Font.BOLD, 20);
      this.myFont4 = new Font("Cambria", Font.BOLD, 20);
      this.myFont5 = new Font("Cambria", Font.BOLD, 48);

      remain = ballRemain;
      this.run = run;
      this.wkt = wkt;
      this.batName = batName;
      this.bowlName = bowlName; 
      this.flag = flag;
      this.noFlag = noFlag;
      this.tWkt = tWkt;
      this.target = target;
      this.tOver = tOver;
      this.ch = ch;

      panel = new JPanel();
      panel.setLayout(null);

      name = new JLabel();
      name.setText("Wheel Cricket");
      name.setBounds(0,0,1280,99);
      name.setHorizontalAlignment(JLabel.LEFT);
      name.setFont(myFont);
      name.setForeground(Color.WHITE);
      panel.add(name);

      label = new JLabel();
      label.setBounds(500, 20, 280, 60);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setFont(myFont5);
      label.setForeground(Color.ORANGE);
      panel.add(label);

      exitBtn = new JButton("leave");
      exitBtn.setBounds(1180, 35, 80, 30);
      exitBtn.addActionListener(this);
      panel.add(exitBtn);

      for(int i=0; i<btnList.length; i++)
      {
         btnList[i] = new JButton();
      }

      int index = 0;
      for(int j=0; j<1280; j+=64)
      {
         for(int k=100; k<700; k+=60)
         {
            btnList[index].setBounds(j,k,64,60);
            btnList[index].addActionListener(this);
            panel.add(btnList[index]);
            index++;
         }
      }
      
      changeBtn = new JButton();
      changeBtn.setText("Change");
      changeBtn.setBounds(560, 710, 80, 30);
      changeBtn.addActionListener(this);
      panel.add(changeBtn);

      okBtn = new JButton("Ok");
      okBtn.setBounds(640, 710, 80, 30);
      okBtn.addActionListener(this);
      panel.add(okBtn);

      chRemain = new JLabel("Change remaining: " + ch);
      chRemain.setBounds(565, 740, 150, 30);
      chRemain.setHorizontalAlignment(JLabel.CENTER);
      panel.add(chRemain);

      batsman = new JLabel();
      batsman.setText("Batting:  " + batName);
      batsman.setBounds(0, 710, 200, 30);
      batsman.setFont(myFont2);
      batsman.setForeground(Color.BLUE);
      panel.add(batsman);

      bowler = new JLabel();
      bowler.setText("Bowling: " + bowlName);
      bowler.setBounds(0, 740, 200, 30);
      bowler.setFont(myFont2);
      bowler.setForeground(Color.RED);
      panel.add(bowler);

      summary = new JLabel();
      summary.setBounds(250, 710, 280, 50);
      summary.setHorizontalAlignment(JLabel.CENTER);
      summary.setFont(myFont4);
      summary.setForeground(Color.DARK_GRAY);
      panel.add(summary);

      bRemaining = new JLabel();
      bRemaining.setBounds(1000, 710, 150, 30);
      bRemaining.setFont(myFont2);
      bRemaining.setForeground(Color.DARK_GRAY);
      panel.add(bRemaining);

      targetLabel = new JLabel();
      targetLabel.setText("Target: " + target);
      targetLabel.setBounds(1000, 740, 100, 30);
      targetLabel.setFont(myFont2);
      targetLabel.setForeground(Color.RED);
      panel.add(targetLabel);

      change(arr);
      chUpdate();
      update(run, wkt, remain);
      checkUser();

      img = new ImageIcon("123.jpg");
      imgLabel = new JLabel(img);
      imgLabel.setBounds(0,0, 1280, 800);
      panel.add(imgLabel);

      this.add(panel);
   }

   public void change(String arr[])
   {
      panel.setVisible(false);
      if(bowlName != "Computer")
      {
         for(int i=0; i<btnList.length; i++)
         {
            num = picker.nextInt(arr.length-1);
            if(arr[num] == "0")
            {
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont3);
               btnList[i].setForeground(Color.BLACK);
            }
            else if(arr[num] == "1")
            {
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont3);
               btnList[i].setForeground(Color.ORANGE);
            }
            else if(arr[num] == "2")
            {
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont3);
               btnList[i].setForeground(Color.ORANGE);
            }
            else if(arr[num] == "4")
            {
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont3);
               btnList[i].setForeground(myColor);
            }
            else if(arr[num] == "6")
            {
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont3);
               btnList[i].setForeground(Color.GREEN);
            }
            else if(num == 11)
            {
               //btnList[i] = new JButton(img3);
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont2);
               btnList[i].setForeground(Color.CYAN);
            }
            else if(num == 12)
            {
               //btnList[i] = new JButton(img3);
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont2);
               btnList[i].setForeground(Color.BLUE);
            }
            else
            {
               //btnList[i] = new JButton(img2);
               btnList[i].setText(arr[num]);
               btnList[i].setFont(myFont2);
               btnList[i].setForeground(Color.RED);
            }
            // else if(num == 14)
            // {
            //     //btnList[i] = new JButton(img2);
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
            // else if(num == 15)
            // {
            //     //btnList[i] = new JButton(img2);
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
            // else if(num == 16)
            // {
            //     //btnList[i] = new JButton(img2);
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
            // else if(num == 17)
            // {
            //     //btnList[i] = new JButton(img2);
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
            // else if(num == 18)
            // {
            //     //btnList[i] = new JButton(img2);
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
            // else
            // {
            //     btnList[i].setText(arr[num]);
            //     btnList[i].setFont(myFont2);
            //     btnList[i].setForeground(Color.RED);
            // }
         }
      }
      else
      {
         for(int i=0; i<btnList.length; i++)
         {
            num = picker.nextInt(arr.length-1);
            btnList[i].setActionCommand(arr[num]);
         }
      }
      panel.setVisible(true);
   }

   public void update(int run, int wkt, int remain)
   {
      summary.setText("runs-wkts: " + run + "/" + wkt);

      bRemaining.setText("Balls remaining: " + remain);
   }

   public void chUpdate()
   {
      if(ch<1)
      {
         changeBtn.setEnabled(false);
      }
      else
      {
         changeBtn.setEnabled(true);
      }

      chRemain.setText("Change remaining: " + ch);
      if(ch == 3)
      {
         chRemain.setForeground(Color.CYAN);
      }
      else if(ch == 2)
      {
         chRemain.setForeground(Color.YELLOW);
      }
      else if(ch == 1)
      {
         chRemain.setForeground(Color.ORANGE);
      }
      else
      {
         chRemain.setForeground(Color.RED);
      }
   }

   public void checkUser()
   {
      if(batName == "Computer")
      {
         okBtn.setVisible(true);
         changeBtn.setVisible(true);
         chRemain.setVisible(true);
         changeBtn.setBounds(560, 710, 80,30);
         for(int i=0; i<btnList.length; i++)
         {
            btnList[i].removeActionListener(this);
         }
      }
      else if(bowlName == "Computer")
      {
         okBtn.setVisible(false);
         changeBtn.setVisible(false);
         chRemain.setVisible(false);
         for(int i=0; i<200; i++)
         {
            btnList[i].setHideActionText(true);
         }
      }
      else
      {
         okBtn.setVisible(false);
         changeBtn.setBounds(600, 710, 80, 30);
      }
   }

   public void check()
   {
      if((remain == 0 || wkt == tWkt) && flag)
      {
         Break b = new Break(batName, bowlName, tWkt, run, flag, tOver, (run+1));
         b.setVisible(true);
         this.setVisible(false);
      }
      else if((remain == 0 || wkt == tWkt || run>=target) && !flag)
      {
         tWkt = tWkt - wkt;
         Break b = new Break(batName, bowlName, tWkt, run, flag, tOver, target);
         b.setVisible(true);
         this.setVisible(false);
      }
      else
      {
         ch = 3;
         update(run, wkt, remain);
         change(arr);
         chUpdate();
      }
   }

   public void action(String command)
   {
      if(command.equals("0") || command.equals("1") || command.equals("2") || command.equals("4") || command.equals("6"))
      {
         if(noFlag)
         {
            run = run+Integer.parseInt(command);
            noFlag = false;               
         }
         else
         {
            run = run+Integer.parseInt(command);
            remain--;
         }
         // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
         // wc.setVisible(true); 
         // this.setVisible(false);
         check();
      }
      else if(command.equals("Wide"))
      {
         if(noFlag)
         {
            noFlag = false;
            check();
         }
         else
         {
            run = run+1;
            // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
            // wc.setVisible(true); 
            // this.setVisible(false);
            check();
         }
      }
      else if(command.equals("No ball"))
      {
         if(noFlag)
         {
            // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
            // wc.setVisible(true); 
            // this.setVisible(false);
            check();
         }
         else
         {
            run = run+1;
            noFlag = true;
            // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
            // wc.setVisible(true); 
            // this.setVisible(false);
            check();
         }
      }
      else if(command.equals("Stamping") || command.equals("Caught") || command.equals("LBW") || command.equals("Bold"))
      {
         if(noFlag)
         {
            noFlag = false;
         }
         else
         {
            wkt++;
            remain--;
         }
         // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
         // wc.setVisible(true); 
         // this.setVisible(false);
         check();
      }
      else if(command.equals("Run out"))
      {
         if(noFlag)
         {
            wkt++;
            noFlag = false;
         }
         else
         {
            wkt++;
            remain--;
         }
         // WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, run, wkt, remain, 3, flag, noFlag);
         // wc.setVisible(true); 
         // this.setVisible(false);
         check();
      }
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      String command = ae.getActionCommand();

      if(command.equals(okBtn.getText()))
      {
         num = picker.nextInt(arr.length);
         label.setText(btnList[num].getText());
         action(btnList[num].getText());
      }
      else if(command.equals("Change"))
      {
         ch--;
         change(arr);
         chUpdate();
      }
      else if(command.equals(exitBtn.getText()))
      {
         System.exit(0);
      }
      else
      {
         label.setText(command);
         action(command);
      }
   }
}