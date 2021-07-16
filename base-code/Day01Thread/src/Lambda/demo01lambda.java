package Lambda;

public class demo01lambda {
	public static void main(String args[]) {
		//使用匿名内部类
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"已启动");
			}
		}).start();
		
		//使用lambda表达式
		new Thread(()-> {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"已启动");
			}
		).start();
	}
}