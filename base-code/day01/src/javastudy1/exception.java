package javastudy1;

import java.util.Scanner;

class exception {
	public static void main(String args[]) {
		try {
			int a=5,b=0;
			int c=0;
//			Scanner scanner =new Scanner(System.in);
//			b=scanner.nextInt();
			c=a/b;
			System.out.println("a/b"+c);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println("end");
		}
		
		try {
			int i,sum=0;
			int a[]= {1,2,3,4};
			for(i=0;i<=4;i++)
				sum=sum+a[i];
			System.out.println("sum="+sum);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
