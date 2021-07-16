package Threadstudy;
/*
 	创建多线程的第一种方式：创建thread类的子类

 	实现步骤：
 		1.创建一个Thread类的子类
 		2.在Thread类的子类中重写run方法，设置线程任务
 		3.创建Thread子类对象
 		4.调用该对象中start方法，开始新线程，执行run方法

 */
public class demo01 {
	public static void main(String args[]) {
		Mythread p = new Mythread();
		p.start();

		new Mythread().start();
		new Mythread().start();

		/*for (int i = 0; i < 20; i++) {
			System.out.println("main:"+i);
		}*/

		//链式编程,该主类未继承Thread，要先调用currentThread()方法获取线程，在调用getName()方法
		System.out.println(Thread.currentThread().getName());
	}
}

