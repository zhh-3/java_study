package javastudy1;

import java.io.*;

public class filecopy {
	public static void main(String args[]) {
		try {
			File t1 = new File("E:\\wenjian\\","text1.txt");   
			File t2 = new File("E:\\wenjian\\","text2.txt");
			FileOutputStream fos1 = new FileOutputStream(t1);//����FileOutputStream����
			int b;
			while ((char)(b = System.in.read() ) !='\n') {
				fos1.write(b);//д�������
			}
			fos1.close();//�ر���
			FileInputStream fis = new FileInputStream(t1);//��ȡtext1�е��ļ�
			FileOutputStream fos2 = new FileOutputStream(t2);//���ļ�д��text2��
			int c;
			while ((c = fis.read()) != -1) {
				fos2.write(c);
			}
			fis.close();
			fos2.close();
			String s = t2.getPath();
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("FileStreamsTest:"+e);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
	}
}
