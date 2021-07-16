package Demo03;

import java.util.function.Consumer;

/*
函数接口  Consumer<T>,消费（使用）一个数据
 */
public class demo03Comsumer {
    public static void main(String[] args) {
        method("zhh",(String name)->{
            //直接输出
            System.out.println(name);

            //反转输出
            String rename = new StringBuffer(name).reverse().toString();
            System.out.println(rename);

            //调用方法输出
            toBig(name);
        });
    }

    public static void method(String name, Consumer<String> con) {
        //该方法接口中只传递了一个参数
        con.accept(name);
    }

    public static void toBig(String name) {
        String rename = name.toUpperCase();
        System.out.println(rename);
    }
}
