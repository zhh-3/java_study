package study_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
  java.io.OutputStreamWriter
  ���ַ���ͨ���ֽ�������������ʹ��ָ���� charset ��Ҫд�����е��ַ�������ֽ�
  ���췽����
  OutputStreamWriter(OutputStream out) ����ʹ��Ĭ���ַ������ OutputStreamWriter��
  OutputStreamWriter(OutputStream out, String charsetName)  ����ʹ��ָ���ַ����� OutputStreamWriter��
  
  ������
    OutputStream  �ֽ������
    String charsetName  ָ�������ʽ�������ִ�Сд��utf-8/UTF-8
    
  ʹ�ò��裺
  1.����OutputStreamWriter����
  2.ʹ��OutputStreamWrite�е�writer����
  3.flush
  4.close
*/
public class output_writer {
	public static void main(String args[]) throws IOException{
		write_utf_8();
//		write_gbk();
	}

//	ʹ��OutputStreamWriterдutf_8��ʽ�ļ�
	private static void write_utf_8() throws IOException{
		// TODO Auto-generated method stub
		//1.����OutputStreamWriter����
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\wenjian\\abc\\d.txt"));
		//2.ʹ��OutputStreamWrite�е�writer����
		osw.write("���");
		//3.flush
		osw.flush();
		//4.close
		osw.close();
	}
	
	private static void write_gbk() throws IOException{
		//1.����OutputStreamWriter����
				OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"),"gbk");
				//2.ʹ��OutputStreamWrite�е�writer����
				osw.write("���");
				//3.flush
				osw.flush();
				//4.close
				osw.close();
	}
}
