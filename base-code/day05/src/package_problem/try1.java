package package_problem;

public class try1 {
    public static void main(String[] args) {
        node a = new node(1,2);
        node b = new node();
        node c = new node(3,3);
        b.i = a.i;
        b.j = a.j;
        a.i = 0;
        c = b;
        System.out.println(b.i+" "+b.j);
        System.out.println(a.i+" "+a.j);
        System.out.println(c.i+" "+c.j);
    }
}
class node{
    int i;
    int j;
    public node(){

    }

    public node(int i,int j){
        this.i = i;
        this.j = j;
    }
}
