package study_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class classfilein {
	static int m = 0;
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\wenjian\\abc\\a\\a1.txt"));
		Object p1;
		Object p2;
		p1 = ois.readObject();
		p2 = ois.readObject();
		ois.close();
		
		System.out.println(p1);
		System.out.println(p2);
		method();
	}

	public static void method(){
		System.out.println("haha");
	}
}
