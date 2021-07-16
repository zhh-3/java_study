package study_file;

import java.io.FileReader;
import java.io.IOException;

/*
 * java.io.Reader  
 * ���з���
 * int read() ��ȡ�����ַ��� 
   int read(char[] cbuf) ���ַ��������� 
   abstract  void close() �رո������ͷ���֮������������Դ�� 

 *FileReader extends InputStreamReader extends Reader
 *���췽����   
 *FileReader(String fileName) �ڸ������ж�ȡ���ݵ��ļ���������´���һ���� FileReader��
 *FileReader(File file)  �ڸ������ж�ȡ���ݵ� File ������´���һ���� FileReader��
 */
public class file_in_string {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("E:\\wenjian\\abc\\a\\a3.png");
        int len = 0;
        char cs[] = new char[1024];
        long a = System.currentTimeMillis();
        while ((len = fr.read(cs)) != -1) {
//            System.out.print(new String(cs, 0, len));
        }
        fr.close();
        long b = System.currentTimeMillis();
        System.out.println("\n��ʱ��" + (b - a) + "����");//��ʱ��15����

        long a1 = System.currentTimeMillis();
        FileReader fr1 = new FileReader("E:\\wenjian\\abc\\a\\p1.png");
        while ((len = fr1.read())!=-1){
//            System.out.print((char)len);
        }
        long b1 = System.currentTimeMillis();
        System.out.println("\n��ʱ��" + (b1 - a1) + "����");//��ʱ��20����
        fr1.close();
    }
}
