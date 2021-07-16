package javastudy1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class diedai {
	public static void main(String args[]) {
		List arraylist = new ArrayList();
		arraylist.add("one");
		arraylist.add("1");
		arraylist.add("two");
		arraylist.add(2);
		arraylist.add("three");
		arraylist.add(3);
		
		Iterator iterator =  arraylist.iterator();//²»Òªnew
		ListIterator listIterator = arraylist.listIterator();
		if (iterator.hasNext()) 
			iterator.next();
		iterator.remove();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
	}
}
