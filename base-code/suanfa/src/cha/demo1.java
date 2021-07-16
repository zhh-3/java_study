package cha;

import java.util.Scanner;

public class demo1 {
	public static void main(String args[]) {
		Scanner scanner  = new Scanner(System.in);
		
		int n;
		n = scanner.nextInt();
		
		calandar calandars [] = new calandar[n*2];

			for (int i = 0; i < calandars.length; i++) {
				calandars[i].y = scanner.nextInt();
				calandars[i].m = scanner.nextInt();
				calandars[i].d = scanner.nextInt();
			/*if (i % 2 == 0) {
				calandars[i].y = scanner.nextInt();
				calandars[i].m = scanner.nextInt();
				calandars[i].d = scanner.nextInt();
//				calandars[i].string = scanner.next();
//				switch (calandars[i].string.toLowerCase()) {
//				case "monday":
//					calandars[i].s =1;
//				case "tuesday":
//					calandars[i].s =2;
//				case "wednesday":
//					calandars[i].s =2;
//				case "thursday":
//					calandars[i].s =4;
//				case "friday":
//					calandars[i].s =5;
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + calandars[i].string.toLowerCase());
//				}
			} else {
				calandars[i].y = scanner.nextInt();
				calandars[i].m = scanner.nextInt();
				calandars[i].d = scanner.nextInt();
			}*/
		}
		
		
		for (int i = 0; i < n; i++) {
			int k = getday(calandars, i);
			switch (k) {
			case 1:
				System.out.println("Monday");
			case 2:
				System.out.println("Tuesday");
			case 3:
				System.out.println("Wednesday");
			case 4:
				System.out.println("Thursday");
			case 5:
				System.out.println("Friday");
			default:
				throw new IllegalArgumentException("Unexpected value: " + k);
			}
		}
	}
	
	public static int getday(calandar[] calandars,int i) {
		int k =0 ;
		try {
			k =(calandars[i+1].y-calandars[i].y)*360+(calandars[i+1].m-calandars[i].m)*30+(calandars[i+1].d-calandars[i].d);
			k = k%5;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return k;
	}
}
