package javastudy1;

public class subclass extends superclass{
	public subclass(int y) {
		// TODO Auto-generated constructor stub
	y+=10;
	System.out.println(y);
	}
	
	public static void main(String args[]) {
		subclass text = new subclass(10);
	}
}

class superclass{
	  public superclass() {
		// TODO Auto-generated constructor stub
		System.out.println(15);
	}
}