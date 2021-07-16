package link;

public class sequenceList<T> {
    //顺序表中一维数组的初始长度
    final int maxSize = 10;
    //存储元素的数组对象
    private T[] listArray;
    //保存顺序表的当前长度
    private int length;

    //构造一个空的线性表
    public sequenceList(){
        length = 0;
        //泛型无法实例化，先实例化一个Object数组，在转化成一个泛型数组
        listArray = (T[]) new Object[maxSize];
    }
    public sequenceList(int n){
        if (n <= 0){
            System.out.println("error");
            System.exit(1);
        }
        length = 0;
        listArray = (T[]) new Object[maxSize];
    }

    //在线性表插入一个新的元素在第pos个元素，既下标为pos-1
    public boolean add(T obj,int pos){
        //pos有范围限制
        if (pos<1||pos>length+1){
            System.out.println("error");
            return false;
        }
        //数组已满时
        if (length == listArray.length){
            T[] p = (T[]) new Object[length*2];
            for (int i = 0; i < length; i++) {
                p[i] = listArray[i];
            }
            listArray = p;
        }
        for (int i = length; i >= pos; i--) {
            listArray[i] = listArray[i-1];
        }
        listArray[pos-1] = obj;
        length++;
        return true;
    }

    //顺序表后面添加元素
    public void insert(T obj){
        //数组已满时
        if (length == listArray.length){
            T[] p = (T[]) new Object[length*2];
            for (int i = 0; i < length; i++) {
                p[i] = listArray[i];
            }
            listArray = p;
        }
        listArray[length] = obj;
        length++;
    }

    //删除线性表中某个元素
    public T remove(int pos){
        T x = listArray[pos-1];
        if (isEmpty()){
            System.out.println("表为空，无法删除");
            return null;
        }
        if (pos < 1||pos >length){
            System.out.println("pos值错误");
            return null;
        }
        for (int i = pos-1; i < length; i++) {
            listArray[i] = listArray[i+1];
        }
        length--;
        return x;
    }

    //在现性中查找某个元素的位置
    public int find(T obj){
        if (isEmpty()){
            return -1;
        }else {
            for (int i = 0; i < length; i++) {
                if (listArray[i].equals(obj)){
                    return i+1;
                }
            }
            return -1;
        }
    }

    //获取线性表中某个位置的值
    public T value(int pos ){
        if (isEmpty()){
            System.out.println("表为空，无法查询");
            return null;
        }else {
            if (pos < 1||pos > length){
                System.out.println("pos错误，下标越界");
                return null;
            }else {
                return listArray[pos-1];
            }
        }
    }

    //更新线性表中某个元素
    public boolean modify(T obj,int pos){
        if (isEmpty()){
            System.out.println("表为空，无法查询");
            return false;
        }else {
            if (pos < 1||pos > length){
                System.out.println("pos错误，下标越界");
                return false;
            }else {
                listArray[pos-1] = obj;
                return true;
            }
        }
    }

    //判断是否为空
    public boolean isEmpty(){
        return length==0;
    }

    //求线性表中元素个数
    public int size(){
        return length;
    }

    //依次访问栈中每个元素并输出
    public void nextOrder(){
        if (isEmpty()){
            System.exit(1);
        }
        for (int i = 0; i < length; i++) {
            System.out.print(listArray[i]+" ");
        }
        System.out.println();
    }

    //销毁一个已存在的线性表
    public void clear(){
        length = 0;
    }
}
