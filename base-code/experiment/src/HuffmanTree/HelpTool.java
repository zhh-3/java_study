package HuffmanTree;

import java.io.*;
import java.util.HashMap;

public class HelpTool {
    static final int n = 256;

    //生成哈弗曼树
    public static void creatHfTree(HTNode hufftree[],int weight[]){
        //初始化节点
        for (int i = 0;i < 2*n-1;i++){
            hufftree[i] = new HTNode();
            //前256个节点为原始节点
            if (i < n){
                hufftree[i].weight = weight[i];
            }
        }

        int x1,x2,min1,min2;//min1,min2分别是最小的和次小的权值，x1,x2分别对应其下标
        //生成哈弗曼树
        for (int i = 0;i < n-1;i++){
            min1 = min2 = 10000000;
            x1 = x2 = 0;
            //寻找最小和次小的权值
            for (int j = 0;j < n+i;j++){
                if (hufftree[j].flag == 0&&hufftree[j].weight < min1){
                    x2 = x1;
                    min2 = min1;
                    x1 = j;
                    min1 = hufftree[j].weight;
                }else if (hufftree[j].flag == 0&&hufftree[j].weight < min2){
                    x2 = j;
                    min2 = hufftree[j].weight;
                }
            }
            //生成新的节点
            hufftree[n+i].weight = hufftree[x1].weight + hufftree[x2].weight;
            hufftree[n+i].Lchild = x1;
            hufftree[n+i].Rchild = x2;
            hufftree[x1].parent = i+n;
            hufftree[x2].parent = i+n;
            hufftree[x1].flag = 1;
            hufftree[x2].flag = 1;
        }
    }

    //生成哈弗曼编码
    public static void creatHfCode(Code huffcode[],HTNode hufftree[]) {
        int child,parent,weight,start;

        for (int i = 0;i < n;i++){
            int bits[] = new int[256];
            start = n-1;
            child = i;
            parent = hufftree[child].parent;
            weight = hufftree[i].weight;
            while (parent != -1){
                if (hufftree[parent].Lchild == child){
                    bits[start] = 0;
                }else {
                    bits[start] = 1;
                }
                start--;
                child = parent;
                parent = hufftree[child].parent;
            }
            StringBuffer str = new StringBuffer();
            for (int j = start+1; j < 256; j++) {
                str.append(bits[j]);
            }
            huffcode[i] = new Code(i,weight,str.toString());
        }
    }

    //压缩文件
    public static int Compress(Code[] huffcode, String filename, String desname) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        FileOutputStream fos = new FileOutputStream(desname);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        int k = 0;
        //记录编译后的数据
        StringBuffer str1 = new StringBuffer();
        while ((k = fis.read()) != -1){
            str1.append(huffcode[k].bits);
        }

        int len = str1.length()%8==0?str1.length()/8:str1.length()/8+1;//确定新的数组（文件）长度，每八位合并成一个字节存储
        int flag = str1.length() - str1.length()%8;//记录不满8位的位置
        int[] bytes1 = new int[len+1];//记录压缩后的数据
        int index = 0;//下标

        for (int i = 0; i < str1.length(); i+=8) {
            String str ;
            if (i+8 < flag){
                str = str1.substring(i,i+8);
            }else {
                str = str1.substring(i);
            }
            int b = Integer.parseInt(str,2);
            bytes1[index++] = b;
        }
        bytes1[len] = (str1.length()%8);

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();//存储权值
        //将权值存入集合
        for (int i = 0; i < n; i++) {
            map.put(i,huffcode[i].weight);
        }

        //以对象的形式写入文件
        oos.writeObject(map);
        oos.writeObject(bytes1);
        //关闭流
        fos.close();
        oos.close();
        System.out.println("压缩成功");
        return len;//返回压缩后文件大小
    }

    //解压
    public static void decode(String filename,String des) throws IOException, ClassNotFoundException {
        HTNode[] huffTree = new HTNode[2*n-1];//哈弗曼树
        int [] weight = new int[n];//权值
        int[] bytes ;

        //打开流
        FileOutputStream fos = new FileOutputStream(des);
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);

        HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) ois.readObject();
        for (int i = 0;i < n;i++){
            weight[i] = map.get(i);
        }
        creatHfTree(huffTree,weight);

        //读取压缩文件
        bytes = (int[]) ois.readObject();

        StringBuffer str = new StringBuffer();
        StringBuffer str1 = new StringBuffer();
        str1.append("00000000");
        for (int i = 0;i < bytes.length-1;i++){
            int k;
            if (i != bytes.length-2){
                k = 8;
            }else {
                k = bytes[bytes.length-1];
            }
            String s = null;
            s = Integer.toBinaryString(bytes[i]);
            int start = k - s.length();
            str.append(str1.substring(0,start));
            str.append(s);
        }

        int root = 0;
        //寻找根节点
        for (int i = 0;i < 2*n-1;i++){
            if (huffTree[i].parent == -1){
                root = i;
                break;
            }
        }
        int k = root;
        char[] bytes2 = str.toString().toCharArray();
        for (int i = 0;i < bytes2.length;i++){
            //如果是叶子节点
            if (huffTree[k].Lchild == -1){
                //写入文件
                fos.write(k);
                k = root;
            }
            //如果不是叶子节点
            if (bytes2[i] == '0'){
                k = huffTree[k].Lchild;
            }else {
                k = huffTree[k].Rchild;
            }
        }
        //关闭流
        ois.close();
        fis.close();
        System.out.println("解压成功");
    }
}
