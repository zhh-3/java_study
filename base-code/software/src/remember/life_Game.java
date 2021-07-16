package remember;

import test1.Cell;
import test1.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class life_Game {
    static Config config = new Config();
    static JFrame jFrame = new JFrame(config.gamename);
    static JPanel jPanel = new JPanel();
    static JMenuBar jMenuBar = new JMenuBar();
    static JMenu j1 = new JMenu(config.menu1);
    static JMenu j2 = new JMenu(config.menu2);
    static JButton j3 = new JButton(config.start);
    static JButton j4 = new JButton(config.newgame);
    static JButton j5 = new JButton(config.next);
    static JMenuItem random = new JMenuItem(config.item1);
    static JMenuItem item1 = new JMenuItem(config.item2);
    static JMenuItem item2 = new JMenuItem(config.item3);
    static JMenuItem speed1 = new JMenuItem(config.speed_1);
    static JMenuItem speed2 = new JMenuItem(config.speed_2);
    static JMenuItem speed3 = new JMenuItem(config.speed_3);
    static JPanel jPanel2 = new JPanel();
    static MyThread mythread = null;
    static JButton jButtons[][];
    static Cell cell ;
    static int speed = 500;

    public life_Game(){
        setConfig();
        cell = new Cell(config.getNum());
        jButtons = new JButton[config.getNum()][config.getNum()];
        jFrame.setVisible(true);
        jFrame.setBounds(500,30,config.getWidth1(),config.getHeight1());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.setVisible(true);
        jPanel.setLayout(null);

        jPanel2.setVisible(true);
        jPanel2.setLayout(null);
        jPanel2.setBounds(0,50,config.getWidth2(),config.getHeight2());
        jFrame.add(jPanel);
        jPanel.add(jPanel2);

        jMenuBar.setBorderPainted(true);
        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.add(j1);
        jMenuBar.add(j2);

        j1.add(random);
        j1.add(item1);
        j1.add(item2);
        random.addActionListener(new datainit());
        item1.addActionListener(new datainit());
        item2.addActionListener(new datainit());

        j2.add(speed1);
        j2.add(speed2);
        j2.add(speed3);
        speed1.addActionListener(new changespeed());
        speed2.addActionListener(new changespeed());
        speed3.addActionListener(new changespeed());

        j3.setBounds(0,0,config.getBwidth(),config.getBheight());
        j4.setBounds(config.getBwidth()*2,0,config.getBwidth(),config.getBheight());
        j5.setBounds(config.getBwidth(),0,config.getBwidth(),config.getBheight());
        jPanel.add(j3);
        jPanel.add(j4);
        jPanel.add(j5);
        j3.addActionListener(new start());
        j4.addActionListener(new newstart());
        j3.setVisible(true);
        j4.setVisible(false);
        j5.addActionListener(new next());
    }

    public void setConfig(){
        //设置按钮参数
        config.setBheight(50);
        config.setBwidth(200);

        //设置细胞参数
        config.setNum(30);//每行细胞个数

        //设置GUI参数
        config.setHeight1();
        config.setWidth1();
        config.setWidth2();
        config.setHeight2();

        //设置细胞大小
        config.setN();
    }

    public void map(){
        for (int i = 1; i <= config.getNum(); i++) {
            for (int j = 1; j <= config.getNum(); j++) {
                jButtons[i-1][j-1] = new JButton();
                jButtons[i-1][j-1].setVisible(true);
                jButtons[i-1][j-1].setBounds((j-1)*config.getN(),50+(i-1)*config.getN(),config.getN(),config.getN());
                if (cell.cellist[i][j] == 0){
                    jButtons[i-1][j-1].setBackground(Color.WHITE);
                }else {
                    jButtons[i-1][j-1].setBackground(Color.black);
                }
                jPanel2.add(jButtons[i-1][j-1]);
            }
        }
        jPanel2.repaint();
    }

    public void redraw(String str){
        if (str.equals(config.item1)){
            cell.init();
        }else if(str.equals(config.item2)){
            cell.init2();
        }else if(str.equals(config.item3)){
            cell.init3();
        }
        jPanel2.removeAll();
        map();
    }

    class datainit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==random){
                redraw(config.item1);
                config.flag = true;
            }else if (e.getSource()==item1){
                redraw(config.item2);
                config.flag = true;
            }else if (e.getSource()==item2){
                redraw(config.item3);
                config.flag = true;
            }
        }
    }

    class changespeed implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==speed1){
                speed = (int)Integer.parseInt(config.speed_1);
            }else if (e.getSource()==speed2){
                speed = (int)Integer.parseInt(config.speed_2);
            }else if (e.getSource()==speed3){
                speed = (int)Integer.parseInt(config.speed_3);
            }
        }
    }

    class start implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (j3.getText().equals(config.start)){
                j3.setText(config.stop);
                j4.setVisible(true);
                mythread = new MyThread();
                mythread.start();
                config.flag = false;
            }else if (j3.getText().equals(config.stop)){
                j3.setText(config.conti);
                if (mythread != null)
                    mythread.stop();
                mythread = null;
                config.flag = true;
            }else if(j3.getText().equals(config.conti)){
                j3.setText(config.stop);
                mythread = new MyThread();
                mythread.start();
                config.flag = false;
            }
        }
    }

    class newstart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mythread != null)
                mythread.stop();
            mythread = new MyThread();
            j3.setText(config.stop);
            redraw(config.item1);
            mythread.start();
        }
    }

    class next implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (config.flag){
                cell.change();
                jPanel2.removeAll();
                map();
            }

        }
    }

    class MyThread extends Thread{
        public void run(){
            while (true){
                cell.change();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                jPanel2.removeAll();
                map();
            }
        }
    }
}