package View;

import Tool.p;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomewindow implements ActionListener {
    public static JFrame jFrame = new JFrame();
    public static JLabel label = new JLabel("Welcome to LLK-game");
    public static JButton button1 = new JButton("开始游戏");
    public static JButton button2 = new JButton("退出游戏");

    public welcomewindow(){
        launch();
    }

    public void launch(){

        jFrame.setTitle("连连看小游戏");
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.WHITE);
        jPanel.setLayout(null);
        jFrame.add(jPanel);

        label.setSize(300,50);
        button1.setSize(100,50);
        button2.setSize(100,50);

        label.setLocation(100,135);
        button1.setLocation(50,185);
        button2.setLocation(200,185);
        jPanel.add(label);
        jPanel.add(button1);
        jPanel.add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
            jFrame.setVisible(false);
            new mainwindow();
        }
        else if (e.getSource() == button2){
            System.exit(0);
        }
    }
}
