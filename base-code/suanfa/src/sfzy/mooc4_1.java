package sfzy;

import java.util.Scanner;

public class mooc4_1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int a[] = new int [n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		
		System.out.println(getnum(a));
	}
	
	public static int getnum(int a[]) {
		int k = 0;
		int dp[] = new int [a.length];//��¼�԰�a[i]��β�ĵݼ�����Ԫ�ظ���
		
		for (int i = 1; i < a.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] <= a[j]) {
					dp[i] = (dp[j] + 1) > dp[i] ? (dp[j] + 1):dp[i];//�Ƚϣ��ҵ������
				}
			}
		}
		
		k = dp[0];
		for (int i = 1; i < dp.length; i++) {
			k = k > dp[i]?k:dp[i];
		}
		return k;
	}
}
