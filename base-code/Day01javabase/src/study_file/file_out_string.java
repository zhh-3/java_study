package study_file;

import java.io.FileWriter;
import java.io.IOException;

/*
  * Ҫˢ�»��߹ر�����������
  * Ҫˢ�»��߹ر�����������
  * Ҫˢ�»��߹ر�����������
  * ����д���ڴ����Ӳ��
 FileWriter  extends OutputStreamWriter extends Writer
 */
public class file_out_string {
	public static void main(String args[]) throws IOException {
		FileWriter  fw = new FileWriter("E:\\wenjian\\abc\\d.txt");
		char [] cs = {'a','b','c','d','e'};
		fw.write("��");
		fw.write(98);
//		fw.write(cs, 0, 3);
		fw.write("��������", 2, 2);
		
		//һ��Ҫ���Ĳ���
		fw.flush();
		fw.close();
	}
}
