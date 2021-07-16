package exception1;
/*
	 自定义异常类：
	 	java提供的异常不够我们使用，需要我们自己定义一些异常类
	 格式：
	 	public class xxxException extends Exception | RuntimeException{
	 	添加一个空参数的构造方法
	 	添加一个包含异常信息的构造方法
	 	}
	 注意：
	 	1.自定义异常类一般以Exception 结尾，说明该类是一个异常类
	 	2.自定义异常类必须继承Exception或者RuntimeException
	 		继承Exception  自定义异常类就是一个编译期异常，如果方法内部抛出了编译期异常，就必须处理这个异常，要么throws,要么try catch
	 		继承RuntimeException  自定义异常就是一个运行期异常，无需处理，交给虚拟机处理，中断异常
 */
public class RegisterException extends Exception{
	public RegisterException() {
		super();
	}

	public RegisterException(String message) {
		super(message);
	}
}
