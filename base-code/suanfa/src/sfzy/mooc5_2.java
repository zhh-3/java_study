package sfzy;

import java.util.Scanner;

public class mooc5_2 {
    public static int flag = 0;
    public static int n,k;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        check(0,a,0);

        if (flag == 0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }

    public static void check(int i,int []a,int t) {
        int m = t;
        int s = 0;//剩余数字的和
        for (int j = i;j < n;j++){
            s += a[j];
        }
        if (i == n){
            if (m == k){
                flag = 1;
            }
        }else {
            if (s+t >= k){
                if (t + a[i] <= k){
                    t = m+ a[i];
                    check(i+1,a,t);
                }

                check(i+1,a,m);
            }
        }
    }
}
