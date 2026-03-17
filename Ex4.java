import java.util.Scanner;
import java.time.*;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira sua data de nascimento (AAAA/MM/DD): ");
        String date_birth_string = sc.nextLine();

        LocalDate date_birth = LocalDate.parse(date_birth_string);
        LocalDate today = LocalDate.now();

        Period days_remaining = Period.between(today, date_birth);
        days = days_remaining.getMonths() / 30

        System.out.println(days_remaining);
        
        sc.close();
    }
}