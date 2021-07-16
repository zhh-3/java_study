package lifegame;

import org.junit.Before;
import org.junit.Test;
import test1.Cell;

import static junit.framework.TestCase.assertEquals;

public class CellTest {
    int n = 3;
    private Cell cell = new Cell(n);
    int pri[][] = {{0,0,0,0,0},{0,1,1,1,0},{0,0,1,0,0},{0,1,1,1,0},{0,0,0,0,0}};

    @Before
    public void setUp() throws Exception {
        cell.setCellist(pri);
    }

    //变量赋值
    @Test
    public void variate(){
        assertEquals(3,cell.getNum());
    }

    //边缘测试
    @Test
    public void edge(){
        boolean flag = true;
        cell.clear();
        cell.change();
        int a[][] = cell.getlist();//获取到的细胞数组
        int b[][] = new int[n+2][n+2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] != b[i][j]){
                    flag = false;
                }
            }
        }
        assertEquals(true,flag);
    }

    //细胞数组测试
    @Test
    public void setCell(){
        int a[][] = cell.getlist();
        boolean flag=true;
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (a[i][j] != pri[i][j]){
                    flag = false;
                }
            }
        }
        assertEquals(true,flag);
    }
    @Test
    public void judge() {
        int num = 6,count = 0;
        count = cell.judge(2,2);
        assertEquals(num,count);
    }

    @Test
    public void change() {
        cell.change();
        int a[][] = cell.getlist();
        //理论上的改变后的数组
        int b[][] = {{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0}};
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                assertEquals(a[i][j],b[i][j]);
            }
        }
    }
}