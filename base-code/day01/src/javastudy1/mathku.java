package javastudy1;

import java.util.Random;

public class mathku {
	public static void main(String args[]) {
		int a=2,b=3;
		int c;
		c=Math.max(a, b);
		System.out.println(c);
		System.out.println(Math.min(a, b));
		System.out.println(Math.toDegrees(Math.PI));
		System.out.println(Math.toRadians(180.0));
		System.out.println(Math.random());
		System.out.println(Math.random()*100);
		Random r = new Random();
		int i1 = r.nextInt();
		int i2 = r.nextInt(20);
		double  i3 = r.nextDouble();
		System.out.println(i1+" "+i2);
		System.out.println(i3);
	}
}
