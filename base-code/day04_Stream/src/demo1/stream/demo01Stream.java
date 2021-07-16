package demo1.stream;

import java.util.ArrayList;
import java.util.List;

public class demo01Stream {
    public static void main(String[] args) {
        //创建一个list集合
        List<String> list = new ArrayList<>();
        list.add("张浩瀚");
        list.add("张无忌");
        list.add("张三丰");
        list.add("周芷若");
        list.add("赵强");
        list.add("张强");

        //对list集合遍历，将以张开头的元素存储到新的集合中
        //对listA进行过滤，只要姓名长度为三的集合
        //遍历listB集合
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));
    }
}
