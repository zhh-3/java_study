package javastudy1;

import java.util.StringTokenizer;

public class textstring {
	public static void main(String args[]) {
		String s="aa bb cc dd";
//		s=s.replace('a', 'b');
//		System.out.println(s);
//		System.out.println(s.startsWith("bb"));
//		System.out.println(s.substring(2));
//		System.out.println(s.substring(2, 4));
//		char a[] = new char[10];
//		a=s.toCharArray();
//		System.out.println(a[0]);
//		String s1="bbbbccdd";
//		if(s==s1)
//			System.out.println("s==s1");
//		else 
//			System.out.println("s1!=s");
//		StringBuffer s2 = new StringBuffer("hello,word!");
//		System.out.println("���ȣ�"+s2.length());
//		System.out.println("������"+s2.capacity());
//		s2.setCharAt(0, 'H');
//		System.out.println(s2);
//		s2.replace(1, 5, "i");
//		System.out.println(s2);
//		s2.delete(0, 3);
//		System.out.println(s2);
//		s2.deleteCharAt(4);
//		System.out.println(s2);
		StringTokenizer fenxi =new StringTokenizer(s);
		int n=fenxi.countTokens(),i;
		for(i=1;i<=n;i++)
		{
			String str = fenxi.nextToken();
			String string =fenxi.toString();
			System.out.println(string+" "+str);
			System.out.println("��ʣ"+fenxi.countTokens()+"������");
		}
//		System.out.println("����"+n+"������");
	}
}
