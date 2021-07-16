package javastudy1;
import java.util.Vector;

public class vector {
	public static void main(String args[]) {
		Vector<train> vec = new Vector<train>(5);
		train a1,b1;
		a1=new train();
		a1.setab(1.2, 2.2);
		b1=new train();
		b1.setab(1.1, 2.1);
		vec.addElement(a1);
		vec.addElement(b1);
		train c,d;
		c=vec.elementAt(0);
		d=vec.lastElement();
		System.out.println(c.geta());
		System.out.println(d.getb());
	}
}

class train{
	private  double a,b;
	public void setab(double a,double b) {
		this.a=a;
		this.b=b;
	}
	
	public double  geta() {
		return a;
	}
	
	public double  getb() {
		return b;
	}
}