package test;

import link.sequenceList;

public class chap2_1 {
    public static void main(String[] args) {
        int []a = {12,23,35,49,56};
        int []b = {10,15,20};
        sequenceList<Integer> La = new sequenceList<Integer>();
        sequenceList<Integer> Lb = new sequenceList<Integer>();
        sequenceList<Integer> Lc = new sequenceList<Integer>();
        for (int i = 0; i < a.length; i++) {
            La.add(a[i],i+1);
        }
        System.out.println("顺序表a中的元素为：");
        La.nextOrder();
        for (int i = 0; i < b.length; i++) {
            Lb.add(b[+i],i+1);
        }
        System.out.println("顺序表b中的元素为：");
        Lb.nextOrder();
        MergeList_Sq(La,Lb,Lc);
        System.out.println("顺序表c中的元素为：");
        Lc.nextOrder();
    }

    //LA，LB中元素按从小到大排列
    public static void MergeList_Sq(sequenceList<Integer> LA,sequenceList<Integer> LB,sequenceList<Integer> LC){
        int i = 1,j = 1;
        while (i <= LA.size()&&j <= LB.size()){
            if (LA.value(i).compareTo(LB.value(j)) <= 0){
                LC.insert(LA.value(i++));
            }else {
                LC.insert(LB.value(j++));
            }
            while (i == LA.size()){
                if (j <= LB.size()){
                    LC.insert(LB.value(j++));
                }else {
                    return;
                }
            }
            while (j == LB.size()){
                if (i <= LA.size()){
                    LC.insert(LA.value(i++));
                }else {
                    return;
                }
            }
        }
    }
}
