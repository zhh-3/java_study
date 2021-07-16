package ThreadSafe;
/*
 	同步方法
 	定义一个方法：将共享数据代码放入该方法中

 	步骤：
 	1.定义一个用synchronized修饰的方法
 	2.将共享数据的代码放在里面
 */
public class Irunnable3 implements Runnable{
	private int tickets = 100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (tickets > 0) {
			paytick();
		}
	}

	//定义一个同步方法
	public synchronized void paytick() {
		if (tickets > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"您正在购买第"+tickets+"张票");
			tickets--;
		}
	}
}
