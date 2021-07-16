package WaitAndNotify;
/*
 	等待唤醒案例：买卖包子
 		创建一个顾客线程（消费者）：告知老板包子数量和种类，调用wait方法，放弃cpu执行，进入WAITING状态
 		创建一个老板线程（生产者）：花费5秒做包子，调用notify方法，告知顾客吃包子

 	注意：
 		顾客和老板线程要用东部代码块包起来，保证等待和唤醒只能有一个在执行
 		同步使用的锁对象必须保证唯一
 		只有锁对象才能调用wait和notify方法

 	Object中的方法
 	void wait() 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
 	void notify()  唤醒在此对象监视器上等待的单个线程
 */
public class demo {
	public static void main(String args[]) {
		//创建锁对象，保证唯一
		Object obj = new Object();

		//创建一个顾客线程
		new Thread() {
			public void run() {
				synchronized (obj) {
					System.out.println("顾客1，告知老板要吃的包子种类和数量");
					//该处异常只能使用try  catch来捕获
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("顾客1开始吃包子，3秒吃完");
					for (int i = 0; i < 3; i++) {
						System.out.println(i+1);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("------------------------------");
				}
			}
		}.start();

		//创建一个顾客线程
		new Thread() {
			public void run() {
				synchronized (obj) {
					System.out.println("顾客2告知老板要吃的包子种类和数量");
					//该处异常只能使用try  catch来捕获
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("顾客2开始吃包子，3秒吃完");
					for (int i = 0; i < 3; i++) {
						System.out.println(i+1);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("------------------------------");						}
			}
		}.start();

		//创建一个老板线程
		new Thread() {
			public void run() {
				synchronized (obj) {
					for (int i = 1; i <= 5; i++) {
						System.out.println(i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("告知顾客包子做好了，可以吃了");
//					obj.notify();
					obj.notifyAll();
				}
			}
		}.start();
	}
}
