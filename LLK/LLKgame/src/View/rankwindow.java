package View;

import Tool.PictureJPanle;

import javax.swing.*;

public class rankwindow {
    static JFrame jFrame = new JFrame("游戏排行榜");
    static PictureJPanle jPanel = new PictureJPanle("image/排行榜.png");
    public rankwindow(){
        launch();
    }

    public void launch(){
        jPanel.setSize(284,174);
        jPanel.setVisible(true);
        jFrame.setBounds(500,500,300,180);
        jFrame.setVisible(true);
        jFrame.add(jPanel);
    }
}
