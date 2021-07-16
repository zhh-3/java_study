package cha;

import java.util.Arrays;
import java.util.Comparator;

public class package_problem {
    public static void main(String[] args) {
        //初始化
        int room = 50;
        int t = room;//背包剩余容量
        pack [] packs = new pack[3];
        packs[0] = new pack(20,60);
        packs[1] = new pack(30,120);
        packs[2] = new pack(10,50);

        //按性价比排序
        Arrays.sort(packs,getcomparator());

        //放入背包
        int i = 0;
        while(packs[i].weight <= t){
            packs[i].flag = 1;
            t -= packs[i].weight;
            i++;
        }
        //可以将物品分成小分，装入部分
        packs[i].flag = 1.0*t/packs[i].weight;

        //展示
        System.out.println("容量为："+room+"KG的背包");
        double sum = 0;
        for (int j = 0;j <= i;j++){
            System.out.println("装入"+packs[j].flag+"个重量为"+packs[j].weight+"KG的物品");
            sum += packs[j].weight*packs[j].flag;
        }
        System.out.println("一共装了"+sum+"KG");
    }

    public static Comparator<pack> getcomparator() {
        return (o1,o2) -> {
            return (int) (o2.pw-o1.pw);
        };
    }
}

class pack{
    int weight;
    int price;
    double pw;
    double flag;


    public pack(int weight,int price){
        this.weight = weight;
        this.price = price;
        pw = 1.0*price/weight;
        flag = 0;
    }
}
