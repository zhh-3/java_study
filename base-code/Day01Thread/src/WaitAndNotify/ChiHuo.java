package WaitAndNotify;
/*
	线程任务：吃包子
	对包子状态判断
	有包子:吃包子
	没包子：wait
 */
class ChiHuo extends Thread{
	private BaoZi bz;

	public ChiHuo(BaoZi bz) {
		this.bz = bz;
	}

	public void run() {
		while (bz.num <= 10) {
			synchronized (bz) {
				if (bz.flag == false) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("吃货正在吃"+bz.name);
					//修改状态
					bz.flag = false;
					//唤醒包子铺线程
					bz.notify();
					System.out.println(bz.name+"已经吃完，包子铺开始生产包子");
					System.out.println(bz.num);
					System.out.println("--------------------------------------------");
				}
			}
		}
	}
}
