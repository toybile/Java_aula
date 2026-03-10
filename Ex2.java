import java.util.Scanner;

public class Ex2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira um ano para verificar se ele é bissexto: ");
        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("O ano é bissexto!");
                } else {
                    System.out.println("O ano não é bissexto!");
                }
            } else {
                System.out.println("O ano é bissexto!");
            }
        } else {
            System.out.println("O ano não é bissexto!");
        }

        sc.close();
    }
}
