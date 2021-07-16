package study_file;

import java.io.FileReader;
import java.io.IOException;

/*
 * java.io.Reader  
 * 共有方法
 * int read() 读取单个字符。 
   int read(char[] cbuf) 将字符读入数组 
   abstract  void close() 关闭该流并释放与之关联的所有资源。 

 *FileReader extends InputStreamReader extends Reader
 *构造方法：   
 *FileReader(String fileName) 在给定从中读取数据的文件名的情况下创建一个新 FileReader。
 *FileReader(File file)  在给定从中读取数据的 File 的情况下创建一个新 FileReader。
 */
public class file_in_string {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("E:\\wenjian\\abc\\a\\a3.png");
        int len = 0;
        char cs[] = new char[1024];
        long a = System.currentTimeMillis();
        while ((len = fr.read(cs)) != -1) {
//            System.out.print(new String(cs, 0, len));
        }
        fr.close();
        long b = System.currentTimeMillis();
        System.out.println("\n耗时：" + (b - a) + "毫秒");//耗时：15毫秒

        long a1 = System.currentTimeMillis();
        FileReader fr1 = new FileReader("E:\\wenjian\\abc\\a\\p1.png");
        while ((len = fr1.read())!=-1){
//            System.out.print((char)len);
        }
        long b1 = System.currentTimeMillis();
        System.out.println("\n耗时：" + (b1 - a1) + "毫秒");//耗时：20毫秒
        fr1.close();
    }
}
