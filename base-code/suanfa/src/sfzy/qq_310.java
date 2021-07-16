package sfzy;

import java.util.Scanner;

public class qq_310 {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n;
		n = scanner.nextInt();
		
		char R[] = new char [n];
		int p;
		p = scanner.nextInt();//p是移动位数，负数右移，正数左移
		
		String string;
		//赋初值
		string  = scanner.next();
		R = string.toCharArray();
		
		
		//大于数组元素个数时，会继续移动，此时有个循环
		if (p < 0) {
			//向右移动P个位置，相当于向左移动R.length - p个位置
			p = R.length - (-p) % R.length;
		}
		else {
			//满足循环，没移动R.length个位置，就恢复了原状
			p = p % R.length;
		}
		nixu(0, p-1, R);
		nixu(p, R.length-1, R);
		nixu(0, R.length-1, R);
		
		for (int i = 0; i < R.length; i++) {
			System.out.print(R[i]+"  ");
		}
	}
	
	//将一个数组从下标a到b逆序排列,以交换数据得以实现
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
