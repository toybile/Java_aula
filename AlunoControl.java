import java.util.Scanner;
import java.time.*;

public class AlunoControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userOption;

        String[] nomes = new String[5];
        int[] idades = new int[5];

        do { int i=0;

            System.out.print("\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Buscar aluno por nome\n4 - Calcular média de idade\n5 - Exibir data/hora atual\n6 - Sair\nOpção: ");
            userOption = Integer.parseInt(sc.nextLine());


            switch (userOption) {
                case 1: // Cadastrar aluno
                    System.out.print("Nome do aluno: ");
                    for (i=0; i<5; i++) {
                        if (nomes[i] == null) {
                            nomes[i] = sc.nextLine();
                            break;
                        }
                    }
                    System.out.print("Idade do aluno: ");
                    for (i=0; i<5; i++) {
                        // if (idades[i] == null) {
                            idades[i] = Integer.parseInt(sc.nextLine());
                            break;
                        // }
                    }
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2: //Listar alunos
                    i = 1;
                    System.out.println("\nAlunos cadastrados:");
                    for (String n : nomes) {
                        if (n != null) {
                            System.out.print(i + ". " + n);
                            i++;
                        }
                    }
                    for (i=0; i<5; i++) {
                        System.out.println(idades[i]);
                    }
                    if (i == 1) {
                        System.out.println("Nenhum aluno foi cadastrado!");
                    }
                    break;

                case 3: //Buscar aluno por nome
                    


                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }



    
        } while (userOption != 6);
    }
}