package study_file;

import java.io.Serializable;

/*
 * ���л��ͷ����л�ʱ�����׳�NotSerializableException�쳣��û�����л�
 * ��ͨ��ʵ��java.io.Serializable�ӿڣ���ʹ�������л��ͷ����л����ܣ�δʵ�ָĽӿڽ��޷�ʹ���κ�״̬���л��ͷ����л�
   Serializable�ӿ�Ҳ�б���ͽӿڣ�
   		��Ҫ�������л��ͷ����л�ʱ�����ͻ��������Ƿ���������
   			�У��������л��ͷ����л�
   			û�У����׳��쳣
 */
class person implements Serializable{
	//�ĳ�������ȷ�����кţ�ʹÿ���޸ı���֮�󣬿���ֱ�ӷ����л���������ȥ���л�һ��
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

	//Ҫ��д�÷�������Ȼ����study_file.person@433c675d
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
