import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float[] number_list = new float[3];

        System.out.println("Insira três números: ");
        for (int i = 0; i < 3; i++) {
            number_list[i] = sc.nextFloat();
        }

        float max = number_list[0];
        for (float number : number_list) {
            if (number > max) max = number;
        }

        System.out.println("O maior número dentre os três: " + max);

        sc.close();
    }
}
