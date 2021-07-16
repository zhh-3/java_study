package internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
TCP服务器端；接受客户端请求，读取客户端发送数据，给客户端回写数据
构造方法：
    ServerSocket(int port) 创建绑定到特定端口的服务器套接字。

服务器端必须明确一件事，必须的知道是哪个客户端请求的服务器
所以可以使用accept方法获取到客户端请求的对象Socket

成员方法
    Socket accept() 侦听并接受到此套接字的连接。

实现步骤：
    1.创建ServerSocket对象和系统指定的端口号
    2.使用ServerSocket中方法accept方法获得客户端对象socket
    3.使用客户端对象Socket的getInputStream()方法获取网络字节输入流对象
    4.使用网络字节输入流对象的read方法，读取客户端发送数据
    5.使用客户端对象Socket的getOutputStream()方法获取网络字节输出流对象
    6.使用网络字节输出流对象的write方法，给客户端发送数据
    7.释放资源（socket，ServerSocket）

 */
public class TCPserver {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //1.创建ServerSocket对象和系统指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //2.使用ServerSocket中方法accept方法获得客户端对象socket
        Socket socket = server.accept();
        //3.使用客户端对象Socket的getInputStream()方法获取网络字节输入流对象
        InputStream is = socket.getInputStream();
        //5.使用客户端对象Socket的getOutputStream()方法获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();

        String string1 = "start";
        while (!string1.equals("end")){
            //4.使用网络字节输入流对象的read方法，读取客户端发送数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            String string2 = new String(bytes,0,len);
            System.out.println(string2);

            string1 = scanner.next();
            os.write(string1.getBytes());
        }

        //7.释放资源（socket，ServerSocket）
        socket.close();
        server.close();
    }
}
