import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class AlunoControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userOption;

        String[] nomes = new String[5];
        Integer[] idades = new Integer[5]; //O int é uma forma de variável primitiva, armazenando somente o valor bruto, recomendado para operações simples. Já o Integer é um objeto (classe wrapper), permitindo manipulações mais complexas a partir dos métodos disponíveis na classe, além de funcionar de maneira diferente quando comparados com == ou .equals(). O primeiro, em objetos, comparará se armazenam o mesmo endereço de memória, já o segundo, os valores em si armazenados.
        
        System.out.println("Bem vindo ao AlunoControl!\nSistema de Cadastro de Alunos");

        do { int i=0;

            System.out.print("\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Buscar aluno por nome\n4 - Calcular média de idade\n5 - Exibir data/hora atual\n6 - Sair\nOpção: ");
            userOption = sc.nextLine();


            switch (userOption) {
                case "1": // Cadastrar aluno
                
                    // requisitando o nome do(a) aluno(a) para o usuário e armazenando o valor fornecido
                    System.out.print("\nNome do(a) aluno(a): ");
                    String nome = sc.nextLine();
                    int idade;
                    
                    // requisitando a idade do(a) aluno(a) para o usuário, armazenando o valor fornecido e verificando se a mesma é positiva
                    do {
                        System.out.print("Idade do(a) aluno(a): ");
                        idade = Integer.parseInt(sc.nextLine());
                        
                        if (idade < 0) {
                            System.out.println("Idade não pode ser negativa!");
                        }
                    } while (idade < 0);
                    
                    // verificando o próximo espaço livre nos arrays nomes e idades e armazenando os valores fornecidos pelo usuário
                    boolean verificarVetorCheio = true;
                    for (i = 0; i < nomes.length; i++) {
                        if (nomes[i] == null) {
                            nomes[i] = nome;
                            idades[i] = idade;
                            verificarVetorCheio = false;
                            break;
                        }
                    }
                    if (verificarVetorCheio) {
                        System.out.println("O número máximo de cadastro de alunos é 5!\nInfelizmente o limite já foi excedido.");
                    }
                    break;

                case "2": // Listar alunos
                    int quantidadeAlunos = 0;
                
                    // coletando a informação de quantos alunos estão cadastrados para exibir junto à lista de alunos
                    for (String n : nomes) {
                        if (n != null) {
                            quantidadeAlunos++;
                        }
                    }
                
                    System.out.println("\n" + quantidadeAlunos + " alunos cadastrados\n");
                    
                    // percorrendo pelo array com for e verificando se não são null, isto é, se possui alguma informação no índice em questão, e então printa o nome e a idade
                    for (i = 0; i < nomes.length; i++) {
                        if (nomes[i] != null) {
                            System.out.print((i + 1) + ". " + nomes[i]);
                    
                            if (idades[i] != null) {
                                System.out.println(" - " + idades[i] + " anos");
                            }
                        }
                    }
                    
                    if (quantidadeAlunos == 0) {
                        System.out.println("Nenhum aluno foi cadastrado!");
                    }
                    break;

                case "3": // Buscar aluno por nome
                    System.out.print("\nInsira o nome do aluno: ");
                    String nomeAluno = sc.nextLine();
                    
                    boolean comunicador = false;
                    
                    // compara o nome fornecido pelo usuário com cada uma das Strings armazenadas no array, caso o encontre, é exibido nome e idade, caso contrário, o boleano comunicador avisará isso e o programa dirá que o aluno não foi encontrado
                    for (i = 0; i < nomes.length; i++) {
                        if (nomes[i] != null && nomeAluno.equals(nomes[i])) {
                            comunicador = true;
                            System.out.println((i + 1) + ". " + nomes[i] + " - " + idades[i] + " anos");
                        }
                    }
                    if (!comunicador) {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                    
                case "4": // Calcular média de idade
                    int contador = 0;
                    int armazenador = 0;
                    int total = 0;
                    int media = 0;
                    
                    for (i = 0; i < idades.length; i++) {
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
                    break;
                    
                case "5": // Exibir data/hora atual
                    System.out.println("\nPadrão: " + LocalDateTime.now());
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // um formato mais bonitinho para a exibição da data e hora, copiei 100% de AI mesmo
                    System.out.println("Formatado: " + LocalDateTime.now().format(formato));
                    break;
                    
                case "6": // Sair
                    System.out.println("\nSaindo do sistema...");
                    break; // ao pressionar 6, o usuário terá escolhido a opção de sair do sistema, em termos técnicos, a variável String userOption armazenará o valor 6, e a condição para o loop de repetição continuar é que esta variável seja diferente de 6, em outras palavras, o programa será encerrado

                // caso a String userOption não seja nenhum valor de 1 a 6, a mensagem abaixo será exibida, e o loop de repetição se manterá
                default:
                    System.out.println("\nOpção inválida");
            } // Poderia ser feito com if/else conforme solicitado, mas optei por switch case pela melhor organização



    
        } while (!userOption.equals("6")); //while só executa o bloco de código caso alguma condição seja satisfeita. Do-while começa executando o blodo de código independentemente de uma condição sendo satisfeita, mas quando acaba o bloco, há uma condição para determinar se o executará novamente, ou se encerrará. Na prática, isso implica que o while pode não ser executado, pois para tal, é necessária a condição, já o do-while será executado no mínimo uma vez, pois inicialmente não depende dela.
        sc.close();
    }
}
