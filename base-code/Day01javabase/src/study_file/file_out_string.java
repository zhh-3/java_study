package study_file;

import java.io.FileWriter;
import java.io.IOException;

/*
  * 要刷新或者关闭流！！！！
  * 要刷新或者关闭流！！！！
  * 要刷新或者关闭流！！！！
  * 数据写入内存而非硬盘
 FileWriter  extends OutputStreamWriter extends Writer
 */
public class file_out_string {
	public static void main(String args[]) throws IOException {
		FileWriter  fw = new FileWriter("E:\\wenjian\\abc\\d.txt");
		char [] cs = {'a','b','c','d','e'};
		fw.write("张");
		fw.write(98);
//		fw.write(cs, 0, 3);
		fw.write("张厉害啊", 2, 2);
		
		//一定要做的步骤
		fw.flush();
		fw.close();
	}
}
