package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_copy {
	public static void main(String args[]) throws IOException {
		//��������
		long s = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream("F:\\test1.c");//д��ط�
		FileInputStream fis = new FileInputStream("F:\\test.c");//��ȡ�ط�
		
		int len = 0;
		//ÿ�ζ�дһ���ֽ�
//		while((len = fis.read()) != -1) {
//			fos.write(len);
//		}
		
		//һ���ֽ�һ���ֽڶ�ȡ̫���������黺��
		byte [] bytes = new byte[1024];
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);//len ����Ч�ֽ���
		}
		
		//�ر������ȹر�д�������ڹرն�����
		fos.flush();
		fos.close();
		fis.close();
		long e = System.currentTimeMillis();
		System.out.println("��ʱ"+(e-s)+"����");

	}
}
