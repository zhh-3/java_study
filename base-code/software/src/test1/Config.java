package test1;

public class Config {
    //每行细胞个数
    private int num ;
    //每个细胞长度大小
    private int n ;
    //装细胞的jpanel参数
    private int width2 ;
    private int height2 ;

    //jfarm参数
    private int width1 ;
    private int height1 ;

    //按钮参数
    private int Bwidth ;
    private int Bheight ;

    //游戏名
    public String gamename = "生命游戏";
    //菜单选项名
    public String menu1 = "初始化选项";
    public String menu2 = "速度";
    public String menu3 = "地图尺寸";
    //初始化选项
    public String item1 = "ramdom";
    public String item2 = "love";
    public String item3 = "一箭穿心";
    //速度选项
    public String speed_1 = "100";
    public String speed_2 = "200";
    public String speed_3 = "1000";
    //地图尺寸
    public String big1 = "10";
    public String big2 = "30";
    public String big3 = "60";
    //按钮名称
    public String start = "开始";
    public String stop = "暂停";
    public String conti = "继续";
    public String newgame = "新游戏";
    public String next = "下一步";
    public boolean flag = false;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getN() {
        return n;
    }

    public void setN() {
        this.n = (getWidth2()-10)/getNum();
    }

    public int getWidth2() {
        return width2;
    }

    public void setWidth2() {
        this.width2 = getWidth1()-10;
    }

    public int getHeight2() {
        return height2;
    }

    public void setHeight2() {
        this.height2 = getHeight1()-150;
    }

    public int getWidth1() {
        return width1;
    }

    public void setWidth1() {
        this.width1 = getBwidth()*3+20;
    }

    public int getHeight1() {
        return height1;
    }

    public void setHeight1() {
        this.height1 = getBwidth()*3+getBheight()+150;
    }

    public int getBwidth() {
        return Bwidth;
    }

    public void setBwidth(int bwidth) {
        Bwidth = bwidth;
    }

    public int getBheight() {
        return Bheight;
    }

    public void setBheight(int bheight) {
        this.Bheight = bheight;
    }

}
