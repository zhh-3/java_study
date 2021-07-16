package Demo02Lambda;

public class Demo02Lambda {
    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(1,() -> {
            System.out.println("满足条件，执行lambda中代码");
            return msg1+" "+msg2+","+msg3;
        });
        showLog(2,() -> {
            System.out.println("不满足条件，不执行");
            return msg1+" "+msg2+","+msg3;
        });
    }

    /*
        使用lambda作为参数传入时，不会拼接字符串
        只有当等级为1时，才会调用buildmessage方法拼接字符串
        如果条件不满足，则不会执行字符串拼接
        则不会存在性能浪费
     */
    public static void showLog(int lever,ImessageBuild mb) {
        if (lever == 1){
            System.out.println(mb.buildmessage());
        }
    }
}
