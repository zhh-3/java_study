package ejb;

public class list {
    static Book booklist[] ;

    public static void set(){
        for (int i = 0; i < 10; i++) {
            Book bk = new Book(String.valueOf(i));
            booklist[i] = bk;
        }
    }

    public static void main(String[] args) {
        set();
        for (int i = 0; i < booklist.length; i++) {
            System.out.println(booklist[i].getIsbn());
        }
    }
}
