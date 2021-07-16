package sfzy;

import java.util.Scanner;

public class mooc4_3 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int m,n,k,s1 = 1,s2 = 1,t1,t2;
		m = scanner.nextInt();
		n = scanner.nextInt();
		t1 = m+n-2;
		t2 = 1;
		for (int i = 0; i < m-1; i++) {
			s1 = s1*t1;
			t1--;
		}
		for (int i = 0; i < m-1; i++) {
			s2 = s2*t2;
			t2++;
		}
		k = s1/s2;
		System.out.println(k);
	}
}
