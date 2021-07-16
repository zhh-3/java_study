package study_file;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream 字节输出流
  * 继承java.io.InputStream
  * 共性方法：
  *  void close()关闭此输入流并释放与该流关联的所有系统资源。
     abstract  int read() 从输入流中读取数据的下一个字节。 
     int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。 
     int read(byte[] b, int off, int len) 将输入流中最多 len 个数据字节读入 byte 数组。  
     
   构造方法：
   FileInputStream(String name) 通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。
   FileInputStream(File file)  通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
   
   方法：
    int read() 从此输入流中读取一个数据字节。 
	int read(byte[] b)  从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。 
	int read(byte[] b, int off, int len)  从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 

 */
public class file_in {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\wenjian\\abc\\d.txt");
		int len = 0;
		int n = fis.read()-'0';
		int [] a = new int[n];
//		len = fis.read();
//		k = len -'0';
//		System.out.println(k);
//		System.out.println(len); //97
//		System.out.println((char)len); //a
		
//		byte [] bytes = new byte[2];
//		len = fis.read(bytes);
//		System.out.println(len);  //2
//		System.out.println(new String(bytes));  //bc指针已移动
		
		for (int i = 0; i < n; i++) {
			a[i] = getnum(fis);
		}
		fis.close();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static int getnum(FileInputStream fis) throws IOException{
		int s = 0;
		int len = 0;
		while ((len = fis.read()) != 32 && len != -1) {
			if (len <= '9'&&len >= '0') {
				s = 10*s +len-'0';
			}
		}
		return s;
	}
}











