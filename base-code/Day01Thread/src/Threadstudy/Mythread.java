package Threadstudy;
/*
 	static Thread currentThread() 返回对当前正在执行的线程对象的引用。
    String getName() 返回该线程的名称。
 */
public class Mythread extends Thread{
	public void run() {
		/*for (int i = 0; i < 20; i++) {
			System.out.println("run:"+i);

		}*/
		String name;
		name = getName();
		System.out.println(name);

		Thread t = Thread.currentThread();
		System.out.println(t);
//		long l;
//		l = getId();
//		System.out.println(l);

		//链式编程
//		System.out.println(Thread.currentThread().getName());
	}
}
