package javastudy1;

import java.io.*;

public class filecopy {
	public static void main(String args[]) {
		try {
			File t1 = new File("E:\\wenjian\\","text1.txt");   
			File t2 = new File("E:\\wenjian\\","text2.txt");
			FileOutputStream fos1 = new FileOutputStream(t1);//创建FileOutputStream对象
			int b;
			while ((char)(b = System.in.read() ) !='\n') {
				fos1.write(b);//写入输出流
			}
			fos1.close();//关闭流
			FileInputStream fis = new FileInputStream(t1);//读取text1中的文件
			FileOutputStream fos2 = new FileOutputStream(t2);//将文件写入text2中
			int c;
			while ((c = fis.read()) != -1) {
				fos2.write(c);
			}
			fis.close();
			fos2.close();
			String s = t2.getPath();
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("FileStreamsTest:"+e);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
	}
}
