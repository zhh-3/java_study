package demo1.stream;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class demo01List {
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
        List<String> listA =new ArrayList<>();
        for (String name: list) {
            if (name.startsWith("张")){
                listA.add(name);
            }
        }

        //对listA进行过滤，只要姓名长度为三的集合
        List<String> listB = new ArrayList<>();
        for (String name : listA) {
            if (name.length() == 3){
                listB.add(name);
            }
        }

        //遍历listB集合
        for (String s : listB) {
            System.out.println(s);
        }
    }
}
