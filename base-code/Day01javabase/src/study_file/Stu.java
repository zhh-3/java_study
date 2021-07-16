package study_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stu {

    public static void main(String[] args) throws IOException{
    
    	//请在下面的Begin-End之间编写正确的代码
		/********** Begin **********/
        int start = 0,end = 0;
        int id = 0,k = 1,flag = 0;
        BufferedReader br = new BufferedReader(new FileReader("/data/workspace/myshixun/step2/test1.c"));
        String line;

        while ((line = br.readLine()) != null){
            id++;
            if (line.startsWith("#if defined")){
                start = id+1;
                flag = 1;
            }else if (line.startsWith("#ifdef")){
                start = id+1;
                flag = 1;
            }else if (line.startsWith("#else")){
                start = id+1;
                flag = 1;
            }
            if (line.equals("#endif")&&flag == 1){
                end = id-1;
                if(k == 1){
                    System.out.print("起始行为"+start+"，结束行为"+end+"。");
                }else{
                    System.out.print("\n起始行为"+start+"，结束行为"+end+"。");
                }
                k++;
                flag = 2;
            }
        }
        br.close();

        if(start == 0){
            System.out.println("NULL");
        }
		/********** End **********/
    }

}



