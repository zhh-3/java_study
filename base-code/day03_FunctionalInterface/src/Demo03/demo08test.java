package Demo03;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
        对集合信息的筛选
        要求满足两个条件：
        1.必须是女生
        2.名字必须是四个字
        对满足要求的元素存入集合ArrayList中
 */
public class demo08test {
    public static ArrayList<String> filter(String[] names, Predicate<String> pre1, Predicate<String> pre2) {
        //定义一个arraylist集合
        ArrayList<String> list = new ArrayList<>();
        //遍历数组，获取数组中每一条信息
        for (String s : names) {
            if (pre1.and(pre2).test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String names[] = {"迪丽热巴，女", "古力娜扎，女", "阿里巴巴，男", "赵丽颖，女"};
        ArrayList<String> list = filter(names, (s) -> {
            String s1 = s.split("，")[1];
            return s1.equals("女");
        }, (s) -> {
            String s1 = s.split("，")[0];
            return s1.length() == 4;
        });
        //遍历
        for (String s : list) {
            System.out.println(s);
        }
    }
}
