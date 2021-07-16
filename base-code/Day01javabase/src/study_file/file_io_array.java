package study_file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/*
 String getProperty(String key) ��ָ���ļ��ڴ������б����������ԡ�   �൱��get(key)
 Set<String> stringPropertyNames() ���ش������б��е�"����"(key)�����иü������Ӧֵ���ַ�����������������б���δ�ҵ�ͬ���ļ����򻹰���Ĭ�������б��в�ͬ�ļ��� �൱��set����
 Object setProperty(String key, String value)  ���� Hashtable �ķ��� put
 
  store ��д��Ӳ��
  load  ����������
 */
public class file_io_array {
	public static void main(String args[]) throws IOException {
		show3();
	}
	
	/*
	 load ����  ��Ӳ���б�����ļ�����ֵ�������浽������ʹ��
	 void load(InputStream inStream) ���������ж�ȡ�����б�����Ԫ�ضԣ��� 
 	 void load(Reader reader) ���򵥵������еĸ�ʽ�������ַ����ж�ȡ�����б�����Ԫ�ضԣ��� 
	 ������
	 	InputStream inStream  ���ܶ�ȡ����
	 	Reader reader  ���Զ�ȡ����
	 ʹ�÷�����
	    1.����Properties���϶���
	    2.ʹ��Properties�����е�load��������ȡ�����ֵ���ļ�
	    3.����Properties����
	 ע�����
	 	1.�����ֵ�Ե��ļ��У�����ֵ��=��ո�����������
	 	2.�����ֵ�Ե��ļ��У�����ʹ��#����ע�ͣ���ע�͵Ĳ��ֲ����ٱ���ȡ
	 	3.�����ֵ�Ե��ļ��У�����ֵĬ�϶����ַ����������ټӡ���
	 */
	private static void show3() throws IOException{
		//1.����Properties���϶���
		Properties prop = new Properties();
		
		//2.ʹ��Properties�����е�load��������ȡ�����ֵ���ļ�
		prop.load(new FileReader("E:\\wenjian\\abc\\e.txt"));
		
		//3.����Properties����
		Set<String> set  = prop.stringPropertyNames();
		for (String key : set ) {
			String value = prop.getProperty(key);
			System.out.println(key+"="+value);
		}
		/*
		 * ����100=//=�����ӷ�
		  zhh=200
		  hah=1000
		 */
		
	}
	
	//
	private static void show1() {
		// TODO Auto-generated method stub
		//��������
		Properties pro = new Properties();
		
		//�������
		pro.setProperty("����", "100");
		pro.setProperty("hah", "1000");
		pro.setProperty("zhh", "200");
		
		//��������
		Set<String > set = pro.stringPropertyNames();
		for (String key : set) {
			String value = pro.getProperty(key);
			System.out.println(key+"="+value);
		}
	}
	
	/*
	 * store ����  �������е��ļ�д��Ӳ��
	 void store(OutputStream out, String comments) ���ʺ�ʹ�� load(InputStream) �������ص� Properties ���еĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д��������� 
 	 void store(Writer writer, String comments) ���ʺ�ʹ�� load(Reader) �����ĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д������ַ��� 
	 ������
		OutputStream out���ֽ��������������������
		Writer writer���ַ��������������������
		String comments�� ���ͣ����������ģ���������룬һ���ÿ��ַ� ����
	ʹ�÷�����
		1.����Properties����
		2.�����ֽ������/�ַ���������󣬲�ָ��Ŀ�ĵ�
		3.ʹ��Properties�е�store����
		4.�ر���
	 */
	private static void show2() throws IOException {
		//1.����Properties����
		Properties pro = new Properties();
		pro.setProperty("����", "100");
		pro.setProperty("hah", "1000");
		pro.setProperty("zhh", "200");
		
		//2.�����ֽ������/�ַ���������󣬲�ָ��Ŀ�ĵ�
		FileWriter  fw = new FileWriter("E:\\wenjian\\abc\\e.txt");
		
		//3.ʹ��Properties�е�store����
		pro.store(fw, "save data");
		
		//4.�ر���
		fw.close();
	}
}
