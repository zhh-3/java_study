package sfzy;

import java.util.Scanner;

public class mooc1_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n,t;
		n = scanner.nextInt();
		int a[] = new int [n];
		try {
			for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		t = getzui(a);
		System.out.println(t);
	}
	
	public static int getzui(int a[]) {
		int t = Math.abs(a[0]-a[1]);
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				t = t > Math.abs(a[i]-a[j]) ? Math.abs(a[i]-a[j]) : t;
			}
		}
		
		return t;
	}
}
