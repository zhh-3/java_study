package test;

import link.linkList;

public class test1 {
    public static void main(String[] args) {
        linkList<Integer> L = new linkList<Integer>();
        int []a = {23,56,12,49,35};
        for (int i = 0; i < a.length; i++) {
            L.add(a[i],i+1);
        }
        System.out.println("单链表中元素为：");
        L.next_order();
        L.add(30,6);
        System.out.println("执行添加操作后单链表中元素为：");
        L.next_order();
        L.remove(6);
        System.out.println("执行删除操作后单链表中元素为：");
        L.next_order();
        int num = L.find(12);
        System.out.println("元素12的位置为："+num);
    }
}
