package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetWindow extends JFrame implements ActionListener {
    static JButton j1 = new JButton("主题设置");
    static JButton j2 = new JButton("音效设置");
    static JLabel l1 = new JLabel("默认");
    static JLabel l2 = new JLabel("自定义");
    static JCheckBox rdobtn1 = new JCheckBox("水果世界",true);
    static JCheckBox rdobtn2 = new JCheckBox("动漫世界");
    static JCheckBox rdobtn3 = new JCheckBox("自定义");
    static JButton j3 = new JButton("确认");
    static JButton j4 = new JButton("取消");

    public SetWindow(){
        launch();
    }

    public void launch(){
        setLayout(null);
        setVisible(true);
        setSize(500,700);
        j1.setSize(100,50);
        j1.setLocation(50,50);
        j2.setSize(100,50);
        j2.setLocation(150,50);
        this.getContentPane().add(j1);
        this.getContentPane().add(j2);
        j1.addActionListener(this);
    }

    public void launch2(){
        l1.setSize(100,50);
        l1.setLocation(50,150);
        rdobtn1.setSize(100,50);
        rdobtn2.setSize(100,50);
        rdobtn1.setLocation(150,200);
        rdobtn2.setLocation(300,200);
        l2.setSize(100,50);
        l2.setLocation(50,250);
        rdobtn3.setSize(100,50);
        rdobtn3.setLocation(200,300);
        j3.setSize(70,40);
        j4.setSize(70,40);
        j3.setLocation(150,450);
        j4.setLocation(330,450);
//        ButtonGroup grp = new ButtonGroup();

        this.getContentPane().add(l1);
        this.getContentPane().add(l2);
        this.getContentPane().add(rdobtn1);
        this.getContentPane().add(rdobtn2);
        this.getContentPane().add(rdobtn3);
        this.getContentPane().add(j3);
        this.getContentPane().add(j4);
        j3.addActionListener(this);
        j4.addActionListener(this);
        /*grp.add(rdobtn1);
        grp.add(rdobtn2);
        grp.add(rdobtn3);*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == j1){
            launch2();
            repaint();
        }else if (e.getSource() == j3){

        }else if (e.getSource() == j4){
            setVisible(false);
        }
    }
}
