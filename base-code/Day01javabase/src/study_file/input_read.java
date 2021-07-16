package study_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 	java.io.InputStreamReader
 	是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符
 	
 	构造方法:
 	InputStreamReader(InputStream in)   创建一个使用默认字符集的 InputStreamReader。  eclipse 中默认为GBK格式
    InputStreamReader(InputStream in, String charsetName)   创建使用指定字符集的 InputStreamReader。
    
    使用方法：
    1.创建一个InputStreamReader对象
    2.使用InputStreamReader对象中的方法read
    3.关闭流
    
   注意事项：
   构造方法中的指定编码表名称要和文件中的一致，否则会发生乱码
 */
public class input_read {
	public static void main(String args[]) throws IOException{
		read_gbk();
//		read_utf_8();
	}

	private static void read_gbk() throws IOException{
		// TODO Auto-generated method stub
		//1.创建一个InputStreamReader对象
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"),"gbk");
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));//默认为gbk格式
		//2.使用InputStreamReader对象中的方法read
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char)len);
		}
		//3.关闭流
		isr.close();
	}
	
	private static void read_utf_8() throws IOException{
		//1.创建一个InputStreamReader对象
		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"),"utf-8");
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\wenjian\\abc\\d.txt"));//默认为gbk格式
		//2.使用InputStreamReader对象中的方法read
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char)len);
		}
		//3.关闭流
		isr.close();
	}
}
