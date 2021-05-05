import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Записная книжка ====");

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("\nВведите имя, номер телефона или команду LIST для просмотра всех записей:");
            String sign = scanner.next();
            PhoneBook.newSign(sign);
        }
    }
}
