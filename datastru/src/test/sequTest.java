package test;

import link.sequenceList;

public class sequTest {
    public static void main(String[] args) {
        sequenceList<Integer> L = new sequenceList<Integer>(4);
        int []a = {1,2,3,4};
        int e,i;
        //将数组插入到L中
        for (i = 0; i <a.length; i++) {
            L.add(a[i],i+1);
        }
        System.out.println("顺序表中元素有：");
        L.nextOrder();
        L.insert(5);
        System.out.println("执行插入操作后的顺序表中元素有:");
        L.nextOrder();
        System.out.println("顺序表长度为：");
        System.out.println(L.size());
        e = L.remove(1);
        System.out.println("执行删除操作后的顺序表中元素有:");
        L.nextOrder();
        //在顺序表中查找元素位置
        i = L.find(2);
        System.out.println("元素2在顺序表中的位置为："+i);
    }
}
