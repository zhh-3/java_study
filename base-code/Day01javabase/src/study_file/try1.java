package study_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class try1 {
    public static void main(String[] args) throws IOException {
        int id = 0;
        int start,end;
        BufferedReader br = new BufferedReader(new FileReader("/data/workspace/myshixun/step1/test1.c"));
        String line;
        while ((line = br.readLine()) != null){
            id++;
            if (line.equals("#if defined(__x86_64__)")){
                start = id+1;
            }else if (line.equals("#ifdef __x86_64__")){
                start = id+1;
            }else if (line.equals("#else")){
                start = id+1;
            }
            if (line.equals("#endif")){
                end = id-1;
            }
        }
        br.close();
    }
}
