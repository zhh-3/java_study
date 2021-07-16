package javastudy1;

import java.util.ArrayList;

public class arrylist {
	public static void main(String args[]) {
		ArrayList list = new ArrayList();
		for(int i = 0;i < 10;i++)
			list.add(i);
		list.remove(0);
		for(int i = 0;i < 3;i++)
		{
			list.add(i);
		}
		Integer[] a =new  Integer[list.size()];
		a=(Integer[]) list.toArray(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}
