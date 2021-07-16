package Demo03;

import java.util.function.Consumer;

/*
       格式化输出 如：
       姓名：Xx  性别：X打印

       要求：
       打印姓名动作作为第一个Consumer接口的lambda实例
       打印性别动作作为第二个Consumer接口的lambda实例
       将两个consumer接口按顺序拼接到一起，
 */
public class demo05text {
    public static void main(String[] args) {
        //注意中英文‘，’，否则会报错
        String arr[] = {"张sir，男", "她，女"};
        printInfo(arr, (message) -> {
                    //切割处理
                    String name = message.split("，")[0];
                    System.out.print("姓名： " + name);
                },
                (message) -> {
                    String sex = message.split("，")[1];
                    System.out.println("。性别： " + sex+"。");
                });
    }

    //定义方法
    public static void printInfo(String arr[], Consumer<String> con1, Consumer<String> con2) {
        //遍历数组
        for (String message : arr) {
            //使用andThen方法，拼接两个接口
            con1.andThen(con2).accept(message);
        }
    }
}
