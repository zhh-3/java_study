package sfzy;

import java.util.Scanner;

public class qq_310 {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n;
		n = scanner.nextInt();
		
		char R[] = new char [n];
		int p;
		p = scanner.nextInt();//p���ƶ�λ�����������ƣ���������
		
		String string;
		//����ֵ
		string  = scanner.next();
		R = string.toCharArray();
		
		
		//��������Ԫ�ظ���ʱ��������ƶ�����ʱ�и�ѭ��
		if (p < 0) {
			//�����ƶ�P��λ�ã��൱�������ƶ�R.length - p��λ��
			p = R.length - (-p) % R.length;
		}
		else {
			//����ѭ����û�ƶ�R.length��λ�ã��ͻָ���ԭ״
			p = p % R.length;
		}
		nixu(0, p-1, R);
		nixu(p, R.length-1, R);
		nixu(0, R.length-1, R);
		
		for (int i = 0; i < R.length; i++) {
			System.out.print(R[i]+"  ");
		}
	}
	
	//��һ��������±�a��b��������,�Խ������ݵ���ʵ��
	public static void nixu(int a,int b,char R[]) {
		int t = (a + b)/2;  
		char k;
		for (int i = a,j = 0; i <= t; i++,j++) {
			k = R[i];
			R[i] = R[b - j];
			R[b - j] = k;
		}
	}
}
