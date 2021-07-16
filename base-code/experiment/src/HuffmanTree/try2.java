package HuffmanTree;

import java.io.*;

public class try2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int a[] = {1,2,3};
        FileOutputStream fos = new FileOutputStream("F:\\T1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("F:\\T1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        int b[] = (int[]) ois.readObject();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        ois.close();
        fis.close();
    }
}
