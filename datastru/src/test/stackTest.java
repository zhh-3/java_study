package test;

import stack.sequenceStack;
public class stackTest {
    public static void main(String[] args) {
        sequenceStack<Integer> st = new sequenceStack<Integer>();
        int []a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            st.push(a[i]);
        }
        System.out.println("栈中元素为：");
        st.next_order();
        System.out.println("出栈元素："+st.pop());
        System.out.println("此时栈顶："+st.getHead());
        System.out.println("栈中元素为：");
        st.next_order();
    }
}
