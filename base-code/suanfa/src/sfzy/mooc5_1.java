package sfzy;

import java.util.Scanner;

public class mooc5_1 {
    public static int m,n,d;
    public static int best = 10000;
    public static int [] op = new int[100];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        d = scanner.nextInt();

        int w[][] = new int[n][m];
        int c[][] = new int[n][m];
        int tx[] = new int[n];//辅助数组
        int tw = 0,tc = 0;//当前重量和价格

        //初始化
        //重量
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                w[i][j] = scanner.nextInt();
            }
        }
        //价格
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                c[i][j] = scanner.nextInt();
            }
        }

        select(0,w,c,tw,tc,tx);
        output();
    }

    public static void select(int i,int [][]w,int [][]c,int tw,int tc,int []tx) {
        if (i == n){
            if (tw < best){
                best = tw;
                for (int k = 0;k < n;k++){
                    op[k] = tx[k];
                }
            }
        } else{
            for (int j = 0;j < m;j++){
                if (tc + c[i][j] < d && tw + w[i][j] <= bound(w,c,i,tw)){
                    tx[i] = j + 1;
                    tw = tw + w[i][j];
                    tc = tc + c[i][j];
                    select(i+1,w,c,tw,tc,tx);
                    tw = tw - w[i][j];
                    tc = tc - c[i][j];
                }
            }
        }
    }

    public static int bound(int [][]w,int [][]c,int i,int tw) {
        int uw = tw;
        for (int a = i;a < n;a++){
            //假设物品重量按从小到大排序
            uw += w[a][0];
        }
        return uw;
    }

    public static void output() {
        int i;
        for (i = 0;i < n-1;i++){
            System.out.print(op[i]+" ");
        }
        System.out.println(op[i]+"\n"+best);
    }
}
