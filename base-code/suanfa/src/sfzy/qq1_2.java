package sfzy;

import java.util.Scanner;

public class qq1_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int k,t;
		System.out.print("���������������");
		k = scanner.nextInt();
		int a[] = new int [k+2];//������С������Ϊk+1
		 for (int i = 0; i < k; i++) {
			 t = scanner.nextInt();
			if (t > 0 && t <= k) {
				a[t] = 1;//����ǣ���������������������Ϊ1��δ���ֱ��Ϊ0
			}
		}
		
		for (int i = 1; i < a.length; i++) {
			//δ����ǵı�ʾû�г��������������
			if (a[i] == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
