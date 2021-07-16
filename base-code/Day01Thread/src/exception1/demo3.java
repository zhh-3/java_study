package exception1;

import java.util.List;

/*
 	异常使用注意事项：
 		多个异常使用捕获处理：
 			1.多个异常分别处理
 			2.多个异常一次捕获，多次处理
 			3.多个异常一次捕获，一次处理
 */
public class demo3 {
	public static void main(String args[]) {
		/*
		//1.多个异常分别处理
		try {
			int [] arr = {1,2,3};
			System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e);
		}

		try {
			List<Integer> list = List.of(1,2,3);
			System.out.println(list.get(4));//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e);
		}*/

		/*
			一个try多个catch注意事项：
				如果多个catch中定义的异常有子父类关系，那么子类异常必须写在上面，否则会报错，如下例中，下面的异常不能放在上面。

		 */
		/*
		//2.多个异常一次捕获，多次处理
		try {
			int [] arr = {1,2,3};
			System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
			List<Integer> list = List.of(1,2,3);
			System.out.println(list.get(4));//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		*/

		//3.多个异常一次捕获，一次处理
		try {
			int [] arr = {1,2,3};
//			System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
			List<Integer> list = List.of(1,2,3);
			System.out.println(list.get(4));//java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
