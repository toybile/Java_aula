import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class AlunoControl {
    public static String menu(Scanner sc) {
        System.out.print("\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Buscar aluno por nome\n4 - Calcular média de idade\n5 - Exibir data/hora atual\n6 - Sair\nOpção: ");
        String userOption = sc.nextLine();
        return userOption;
    }
    
    public static String requisicaoNome(Scanner sc) {
        System.out.print("\nNome do(a) aluno(a): ");
        String nome = sc.nextLine();
        return nome;
    }
    
    public static int validacaoIdade(Scanner sc) {
        int idade;
        do {
            System.out.print("Idade do(a) aluno(a): ");
            idade = Integer.parseInt(sc.nextLine());
                        
            if (idade < 0) {
                System.out.println("Idade não pode ser negativa!");
            }
        } while (idade < 0);
        return idade;
    }
    
    public static boolean atribuiNomeIdadeEValidacaoVetorMax(String[] nomes, Integer[] idades, String nome, int idade) {
        boolean vetorMax = true;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null) {
                nomes[i] = nome;
                idades[i] = idade;
                vetorMax = false;
                break;
            }
        }
        return vetorMax;
    }
    
    public static int verificarQuantidadeAlunos(String[] nomes) {
        int quantidadeAlunos = 0;
        for (String n : nomes) {
            if (n != null) {
                quantidadeAlunos++;
            }
        }
        return quantidadeAlunos;
    }
    
    public static void listarAlunos(String[] nomes, Integer[] idades) {
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.print((i + 1) + ". " + nomes[i]);
                    
                if (idades[i] != null) {
                    System.out.println(" - " + idades[i] + " anos");
                }
            }
        }
    }
    
    public static boolean buscarAluno(Scanner sc, String[] nomes, Integer[] idades) {
        System.out.print("\nInsira o nome do aluno: ");
        String nomeAluno = sc.nextLine();
        boolean comunicador = false;
        
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomeAluno.equals(nomes[i])) {
                comunicador = true;
                System.out.println((i + 1) + ". " + nomes[i] + " - " + idades[i] + " anos");
            }
        }
        return comunicador;
    }
    
    public static void exibirMedia(Integer[] idades) {
        int contador = 0;
        int total = 0;
        int media = 0;
                    
        for (int i = 0; i < idades.length; i++) {
            if (idades[i] != null) {
                contador++; // define o denominador da equação de média simples
                total += idades[i]; // define o numerador da equação de média simples
            }
        }
        if (contador == 0) {
            System.out.println("Nenhum aluno cadastrado!");
        } else {
            media = total / contador;
            System.out.println("\nMédia das idades dos alunos: " + media);
        }
    }
    
    public static void exibirDataHora() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("\n" + LocalDateTime.now().format(formato));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String userOption;

        String[] nomes = new String[5];
        Integer[] idades = new Integer[5];
        
        System.out.println("Bem vindo(a) ao AlunoControl!\nSistema de Cadastro de Alunos");

        do { int i=0;
            userOption = menu(sc);
            
            switch (userOption) {
                case "1": // Cadastrar aluno
                    String nome = requisicaoNome(sc);
                    int idade = validacaoIdade(sc);
                    boolean vetorMax = atribuiNomeIdadeEValidacaoVetorMax(nomes, idades, nome, idade);
                    
                    if (vetorMax) {
                        System.out.println("O número máximo de cadastro de alunos é 5!\nInfelizmente o limite já foi excedido.");
                    }
                    break;

                case "2": // Listar alunos
                    int quantidadeAlunos = verificarQuantidadeAlunos(nomes);
                
                    System.out.println("\n" + quantidadeAlunos + " alunos cadastrados\n");
                    
                    listarAlunos(nomes, idades);
                    
                    if (quantidadeAlunos == 0) {
                        System.out.println("Nenhum aluno foi cadastrado!");
                    }
                    break;

                case "3": // Buscar aluno por nome
                    boolean comunicador = buscarAluno(sc, nomes, idades);
                    if (!comunicador) {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                    
                case "4": // Calcular média de idade
                    exibirMedia(idades);
                    break;
                    
                case "5": // Exibir data/hora atual
                    exibirDataHora();
                    break;
                    
                case "6": // Sair
                    System.out.println("\nSaindo do sistema...");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida");
            }
        } while (!userOption.equals("6"));
        sc.close();
    }
}