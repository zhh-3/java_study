package study_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 	java.io.InputStreamReader
 	���ֽ���ͨ���ַ�������������ʹ��ָ���� charset ��ȡ�ֽڲ��������Ϊ�ַ�
 	
 	���췽��:
 	InputStreamReader(InputStream in)   ����һ��ʹ��Ĭ���ַ����� InputStreamReader��  eclipse ��Ĭ��ΪGBK��ʽ
    InputStreamReader(InputStream in, String charsetName)   ����ʹ��ָ���ַ����� InputStreamReader��
    
    ʹ�÷�����
    1.����һ��InputStreamReader����
    2.ʹ��InputStreamReader�����еķ���read
    3.�ر���
    
   ע�����
   ���췽���е�ָ�����������Ҫ���ļ��е�һ�£�����ᷢ������
 */
public class input_read {
	public static void main(String args[]) throws IOException{
		read_gbk();
//		read_utf_8();
	}

	private static void read_gbk() throws IOException{
		// TODO Auto-generated method stub
		//1.����һ��InputStreamReader����
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"),"gbk");
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));//Ĭ��Ϊgbk��ʽ
		//2.ʹ��InputStreamReader�����еķ���read
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char)len);
		}
		//3.�ر���
		isr.close();
	}
	
	private static void read_utf_8() throws IOException{
		//1.����һ��InputStreamReader����
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"),"utf-8");
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"));//Ĭ��Ϊgbk��ʽ
		//2.ʹ��InputStreamReader�����еķ���read
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char)len);
		}
		//3.�ر���
		isr.close();
	}
}
