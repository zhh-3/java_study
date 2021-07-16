import java.util.ArrayList;
import java.util.Scanner;

public class List {
    static int num;
    static Book booklist[];
    static ArrayList<Book> lists = new ArrayList<>();
    public static void main(String[] args) {
        set();
        for (int i = 0; i < booklist.length; i++) {
            System.out.println(booklist[i].isbn);
        }
    }

    public static void set(){

        for (int i = 0; i < 10; i++) {
            Book bk = new Book(i);
            lists.add(bk);
        }
        num = lists.size();
        booklist = new Book[num];
        System.out.println(booklist.length);
        for (int i = 0; i < num; i++) {
            booklist[i] = lists.get(i);
        }
    }
}
