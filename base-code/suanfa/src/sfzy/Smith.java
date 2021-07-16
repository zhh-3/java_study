package sfzy;

public class Smith {
	
	public static boolean judge(int t) {
		int s1,s2;	//s1��ʾ��������,s2��ʾ����λ���ĺ�
		boolean flag;
		//�����������ĺ�S1
		s1 = zsh(t);
		
		//����λ����S2
		s2 = wsh(t);
		
		if (s1 == s2) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	//����������λ����
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
	
	//����λ����
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
