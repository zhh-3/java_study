package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * �Զ�����󣬿����Ƚ�����浽�����У��ڶԼ��Ͻ������л��ͷ����л�
 * 
 * ������
  		1.����һ������person����ļ��� ArrayList
  		2.��ArrayList�����д洢person����
  		3.����һ��ObjectOutputStream����
  		4.ʹ��writeobject�����������л�
  		5.����һ��ObjectInputStream����
  		6.ʹ��ReadObject���������л�����
  		7.��Object���͵ļ���ת����ArrayList��
  		8.��������
  		9.�ͷ���Դ
 */
public class demo3 {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		//1.����һ������person����ļ��� ArrayList
		ArrayList<person> arrayList = new ArrayList<person>();
		//2.��ArrayList�����д洢person����
		arrayList.add(new person());
		arrayList.add(new person("haha", 18));
		arrayList.add(new person("��",20));
		
		//3.����һ��ObjectOutputStream����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\wenjian\\abc\\a\\a1.txt"));
		//4.ʹ��writeobject�����������л�
		oos.writeObject(arrayList);
		//5.����һ��ObjectInputStream����
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\wenjian\\abc\\a\\a1.txt"));
  		//6.ʹ��ReadObject���������л�����
		Object object  = ois.readObject();
  		//7.��Object���͵ļ���ת����ArrayList��
		ArrayList<person> arrayList2 = (ArrayList<person>)object;
  		//8.��������
		for (person p : arrayList2) {
			System.out.println(p);
		}
  		//9.�ͷ���Դ
		oos.close();
		ois.close();
	}
}
