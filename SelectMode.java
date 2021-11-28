import java.lang.*;
import java.awt.*;
import java .awt.event.*;
import javax.swing.*;

public class SelectMode extends JFrame implements ActionListener
{
    JPanel panel;
    JButton vsBtn1, vsBtn2, vsBtn3, backBtn;
    JLabel txtLabel, imgLabel;
    ImageIcon img;
    Font myFont, myFont2, myFont3;
    Color myColor;

    public SelectMode()
    {
        super("Wheel Cricket");
        this.setSize(1280, 800);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.myFont = new Font("Cambria", Font.BOLD, 42);
        this.myFont2 = new Font("Cambria", Font.BOLD, 32);
        this.myFont3 = new Font("Cambria", Font.BOLD, 28);
        this.myColor = new Color(130, 30, 0);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        txtLabel = new JLabel("Select Mode");
        txtLabel.setBounds(470, 80, 340, 80);
        txtLabel.setFont(myFont);
        txtLabel.setForeground(Color.ORANGE);
        txtLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(txtLabel);

        vsBtn1 = new JButton();
        vsBtn1.setBounds(340, 200, 250, 180);
        vsBtn1.setText("Computer");
        vsBtn1.setFont(myFont2);
        vsBtn1.setForeground(myColor);
        vsBtn1.addActionListener(this);
        panel.add(vsBtn1);

        vsBtn2 = new JButton();
        vsBtn2.setBounds(690, 200, 250, 180);
        vsBtn2.setText("Player");
        vsBtn2.setFont(myFont2);
        vsBtn2.setForeground(myColor);
        vsBtn2.addActionListener(this);
        panel.add(vsBtn2);

        vsBtn3 = new JButton("Tournament");
        vsBtn3.setBounds(515, 420, 250, 180);
        vsBtn3.setFont(myFont2);
        vsBtn3.setForeground(Color.GREEN);
        vsBtn3.addActionListener(this);
        panel.add(vsBtn3);
        vsBtn3.setEnabled(false);

        backBtn = new JButton("<");
        backBtn.setBounds(30, 30, 30, 30);
        backBtn.setFont(myFont3);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        img = new ImageIcon("25.png");
        imgLabel = new JLabel(img);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
		imgLabel.setBounds(0,0, 1280, 800);
		panel.add(imgLabel);

        this.add(panel);
    }


    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if(command.equals(vsBtn1.getText()))
        {
            SelectPage sp = new SelectPage(false);
            sp.setVisible(true);
            this.setVisible(false);
        }
        else if(command.equals(vsBtn2.getText()))
        {
            SelectPage sp = new SelectPage(true);
            sp.setVisible(true);
            this.setVisible(false);
        }
        else if(command.equals(vsBtn3.getText()))
        {
            
        }
        else if(command.equals(backBtn.getText()))
        {
            StartPage sp = new StartPage();
            sp.setVisible(true);
            this.setVisible(false);
        }
    }
}