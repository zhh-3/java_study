package WaitAndNotify;

public class demo1 {
	public static void main(String args[]) {
		//创建包子对象
		BaoZi bz = new BaoZi("肉包");

		//开启两个线程
		new BZStore(bz).start();
		new ChiHuo(bz).start();
	}
}
