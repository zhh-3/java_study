package Tool;

import Tool.Putil;

import javax.swing.*;
import java.awt.*;

public class PictureJPanle extends JPanel {
    private Image background;
    public PictureJPanle(String url){
        background = Putil.getimage(url);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,null);
        super.setVisible(true);
    }
}
