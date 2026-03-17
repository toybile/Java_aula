import java.util.Scanner;
import java.time.*;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Referente à sua data de nascimento, informe:\nAno: ");
        int year_birth = sc.nextInt();
        System.out.print("Mês: ");
        int month_birth = sc.nextInt();
        System.out.print("Dia: ");
        int day_birth = sc.nextInt();

        LocalDate date_birth = LocalDate.of(year_birth, month_birth, day_birth);
        LocalDate today = LocalDate.now();
        Period age = Period.between(date_birth, today);
        System.out.println("Você tem " + age.getYears() + " anos, " + age.getMonths() + " meses e " + age.getDays() + " dias");

        sc.close();
    }
}