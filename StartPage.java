import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage extends JFrame implements ActionListener, MouseListener
{
    JButton playBtn, instructBtn, exitBtn, optionBtn;
    JPanel panel;
    JLabel imgLabel, name, label;
    ImageIcon img, img2;
    Font myFont, myFont2;

    public StartPage()
    {
        super("Start Page");
        this.setSize(1280, 800);
        this.setUndecorated(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.myFont = new Font("Cambria", Font.BOLD, 52);
        this.myFont2 = new Font("Cambria", Font.BOLD, 18);

        panel = new JPanel();
        panel.setLayout(null);

        name = new JLabel();
        name.setText("Wheel Cricket");
        name.setBounds(440, 80, 400, 100);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(myFont);
        name.setForeground(Color.DARK_GRAY);
        panel.add(name);

        playBtn = new JButton("Play");
        playBtn.setBounds(600, 300, 100, 40);
        //playBtn.setOpaque(true);
        playBtn.addMouseListener(this);
        playBtn.addActionListener(this);
        panel.add(playBtn);

        optionBtn = new JButton("Option");
        optionBtn.setBounds(600, 350, 100, 40);
        //optionBtn.setOpaque(true);
        //optionBtn.setMouseListener(this);
        optionBtn.addActionListener(this);
        optionBtn.setEnabled(false);
        panel.add(optionBtn);

        instructBtn = new JButton("Instruction");
        instructBtn.setBounds(600, 400, 100, 40);
        //instructBtn.setOpaque(true);
        //instructBtn.setMouseListener(this);
        instructBtn.addActionListener(this);
        instructBtn.setEnabled(false);
        panel.add(instructBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(600, 450, 100, 40);
        //exitBtn.setOpaque(true);
        exitBtn.addMouseListener(this);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        label = new JLabel("Created by Fahim");
        label.setBounds(1100, 720, 180, 50);
        label.setFont(myFont2);
        label.setForeground(Color.CYAN);
        panel.add(label);

        img = new ImageIcon("abc.jpg");
        imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0, 1280, 800);
		panel.add(imgLabel);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if(command.equals("Play"))
        {
            SelectMode sm = new SelectMode();
            sm.setVisible(true);
            this.setVisible(false);
        }
        // else if(command.equals("Option"))
        // {

        // }
        // else if(command.equals("Instruction"))
        // {

        // }
        else if(command.equals("Exit"))
        {
            System.exit(0);
        }
    }

    public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        // if(me.getSource() == playBtn)
        // {
        //     playBtn.setBackground(Color.GREEN);
        //     playBtn.setForeground(Color.WHITE);
        // }
        // else if(me.getSource() == exitBtn)
        // {
        //     exitBtn.setBackground(Color.RED);
        //     exitBtn.setForeground(Color.WHITE);
        // }
    }
    public void mouseExited(MouseEvent me)
    {
        // if(me.getSource() == playBtn)
        // {
        //     playBtn.setBackground(Color.WHITE);
        //     playBtn.setForeground(Color.BLACK);
        // }
        // else if(me.getSource() == exitBtn)
        // {
        //     exitBtn.setBackground(Color.WHITE);
        //     exitBtn.setForeground(Color.BLACK);
        // }
    }
}