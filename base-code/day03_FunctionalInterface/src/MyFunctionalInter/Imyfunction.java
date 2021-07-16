package MyFunctionalInter;
/*
    函数式接口：抽象方法有且仅有一个

    @FunctionalInterface
        作用：可以检测接口是否只有一个抽象方法
        是：编译成功
        否：编译失败
            1.没有抽象方法  0
            2.抽象方法大于1个  >1
 */
@FunctionalInterface
public interface Imyfunction {
    public abstract void method();
}
