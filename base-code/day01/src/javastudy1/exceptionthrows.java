package javastudy1;

public class exceptionthrows {
	public static void main(String args[]) {
		try {
			myexception my = new myexception();
			my.someMethod("abc");
			my.someMethod("abcdefg");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}

class myexception extends Exception{

	public myexception() {
		super("×Ö·û´®Ì«¶Ì");
	}
	public  void someMethod(String s) throws myexception {
		if(s.length()<4)
			throw new myexception();
		else 
			System.out.println("¿ÉÒÔµÄ");
	}
}