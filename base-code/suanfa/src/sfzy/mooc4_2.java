package sfzy;

import java.util.Scanner;

public class mooc4_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		String str1,str2;
		str1 = scanner.next();
		str2 = scanner.next();
		
		System.out.println(getname(str1, str2));
	}
	
	public static char[]  getname(String str1,String str2) {
		char[] name1 = str1.toCharArray();
		char[] name2 = str2.toCharArray();
		int m,n;
		m = name1.length + 1;
		n = name2.length + 1;
		int [][] dp = new int [m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 0;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (name1[i-1] == name2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
				}
			}
		}
		
		int k = dp[m-1][n-1];
		int i = m-1,j = n-1,z = i+j-k;
		char[] arr = new char[z];
		while (z > 0) {
			if (dp[i][j] != 0) {
				if (dp[i][j] == dp[i][j-1]) {
				arr[--z] = name2[--j];
				}
				else if (dp[i][j] == dp[i-1][j]) {
					arr[--z] = name1[--i];
				}
				else {
					arr[--z] = name1[--i];
					j--;
					k--;
				}
			}else {
				while (j > 0) {
					arr[--z] = name2[--j];
				}
				while (i > 0) {
					arr[--z] = name1[--i];
				}
			}
		}
		return arr;
	}
}
