package study_file;

import java.io.File;
import java.io.FileFilter;

public class IFilefilter implements FileFilter{

	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		/*
		  ���˹���
		  ��.txt��β���ļ�����true
		  ���򷵻�false
		 */
		//������ļ��м�������������true
		if (pathname.isDirectory()) {
			return true;
		}
		return pathname.getName().toLowerCase().endsWith(".txt");
//		return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt");
	}
}
