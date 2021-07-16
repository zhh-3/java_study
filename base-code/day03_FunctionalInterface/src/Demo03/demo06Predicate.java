package Demo03;

import java.util.function.Predicate;

/*
    作用：对某种数据类型的数据进行判断结果返回一个布尔值
    Predicate，中的抽象方法
        boolean test(T t):用来判断指定数据类型的数据
            结果：
                符合条件，返回true
                不符合，返回false
 */
public class demo06Predicate {
    /*
    定义一个方法，参数传递一个字符串，在传递一个predicate接口，泛型使用string
    在使用接口中的test方法，对字符串进行判断，并返回结果
     */
    public static boolean checkstring(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcde";
        boolean b = checkstring(s, (name) -> {
            return name.length() > 3;
        });

        System.out.println(b);
    }
}
