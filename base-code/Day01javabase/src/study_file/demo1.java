package study_file;

import java.io.File;

/*
 * �ļ�����
 * ����
 *    1.�����ļ���E:\wenjian\abc
 *    2.ֻҪ.txt��β���ļ�
 */
public class demo1 {
		public static void main(String args[]) {
			File  f1 = new File("E:\\wenjian\\abc");
			getallfile(f1);
		}
		
		private static void getallfile(File file ) {
			// TODO Auto-generated method stub
//			System.out.println(file);
			File[] arr = file.listFiles();
			for (File  filename : arr) 
			{
				if (filename.isFile()) 
				{
//					System.out.println(filename);
					if (filename.toString().endsWith(".txt"))
					{
						System.out.println(filename);
					}
				}
				else if (filename.isDirectory())
				{
					getallfile(filename);
				}
			}
		}
}
