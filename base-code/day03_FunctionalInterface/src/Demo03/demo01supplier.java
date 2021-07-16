package Demo03;

import java.util.function.Supplier;

/*
    常用函数式接口，supplier   只有一个T get()接口;
 */
public class demo01supplier {
    //T get();
    public static String getstr (Supplier<String> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        String s = getstr(() -> {
           return "haha";
        });

        String s1 = getstr(() -> "zhh");
        System.out.println(s1+s);
    }
}
