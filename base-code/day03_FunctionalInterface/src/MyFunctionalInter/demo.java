package MyFunctionalInter;
/*
    函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class demo{
    public static void main(String[] args) {
        //使用匿名内部类
        show(new Imyfunction() {
            @Override
            public void method() {
                System.out.println("匿名内部类重写接口中的method抽象方法");
            }
        });

        //使用lambda
        show(() -> System.out.println("使用lambda表达式重写接口中的抽象方法")
        );
    }

    public  static void show(Imyfunction myInter){
        myInter.method();
    }
}
