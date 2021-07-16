package HuffmanTree;

import java.io.*;

public class Main {

    public static final int n = 256;
    public static void main(String[] args) throws IOException {
        String filename = "F:\\Pic.bmp";
        String desname = "F:\\pic_huf.zip";
        HelpTool ht = new HelpTool();

        int t1;//源文件大小
        int weight[] = new int[n];//权值
        HTNode [] hufftree = new HTNode[2*n-1];//哈弗曼树
        Code[] huffcode = new Code[n];//哈弗曼编码表

        //获取权值
        FileInputStream fis = new FileInputStream(filename);
        t1 = fis.available();
        int len = 0;
        while((len = fis.read()) != -1){
            weight[len]++;
        }
        fis.close();

        //创造哈弗曼树
        ht.creatHfTree(hufftree,weight);

        //生成哈弗曼编码
        ht.creatHfCode(huffcode,hufftree);

        //生成压缩后的文件
        int t2;//压缩后文件大小
        t2 = ht.Compress(huffcode,filename,desname);

        System.out.printf("压缩率为：%.2f",100.0*t2/t1);
        System.out.print("%");
    }
}

class HTNode {
    //顺序存储
    int weight;//权值
    int flag = 0;
    int Lchild;//左孩子
    int Rchild;//右孩子
    int parent;//父节点

    public HTNode(){
        weight = 0;
        flag = 0;
        Lchild = -1;
        Rchild = -1;
        parent = -1;
    }
}

class Code{
    String bits = new String();
    int i;
    int weight;

    public Code(int i,int weight,String bits){
        this.i = i;
        this.weight = weight;
        this.bits = bits;
    }
}
