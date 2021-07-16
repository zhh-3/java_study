package View;

import Tool.PictureJPanle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainwindow implements ActionListener {
    static JFrame jFrame = new JFrame("连连看小游戏");
    static PictureJPanle mainPanle = new PictureJPanle("image/主界面.png");
    static JButton j1 = new JButton("基本模式");
    static JButton j2 = new JButton("休闲模式");
    static JButton j3 = new JButton("关卡模式");
    static JButton j4 = new JButton("排行榜");
    static JButton j5 = new JButton("设置");
    static JButton j6 = new JButton("帮助");
    public mainwindow() {
        launch();
    }

    public void launch() {
        jFrame.repaint();
        jFrame.setSize(810,640);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanle.setLayout(null);
        jFrame.add(mainPanle);


        j1.addActionListener(this);
        j2.addActionListener(this);
        j3.addActionListener(this);
        j4.addActionListener(this);
        j5.addActionListener(this);
        j6.addActionListener(this);
        j1.setSize(100,60);
        j2.setSize(100,60);
        j3.setSize(100,60);
        j4.setSize(80,50);
        j5.setSize(65,50);
        j6.setSize(65,50);
        j1.setLocation(28,225);
        j2.setLocation(28,330);
        j3.setLocation(28,435);
        j4.setLocation(580,550);
        j5.setLocation(665,550);
        j6.setLocation(735,550);
        mainPanle.add(j1);
        mainPanle.add(j2);
        mainPanle.add(j3);
        mainPanle.add(j4);
        mainPanle.add(j5);
        mainPanle.add(j6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == j1){
            jFrame.setVisible(false);
            GameWin.init();
            GameWin.init1();
            new GameWin("基本模式");
        }else if (e.getSource() == j2){
            jFrame.setVisible(false);
            GameWin.init();
            GameWin.init1();
            new GameWin("休闲模式");
        }else if (e.getSource() == j3){
            jFrame.setVisible(false);
            GameWin.init();
            GameWin.init1();
            new GameWin("关卡模式");
        }else if (e.getSource() == j4){
            new rankwindow();
        }else if (e.getSource() == j5){
            new SetWindow();
        }else if (e.getSource() == j6){
            new helpwindow("基本模式");
        }
    }
}
