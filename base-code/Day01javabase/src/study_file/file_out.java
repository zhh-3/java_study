package study_file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutputStream  �ļ��ֽ������
 * �̳� OutputStream
 *���Է�����
 *void close() �رմ���������ͷ�������йص�����ϵͳ��Դ�� 
 *void flush() ˢ�´��������ǿ��д�����л��������ֽڡ� 
 *void write(byte[] b) �� b.length ���ֽڴ�ָ���� byte ����д���������� 
 *void write(byte[] b, int off, int len)  ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д���������� 
 *abstract  void write(int b) ��ָ�����ֽ�д���������� 
 
 
 * ������
 *  protected  void finalize() �����ļ������ӣ���ȷ���ڲ������ô��ļ������ʱ���ô����� close ������
 *  FileChannel getChannel() ��������ļ�������йص�Ψһ FileChannel ����
 *  FileDescriptor getFD() ����������йص��ļ���������
 *  void write(int b) ��ָ���ֽ�д����ļ��������     
 
 * ���췽����
 * FileOutputStream(File file)  ����һ����ָ�� File �����ʾ���ļ���д�����ݵ��ļ��������
 * FileOutputStream(String name) ����һ�������ָ�����Ƶ��ļ���д�����ݵ�����ļ�����
 * ׷��д�Ĺ��췽��
   FileOutputStream(File file, boolean append) ����һ����ָ�� File �����ʾ���ļ���д�����ݵ��ļ��������
   FileOutputStream(String name, boolean append) ����һ�������ָ�� name ���ļ���д�����ݵ�����ļ�����
   name: ·��
   file: �ļ�
 */
public class file_out {
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("E:\\wenjian\\abc\\d.txt");
		fos.write(97);
		fos.flush();
		fos.close();
	}
}


















