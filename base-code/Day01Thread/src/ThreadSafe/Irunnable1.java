package ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 	使用lock锁
 	lock是一个接口
 	ReentrantLock implements lock

 	使用步骤：
 	1.在成员位置定义一个ReentrantLock对象
 	2.在可能出现安全问题的代码前调用lock中的lock方法获取锁
 	3.在可能出现安全问题的代码后调用lock中的unlock方法释放锁
 */
public class Irunnable1 implements Runnable{
	private int tickes = 100;

	//1.在成员位置定义一个ReentrantLock对象
	Lock  l = new ReentrantLock();

	//设置线程任务，卖票
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(tickes > 0) {
			//2.在可能出现安全问题的代码前调用lock中的lock方法获取锁
			l.lock();
			//判断票是否存在
			if (tickes > 0) {
				System.out.println(Thread.currentThread().getName()+"您正在购买第"+tickes+"张票");
				tickes--;
			}
			l.unlock();
		}
	}
}
