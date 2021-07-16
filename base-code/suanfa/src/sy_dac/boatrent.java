package sy_dac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class boatrent {
	
	static File f1 = new File("E:\\eclipse-workspace\\suanfa\\src\\input.txt");
	static File f2 = new File("E:\\eclipse-workspace\\suanfa\\src\\output.txt");
	
	public static void main(String args[]) throws IOException{
		FileInputStream fis = new FileInputStream(f1);
		FileWriter fw = new FileWriter(f2);
		int n;//站点数
		n = getnum(fis);
		
		//站点之间到达费用
		int [][] rent = new int [n-1][n];
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				rent[i][j] = getnum(fis);
			}
		}
		
		if (n >= 2) {
			//计算最小费用
			Integer money = minmoney(rent,n);
			fw.write(money.toString());
		}else {
			System.out.println("站点数错误");
		}
		
		//关闭流
		fw.close();
		fis.close();
	}
	
	//计算最小费用
	private static int minmoney(int [][]rent,int n) {
		//min用来存储第i+1个站点到最后一个站点的最少钱
		int min[] = new int [n-1];
		min[n-2] = rent[n-2][n-1];
		
		for (int i = n-3; i >= 0; i--) {
			int money = rent[i][n-1];//存储当前最少钱数
			for (int j = i+1; j < n-1; j++) {
				money = Math.min(rent[i][j]+min[j], money);
			}
			min[i] = money;//将最少钱数存入数组
		}
		return min[0];
	}
	
	//获取多位数，如15,
	private static int getnum(FileInputStream fis) throws IOException{
		int s = 0;
		int len = 0;
		while ((len = fis.read()) != (int)' ' &&len != (int)'\n' && len != -1) {
			if (len <= '9'&&len >= '0') {
				s = 10*s +len-'0';
			}
		}
		return s;
	}
}
