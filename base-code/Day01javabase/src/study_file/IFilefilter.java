package study_file;

import java.io.File;
import java.io.FileFilter;

public class IFilefilter implements FileFilter{

	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		/*
		  过滤规则
		  以.txt结尾的文件返回true
		  否则返回false
		 */
		//如果是文件夹继续遍历，返回true
		if (pathname.isDirectory()) {
			return true;
		}
		return pathname.getName().toLowerCase().endsWith(".txt");
//		return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt");
	}
}
