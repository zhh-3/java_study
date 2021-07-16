package Demo03;

import java.util.function.Supplier;

public class demo02 {

    public static int getmax(Supplier<Integer> sup) {
        return sup.get();
    }
    public static void main(String[] args) {
        //定义一个数组并赋值
        int arr[] ={11,22,43,40,0,-10,100};
        int max = getmax(() -> {
            int k = arr[0];
            //遍历找出最大值
            for (int t : arr) {
                if (t > k){
                    k = t;
                }
            }
            return k;
        });
        System.out.println(max);
    }
}
