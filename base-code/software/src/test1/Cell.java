package test1;

public class Cell {
    public int num; //边长
    public int[][] cellist;

    public Cell(int num) {
        this.num = num;
        cellist = new int[num + 2][num + 2];
    }

    //自定义设置
    public void setCellist(int [][]a) {
        for (int i = 0; i < num + 2; i++) {
            for (int j = 0; j < num + 2; j++) {
                cellist[i][j] = a[i][j];
            }
        }
    }

    //初始化细胞
    public void init() {
        for (int i = 0; i < num + 2; i++) {
            for (int j = 0; j < num + 2; j++) {
                if (i == 0 || j == 0 || i == (num + 1) || j == (num + 1)) {
                    cellist[i][j] = 0;
                } else {
                    cellist[i][j] = (int) (Math.random() + 0.5);
                }
            }
        }
    }

    //LOVE
    public void init2() {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                cellist[i][j] = 0;
            }
        }
        cellist[9][3] = 1;
        cellist[10][3] = 1;
        cellist[11][3] = 1;
        cellist[12][3] = 1;
        cellist[13][3] = 1;
        cellist[14][3] = 1;
        cellist[14][4] = 1;
        cellist[14][5] = 1;

        cellist[9][8] = 1;
        cellist[10][7] = 1;
        cellist[11][7] = 1;
        cellist[12][7] = 1;
        cellist[13][7] = 1;
        cellist[14][8] = 1;
        cellist[10][9] = 1;
        cellist[11][9] = 1;
        cellist[12][9] = 1;
        cellist[13][9] = 1;

        cellist[9][11] = 1;
        cellist[10][12] = 1;
        cellist[11][13] = 1;
        cellist[12][14] = 1;
        cellist[13][15] = 1;
        cellist[14][16] = 1;
        cellist[13][17] = 1;
        cellist[12][18] = 1;
        cellist[11][19] = 1;
        cellist[10][20] = 1;
        cellist[9][21] = 1;

        cellist[9][23] = 1;
        cellist[9][24] = 1;
        cellist[9][25] = 1;
        cellist[9][26] = 1;
        cellist[10][23] = 1;
        cellist[11][23] = 1;
        cellist[12][23] = 1;
        cellist[12][24] = 1;
        cellist[12][25] = 1;
        cellist[12][26] = 1;
        cellist[13][23] = 1;
        cellist[14][23] = 1;
        cellist[15][23] = 1;
        cellist[15][24] = 1;
        cellist[15][25] = 1;
        cellist[15][26] = 1;
    }

    //一箭穿心
    public void init3(){
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                cellist[i][j] = 0;
            }
        }
        cellist[10][1] = 1;
        cellist[11][2] = 1;
        cellist[14][1] = 1;
        cellist[13][2] = 1;
        cellist[12][3] = 1;
        cellist[12][4] = 1;
        cellist[12][5] = 1;
        cellist[12][6] = 1;
        cellist[12][7] = 1;
        cellist[12][8] = 1;
        cellist[12][9] = 1;
        cellist[12][10] = 1;
        cellist[12][11] = 1;
        cellist[12][12] = 1;
        cellist[12][13] = 1;
        cellist[12][14] = 1;
        cellist[12][15] = 1;
        cellist[12][16] = 1;
        cellist[12][17] = 1;
        cellist[12][18] = 1;
        cellist[12][19] = 1;
        cellist[12][20] = 1;
        cellist[12][21] = 1;
        cellist[12][22] = 1;
        cellist[12][23] = 1;
        cellist[12][24] = 1;
        cellist[12][25] = 1;
        cellist[12][26] = 1;
        cellist[12][27] = 1;
        cellist[12][28] = 1;
        cellist[12][29] = 1;
        cellist[10][5] = 1;
        cellist[11][5] = 1;
        cellist[13][5] = 1;
        cellist[9][6] = 1;
        cellist[14][6] = 1;
        cellist[8][7] = 1;
        cellist[15][7] = 1;
        cellist[8][8] = 1;
        cellist[16][8] = 1;
        cellist[8][9] = 1;
        cellist[17][9] = 1;
        cellist[9][10] = 1;
        cellist[18][10] = 1;
        cellist[10][11] = 1;
        cellist[19][11] = 1;
        cellist[9][12] = 1;
        cellist[18][12] = 1;
        cellist[8][13] = 1;
        cellist[17][13] = 1;
        cellist[8][14] = 1;
        cellist[16][14] = 1;
        cellist[8][15] = 1;
        cellist[15][15] = 1;
        cellist[16][15] = 1;
        cellist[9][16] = 1;
        cellist[14][16] = 1;
        cellist[17][16] = 1;
        cellist[9][17] = 1;
        cellist[10][17] = 1;
        cellist[11][17] = 1;
        cellist[13][17] = 1;
        cellist[18][17] = 1;
        cellist[10][18] = 1;
        cellist[19][18] = 1;
        cellist[9][19] = 1;
        cellist[18][19] = 1;
        cellist[8][20] = 1;
        cellist[17][20] = 1;
        cellist[8][21] = 1;
        cellist[16][21] = 1;
        cellist[8][22] = 1;
        cellist[15][22] = 1;
        cellist[9][23] = 1;
        cellist[14][23] = 1;
        cellist[10][24] = 1;
        cellist[11][24] = 1;
        cellist[13][24] = 1;
        cellist[9][26] = 1;
        cellist[15][26] = 1;
        cellist[10][27] = 1;
        cellist[14][27] = 1;
        cellist[11][28] = 1;
        cellist[13][28] = 1;
    }

    //获取细胞列表
    public int[][] getlist() {
        if (cellist == null) {
            return null;
        } else {
            return cellist;
        }
    }

    //获取细胞列数
    public int getNum() {
        return num;
    }

    //判断周围活细胞数
    public int judge(int i, int j) {
        int n = 0;
        n = cellist[i - 1][j - 1] + cellist[i - 1][j] + cellist[i - 1][j + 1] + cellist[i][j - 1]
                +cellist[i][j + 1] + cellist[i + 1][j - 1] + cellist[i + 1][j] + cellist[i + 1][j + 1];
        return n;
    }

    //改变细胞状态
    public void change() {
        int [][]a = new int[num+2][num+2];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <=num ; j++) {
                if (judge(i, j) > 3) {
                    a[i][j] = 0;
                } else if(judge(i, j) == 3) {
                    a[i][j] = 1;
                } else if(judge(i, j) == 2) {
                    a[i][j] = cellist[i][j];
                } else {
                    a[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                cellist[i][j]=a[i][j];
            }
        }
    }

    //清0
    public void clear(){
        for (int i = 0; i < num+2; i++) {
            for (int j = 0; j < num+2; j++) {
                cellist[i][j]=0;
            }
        }
    }
}
