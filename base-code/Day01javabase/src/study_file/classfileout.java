package study_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 java.io.ObjectOutputStream  extend OutputStream
 �������л�
 ���ã��Ѷ������ֽڵ���ʽд���ļ�
 ���췽����
 ObjectOutputStream(OutputStream out)  ����д��ָ�� OutputStream �� ObjectOutputStream��
 ���еĳ�Ա������
 writeObject(Object obj)   ��ָ���Ķ���д�� ObjectOutputStream��
 
 ʹ�÷�����
 1.����һ��ObjectOutputStream����
 2.ʹ��writeObject����
 3.�ͷ���Դ
 
 ע�⣺
 ��static ��̬��Ա�������εĳ�Ա���ܱ����л�
 ����  ����Ů0
 
 �ؼ���transient ���ε�ͬ�����ܱ����л���˲̬�ؼ���
 ���ڲ��뱻���л��ķǾ�̬��Ա�����������������
 
 */
public class classfileout {
	public static void main(String args[]) throws IOException{
		//1.����һ��ObjectOutputStream����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\wenjian\\abc\\a\\a1.txt"));
		//2.ʹ��writeObject����
		oos.writeObject(new person("����Ů",18));
		oos.writeObject(new person("С��Ů", 18));//��������ô�������԰ɶ���д��һ�����ϣ��ڶԼ��Ͻ������л��ͷ����л�
		//3.�ͷ���Դ
		oos.close();
	}
}
