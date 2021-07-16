package test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Life_Game {
    public Config config = new Config();
    public JFrame jFrame = new JFrame(config.gamename);
    public JPanel jPanel = new JPanel();
    public JMenuBar jMenuBar = new JMenuBar();
    public JMenu j1 = new JMenu(config.menu1);
    public JMenu j2 = new JMenu(config.menu2);
    public JMenu big = new JMenu(config.menu3);
    public JButton j3 = new JButton(config.start);
    public JButton j4 = new JButton(config.newgame);
    public JButton j5 = new JButton(config.next);
    public JMenuItem size1 = new JMenuItem(config.big1);
    public JMenuItem size2 = new JMenuItem(config.big2);
    public JMenuItem size3 = new JMenuItem(config.big3);
    public JMenuItem random = new JMenuItem(config.item1);
    public JMenuItem item1 = new JMenuItem(config.item2);
    public JMenuItem item2 = new JMenuItem(config.item3);
    public JMenuItem speed1 = new JMenuItem(config.speed_1);
    public JMenuItem speed2 = new JMenuItem(config.speed_2);
    public JMenuItem speed3 = new JMenuItem(config.speed_3);
    public JPanel jPanel2 = new JPanel();
    public MyThread mythread = null;
    public JButton jButtons[][];
    public int num;
    public int n;
    public Cell cell;
    public int speed = 500;
    public static int gamenum = 0;

    public Life_Game() {
        setConfig();

        jFrame.setVisible(true);
        jFrame.setBounds(500, 30, config.getWidth1(), config.getHeight1());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.setVisible(true);
        jPanel.setLayout(null);

        jPanel2.setVisible(true);
        jPanel2.setLayout(null);
        jPanel2.setBounds(0, 50, config.getWidth2(), config.getHeight2());
        jFrame.add(jPanel);
        jPanel.add(jPanel2);

        jMenuBar.setBorderPainted(true);
        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.add(big);
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

        big.add(size1);
        big.add(size2);
        big.add(size3);
        size1.addActionListener(new mapsize());
        size2.addActionListener(new mapsize());
        size3.addActionListener(new mapsize());

        j3.setBounds(0, 0, config.getBwidth(), config.getBheight());
        j4.setBounds(config.getBwidth()*2, 0,config.getBwidth(), config.getBheight());
        j5.setBounds(config.getBwidth(), 0,config.getBwidth(), config.getBheight());
        jPanel.add(j3);
        jPanel.add(j4);
        jPanel.add(j5);
        j3.addActionListener(new start());
        j4.addActionListener(new newstart());
        j3.setVisible(true);
        j4.setVisible(false);
        j5.addActionListener(new next());
    }

    public void initmap(){
        config.setNum(num);
        config.setN();
        n = config.getN();
        cell = new Cell(num);
        jButtons = new JButton[num][num];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                jButtons[i-1][j-1] = new JButton();
                jButtons[i-1][j-1].setVisible(true);
                jButtons[i-1][j-1].setBackground(Color.white);
                jButtons[i-1][j-1].setBounds((j-1)*n,50+(i-1)*n,n,n);
                jPanel2.add(jButtons[i-1][j-1]);
            }
        }
        jPanel2.repaint();
    }

    public void setConfig() {
        //设置按钮参数
        config.setBheight(50);
        config.setBwidth(200);

        //设置GUI参数
        config.setHeight1();
        config.setWidth1();
        config.setWidth2();
        config.setHeight2();
    }

    public void map() {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (cell.cellist[i][j] == 0){
                    jButtons[i-1][j-1].setBackground(Color.WHITE);
                }else {
                    jButtons[i-1][j-1].setBackground(Color.black);
                }
            }
        }
        jPanel2.repaint();
    }

    public void redraw(String str) {
        if (str.equals(config.item1)){
            cell.init();
        }else if(str.equals(config.item2)){
            cell.init2();
        }else if(str.equals(config.item3)){
            cell.init3();
        }
        map();
    }

    class datainit implements ActionListener {

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

    class changespeed implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==speed1){
                speed = Integer.parseInt(config.speed_1);
            }else if (e.getSource()==speed2){
                speed = Integer.parseInt(config.speed_2);
            }else if (e.getSource()==speed3){
                speed = Integer.parseInt(config.speed_3);
            }
        }
    }

    class mapsize implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == size1){
                num = Integer.parseInt(config.big1);
                item1.setVisible(false);
                item2.setVisible(false);
            }else if(e.getSource() == size2){
                num = Integer.parseInt(config.big2);
                item1.setVisible(true);
                item2.setVisible(true);
            }else if (e.getSource() == size3){
                num = Integer.parseInt(config.big3);
                item1.setVisible(true);
                item2.setVisible(true);
            }
            jPanel2.removeAll();
            initmap();
        }
    }

    class start implements ActionListener {

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

    class newstart implements ActionListener {

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

    class next implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (config.flag){
                cell.change();
                map();
            }
        }
    }

    class MyThread extends Thread {
        public void run(){
            gamenum++;
//            System.out.println(gamenum);
            while (true){
                cell.change();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                map();
            }
        }
    }
}