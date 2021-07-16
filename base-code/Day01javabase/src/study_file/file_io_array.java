package study_file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/*
 String getProperty(String key) 用指定的键在此属性列表中搜索属性。   相当于get(key)
 Set<String> stringPropertyNames() 返回此属性列表中的"键集"(key)，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。 相当于set方法
 Object setProperty(String key, String value)  调用 Hashtable 的方法 put
 
  store ：写入硬盘
  load  ：读到集合
 */
public class file_io_array {
	public static void main(String args[]) throws IOException {
		show3();
	}
	
	/*
	 load 方法  把硬盘中保存的文件（键值），保存到集合中使用
	 void load(InputStream inStream) 从输入流中读取属性列表（键和元素对）。 
 	 void load(Reader reader) 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。 
	 参数：
	 	InputStream inStream  不能读取中文
	 	Reader reader  可以读取中文
	 使用方法：
	    1.创建Properties集合对象
	    2.使用Properties集合中的load方法，读取保存键值的文件
	    3.遍历Properties集合
	 注意事项：
	 	1.储存键值对的文件中，键与值以=或空格（其他）链接
	 	2.储存键值对的文件中，可以使用#进行注释，被注释的部分不会再被读取
	 	3.储存键值对的文件中，键与值默认都是字符串，不用再加“”
	 */
	private static void show3() throws IOException{
		//1.创建Properties集合对象
		Properties prop = new Properties();
		
		//2.使用Properties集合中的load方法，读取保存键值的文件
		prop.load(new FileReader("E:\\wenjian\\abc\\e.txt"));
		
		//3.遍历Properties集合
		Set<String> set  = prop.stringPropertyNames();
		for (String key : set ) {
			String value = prop.getProperty(key);
			System.out.println(key+"="+value);
		}
		/*
		 * 哈哈100=//=是连接符
		  zhh=200
		  hah=1000
		 */
		
	}
	
	//
	private static void show1() {
		// TODO Auto-generated method stub
		//创建对象
		Properties pro = new Properties();
		
		//添加数据
		pro.setProperty("哈哈", "100");
		pro.setProperty("hah", "1000");
		pro.setProperty("zhh", "200");
		
		//遍历数据
		Set<String > set = pro.stringPropertyNames();
		for (String key : set) {
			String value = pro.getProperty(key);
			System.out.println(key+"="+value);
		}
	}
	
	/*
	 * store 方法  将集合中的文件写入硬盘
	 void store(OutputStream out, String comments) 以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。 
 	 void store(Writer writer, String comments) 以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。 
	 参数：
		OutputStream out；字节输出流，不能输入中文
		Writer writer；字符输出流，可以输入中文
		String comments： 解释，不能用中文，会产生乱码，一般用空字符 “”
	使用方法：
		1.创建Properties对象
		2.创建字节输出流/字符输出流对象，并指明目的地
		3.使用Properties中的store方法
		4.关闭流
	 */
	private static void show2() throws IOException {
		//1.创建Properties对象
		Properties pro = new Properties();
		pro.setProperty("哈哈", "100");
		pro.setProperty("hah", "1000");
		pro.setProperty("zhh", "200");
		
		//2.创建字节输出流/字符输出流对象，并指明目的地
		FileWriter  fw = new FileWriter("E:\\wenjian\\abc\\e.txt");
		
		//3.使用Properties中的store方法
		pro.store(fw, "save data");
		
		//4.关闭流
		fw.close();
	}
}
