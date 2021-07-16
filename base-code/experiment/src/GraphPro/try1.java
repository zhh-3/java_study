package GraphPro;

import java.io.IOException;

public class try1 {
    public static int k[];
    public static void main(String[] args) {
        change();
        for (int i = 0; i < k.length; i++) {
            System.out.println(k[i]);
        }
    }

    public static void change() {
        k = new int[3];
        for (int i = 0; i < 3; i++) {
            k[i] = i;
        }
    }
}
