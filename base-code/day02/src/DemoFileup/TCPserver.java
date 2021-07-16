package DemoFileup;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    文件上传案例：
    服务器端实现：读取客户端上传的文件保存到硬盘，给客户端回写上传成功
    明确：
          数据源：客户端上传文件
          目的地：服务器硬盘

    实现步骤：
        1.创建一个ServerSocket对象，和系统要指定的端口号
        2.使用ServerSocket对象中的accept方法，获取socket对象
        3.使用socket对象中的方法getInputStream,获得网络字节输入流对象
        4.判断目的地是否存在，不存在则创建一个
        5.创建一个本地的字节输出流对象，构造方法中绑定目的地
        6.使用网络字节输入流对象的方法read，读取客户端上传的文件
        7.使用本地字节输出流对象的write方法，把读取的文件写入目的地
        8.使用socket对象中的方法getOutputStream,获取网络字节输出流对象
        9.使用网络字节输出流对象的write方法，回写上传成功给客户端
        10.释放资源

 */
public class TCPserver {
    public static void main(String[] args) throws IOException {
        //1.创建一个ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        /*
        次数优化
        使用死循环,可以多次上图片，同时可以使用线程，提高效率
        线程使用注意：
        要使用try catch处理异常，因为run方法中没有抛出异常，重写时也不能抛出异常
         */
        //2.使用ServerSocket对象中的accept方法，获取socket对象
        Socket socket = server.accept();
        //3.使用socket对象中的方法GetInputStream,获得网络字节输入流对象
        InputStream sis = socket.getInputStream();
        //4.判断目的地是否存在，不存在则创建一个
        File f1 = new File("F:\\upload");
        if (!f1.exists()){
            f1.mkdirs();
        }
        //5.创建一个本地的字节输出流对象，构造方法中绑定目的地
//        FileOutputStream fos = new FileOutputStream(f1+"\\1.png");
        //优化命名,只能上传图片，后缀名决定
        String filename = "haha"+System.currentTimeMillis()+new Random().nextInt()+".png";
        FileOutputStream fos = new FileOutputStream(f1+"\\"+filename);

        //6.使用网络字节输入流对象的方法read，读取客户端上传的文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = sis.read(bytes))!=-1){
            //7.使用本地字节输出流对象的write方法，把读取的文件写入目的地
            fos.write(bytes,0,len);
        }
        //8.使用socket对象中的方法getOutputStream,获取网络字节输出流对象
        OutputStream sos = socket.getOutputStream();
        //9.使用网络字节输出流对象的write方法，回写上传成功给客户端
        sos.write("上传成功".getBytes());
        //10.释放资源
        fos.flush();
        fos.close();
        server.close();
        socket.close();
    }
}
