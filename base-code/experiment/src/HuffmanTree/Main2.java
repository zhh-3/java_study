package HuffmanTree;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "F:\\pic_huf.zip";
        String des = "F:\\pic2.bmp";
        HelpTool ht = new HelpTool();
        ht.decode(filename,des);
    }
}
