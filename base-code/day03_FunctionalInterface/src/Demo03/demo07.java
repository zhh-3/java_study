package Demo03;

import java.util.function.Predicate;

/*
        predicate中的方法
        and
 */
public class demo07 {
    //and
    public static boolean check1(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(s);
    }

    //or
    public static boolean check2(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        String s1 = "Zhaha";
        String s2 = "zhaha";
        boolean b = check1(s1, (s) -> {
                    return s.length() > 3;
                },
                (s) -> {
                    return s.contains("Z");
                });
        boolean b1 = check2(s2, s -> s.length() > 3,
                s -> s.contains("Z"));
        System.out.println(b);//true
        System.out.println(b1);//true
    }
}
