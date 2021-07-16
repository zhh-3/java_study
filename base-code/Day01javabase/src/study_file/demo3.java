package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 对多个对象，可以先将对象存到集合中，在对集合进行序列化和反序列化
 * 
 * 分析：
  		1.定义一个储存person对象的集合 ArrayList
  		2.向ArrayList集合中存储person对象
  		3.创建一个ObjectOutputStream对象
  		4.使用writeobject方法进行序列化
  		5.创建一个ObjectInputStream对象
  		6.使用ReadObject方法反序列化集合
  		7.吧Object类型的集合转化成ArrayList类
  		8.遍历集合
  		9.释放资源
 */
public class demo3 {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		//1.定义一个储存person对象的集合 ArrayList
		ArrayList<person> arrayList = new ArrayList<person>();
		//2.向ArrayList集合中存储person对象
		arrayList.add(new person());
		arrayList.add(new person("haha", 18));
		arrayList.add(new person("张",20));
		
		//3.创建一个ObjectOutputStream对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\wenjian\\abc\\a\\a1.txt"));
		//4.使用writeobject方法进行序列化
		oos.writeObject(arrayList);
		//5.创建一个ObjectInputStream对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\wenjian\\abc\\a\\a1.txt"));
  		//6.使用ReadObject方法反序列化集合
		Object object  = ois.readObject();
  		//7.吧Object类型的集合转化成ArrayList类
		ArrayList<person> arrayList2 = (ArrayList<person>)object;
  		//8.遍历集合
		for (person p : arrayList2) {
			System.out.println(p);
		}
  		//9.释放资源
		oos.close();
		ois.close();
	}
}
