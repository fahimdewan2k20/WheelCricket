import java.awt.event.*;
import java .awt.*;
import javax.swing.*;

public class Break extends JFrame implements ActionListener
{
    JPanel panel;
    JLabel txtLabel, targetLabel, txtLabel2, txtLabel3, imgLabel;
    JButton continueBtn, exitBtn;
    int target, tWkt, tOver;
    boolean flag;
    String batName, bowlName;
    ImageIcon img;
    Font myFont, myFont2, myFont3, myFont4;
    Color myColor;

    public Break(String batName, String bowlName, int tWkt, int run, boolean flag, int tOver, int target)
    {
        super("Wheel Game");
        this.setSize(1280, 800);
        this.setUndecorated(true);

        this.myColor = new Color(130, 30, 00);
        this.myFont = new Font("Cambria", Font.BOLD, 28);
        this.myFont2 = new Font("Cambria", Font.BOLD, 36);
        this.myFont3 = new Font("Cambria", Font.BOLD, 24);
        this.myFont4 = new Font("Cambria", Font.BOLD, 42);

        this.flag = flag;
        this.tWkt = tWkt;
        this.batName = batName;
        this.bowlName = bowlName;
        this.tOver = tOver;
        this.target = target;

        panel = new JPanel();
        panel.setLayout(null);

        continueBtn = new JButton("continue");
        continueBtn.setBounds(590, 550, 100, 30);
        continueBtn.addActionListener(this);
        panel.add(continueBtn);

        exitBtn = new JButton("exit");
        exitBtn.setBounds(600, 600, 80, 30);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        if(flag)
        {
            exitBtn.setVisible(false);  
            txtLabel2 = new JLabel(batName + " scored " + run + " runs.");
            txtLabel2.setBounds(400, 200, 480, 50);
            txtLabel2.setHorizontalAlignment(JLabel.CENTER);
            txtLabel2.setFont(myFont);
            txtLabel2.setForeground(Color.ORANGE);
            panel.add(txtLabel2);

            txtLabel = new JLabel();
            txtLabel.setText("Target");
            txtLabel.setBounds(500, 300, 280, 70);
            txtLabel.setHorizontalAlignment(JLabel.CENTER);
            txtLabel.setFont(myFont2);
            txtLabel.setForeground(Color.WHITE);
            panel.add(txtLabel);
    
            targetLabel = new JLabel();
            targetLabel.setText(target + "");
            targetLabel.setBounds(500, 370, 280, 100);
            targetLabel.setHorizontalAlignment(JLabel.CENTER);
            targetLabel.setFont(myFont2);
            targetLabel.setForeground(Color.RED);
            panel.add(targetLabel);
        }
        else
        {
            txtLabel = new JLabel();
            txtLabel.setText("Game Over");
            txtLabel.setBounds(500, 200, 280, 100);
            txtLabel.setHorizontalAlignment(JLabel.CENTER);
            txtLabel.setFont(myFont4);
            txtLabel.setForeground(Color.RED);
            panel.add(txtLabel);

            txtLabel2 = new JLabel(bowlName + ": " + (target-1));
            txtLabel2.setBounds(500, 320, 280, 60);
            txtLabel2.setHorizontalAlignment(JLabel.CENTER);
            txtLabel2.setFont(myFont3);
            txtLabel2.setForeground(Color.WHITE);
            panel.add(txtLabel2);

            txtLabel3 = new JLabel(batName + ": " + run);
            txtLabel3.setBounds(500, 360, 280, 60);
            txtLabel3.setHorizontalAlignment(JLabel.CENTER);
            txtLabel3.setFont(myFont3);
            txtLabel3.setForeground(Color.WHITE);
            panel.add(txtLabel3);
    
            if(run<(target-1))
            {
                targetLabel = new JLabel(bowlName + " wins by " + (target-run-1) + " runs.");
                targetLabel.setBounds(300, 450, 680, 50);
                targetLabel.setHorizontalAlignment(JLabel.CENTER);
                targetLabel.setFont(myFont3);
                targetLabel.setForeground(Color.ORANGE);
                panel.add(targetLabel);
            }
            else if(run>=target)
            {
                targetLabel = new JLabel(batName + " wins with " + tWkt + " wickets in hand.");
                targetLabel.setBounds(300, 450, 680, 50);
                targetLabel.setHorizontalAlignment(JLabel.CENTER);
                targetLabel.setFont(myFont3);
                targetLabel.setForeground(Color.ORANGE);
                panel.add(targetLabel);
            }
            else if(run == (target-1))
            {
                targetLabel = new JLabel("Draw!!");
                targetLabel.setBounds(500, 450, 280, 50);
                targetLabel.setHorizontalAlignment(JLabel.CENTER);
                targetLabel.setFont(myFont2);
                targetLabel.setForeground(Color.BLUE);
                panel.add(targetLabel);
            }
        }

        img = new ImageIcon("1.jpg");
        imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0, 1280, 800);
		panel.add(imgLabel);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();
        if(command.equals("continue") && flag)
        {
            int remain = 6*tOver;
            flag = false;
            WheelCricket wc = new WheelCricket(bowlName, batName, tWkt, 0, 0, remain, 3, flag, false, tOver, target);
            wc.setVisible(true);
            this.setVisible(false);
        }
        else if(command.equals("continue") && !flag)
        {
            StartPage sp = new StartPage();
            sp.setVisible(true);
            this.setVisible(false);
        }
        else if(command.equals("exit"))
        {
            System.exit(0);
        }
    }
}