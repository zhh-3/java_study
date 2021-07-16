package javastudy1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
	public static void main(String args[]) {
		Date date = new Date();
		System.out.println(date);
		
		String s = date.toString();
		System.out.println(s);
		
		String	s1= DateFormat.getInstance().format(date);
		System.out.println(s1);
		
		SimpleDateFormat time = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ HH:mm:ss");
		System.out.println(time.format(date));
//		long t = date.getTime();
//		System.out.println(t);
		
	}
   
}
