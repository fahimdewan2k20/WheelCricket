import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SelectPage extends JFrame implements ActionListener
{
    JPanel panel, panel2;
    JButton doneBtn, backBtn;
    JLabel over, wkt, batName, bowlName, imgLabel, name, txt1, txt2, txt3, txt4;
    JTextField batNameTF, bowlNameTF;
    JComboBox overCombo, wktCombo;
    ImageIcon img, img2;
    Font myFont, myFont2, myFont3;
    Color myColor;
    Boolean state, flag = false;

    public SelectPage(Boolean state)
    {
        super("Selection Page");
        this.setSize(1280,800);
        this.setUndecorated(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.state = state;

        this.myFont = new Font("Cambria", Font.PLAIN, 16);
        this.myFont2 = new Font("Cambria", Font.BOLD, 42);
        this.myFont3 = new Font("Cambria", Font.BOLD, 24);
        this.myColor = new Color(130, 30, 0);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        name = new JLabel();
        name.setText("Wheel Cricket");
        name.setBounds(470, 80, 340, 80);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(myFont2);
        name.setForeground(Color.ORANGE);
        panel.add(name);

        batName = new JLabel("Batsman Name: ");
        batName.setBounds(510,300, 150, 30);
        batName.setFont(myFont);
        batName.setForeground(Color.WHITE);
        panel.add(batName);

        batNameTF = new JTextField();
        batNameTF.setBounds(660, 300, 150, 30);
        panel.add(batNameTF);

        bowlName = new JLabel("Bowler Name: ");
        bowlName.setBounds(510, 350, 150, 30);
        bowlName.setFont(myFont);
        bowlName.setForeground(Color.WHITE);
        panel.add(bowlName);

        bowlNameTF = new JTextField();
        bowlNameTF.setBounds(660, 350, 150, 30);
        panel.add(bowlNameTF);

        over = new JLabel("Select Overs: ");
        over.setBounds(510, 400, 150, 30);
        over.setFont(myFont);
        over.setForeground(Color.WHITE);
        panel.add(over);

        String ov[] = new String[] {"5", "10", "20"};
        overCombo = new JComboBox<String>(ov);
        overCombo.setBounds(660, 400, 70, 30);
        panel.add(overCombo);

        wkt = new JLabel("Select Wickets: ");
        wkt.setBounds(510, 450, 150, 30);
        wkt.setFont(myFont);
        wkt.setForeground(Color.WHITE);
        panel.add(wkt);

        String wicket[] = new String[] {"2", "3", "5", "10"};
        wktCombo = new JComboBox<String>(wicket);
        wktCombo.setBounds(660, 450, 70, 30);
        panel.add(wktCombo);

        addButton();
        panel.add(doneBtn);
        panel.add(backBtn);
        checkState();

        img = new ImageIcon("12.png");
        imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0, 1280, 800);
        panel.add(imgLabel);

        this.add(panel);
    }

    public void select()
    {
        flag = true;
        panel.setVisible(false);;
        panel2 = new JPanel();
        panel2.setLayout(null);

        txt4 = new JLabel(overCombo.getSelectedItem().toString() + " over match");
        txt4.setBounds(400, 200, 480, 50);
        txt4.setHorizontalAlignment(JLabel.CENTER);
        txt4.setFont(myFont3);
        txt4.setForeground(Color.MAGENTA);
        panel2.add(txt4);

        if(state)
        {
            txt1 = new JLabel(batNameTF.getText());
        }
        else
        {
            txt1 = new JLabel("Computer");
        }
        txt1.setBounds(400, 250, 480, 80);
        txt1.setHorizontalAlignment(JLabel.CENTER);
        txt1.setFont(myFont2);
        txt1.setForeground(Color.YELLOW);
        panel2.add(txt1);

        txt2 = new JLabel("VS");
        txt2.setBounds(400, 330, 480, 80);
        txt2.setHorizontalAlignment(JLabel.CENTER);
        txt2.setFont(myFont2);
        txt2.setForeground(Color.WHITE);
        panel2.add(txt2);

        txt3 = new JLabel(bowlNameTF.getText());
        txt3.setBounds(400, 410, 480, 80);
        txt3.setHorizontalAlignment(JLabel.CENTER);
        txt3.setFont(myFont2);
        txt3.setForeground(Color.RED);
        panel2.add(txt3);

        addButton();
        doneBtn.setText("continue");
        panel2.add(doneBtn);
        panel2.add(backBtn);

        panel2.setBackground(Color.DARK_GRAY);
        img2 = new ImageIcon("24.png");
        imgLabel = new JLabel(img2);
		imgLabel.setBounds(0,0, 1280, 800);
        panel2.add(imgLabel);
        
        this.add(panel2);
    }

    public void addButton()
    {
        doneBtn = new JButton("Done");
        doneBtn.setBounds(600, 550, 80, 30);
        doneBtn.addActionListener(this);

        backBtn = new JButton("<");
        backBtn.setBounds(30, 30, 30, 30);
        backBtn.setHorizontalAlignment(JLabel.CENTER);
        backBtn.setFont(myFont3);
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setOpaque(true);
        backBtn.addActionListener(this);
    }

    public void checkState()
    {
        if(state == true)
        {
            batName.setVisible(true);
            batNameTF.setVisible(true);
            bowlName.setText("Bowler Name: ");
        }
        else if(state == false)
        {
            batName.setVisible(false);
            batNameTF.setVisible(false);
            bowlName.setText("Player Name: ");
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();
        if(command.equals("continue"))
        {  
            String batName;
            String bowlName = bowlNameTF.getText();
            String over = overCombo.getSelectedItem().toString();
            int tWkt = Integer.parseInt(wktCombo.getSelectedItem().toString());
            int tOver = Integer.parseInt(over);
            int ballRemain = 6*tOver;

            if(state)
            {
                batName = batNameTF.getText();

                WheelCricket wc = new WheelCricket(batName, bowlName, tWkt, 0, 0, ballRemain, 3, true, false, tOver, 0);
                wc.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                batName = "Computer";
                WheelCricket wc = new WheelCricket(bowlName, batName, tWkt, 0, 0, ballRemain, 3, true, false, tOver, 0);
                wc.setVisible(true);
                this.setVisible(false);
            }
        }
        else if(command.equals("Done"))
        {
            select();
        }
        else if(command.equals("<"))
        {
            if(!flag)
            {
                SelectMode sm = new SelectMode();
                sm.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                SelectPage sp = new SelectPage(state);
                sp.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}