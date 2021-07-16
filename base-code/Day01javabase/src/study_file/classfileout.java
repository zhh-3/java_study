package study_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 java.io.ObjectOutputStream  extend OutputStream
 对象序列化
 作用：把对象以字节的形式写入文件
 构造方法：
 ObjectOutputStream(OutputStream out)  创建写入指定 OutputStream 的 ObjectOutputStream。
 特有的成员方法：
 writeObject(Object obj)   将指定的对象写入 ObjectOutputStream。
 
 使用方法：
 1.构建一个ObjectOutputStream对象
 2.使用writeObject方法
 3.释放资源
 
 注意：
 被static 静态成员变量修饰的成员不能被序列化
 比如  大美女0
 
 关键字transient 修饰的同样不能被序列化，瞬态关键字
 对于不想被序列化的非静态成员，可以用这个来修饰
 
 */
public class classfileout {
	public static void main(String args[]) throws IOException{
		//1.构建一个ObjectOutputStream对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\wenjian\\abc\\a\\a1.txt"));
		//2.使用writeObject方法
		oos.writeObject(new person("大美女",18));
		oos.writeObject(new person("小美女", 18));//不建议这么做，可以吧对象写入一个集合，在对集合进行序列化和反序列化
		//3.释放资源
		oos.close();
	}
}
