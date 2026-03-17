// import java.util.Scanner;
import java.time.LocalDate;

public class test {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Scanner sc = new Scanner();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println(yesterday + "\n" + today + " (Today!)\n" + tomorrow);

        // sc.close;
    }
}
