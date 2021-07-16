package demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class No2020122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int num[][] = new int[m][2];
        ArrayList<Integer> num1 = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            num[i][0] = scanner.nextInt();
            num[i][1] = scanner.nextInt();
            if (!num1.contains(num[i][0])){
                num1.add(num[i][0]);
            }
        }

        int th = 0, s = 0;
        for (Integer n : num1) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                int k = 0;
                int predict = n > num[j][0]?0:1;
                if (predict == num[j][1]){
                    k = 1;
                }
                sum+=k;
            }

            if (sum > s){
                s = sum;
                th = n;
            }else if (sum == s){
                th = th > n?th:n;
            }
        }
        System.out.println(th);
    }
}
