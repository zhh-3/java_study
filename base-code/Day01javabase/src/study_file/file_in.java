package study_file;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream �ֽ������
  * �̳�java.io.InputStream
  * ���Է�����
  *  void close()�رմ����������ͷ����������������ϵͳ��Դ��
     abstract  int read() ���������ж�ȡ���ݵ���һ���ֽڡ� 
     int read(byte[] b) ���������ж�ȡһ���������ֽڣ�������洢�ڻ��������� b �С� 
     int read(byte[] b, int off, int len) ������������� len �������ֽڶ��� byte ���顣  
     
   ���췽����
   FileInputStream(String name) ͨ����һ����ʵ���ļ�������������һ�� FileInputStream�����ļ�ͨ���ļ�ϵͳ�е�·���� name ָ����
   FileInputStream(File file)  ͨ����һ����ʵ���ļ�������������һ�� FileInputStream�����ļ�ͨ���ļ�ϵͳ�е� File ���� file ָ����
   
   ������
    int read() �Ӵ��������ж�ȡһ�������ֽڡ� 
	int read(byte[] b)  �Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte �����С� 
	int read(byte[] b, int off, int len)  �Ӵ��������н���� len ���ֽڵ����ݶ���һ�� byte �����С� 

 */
public class file_in {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\wenjian\\abc\\d.txt");
		int len = 0;
		int n = fis.read()-'0';
		int [] a = new int[n];
//		len = fis.read();
//		k = len -'0';
//		System.out.println(k);
//		System.out.println(len); //97
//		System.out.println((char)len); //a
		
//		byte [] bytes = new byte[2];
//		len = fis.read(bytes);
//		System.out.println(len);  //2
//		System.out.println(new String(bytes));  //bcָ�����ƶ�
		
		for (int i = 0; i < n; i++) {
			a[i] = getnum(fis);
		}
		fis.close();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static int getnum(FileInputStream fis) throws IOException{
		int s = 0;
		int len = 0;
		while ((len = fis.read()) != 32 && len != -1) {
			if (len <= '9'&&len >= '0') {
				s = 10*s +len-'0';
			}
		}
		return s;
	}
}











