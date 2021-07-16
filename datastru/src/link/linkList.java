package link;

public class linkList<T> {
    //头指针
    private Node<T> head;
    //单链表长度
    private int length;

    //构造一个空链表
    public linkList(){
        length = 0;
        head = new Node<T>(null);
    }

    //获取链表头指针节点
    public Node<T> getHead(){
        return head;
    }

    //在链表中插入一个新元素
    public boolean add(T obj,int pos){
        if (pos < 1||pos >length+1){
            System.out.println("pos位置错误，下标越界");
            return false;
        }else {
            int i=1;
            Node<T> p = head;
            for (; i < pos; i++) {
                p = p.next;
            }
            Node<T> q = new Node(obj,p.next);
            p.next = q;
            length++;
            return true;
        }

    }

    //删除链表中某个元素
    public T remove(int pos){
        if (isEmpty()){
            System.out.println("链表为空");
            return null;
        }else {
            if (pos < 1||pos > length){
                System.out.println("pos值不合法");
                return null;
            }
            int i = 1;
            Node<T> p = head,q = p.next;
            for (;i < pos;i++){
                p = q;
                q = q.next;
            }
            p.next = q.next;
            length--;
            return q.data;
        }
    }

    //获取链表中一个元素
    public T value(int pos){
        if (isEmpty()){
            System.out.println("链表为空");
            return null;
        }else {
            if (pos < 1||pos > length){
                System.out.println("pos值错误");
                return null;
            }
            Node<T> p = head.next;
            int num = 1;
            while (num < pos){
                p = p.next;
                num++;
            }
            return p.data;
        }
    }

    //在链表中查找一个元素
    public int find(T obj){
        if (isEmpty()){
            System.out.println("表为空，无法查找");
            return -1;
        }else {
            Node<T> p = head.next;
            for (int i = 0; i < length; i++) {
                if (p.data.equals(obj)){
                    return i+1;
                }
                p = p.next;
            }
            return -1;
        }
    }

    //更新链表中某个元素
    public boolean modify(T obj,int pos){

        if (isEmpty()){
            System.out.println("链表为空");
            return false;
        }else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return false;
            }
            Node<T> p = head.next;
            int num = 1;
            while (num < pos){
                p = p.next;
                num++;
            }
            p.data = obj;
            return true;
        }
    }

    //判空
    public boolean isEmpty(){
        return length==0;
    }

    //求链表中元素个数
    public int size(){
        return length;
    }

    //依次访问链表中每个元素并输出
    public void next_order(){
        Node<T> p = head.next;
        while (p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    //销毁一个已存在的链表
    public void clear(){
        length = 0;
        head.next = null;
    }
}
