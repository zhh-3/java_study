package sfzy;

import java.util.Scanner;

public class mooc1_1 {
	public static void main(String args[]) {
		Smith smith = new Smith();
		Scanner scanner = new Scanner(System.in);
		int t = 1,i = 0;
		int a[] = new int [10];
		while (t != 0) {
			t = scanner.nextInt();
			while (smith.judge(t) == false) {
				t++;
			}
			a[i++] = t;
		}
		for (i = 0; a[i] > 0; i++) {
			System.out.println(a[i]);
		}
		
	}
}
