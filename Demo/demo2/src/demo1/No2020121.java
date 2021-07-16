package demo1;

import java.util.Scanner;

public class No2020121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,sum = 0,score;
        n = scanner.nextInt();
        int num[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            num[i][0] = scanner.nextInt();
            num[i][1] = scanner.nextInt();
            score = num[i][0] * num[i][1];
            sum += score;
        }

        int y = sum > 0?sum:0;
        System.out.println(y);
    }
}
