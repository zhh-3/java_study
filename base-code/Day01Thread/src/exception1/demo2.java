package exception1;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *  throws关键字的使用：throws  xxxException
 * 		1.该关键字必须写在方法声明处
 * 		2.如果声明多个异常，throws后面也要抛出多个异常，如果是子父类关系可以只抛出父类异常
 * 		3.调用一个声明抛出异常，我们就必须处理这个异常对象
 * 			要么继续使用throws声明抛出，交给方法的调用者处理，最终交给JVM
 * 			或者使用try  catch结构
 * 			
 */
public class demo2 {
	public static void main(String args[]) {
		try {
			readfile("c:\\b.txt");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("无此文件");
		}
		System.out.println("后续代码");
	}
	
	public static void readfile(String filename) throws FileNotFoundException{
		if (!filename.equals("c:\\a.txt")) {
			//该异常不是RuntimeException异常，是编译异常，需要处理该异常，可以使用throws继续抛出异常
			throw new FileNotFoundException("文件路径不正确");
		}
		if (filename.endsWith(".txt")) {
			throw new FileNotFoundException("后缀名错误");
		}
		System.out.println("路径正确");
	}
}
