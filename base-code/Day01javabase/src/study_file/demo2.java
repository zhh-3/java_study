package study_file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*
 * 过滤器实现遍历输出
 *  File[] listFiles(FileFilter filter) 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 *   File[] listFiles(FilenameFilter filter) 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。 
 */
public class demo2 {
	public static void main(String args[]) {
		File  f1 = new File("E:\\wenjian\\abc");
		getallfile(f1);
	}
	
	private static void getallfile(File file ) {
		// TODO Auto-generated method stub
		File[] arr = file.listFiles(new IFilefilter());
		//使用匿名内部类
		/*File[] arr = file.listFiles(  new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				过滤规则：
						以.txt结尾的文件或者是文件夹返回true
						否则返回false
		判断是否是文件夹的方法:parent + child
				return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".txt");
			}
		}  ); */
		
		//使用lambda表达式优化匿名内部类(接口中只有一个抽象方法)
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
