package study_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
  java.io.OutputStreamWriter
  是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节
  构造方法：
  OutputStreamWriter(OutputStream out) 创建使用默认字符编码的 OutputStreamWriter。
  OutputStreamWriter(OutputStream out, String charsetName)  创建使用指定字符集的 OutputStreamWriter。
  
  参数：
    OutputStream  字节输出流
    String charsetName  指定编码格式，不区分大小写，utf-8/UTF-8
    
  使用步骤：
  1.创建OutputStreamWriter对象。
  2.使用OutputStreamWrite中的writer方法
  3.flush
  4.close
*/
public class output_writer {
	public static void main(String args[]) throws IOException{
		write_utf_8();
//		write_gbk();
	}

//	使用OutputStreamWriter写utf_8格式文件
	private static void write_utf_8() throws IOException{
		// TODO Auto-generated method stub
		//1.创建OutputStreamWriter对象。
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\wenjian\\abc\\d.txt"));
		//2.使用OutputStreamWrite中的writer方法
		osw.write("你好");
		//3.flush
		osw.flush();
		//4.close
		osw.close();
	}
	
	private static void write_gbk() throws IOException{
		//1.创建OutputStreamWriter对象。
				OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"),"gbk");
				//2.使用OutputStreamWrite中的writer方法
				osw.write("你好");
				//3.flush
				osw.flush();
				//4.close
				osw.close();
	}
}
