package Threadstudy;
/*
	创建线程的第二种方法：实现Runnable接口
	public interface RunnableRunnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参数方法。

	实现步骤：
		1.创建Runnable接口实现类
		2.在实现类中重写无参run方法
		3.创建一个runnable接口实现类的对象
		4.创建一个Thread类对象，构造方法中传递Runnable接口实现类对象
		5.调用Thread对象中的start方法，
	使用Runnable的好处
		1.避免单继承的局限性，
			一个类只能继承一个类，继承了Thread类，就不能继承其他类
			实现Runnable接口还可以继承其他类，实现其他接口
		2.增强了程序的扩展性，降低了程序的耦合性
			实现Runnable接口的方式，吧设置线程任务和开启线程任务进行了分离
			实现类中，重写Run方法：用来设置线程任务
			创建Thread对象，调用start方法：用来开启新的线程
 */
public class demo2 {
	public static void main(String args[]) {
		//3.创建一个runable接口实现类的对象
		Irunable ia = new Irunable();
		//4.创建一个Thread类对象，构造方法中传递Runable接口实现类对象
		Thread t1 = new Thread(ia,"haha");
		t1.start();

		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}
