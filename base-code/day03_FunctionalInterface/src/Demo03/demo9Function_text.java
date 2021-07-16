package Demo03;

import java.util.function.Function;

public class demo9Function_text {
    /*
    “赵丽颖，20”
    1.将字符串截取数字部分，得到字符串
    2.将上一步字符串转化为int类型数字
    3.将上一步得到的数字加100得到的数字转化为字符串类型
     */

    public static void change(String name, Function<String,String> fun1,Function<String,Integer> fun2,Function<Integer,String> fun3) {
        String s = fun1.andThen(fun2).andThen(fun3).apply(name);
        System.out.println(s);
    }

    public static void main(String[] args) {
        String name = "赵丽颖，20";
        change(name,(str1)->{
            return str1.split("，")[1];
        },(str2)->{
            return Integer.parseInt(str2);
        },(t)->{
            return (t+100)+"";
        });

        //简化
        change(name,str1->str1.split("，")[1],str2->Integer.parseInt(str2), t-> (t+100)+"");
    }
}
