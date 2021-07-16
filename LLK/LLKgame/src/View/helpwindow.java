package View;

import Tool.PictureJPanle;

import javax.swing.*;
import java.awt.*;

public class helpwindow extends JFrame {
    static PictureJPanle jPanle;
    public helpwindow(String name){
        jPanle = new PictureJPanle("image/"+name+".png");
        launch();
    }

    public void launch(){
        setTitle("连连看游戏---帮助");
        setSize(755,670);
        setVisible(true);
        add(jPanle);
        jPanle.setVisible(true);
    }
}
