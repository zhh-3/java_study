package javastudy1;

import java.util.Calendar;

public class calendar {
public static void main(String args[]) {
    System.out.println(" ��  һ  ��  ��  ��  ��  ��");

    //calendar û��new ,������getInstance�����õ�һ��ͨ�ö���
    
    Calendar rightnow = Calendar.getInstance();
    rightnow.set(2019, 0, 1);//0��ʾ����1��,��������,��ʾ����һ�µľ���
    
    /*
     * 1. �ڻ�ȡ�·�ʱ��Calendar.MONTH + 1 ��ԭ��
        Java�е��·���ѭ���������еĹ��򣺵�ʱһ���е��·������ǲ��̶��ģ�
        ��һ������JANUARY����Java��Calendar.MONTH���ص���ֵ��ʵ�ǵ�ǰ�¾����һ�����ж��ٸ��·ݵ���ֵ��
        JANUARY��Java�з��ء�0��������������Ҫ+1��
        2. �ڻ�ȡ���ڼ� Calendar.DAY_OF_WEEK �C 1 ��ԭ��
        Java��Calendar.DAY_OF_WEEK��ʵ��ʾ��һ���еĵڼ��죬���������ܵ� ��һ�������ڼ� ��Ӱ�졣
        ��Щ��������������Ϊһ�ܵĵ�һ�죬����Щ����������һ��Ϊһ�ܵĵ�һ�죬��2���������Ҫ���ֵġ�
     */
    
    int xinqi = rightnow.get(Calendar.DAY_OF_WEEK)-1;//���������е�һ���ǵڼ���
    String a[] = new String[xinqi + 30];
    for(int i=0;i<xinqi ;i++)
    {
        a[i]="  ";
    }
    for(int i= xinqi,n=1;i<xinqi+30;i++)
    {
        if(n<=9)
            a[i]=String.valueOf(n)+" ";//��n���ַ�����ʽ����
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
