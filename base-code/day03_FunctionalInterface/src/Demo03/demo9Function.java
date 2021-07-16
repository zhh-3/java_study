package Demo03;

import java.util.function.Function;

public class demo9Function {
    /*
    定义一个方法
    方法参数传递一个字符串整数
    方法参数传递一个Function接口泛型使用<String,Integer>
    使用Function中的apply方法,将字符串类型整数，转化为Integer类型
     */

    public static void change(String s, Function<String,Integer> fun) {
        Integer in = fun.apply(s);
        System.out.println(in+1);
    }

    public static void main(String[] args) {
        //定义一个字符串类型的整数
        String s = "1234";
        String s1 = "2345";
        change(s,(String str)->{
            return Integer.parseInt(str);
        });

        change(s1,str->Integer.parseInt(str));
    }
}
