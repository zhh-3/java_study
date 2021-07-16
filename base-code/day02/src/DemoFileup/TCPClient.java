package DemoFileup;

import java.io.*;
import java.net.Socket;

/*
    文件上传客户端:读取本地文件，上传服务器，读取服务器返回值
    明确
        上传数据源  本地文件
        目的地      服务器

    实现步骤：
        1.创建一个本地字节输入流对象，构造方法中绑定数据源
        2.创建一个socket对象，绑定IP地址和端口号
        3.使用socket中的方法getOutputStream，获取网络字节输出流对象
        4.使用本地字节输入流对象读取文件
        5.使用网络字节输出流，上传读取到的文件
        6.使用socket中的getInputStream方法，获取网络字节输入流对象
        7.使用网络字节输入流对象读取回写数据
        8.释放资源
 */
public class TCPClient {
    public static void main(String[] args) throws IOException{
        File f = new File("F:\\downlaod\\1.png");
        //1.创建一个本地字节输入流对象，构造方法中绑定数据源
        FileInputStream fis = new FileInputStream(f);
        //2.创建一个socket对象，绑定IP地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //3.使用socket中的方法getOutputStream，获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //4.使用本地字节输入流对象读取文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!=-1){
            //5.使用网络字节输出流，上传读取到的文件
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        //6.使用socket中的getInputStream方法，获取网络字节输入流对象
        InputStream is = socket.getInputStream();
        //7.使用网络字节输入流对象读取回写数据
        while ((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //8.释放资源
        is.close();
        socket.close();
    }
}
