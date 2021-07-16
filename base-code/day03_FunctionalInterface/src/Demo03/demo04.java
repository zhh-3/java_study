package Demo03;

import java.util.function.Consumer;

/*
       Consumer 中的默认方法  andThen

       作用：将两个Consumer接口组合到一起，对数据进行消费

       例如:
       Consumer<String> con1;
       Consumer<String> con2;
       String s;
       con1.accept(s);
       con2.accept(s);
       谁写前面，谁先消费
       con1.andThen(con2).accept(s);
 */
public class demo04 {
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
        con1.accept(s);
        con2.accept(s);

        //使用andThen
        con2.andThen(con1).accept(s);
    }

    public static void main(String[] args) {
        method("Zhaha", (s) -> {
                    System.out.println(s.toLowerCase());
                },
                (s) -> {
                    System.out.println(s.toUpperCase());
                });
    }
}
