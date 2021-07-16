package study_file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*
 * ������ʵ�ֱ������
 *  File[] listFiles(FileFilter filter) ���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
 *   File[] listFiles(FilenameFilter filter) ���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼�� 
 */
public class demo2 {
	public static void main(String args[]) {
		File  f1 = new File("E:\\wenjian\\abc");
		getallfile(f1);
	}
	
	private static void getallfile(File file ) {
		// TODO Auto-generated method stub
		File[] arr = file.listFiles(new IFilefilter());
		//ʹ�������ڲ���
		/*File[] arr = file.listFiles(  new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				���˹���
						��.txt��β���ļ��������ļ��з���true
						���򷵻�false
		�ж��Ƿ����ļ��еķ���:parent + child
				return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".txt");
			}
		}  ); */
		
		//ʹ��lambda���ʽ�Ż������ڲ���(�ӿ���ֻ��һ�����󷽷�)
		/*File[] arr = file.listFiles((File f,String name)->{
			return new File(f, name).isDirectory() || name.toLowerCase().endsWith(".txt");
		});*/
		
		for (File  filename : arr) 
		{
			if (filename.isFile()) 
			{
				System.out.println(filename);
			}
			else if (filename.isDirectory())
			{
				getallfile(filename);
			}
		}
	}

}
