package study_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 	练习读取GBK文件，并将其以UTF-8的格式写入文件中
 	分析：
 	1.创建一个InputStreamReader对象
 	2.创建OutputStreamWriter对象。
 	3.使用InputStreamReader对象中的read方法，读取数据
 	4.使用OutputStreamWriter对象中的write方法，写入数据
 	5.释放资源
 */
public class gbk_change_utf {
	public static void main(String args[]) throws IOException{
		//1.创建一个InputStreamReader对象,默认为GBK格式
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));
		//2.创建OutputStreamWriter对象,默认为GBK格式，如果使用GBK格式，写入的还是“你好”,字节为4个。
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\eclipse-workspace\\javastudy\\src\\out2.txt"),"utf-8");
		//3.使用InputStreamReader对象中的read方法，读取数据
		int len = 0;
		while ((len = isr.read()) != -1) {
			//4.使用OutputStreamWriter对象中的write方法，写入数据
			osw.write(len);
		}
		//5.释放资源
		isr.close();
		osw.close();
	}
}
