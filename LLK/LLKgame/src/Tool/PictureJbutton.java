package Tool;

import javax.swing.*;
import java.awt.*;

public class PictureJbutton extends JButton {
    private Image background;
    public PictureJbutton(String url){
        background = Putil.getimage(url);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,null);
        super.setVisible(true);
    }
}
