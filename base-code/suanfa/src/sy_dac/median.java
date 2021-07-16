package sy_dac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class median {
	
	public static void main(String args[]) throws IOException {
	File f1 = new File("E:\\eclipse-workspace\\suanfa\\src\\sy_dac\\input.txt");
	File f2 = new File("E:\\eclipse-workspace\\suanfa\\src\\sy_dac\\output.txt");
	FileInputStream fis = new FileInputStream(f1);
	FileWriter fw = new FileWriter(f2);
	
	int n;
	n = fis.read()-'0';
	int a[] = new int [2*n];
	
	for (int i = 0; i < 2*n; i++) {
		a[i] = getnum(fis);
	}

	Double middle;
	middle = getmedian(a, 0, a.length/2-1, a.length/2, a.length-1);
	
	fw.write(middle.toString());
	
	fis.close();
	fw.close();
	}
	
	private static double getmedian(int a[],int left1,int right1,int left2,int right2) {
		double middle = 0;
		if (a[left1] >= a[right2]) {
			return (a[left1] + a[right2])/2.0;
		}
		if (a[right1] <= a[left2]) {
			return (a[right1] + a[left2])/2.0;
		}
		
		//当每组中只剩下两个时，会不断循环
		if ((right1-left1) > 1) {
			double middle1 = getmedian(a, left1,(left1+right1)/2,(int)((left1+right1)/2+0.5), right1);
			double middle2 = getmedian(a, left2,(left2+right2)/2,(int)((left2+right2)/2+0.5), right2);
			
			if (middle1 == middle2) {
				return middle1;
			}
			else if (middle1 > middle2) {
				return getmedian(a, left1, (int)((left1+right1)/2+0.5), (left2+right2)/2, right2);
			}
			else if (middle1 < middle2) {
				return getmedian(a,(left1+right1)/2,right1,left2,(int)((left2+right2)/2.0+0.5));
			}
		}
		else {
			if (a[left1] >= a[left2] ) {
				if (a[right1] >= a[right2]) {
					return (a[left1] + a[right2])/2.0;
				}
				else {
					return (a[left1] + a[right1])/2.0;
				}
			} else {
				if (a[right1] >= a[right2]) {
					return (a[left2] + a[right2])/2.0;
				} else {
					return (a[left2] + a[right1])/2.0;
				}
			}
		}
		return middle;
	}
	
	//获取多位数，如15,同时数字后面接一个空格隔开
	public static int getnum(FileInputStream fis) throws IOException{
		int s = 0;
		int len = 0;
		while ((len = fis.read()) != 32 && len != -1) {
			if (len <= '9'&&len >= '0') {
				s = 10*s +len-'0';
			}
		}
		return s;
	}
}
