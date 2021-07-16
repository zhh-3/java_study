package internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
    TCP通信的客户端：向服务器发送连接请求，读取服务器回写的数据
    表示客户端的类：Socket

    构造方法：
        Socket(String host, int port) 创建一个流套接字并将其连接到指定主机上的指定端口号。
        参数：
            host：ip地址
            port：服务器端口号
        成员方法：
            void close() 关闭此套接字。
            OutputStream getOutputStream() 返回此套接字的输出流。
            InputStream getInputStream() 返回此套接字的输入流。

        使用步骤：
            1.创建客户端对象Socket，构造方法绑定服务器IP地址和端口号
            2.使用客户端对象Socket的getOutputStream()方法获取网络字节输出流对象
            3.使用网络字节输出流对象的write方法，给服务器发送数据
            4.使用客户端对象Socket的getInputStream()方法获取网络字节输入流对象
            5.使用网络字节输入流对象的read方法，读取服务器回写数据
            6.释放资源（socket）
        注意事项：
            1.客户端和服务器端交互必须使用socket中提供的网络字节流，不能使用自己创建的流
            2.当我们创建客户端socket对象时，就会去服务器和服务器经过3次握手，建立连接通路
                这是如果服务器没有启动，就会抛出异常
                如果服务器已启动，那么就可以进行交互
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //1.创建客户端对象Socket，构造方法绑定服务器IP地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //2.使用客户端对象Socket的getOutputStream()方法获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //4.使用客户端对象Socket的getInputStream()方法获取网络字节输入流对象
        InputStream is = socket.getInputStream();

        String string2 = "start";
        while (!string2.equals("end")){
            String string1 = scanner.next();
            //3.使用网络字节输出流对象的write方法，给服务器发送数据
            os.write(string1.getBytes());

            //5.使用网络字节输入流对象的read方法，读取服务器回写数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            string2 = new String(bytes,0,len);
            System.out.println(string2);
        }

        //6.释放资源（socket）
        socket.close();
    }
}
