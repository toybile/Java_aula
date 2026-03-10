import java.util.Scanner;
public class Ex1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a nota final do aluno: ");
        float nf = sc.nextFloat();
        
        if (nf < 6) {
            System.out.println("O aluno está reprovado!");
        } else {
            System.out.println("O aluno está aprovado!");
        }

        sc.close();
    }
}
