import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    //All the Frame coding, done inside the constructor
    JButton rules,back;
    JTextField tfname;
    Login(){
        //Firstly picked up the whole frame then the background will be change
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading=new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Vimer Hand ITC", Font.BOLD, 40));
        //TO change font color
        //heading.setForeground(Color.BLUE);
        //on rgb to make obj of color class
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30,144,254));
        add(name);

        tfname=new JTextField();
        tfname.setBounds(735,200, 300, 25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);

        rules=new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back=new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        //Differenciate rules and back button
        if(ae.getSource()==rules){
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if(ae.getSource()==back){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Login();//Anonymous object
    }
}