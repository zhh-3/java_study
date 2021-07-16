package lifegame;

import org.junit.Before;
import org.junit.Test;
import test1.Life_Game;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class GUI_Text {

    Life_Game ui;
    @Before
    public void setUp() {
        ui = new Life_Game();
    }

    //对属性值检测
    @Test
    public void variate(){
        //按钮属性值
        assertEquals(200, ui.j3.getWidth());
        assertEquals(50, ui.j3.getHeight());

        //jFrame属性值，jPanel属性值
        //jFrame
        assertEquals(true, ui.jFrame.isVisible());
        assertEquals(3, ui.jFrame.getDefaultCloseOperation());//close操作时，operation值
        assertEquals(620, ui.jFrame.getWidth());
        assertEquals(800, ui.jFrame.getHeight());
        //jPanel
        assertEquals(true, ui.jPanel.isVisible());
        assertEquals(true, ui.jPanel2.isVisible());
        assertEquals(610, ui.jPanel2.getWidth());
        assertEquals(650, ui.jPanel2.getHeight());

        //速度初始化赋值
        assertEquals(500, ui.speed);
    }

    //模拟点击
    @Test
    public void doClick(){
        //点击地图尺寸
        ui.size2.doClick();
        assertEquals(30, ui.num);
        //点击初始化
        ui.item1.doClick();
        assertEquals(Color.BLACK, ui.jButtons[8][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[9][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[12][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[13][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[13][3].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[13][4].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[8][7].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[9][6].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][6].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][6].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[12][6].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[13][7].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[9][8].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][8].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][8].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[12][8].getBackground());
        //点击速度
        ui.speed1.doClick();
        assertEquals(100, ui.speed);
        //点击下一步
        ui.j5.doClick();
        assertEquals(Color.BLACK, ui.jButtons[9][1].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[9][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[9][3].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][1].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[10][3].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][1].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][2].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[11][3].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[12][1].getBackground());
        assertEquals(Color.BLACK, ui.jButtons[12][2].getBackground());
        //点击开始按钮
        ui.j3.doClick();
        assertEquals(false, ui.config.flag);
        //点击新游戏按钮
        ui.j4.doClick();
        assertEquals(1, ui.gamenum);
    }
}
