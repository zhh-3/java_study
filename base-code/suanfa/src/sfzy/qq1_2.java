package sfzy;

import java.util.Scanner;

public class qq1_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int k,t;
		System.out.print("请输入数组个数：");
		k = scanner.nextInt();
		int a[] = new int [k+2];//最大的最小正整数为k+1
		 for (int i = 0; i < k; i++) {
			 t = scanner.nextInt();
			if (t > 0 && t <= k) {
				a[t] = 1;//做标记，输入数组出现正数，标记为1，未出现标记为0
			}
		}
		
		for (int i = 1; i < a.length; i++) {
			//未做标记的表示没有出现在输入的数组
			if (a[i] == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
