package study_file;

import java.io.Serializable;

/*
 * 序列化和反序列化时，会抛出NotSerializableException异常，没有序列化
 * 类通过实现java.io.Serializable接口，以使用其序列化和反序列化功能，未实现改接口将无法使用任何状态序列化和反序列化
   Serializable接口也叫标记型接口，
   		当要进行序列化和反序列化时，，就会检测类上是否有这个标记
   			有：可以序列化和反序列化
   			没有：会抛出异常
 */
class person implements Serializable{
	//改常量用于确定序列号，使每次修改本类之后，可以直接反序列化，不用再去序列化一次
	private static final long serialVersionUID = 1L;
	String name;
	private int age;
	
	public person() {
		// TODO Auto-generated constructor stub
		name = "no name";
		age = 10;
	}
	
	public  person(String name,int age) {
		this.name = name;
		this.age = age;
	}

	//要重写该方法，不然返回study_file.person@433c675d
	public String toString() {
		return name+"="+age;
	}

	public String  getname() {
		return name;
	}
	
	public int getage() {
		return age;
	}
	
}
