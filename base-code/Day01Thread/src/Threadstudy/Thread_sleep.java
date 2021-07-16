package Threadstudy;
/*
 	static void sleep(long millis) 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。
 */
public class Thread_sleep {
	public static void main(String args[]) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 1; i <= 60; i++) {
			System.out.println(i);
			Thread.sleep(100);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - start));
		
	}
}
