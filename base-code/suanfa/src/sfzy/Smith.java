package sfzy;

public class Smith {
	
	public static boolean judge(int t) {
		int s1,s2;	//s1表示质因数和,s2表示各个位数的和
		boolean flag;
		//计算质因数的和S1
		s1 = zsh(t);
		
		//计算位数和S2
		s2 = wsh(t);
		
		if (s1 == s2) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	//求质因数的位数和
	public static int zsh(int t) {
		int s = 0;
		int n = t,i = 2;
		while (i <= n) {
			if (n%i == 0) {
				s += wsh(i);
				n = n / i;
				i = 2;
			}
			else {
				i++;
			}
		}
		return s;
	}
	
	//计算位数和
	public static int wsh(int t) {
		int n = t;
		int s = 0;
		while (n > 0) {
			s += n % 10;
			n = n / 10;
		}
		return s;
	}
}
