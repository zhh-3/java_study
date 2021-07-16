package sfzy;

import java.util.Scanner;

public class mooc7_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums;
        nums = scanner.nextInt();
        Niu []nius = new Niu[nums];
        for (int i = 0;i < nums;i++){
            int start,end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            nius[i] = new Niu(start,end);
        }
        int sum = 1;
        nius[0].num = sum;
        for (int i = 1; i < nums; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (!Niu.check(nius[i],nius[j])) {
                    nius[i].num = nius[j].num;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                nius[i].num = ++sum;
            }
        }

        System.out.println(sum);
        for (Niu niu : nius) {
            System.out.println(niu.num);
        }
    }

}

class Niu{
    int start;
    int end;
    int num;//采奶的栅栏序号

    public Niu(int start,int end){
        this.start = start;
        this.end = end;
        num = 0;
    }

    //返回true,代表有重合的时间
    public static boolean check(Niu n1,Niu n2) {
        if (n1.end < n2.start || n1.start > n2.end){
            return false;
        }else{
            return true;
        }
    }
}