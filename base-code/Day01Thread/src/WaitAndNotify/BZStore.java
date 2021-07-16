package WaitAndNotify;
/*
 	生产者类，是一个线程可以继承thread
 	设置线程任务，run生产包子
 	对包子状态进行判断
 	true：有包子，进入等待状态
 	false：没包子，包子铺生产包子
 	生产好包子之后，修改包子状态，为有包子
 	唤醒吃货线程，吃包子

 	注意：包子铺线程和包子线程的关系是通信关系（互斥）
 		  必须同时同步技术，保证两个线程只有一个在执行
 		  锁对象保证唯一，可以使用包子对象作为锁对象
 		  将包子作为参数传入包子铺类和吃货类
 */
class BZStore extends Thread{
	private BaoZi bz;

	public  BZStore(BaoZi bz) {
		this.bz = bz;
	}

	//设置线程任务
	public void run(){
		bz.num = 0;

		//生产10个包子
		while (bz.num < 10) {
			synchronized (bz) {
				//有包子
				if (bz.flag == true) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					if (bz.num%2 == 0) {
						bz.name = "牛肉馅包子";
					}else {
						bz.name = "羊肉馅包子";
					}
					bz.num++;
					System.out.println("包子铺正在生产"+bz.name);
					//生产时间
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bz.flag = true;

					//生产好包子，唤醒吃货
					bz.notify();
					System.out.println("已经生产好"+bz.name+"吃货可以开始吃");
				}
			}
		}
	}
}
