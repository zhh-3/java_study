package sfzy;

import java.util.Scanner;

public class Mooc6 {
    public static final int N = 5;
    public static int num[][] = new int[2*N-1][2];
    public static int maze[][] = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                maze[i][j] = scanner.nextInt();
            }
        }
        num[0][0] = 0;
        num[0][1] = 0;
        num[N-1][0] = N-1;
        num[N-1][1] = N-1;
        mi(maze,0,0,1);
    }

    public static void mi(int maze[][],int i,int j,int k) {
        if (i != N-1 || j != N-1){
            if (i < 4 && maze[i+1][j] == 0){
                num[k][0] = i+1;
                num[k][1] = j;
                mi(maze,i+1,j,k+1);
            }
            num[k][0] = i;
            num[k][1] = j;
            if (j < 4 && maze[i][j+1] == 0){
                num[k][0] = i;
                num[k][1] = j+1;
                mi(maze,i,j+1,k+1);
            }
            num[k][0] = i;
            num[k][1] = j;
        } else {
            for (int a = 0; a < num.length; a++) {
                System.out.println("("+num[a][0]+","+num[a][1]+")");
            }
        }
    }
}
