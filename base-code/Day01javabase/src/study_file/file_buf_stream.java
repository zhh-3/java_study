package study_file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 java.io.BufferedOutputStream extends OutputStream
 共有的方法：略
 构造方法：
 	1.BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入指定的底层输出流。 
	2.BufferedOutputStream(OutputStream out, int size) 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。 
	参数：
	OutPutStream out 字节输出流
		我们可以传入一个FileOutPutStream，提供给他一个缓冲区，提高效率
	int size  给定缓冲流中缓冲区大小
	
	使用步骤：
	1.创建一个FileOutPutStream对象
	2.创建一个BufferedOutputStream对象，构造方法中传入FileOutPutStream，提高FileOutPutStream效率
	3.使用BufferedOutputStream中的writer方法，将数据写入缓冲区，
	4.使用flush方法
	5.释放资源，关闭流
 */
public class file_buf_stream {
	public static void main(String args[]) throws IOException{
		show1();
	}
	
	private static void show1() throws IOException{
		long s = System.currentTimeMillis();
		//1.创建一个FileOutPutStream对象
		FileOutputStream fos = new FileOutputStream("E:\\wenjian\\abc\\f.txt",true);//续写
		
		//2.创建一个BufferedOutputStream对象，构造方法中传入FileOutPutStream，提高FileOutPutStream效率
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//3.使用BufferedOutputStream中的writer方法，将数据写入缓冲区，
		bos.write("哈哈哈".getBytes());
		
		//4.使用flush方法
		bos.flush();
		
		//5.释放资源，关闭流
		bos.close();
		
		long e = System.currentTimeMillis();
		System.out.println("耗时："+(e-s)+"毫秒");
		
		//以下为比较时间部分
		long a = System.currentTimeMillis();
		FileOutputStream fos2 = new FileOutputStream("E:\\wenjian\\abc\\f.txt",true);
		fos2.write("哈哈哈".getBytes());
		fos2.close();
		long b = System.currentTimeMillis();
		System.out.println("耗时："+(b-a)+"毫秒");
		
		
		
	}
}
