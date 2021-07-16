package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_copy {
	public static void main(String args[]) throws IOException {
		//创建对象
		long s = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream("F:\\test1.c");//写入地方
		FileInputStream fis = new FileInputStream("F:\\test.c");//读取地方
		
		int len = 0;
		//每次读写一个字节
//		while((len = fis.read()) != -1) {
//			fos.write(len);
//		}
		
		//一个字节一个字节读取太慢，用数组缓冲
		byte [] bytes = new byte[1024];
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);//len 是有效字节数
		}
		
		//关闭流，先关闭写的流，在关闭读的流
		fos.flush();
		fos.close();
		fis.close();
		long e = System.currentTimeMillis();
		System.out.println("耗时"+(e-s)+"毫秒");

	}
}
