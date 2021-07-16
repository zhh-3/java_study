package study_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 * 练习，对文本按照序号排列
 * 使用map集合
 * 分析：
 * 1.使用hashmap集合，存储每行的文本序列号（1,2,3）；value存储没条文本
 * 2.创建字符缓冲输入流对象，构造方法中绑定字符输入流
 * 3.创建字符缓冲输出流对象，构造方法中绑定字符输出流
 * 4.使用字符缓冲输入流中的方法readline,逐行读取文本
 * 5.对读取的文本进行切割，获取行中的序列号和文本内容
 * 6.吧切割好的序列号和文本内容存储到HashMap集合中（key是序号，会自动的排序）
 * 7.遍历HsahMap ,获取每一个键值对
 * 8.把每一个键值对拼接为一个文本行
 * 9.吧拼接好的文本，使用字符缓冲输出流中的方法Write写入到文件中
 * 10.释放资源
 */
public class practice_order {
	public static void main(String args[]) throws IOException {
//		1.使用hashmap集合，存储每行的文本序列号（1,2,3）；value存储没条文本
		HashMap<String, String > hashMap = new HashMap<String, String>();
//		2.创建字符缓冲输入流对象，构造方法中绑定字符输入流
		BufferedReader br = new BufferedReader(new FileReader("E:\\eclipse-workspace\\javastudy\\src\\in.txt"));
//		3.创建字符缓冲输出流对象，构造方法中绑定字符输出流
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));
//		4.使用字符缓冲输入流中的方法readline,逐行读取文本
		String line;
		while ((line = br.readLine()) != null) {
			//5.对读取的文本进行切割，获取行中的序列号和文本内容
			String [] arr = line.split("\\.");//以 . 为分割符，将文本分割为两部分
			//6.吧切割好的序列号和文本内容存储到HashMap集合中（key是序号，会自动的排序）
			hashMap.put(arr[0], arr[1]);
		}
		
//		7.遍历HsahMap ,获取每一个键值对
		for (String key : hashMap.keySet()) {
			String value = hashMap.get(key);
			//8.把每一个键值对拼接为一个文本行
			line = key + "." + value;
			//9.吧拼接好的文本，使用字符缓冲输出流中的方法Write写入到文件中
			bw.write(line);
			//读取时不会读取到换行符，自己换行
			bw.newLine();
		}
//		10.释放资源
		bw.close();
		br.close();
		
		
	}
}
