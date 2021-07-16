package study_file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 java.io.BufferedOutputStream extends OutputStream
 ���еķ�������
 ���췽����
 	1.BufferedOutputStream(OutputStream out) ����һ���µĻ�����������Խ�����д��ָ���ĵײ�������� 
	2.BufferedOutputStream(OutputStream out, int size) ����һ���µĻ�����������Խ�����ָ����������С������д��ָ���ĵײ�������� 
	������
	OutPutStream out �ֽ������
		���ǿ��Դ���һ��FileOutPutStream���ṩ����һ�������������Ч��
	int size  �����������л�������С
	
	ʹ�ò��裺
	1.����һ��FileOutPutStream����
	2.����һ��BufferedOutputStream���󣬹��췽���д���FileOutPutStream�����FileOutPutStreamЧ��
	3.ʹ��BufferedOutputStream�е�writer������������д�뻺������
	4.ʹ��flush����
	5.�ͷ���Դ���ر���
 */
public class file_buf_stream {
	public static void main(String args[]) throws IOException{
		show1();
	}
	
	private static void show1() throws IOException{
		long s = System.currentTimeMillis();
		//1.����һ��FileOutPutStream����
		FileOutputStream fos = new FileOutputStream("E:\\wenjian\\abc\\f.txt",true);//��д
		
		//2.����һ��BufferedOutputStream���󣬹��췽���д���FileOutPutStream�����FileOutPutStreamЧ��
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//3.ʹ��BufferedOutputStream�е�writer������������д�뻺������
		bos.write("������".getBytes());
		
		//4.ʹ��flush����
		bos.flush();
		
		//5.�ͷ���Դ���ر���
		bos.close();
		
		long e = System.currentTimeMillis();
		System.out.println("��ʱ��"+(e-s)+"����");
		
		//����Ϊ�Ƚ�ʱ�䲿��
		long a = System.currentTimeMillis();
		FileOutputStream fos2 = new FileOutputStream("E:\\wenjian\\abc\\f.txt",true);
		fos2.write("������".getBytes());
		fos2.close();
		long b = System.currentTimeMillis();
		System.out.println("��ʱ��"+(b-a)+"����");
		
		
		
	}
}
