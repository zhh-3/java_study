package View;

import Tool.PictureJPanle;
import Tool.PictureJbutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWin extends JFrame implements ActionListener {
    public JFrame jFrame = this;
    public PictureJPanle gamePanle;
    public static JButton j1 = new JButton("开始游戏");
    public JButton j2 = new JButton("暂停游戏");
    public JButton j3 = new JButton("提示");
    public JButton j4 = new JButton("重排");
    public JButton j5 = new JButton("设置");
    public JButton j6 = new JButton("帮助");
    public PictureJbutton jbutton[][] = new PictureJbutton[4][4];//选项
    public JButton first=jbutton[0][0],second=jbutton[0][1];//两次选择
    public boolean flag = false;//是否选择
    public static int grid[][] = new int[4][4];//游戏按钮位置
    public int grid2[][] = {{-2,-2,-2,-2},{-2,-2,-2,-2},{-2,-2,-2,-2},{-2,-2,-2,-2}};
    public static int num[][] = new int[4][4];//该处按钮为空，值为1，否则为0
    public int cnum[][] = new int[4][4];
    public int x=-1,y=-1,x0=-1,y0=-1,k=0;//游戏按钮位置坐标
    public int firstMsg=0,secondMsg=0;//每次选择按钮对应的值
    public Graphics g;
    public boolean aBoolean = false;
    public String name;
    public int mk = 1;
    public JProgressBar progress = new JProgressBar(0,20);
    public Timer timer = new Timer(1000,new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            int time = progress.getValue();
            time--;
            progress.setValue(time);
            if (time == 0){
                new WinWindow("可惜，你失败了");
            }
        }
    });

    public GameWin(String str) {
        name = str;
        launch();
    }

    public void launch() {
        jFrame.setTitle("连连看小游戏--"+name);
        jFrame.repaint();
        jFrame.setSize(815,640);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanle = new PictureJPanle("image/游戏界面.png");
        gamePanle.setLayout(null);
        jFrame.add(gamePanle);
        g = this.getGraphics();
        g.setColor(Color.red);

        j1.addActionListener(this);
        j1.setVisible(true);
        j2.addActionListener(this);
        j2.setVisible(false);
        j3.addActionListener(this);
        j3.setVisible(false);
        j4.addActionListener(this);
        j4.setVisible(false);
        j5.addActionListener(this);
        j5.setVisible(true);
        j6.addActionListener(this);
        j6.setVisible(true);

        j1.setSize(120,50);
        j2.setSize(120,50);
        j3.setSize(120,50);
        j4.setSize(120,50);
        j5.setSize(60,40);
        j6.setSize(60,40);
        j1.setLocation(655,50);
        j2.setLocation(655,120);
        j3.setLocation(655,185);
        j4.setLocation(655,255);
        j5.setLocation(735,500);
        j6.setLocation(735,553);
        gamePanle.add(j1);
        gamePanle.add(j2);
        gamePanle.add(j3);
        gamePanle.add(j4);
        gamePanle.add(j5);
        gamePanle.add(j6);
    }

    public void luanch2(){
        String str1 = "image/";
        String str2 = ".png";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] != -1){
                    String url = str1+grid[i][j]+str2;
                    jbutton[i][j] = new PictureJbutton(url);
                    jbutton[i][j].setVisible(true);
                }
                else {
                    jbutton[i][j].setVisible(false);
                }
            }
        }

        //设置宽度
        for (int i = 0;i<4;i++){
            for (int j = 0;j<4;j++){
                if (grid[i][j] != -1)
                    jbutton[i][j].setSize(40,40);
            }
        }

        //设置位置
        for (int i = 0;i<4;i++){
            for (int j = 0;j<4;j++){
                if (grid[i][j] != -1)
                    jbutton[i][j].setLocation(50+j*40,50+i*40);
            }
        }

        for (int i = 0;i<4;i++){
            for (int j = 0;j<4;j++){
                if (grid[i][j] != -1)
                    gamePanle.add(jbutton[i][j]);
            }
        }

        //添加监听器
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] != -1)
                    jbutton[i][j].addActionListener(this);
            }
        }
    }

    public static void init(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num[i][j] = 0;
            }
        }
    }

    public static void init1(){
        grid[0][0] = 2;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 3;
        grid[1][0] = 2;
        grid[1][1] = 2;
        grid[1][2] = 1;
        grid[1][3] = 3;
        grid[2][0] = 2;
        grid[2][1] = 1;
        grid[2][2] = 0;
        grid[2][3] = 0;
        grid[3][0] = 1;
        grid[3][1] = 3;
        grid[3][2] = 0;
        grid[3][3] = 3;
    }

    public void init2(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cnum[i][j] = 0;
            }
        }
    }

    public void init3(int num1[][],int num2[][]){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = num1[i][j];
                num[i][j] = num2[i][j];
            }
        }
    }

    public void remove(){
        g.drawLine(70+40*y0,100+40*x0,70+40*y,100+40*x);
        repaint();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        first.setVisible(false);
        second.setVisible(false);
        grid[x][y] = -1;
        grid[x0][y0] = -1;
        if (++k == 8){
            stop();
            new WinWindow("恭喜你，胜利了");
        }
    }

    public void estimateEven(int placeX,int placeY,JButton bz) {
        if(flag==false) {
            x=placeX;
            y=placeY;
            secondMsg=grid[x][y];
            second=bz;
            flag=true;
            g.drawRect(60+y*40,80+x*40,39,39);
            repaint();
        }else {
            x0=x;
            y0=y;
            firstMsg=secondMsg;
            first=second;
            x=placeX;
            y=placeY;
            secondMsg=grid[x][y];
            second=bz;
            flag = false;
            if(firstMsg==secondMsg && second!=first){
                xiao();
            }
        }
    }

    public void xiao(){
        if((x0==x &&(y0==y+1||y0==y-1)) || ((x0==x+1||x0==x-1)&&(y0==y))){ //判断是否相邻
            remove();
        }
        else {
            init();
            init2();
            judge(x,y,x0,y0);
            if (aBoolean){
                remove();
                aBoolean = false;
            }
        }
    }

    //判断能否连接
    public void judge(int x1,int y1,int x2,int y2){
        num[x1][y1] = 1;
        cnum[x1][y1] = 1;
        if ((x1==x2 &&(y1==y2+1||y1==y2-1)) || ((x1==x2+1||x1==x2-1)&&(y1==y2))){
            cnum[x2][y2] = 1;
            aBoolean = true;
        }
        else {
            if (x1<3&&grid[x1+1][y1] == -1&&num[x1+1][y1]==0){
                judge(x1+1,y1,x2,y2);
                if (aBoolean)
                    return;
                cnum[x1+1][y1] = 0;
            }
            if (y1<3&&grid[x1][y1+1] == -1&&num[x1][y1+1]==0){
                judge(x1,y1+1,x2,y2);
                if (aBoolean)
                    return;
                cnum[x1][y1+1] = 0;
            }
            if (x1>0&&grid[x1-1][y1] == -1&&num[x1-1][y1]==0){
                judge(x1-1,y1,x2,y2);
                if (aBoolean)
                    return;
                cnum[x1-1][y1] = 0;
            }
            if (y1>0&&grid[x1][y1-1] == -1&&num[x1][y1-1]==0){
                judge(x1,y1-1,x2,y2);
                if (aBoolean)
                    return;
                cnum[x1][y1-1] = 0;
            }
        }
    }

    public void remind(){
        int n = 1;
        int x1=-1,x2=-1,y1=-1,y2=-1;
        init2();
        while (n != 3){
            n = 1;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (n == 2){
                        if (grid[x1][y1] == grid[i][j]){
                            init();
                            judge(x1,y1,i,j);
                        }
                        if (aBoolean){
                            x2 = i;
                            y2 = j;
                            aBoolean = false;
                            g.drawLine(70+40*y1,100+40*x1,70+40*y2,100+40*x2);
                            n++;
                        }
                    }
                    if (n == 3){
                        break;
                    }
                    if (n == 1&&grid[i][j]!=-1&&cnum[i][j]==0){
                        x1 = i;
                        y1 = j;
                        cnum[i][j] = 1;
                        n++;
                    }
                }
                if (n == 3){
                    break;
                }
            }
        }

    }

    public void reload(){
        int save[] = new int[17];
        int i,j,n=0;
        for(i=0;i<4;i++) {
            for(j=0;j<4;j++) {
                    save[n]=grid[i][j];
                    n++;
            }
        }
        n--;
        Random num = new Random();
        while (n>=0){
            i = num.nextInt(4);
            j = num.nextInt(4);
            while (grid2[i][j] != -2){
                i = num.nextInt(4);
                j = num.nextInt(4);
            }
            grid2[i][j] = save[n--];
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                grid[i][j] = grid2[i][j];
                if (grid[i][j] == -1){
                    this.num[i][j] = 1;
                }else {
                    this.num[i][j] = 0;
                }
            }
        }
        timer.stop();
        luanch2();
        flag = false;
        timer.start();
    }

    public void stop(){
        timer.stop();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                jbutton[i][j].setVisible(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == j1){
            luanch2();
            //添加倒计时
            progress.setValue(20);
            gamePanle.add(progress);
            progress.setSize(200,10);
            progress.setLocation(100,550);
            JLabel jLabel = new JLabel("计时器");
            jLabel.setSize(100,100);
            jLabel.setLocation(0,500);
            gamePanle.add(jLabel);
            timer.start();
            jFrame.repaint();
            j1.setVisible(false);
            j2.setVisible(true);
            j3.setVisible(true);
            j4.setVisible(true);
        }
        if (e.getSource() == j2){
            if (mk % 2 !=0){
                stop();
                j3.setVisible(false);
                j4.setVisible(false);
                j2.setText("继续游戏");
                mk++;
            }
            else {
                mk++;
                j3.setVisible(true);
                j4.setVisible(true);
                j2.setText("暂停游戏");
                timer.start();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (grid[i][j] != -1){
                            jbutton[i][j].setVisible(true);
                        }
                    }
                }
            }
        }
        if (e.getSource() == j3){
            remind();
        }
        if (e.getSource() == j4){
            reload();
        }
        if (e.getSource() == j5){
            new SetWindow();
        }
        if (e.getSource() == j6){
            new helpwindow(name);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] != -1&&e.getSource()==jbutton[i][j]){
                    estimateEven(i,j,jbutton[i][j]);
                }
            }
        }
    }

}
