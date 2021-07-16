package javastudy1;

import java.util.Calendar;

public class calendar {
public static void main(String args[]) {
    System.out.println(" 日  一  二  三  四  五  六");

    //calendar 没有new ,可以用getInstance方法得到一个通用对象
    
    Calendar rightnow = Calendar.getInstance();
    rightnow.set(2019, 0, 1);//0表示的是1月,依次类推,表示距离一月的距离
    
    /*
     * 1. 在获取月份时，Calendar.MONTH + 1 的原因
        Java中的月份遵循了罗马历中的规则：当时一年中的月份数量是不固定的，
        第一个月是JANUARY。而Java中Calendar.MONTH返回的数值其实是当前月距离第一个月有多少个月份的数值，
        JANUARY在Java中返回“0”，所以我们需要+1。
        2. 在获取星期几 Calendar.DAY_OF_WEEK – 1 的原因
        Java中Calendar.DAY_OF_WEEK其实表示：一周中的第几天，所以他会受到 第一天是星期几 的影响。
        有些地区以星期日作为一周的第一天，而有些地区以星期一作为一周的第一天，这2种情况是需要区分的。
     */
    
    int xinqi = rightnow.get(Calendar.DAY_OF_WEEK)-1;//返回这周中第一天是第几天
    String a[] = new String[xinqi + 30];
    for(int i=0;i<xinqi ;i++)
    {
        a[i]="  ";
    }
    for(int i= xinqi,n=1;i<xinqi+30;i++)
    {
        if(n<=9)
            a[i]=String.valueOf(n)+" ";//将n以字符串形式返回
        else 
            a[i]=String.valueOf(n);
        n++;
    }
    for(int i=0;i<a.length;i++)
    {
        if(i%7==0)
            System.out.println();
        System.out.print(" "+a[i]);
    }
    }
}
