package javastudy1;

//���͵�Ӧ��
class pointdemo<T>{		//T��һ����,����
	private T x;
	private T y;
	
	public void setx(T X) {
		this.x=X;	
	}
	public void sety(T Y)
	{
		this.y=Y;
	}
	
	public T getx()
	{
		return x;
	}
	public T gety() {
		return y;
	}
}

public class fanxing {
	public static void main(String args[]) {
		//����ת��
//		String a = "123"; 
//		int i = Integer.parseInt(a)+1;
//		Integer num = new Integer(i);
//		int x = num.intValue();
//		System.out.println(x);
		
		pointdemo<Integer> p1=new pointdemo<Integer>();
		pointdemo<Double> p2 = new pointdemo<Double>();
		pointdemo<String> p3 = new pointdemo<String>();
		p1.setx(30);
		p1.sety(50);
		p2.setx(10.5);
		p2.sety(10.5);
		p3.setx("����");
		p3.sety("��γ");
		System.out.println(p1.getx()+" "+p1.gety());
		System.out.println(p2.getx()+" "+p2.gety());
		System.out.println(p3.getx()+" "+p3.gety());
	}
}
