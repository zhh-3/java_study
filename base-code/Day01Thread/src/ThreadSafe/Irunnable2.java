package ThreadSafe;
/*
	卖票案例出现安全问题
	卖出了不存在和重复的票

	解决安全问题的第一种方法：使用同步代码块
	格式:
		synchronized(锁对象）{
			可能出现安全问题的代码块（访问了共享数据的代码块）
		}

	注意：
		1.通过代码块的锁对象可以是任何对象
		2.但是必须保证多个线程中使用的锁对象是同一个
		3.锁对象的作用：
			把同步代码块锁住，只让一个线程在同步代码块中执行
 */
public class Irunnable2 implements Runnable{

	private int tickes = 100;

	//创建一个任意锁对象
	Object obj = new Object();//定义在run方法外面，保证每次调用的锁对象是同一个

	//设置线程任务，卖票
	public void run() {
		// TODO Auto-generated method stub
//		while(tickes > 0) {
//			synchronized (obj) {
//				//判断票是否存在
//				if (tickes > 0) {
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName()+"您正在购买第"+tickes+"张票");
//					tickes--;
//				}
//			}
//		}

		synchronized (obj) {
			//判断票是否存在
			while(tickes > 0) {
				System.out.println(Thread.currentThread().getName()+"您正在购买第"+tickes+"张票");
				tickes--;
			}
		}
	}
}
