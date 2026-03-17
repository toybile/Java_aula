import java.util.Scanner;
import java.time.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe uma data (AAAA-MM-DD): ");
        String date = sc.nextLine();

        LocalDate local_date = LocalDate.parse(date);
        if (local_date.isLeapYear() == true) {
            System.out.println("Este é um ano bissexto.");
        } else {
            System.out.println("Este não é um ano bissexto.");
        }
        

        sc.close();
    }
}