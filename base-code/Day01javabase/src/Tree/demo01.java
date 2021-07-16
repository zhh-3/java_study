package Tree;

public class demo01 {
    public static void main(String[] args) {
        Notetree tree1 = new Notetree(1);
        tree1.left = new Notetree(2);
        tree1.right = new Notetree(3);
        System.out.println("先序遍历");
        preorder(tree1);
        System.out.println();
        System.out.println("中序遍历");
        inorder(tree1);
        System.out.println();
        System.out.println("后序遍历");
        postorder(tree1);
    }

    //先序遍历
    public static void preorder(Notetree p) {
        if (p == null){
            return;
        }
        System.out.print(p.value+" ");
        preorder(p.left);
        preorder(p.right);
    }
    
    //中序遍历
    public static void inorder(Notetree p) {
        if (p == null){
            return;
        }
        inorder(p.left);
        System.out.print(p.value+" ");
        inorder(p.right);
    }
    
    //后序遍历
    public static void postorder(Notetree p) {
        if (p == null){
            return;
        }
        postorder(p.left);
        postorder(p.right);
        System.out.print(p.value+" ");
    }
}

class Notetree{
    int value;
    Notetree left = null;
    Notetree right = null;
    public Notetree(int x){
        value = x;
    }
}
