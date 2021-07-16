package Threadstudy;
/*
 	匿名内部类：简化代码
 		将子类继承父类，重写父类方法，创建子类对象合成一步
 		将实现类实现接口，重写接口中方法，创建实现类对象合成一步
 	格式：
 		new 父类/接口（）{
 		 重写方法
 		}；
 */
public class Innerclass {
	public static void main(String args[]) {
		//线程的父类是Thread
		//new Mythread().start();
		new Thread() {
			//重写run方法
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"-->"+i);
				}
			}
		}.start();

		//线程接口Runnable
		//Runnable ir = new Irunnable();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"-->"+i);
				}
			}
		};
		new Thread(r,"haha1").start();

		//简化接口
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"-->"+i);
				}
			}
		},"haha2").start();

	}
}
