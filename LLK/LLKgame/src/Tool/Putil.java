package Tool;

import javax.swing.*;
import java.awt.*;

public class Putil {
    //返回指定路径图片对象
    public static Image getimage(String url){
        ImageIcon icon = new ImageIcon(Putil.class.getClassLoader().getResource(url));
        return icon.getImage();
    }
}
