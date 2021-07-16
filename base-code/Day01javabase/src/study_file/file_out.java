package study_file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutputStream  文件字节输出流
 * 继承 OutputStream
 *共性方法：
 *void close() 关闭此输出流并释放与此流有关的所有系统资源。 
 *void flush() 刷新此输出流并强制写出所有缓冲的输出字节。 
 *void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。 
 *void write(byte[] b, int off, int len)  将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。 
 *abstract  void write(int b) 将指定的字节写入此输出流。 
 
 
 * 方法：
 *  protected  void finalize() 清理到文件的连接，并确保在不再引用此文件输出流时调用此流的 close 方法。
 *  FileChannel getChannel() 返回与此文件输出流有关的唯一 FileChannel 对象。
 *  FileDescriptor getFD() 返回与此流有关的文件描述符。
 *  void write(int b) 将指定字节写入此文件输出流。     
 
 * 构造方法：
 * FileOutputStream(File file)  创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
 * FileOutputStream(String name) 创建一个向具有指定名称的文件中写入数据的输出文件流。
 * 追加写的构造方法
   FileOutputStream(File file, boolean append) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
   FileOutputStream(String name, boolean append) 创建一个向具有指定 name 的文件中写入数据的输出文件流。
   name: 路径
   file: 文件
 */
public class file_out {
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("E:\\wenjian\\abc\\d.txt");
		fos.write(97);
		fos.flush();
		fos.close();
	}
}


















