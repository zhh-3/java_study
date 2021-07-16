package lifegame;

import org.junit.Test;
import test1.Config;

import static org.junit.Assert.assertEquals;

public class ConfigTest {

    private Config config = new Config();

    //测试属性值是否为空
    @Test
    public void EleTest(){
        //完成属性的赋值
        config.setNum(30);
        config.setBwidth(200);
        config.setBheight(50);
        config.setHeight1();
        config.setWidth1();
        config.setWidth2();
        config.setHeight2();
        config.setN();

        //对结果进行检测，比对期望
        assertEquals(config.getNum(),30);
        assertEquals(config.getBheight(),50);
        assertEquals(config.getBwidth(),200);
        assertEquals(config.getHeight1(),800);
        assertEquals(config.getWidth1(),620);
        assertEquals(config.getHeight2(),650);
        assertEquals(config.getWidth2(),610);
        assertEquals(config.getN(),20);
    }
}