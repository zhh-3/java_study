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
		int n;//վ����
		n = getnum(fis);
		
		//վ��֮�䵽�����
		int [][] rent = new int [n-1][n];
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				rent[i][j] = getnum(fis);
			}
		}
		
		if (n >= 2) {
			//������С����
			Integer money = minmoney(rent,n);
			fw.write(money.toString());
		}else {
			System.out.println("վ��������");
		}
		
		//�ر���
		fw.close();
		fis.close();
	}
	
	//������С����
	private static int minmoney(int [][]rent,int n) {
		//min�����洢��i+1��վ�㵽���һ��վ�������Ǯ
		int min[] = new int [n-1];
		min[n-2] = rent[n-2][n-1];
		
		for (int i = n-3; i >= 0; i--) {
			int money = rent[i][n-1];//�洢��ǰ����Ǯ��
			for (int j = i+1; j < n-1; j++) {
				money = Math.min(rent[i][j]+min[j], money);
			}
			min[i] = money;//������Ǯ����������
		}
		return min[0];
	}
	
	//��ȡ��λ������15,
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
