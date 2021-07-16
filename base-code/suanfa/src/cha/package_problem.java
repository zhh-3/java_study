package cha;

import java.util.Arrays;
import java.util.Comparator;

public class package_problem {
    public static void main(String[] args) {
        //��ʼ��
        int room = 50;
        int t = room;//����ʣ������
        pack [] packs = new pack[3];
        packs[0] = new pack(20,60);
        packs[1] = new pack(30,120);
        packs[2] = new pack(10,50);

        //���Լ۱�����
        Arrays.sort(packs,getcomparator());

        //���뱳��
        int i = 0;
        while(packs[i].weight <= t){
            packs[i].flag = 1;
            t -= packs[i].weight;
            i++;
        }
        //���Խ���Ʒ�ֳ�С�֣�װ�벿��
        packs[i].flag = 1.0*t/packs[i].weight;

        //չʾ
        System.out.println("����Ϊ��"+room+"KG�ı���");
        double sum = 0;
        for (int j = 0;j <= i;j++){
            System.out.println("װ��"+packs[j].flag+"������Ϊ"+packs[j].weight+"KG����Ʒ");
            sum += packs[j].weight*packs[j].flag;
        }
        System.out.println("һ��װ��"+sum+"KG");
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
