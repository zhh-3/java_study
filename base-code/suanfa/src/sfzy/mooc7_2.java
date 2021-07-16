package sfzy;

import java.util.Arrays;
import java.util.Scanner;

public class mooc7_2 {
    public static void main(String[] args) {
        //数据初始化
        int n,k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        //排序
        Arrays.sort(num);

        int t = num[0]+k;
        int sum = 1;

        for(int i = 1;i < n;i++){
            if (num[i] > t){
                t=num[i]+k;
                sum++;
            }
        }
       /* while (t < num[n-1]){
            t += k;
            sum++;
            for(int i = 0;i < n;i++){
                if (num[i] >= t){
                    t = num[i];
                    break;
                }
            }
        }*/
        System.out.println(sum);
    }
}
