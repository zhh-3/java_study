package Demo02Lambda;
/*
    日志案例
    
    存在一些性能浪费问题
    调用showLog方法，传递的第二个参数是个拼接字符串
    拼接在调用方法之前执行
    但是如果传递的日志等级不是1级，则拼接无用，浪费了性能
 */
public class Demo01Logger {
    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(1,msg1+" "+msg2+","+msg3);
        showLog(2,msg1+" "+msg2+","+msg3);
    }

    //lever代表日志等级，1可以输出，message代表日志信息
    public static void showLog(int lever,String message) {
        if (lever == 1){
            System.out.println(message);
        }
    }
}
