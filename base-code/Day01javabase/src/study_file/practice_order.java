package study_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 * ��ϰ�����ı������������
 * ʹ��map����
 * ������
 * 1.ʹ��hashmap���ϣ��洢ÿ�е��ı����кţ�1,2,3����value�洢û���ı�
 * 2.�����ַ��������������󣬹��췽���а��ַ�������
 * 3.�����ַ�������������󣬹��췽���а��ַ������
 * 4.ʹ���ַ������������еķ���readline,���ж�ȡ�ı�
 * 5.�Զ�ȡ���ı������и��ȡ���е����кź��ı�����
 * 6.���и�õ����кź��ı����ݴ洢��HashMap�����У�key����ţ����Զ�������
 * 7.����HsahMap ,��ȡÿһ����ֵ��
 * 8.��ÿһ����ֵ��ƴ��Ϊһ���ı���
 * 9.��ƴ�Ӻõ��ı���ʹ���ַ�����������еķ���Writeд�뵽�ļ���
 * 10.�ͷ���Դ
 */
public class practice_order {
	public static void main(String args[]) throws IOException {
//		1.ʹ��hashmap���ϣ��洢ÿ�е��ı����кţ�1,2,3����value�洢û���ı�
		HashMap<String, String > hashMap = new HashMap<String, String>();
//		2.�����ַ��������������󣬹��췽���а��ַ�������
		BufferedReader br = new BufferedReader(new FileReader("E:\\eclipse-workspace\\javastudy\\src\\in.txt"));
//		3.�����ַ�������������󣬹��췽���а��ַ������
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\eclipse-workspace\\javastudy\\src\\out.txt"));
//		4.ʹ���ַ������������еķ���readline,���ж�ȡ�ı�
		String line;
		while ((line = br.readLine()) != null) {
			//5.�Զ�ȡ���ı������и��ȡ���е����кź��ı�����
			String [] arr = line.split("\\.");//�� . Ϊ�ָ�������ı��ָ�Ϊ������
			//6.���и�õ����кź��ı����ݴ洢��HashMap�����У�key����ţ����Զ�������
			hashMap.put(arr[0], arr[1]);
		}
		
//		7.����HsahMap ,��ȡÿһ����ֵ��
		for (String key : hashMap.keySet()) {
			String value = hashMap.get(key);
			//8.��ÿһ����ֵ��ƴ��Ϊһ���ı���
			line = key + "." + value;
			//9.��ƴ�Ӻõ��ı���ʹ���ַ�����������еķ���Writeд�뵽�ļ���
			bw.write(line);
			//��ȡʱ�����ȡ�����з����Լ�����
			bw.newLine();
		}
//		10.�ͷ���Դ
		bw.close();
		br.close();
		
		
	}
}
