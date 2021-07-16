package exception1;

import java.util.Scanner;

/*
 	要求：模拟注册操作，如果用户名已存在，则抛出异常并告知用户”用户名已存在“

 	分析：
 	 	1.使用数组保存已经注册过的用户名
 	 	2.使用Scanner获取输入注册用户名
 	 	3.定义一个方法，对用户输入中注册的用户名做一个判断
 	 		遍历用户名数组，获取每一个用户名
 	 		使用获取的用户名一一和输入用户名比较
 	 			true 用户名已存在，抛出异常，并告知用户
 	 			false  继续遍历比较
 	 	循环结束还未找到相同用户名，告知用户注册成功
 */
public class demo4register {
	static String [] names = {"zhh","haha","zhaha","zhang","hanhan"};

	public static void main(String args[]) throws RegisterException {
		Scanner scanner = new Scanner(System.in);
		String name;
		name = scanner.next();
		boolean flag = check(name);

		if (flag) {
			System.out.println("注册成功");
		}
	}

	public static boolean check(String name) throws RegisterException{
		boolean flag = true;
		for (String username : names) {
			if (name.equals(username)) {
				flag = false;
				throw new RegisterException("用户名已存在");
			}
		}
		return flag;
	}
}
