package study_file;

import java.io.*;

public class count_line_number {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        File src = new File("F:\\IDEA\\IdeaProjects");
        System.out.println(get_java_file_count(src));
    }

    public static int get_java_file_count(File file) throws IOException {
        if (file != null){
            File [] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()){
                    get_java_file_count(f);
                }else {
                    if (f.getName().endsWith("java") || f.getName().endsWith("html")){
                        count+=getCount_number_line(f);
                    }
                }
            }
            return count;
        }
        else return 0;
    }

    public static int getCount_number_line(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        LineNumberReader line = new LineNumberReader(fileReader);
        line.skip(Long.MAX_VALUE);
        int c = line.getLineNumber() + 1;
        return c;
    }
}
