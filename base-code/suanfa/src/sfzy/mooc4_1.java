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
		int dp[] = new int [a.length];//记录以啊a[i]结尾的递减数组元素个数
		
		for (int i = 1; i < a.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] <= a[j]) {
					dp[i] = (dp[j] + 1) > dp[i] ? (dp[j] + 1):dp[i];//比较，找到最长数组
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
