package javastudy1;

public class xiancheng  extends Thread{
	String threadname;
	public xiancheng(String s) {
		// TODO Auto-generated constructor stub
		System.out.println("making thread:"+s);
		threadname = s;
	}
	
	public void run() {   
		System.out.println("123");
		for(int i=0;i<3;i++) {
			System.out.println("Runing thread number ="+threadname);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.err.println(e.toString());
			}
		}
	}
	
	public static void main(String args[]) {
		xiancheng thread1 = new xiancheng("tom");
		
		xiancheng thread2 = new xiancheng("jack");
		
		System.out.println("end");
		thread1.start();
		thread2.start();
	}
}


