package ThreadSafe;
/*
 * 模拟卖票
 * 创建3个线程，同时开启，对共享的票进行出售
 */
public class demo {
	public static void main(String args[]) {
		//接口实现类对象
		Irunnable1 run = new Irunnable1();
//		Irunnable2 run = new Irunnable2();
//		Irunnable3 run = new Irunnable3();

		//创建Thread对象,传入的是同一个接口实现类对象，保证售卖的是同100张票，如果传入三个不同对象则售卖300张票
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);

		t1.start();
		t2.start();
		t3.start();
	}
}
