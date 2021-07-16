package stack;

public class sequenceStack<T> {
    final int maxsize = 10;
    private T[] stackArray;
    private int top;

    public sequenceStack(){
        top = -1;
        //强转
        stackArray = (T[]) new Object[maxsize];
    }

    public sequenceStack(int n){
        if (n <= 0){
            System.out.println("数组长度要大于0");
            System.exit(1);
        }
        top = -1;
        stackArray = (T[]) new Object[maxsize];
    }

    //入栈
    public void push(T obj){
        top++;
        if (top == stackArray.length){
            T[] p = (T[]) new Object[top*2+2];
            for (int i = 0; i < top; i++) {
                p[i] = stackArray[i];
            }
            stackArray = p;
        }
        stackArray[top] = obj;
    }

    //出栈
    public T pop(){
        if (isEmpty()){
            System.out.println("栈为空，无可删除元素");
            return null;
        }else {
            top--;
            return stackArray[top+1];
        }

    }

    //取栈顶元素
    public T getHead(){
        if (isEmpty()){
            System.out.println("栈为空，无可删除元素");
            return null;
        }else {
            return stackArray[top];
        }
    }

    //为空判断
    public boolean isEmpty(){
        return top==-1;
    }

    //栈的大小
    public int size(){
        return top+1;
    }

    //依次访问栈中元素，并输出
    public void next_order(){
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i]+" ");
        }
        System.out.println();
    }

    //销毁一个栈
    public void clear(){
        top = -1;
    }
}
