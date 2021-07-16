package Demo03Lambda;
/*
    lambda作为参数传入
 */
public class demo01runnable {
    public static void main(String[] args) {
        //使用匿名内部类
        startthread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->已开启");
            }
        });
        //使用Lambda表达式
        startthread(() -> System.out.println(Thread.currentThread().getName()+"-->已开启"));
    }

    public static void startthread(Runnable run) {
        new Thread(run).start();
    }
}
