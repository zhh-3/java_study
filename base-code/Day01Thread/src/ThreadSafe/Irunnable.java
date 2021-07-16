package ThreadSafe;
/*
 * 卖票案例
 */
public class Irunnable implements Runnable{
	private int tickes = 100;

	//设置线程任务，卖票
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//判断票是否存在
			if (tickes > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"您正在购买第"+tickes+"张票");
				tickes--;
			}
		}
	}

}
