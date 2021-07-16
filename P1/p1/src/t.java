import java.util.Scanner;

public class t {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String isbn,title;
        double price;
        System.out.print("isbn:");
        isbn = scanner.next();
        System.out.print("title:");
        title = scanner.next();
        System.out.print("price:");
        price = scanner.nextDouble();
        System.out.println("('"+isbn+"','"+title+"','"+price+"')");
    }
}
