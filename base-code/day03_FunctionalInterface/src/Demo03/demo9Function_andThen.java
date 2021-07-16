package Demo03;

import java.util.function.Function;

public class demo9Function_andThen {
    /*
    用于组合操作
    吧string类型数据转化成整形，加10之后，转化为string类型
     */

    public static Integer change1(String s, Function<String,Integer> fun) {
        return fun.apply(s);
    }

    public static String change2(Integer t,Function<Integer,String> fun) {
        return fun.apply(t);
    }

    public static void change3(String s,Function<String,Integer> fun1,Function<Integer,String> fun2) {
        String num = fun1.andThen(fun2).apply(s);
        System.out.println(num);
    }
    public static void main(String[] args) {
        String s = "123";
        change3(s,str->Integer.parseInt(str)+10,t->t+"");

        Integer t = change1(s, str -> Integer.parseInt(str) + 10);
        String s1 = change2(t, i -> i + "");
        System.out.println(s1);
    }
}
