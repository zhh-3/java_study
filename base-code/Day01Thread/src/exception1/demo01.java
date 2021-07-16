package exception1;

import java.util.Objects;

/*
 *throw使用：
 * throw new xxxxException("异常原因");
 * 注意事项：
 * 	1.throw必须写在方法内部
 * 	2.new 后面必须是Exception或其子类对象
 * 	3.throw关键字抛出的是指定的异常对象，我们就必须处理这个异常对象
 * 			如果是RuntimeException,可以不处理，交给JVM机处理
 */
public class demo01 {
	public static void main(String args[]){
		int arr[] = {1,2,3};
		int e = getElement(arr, 2);
		System.out.println(e);
		method(null);
	}
	
	public static int getElement(int arr[],int index) {
		/*
		 * 检验传入数据的合法性
		 */
		//空数组检验
		if (arr == null) {
			//使用throw关键字
			throw new NullPointerException("空指针");
		}
		//下标越界检验
		if (index < 0 || index > arr.length-1) {
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		int x = arr[index];
		return x;
	}

	//判断空指针异常
	public static void method(Object obj) {
//		Objects.requireNonNull(obj);
		Objects.requireNonNull(obj, "what");
	}
}
