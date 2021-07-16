package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 	��ϰ��ȡGBK�ļ�����������UTF-8�ĸ�ʽд���ļ���
 	������
 	1.����һ��InputStreamReader����
 	2.����OutputStreamWriter����
 	3.ʹ��InputStreamReader�����е�read��������ȡ����
 	4.ʹ��OutputStreamWriter�����е�write������д������
 	5.�ͷ���Դ
 */
public class gbk_change_utf {
	public static void main(String args[]) throws IOException{
		//1.����һ��InputStreamReader����,Ĭ��ΪGBK��ʽ
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));
		//2.����OutputStreamWriter����,Ĭ��ΪGBK��ʽ�����ʹ��GBK��ʽ��д��Ļ��ǡ���á�,�ֽ�Ϊ4����
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\eclipse-workspace\\javastudy\\src\\out2.txt"),"utf-8");
		//3.ʹ��InputStreamReader�����е�read��������ȡ����
		int len = 0;
		while ((len = isr.read()) != -1) {
			//4.ʹ��OutputStreamWriter�����е�write������д������
			osw.write(len);
		}
		//5.�ͷ���Դ
		isr.close();
		osw.close();
	}
}
