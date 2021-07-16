package sfzy;

import java.util.Scanner;

public class mooc3_2 {
	public static void main(String args[]) {
		
		Scanner scanner  = new Scanner(System.in);
		
		int n,s = 0;
		n = scanner.nextInt();
		
		int [] r = new int [n];
		for (int i = 0; i < r.length; i++) {
			r[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < r.length - 1; i++) {
			s += shu(i, r);
		}
		
		System.out.println(s);
	}
	
	public static int shu(int a,int []r ) {
		int count = 0;
		for (int i = a+1; i < r.length; i++) {
			if (r[a] > r[i]) {
				count++;
			}
		}
		return count;
	}
}
