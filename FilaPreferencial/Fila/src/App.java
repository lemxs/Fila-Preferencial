import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();
        exibirMenu(fila);
    }

    private static void exibirMenu(Fila fila){
        System.out.println("\nSelecione uma opção");
        System.out.println("1 - Adicionar paciente;");
        System.out.println("2 - Chamar próximo paciente;");
        System.out.println("3 - Exibir fila; \n");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch(opcao){
            case 1:
                adicionarPaciente(fila);
                break;

            case 2:
                chamarPaciente(fila);
                break;
            
            case 3: 
                fila.exibirfila();
                exibirMenu(fila);
                break;
            
            default:
            System.out.println("\n Digite uma opção válida");
            exibirMenu(fila);
            break;
        }
    }

    private static void adicionarPaciente(Fila fila) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.println("\nPaciente preferencial?");
        System.out.println("Se sim, digite 1");
        System.out.println("Se não, digite 2");

        int opcao = scanner.nextInt();
        
        while( opcao != 1 && opcao != 2){
          System.out.println("\n Selecione uma opção válida");
          opcao = scanner.nextInt();
        }
        
        if (opcao == 1){
            Paciente paciente = new Paciente(nome, true);
            fila.adicionarPaciente(paciente);
        } else {
            Paciente paciente = new Paciente(nome, false);
            fila.adicionarPaciente(paciente);
        }

        exibirMenu(fila);
    }

    public static void chamarPaciente(Fila fila) {
        if (!fila.filaVazia()){
            Paciente paciente = fila.chamarPaciente();
            System.out.println("\nPróximo paciente:");
            System.out.println(fila.contador);
            if(paciente.isPreferencial()){
                System.out.println("Nome: "+ paciente.getNome() + " - Atendimento: Preferencial");
            } else {
                System.out.println("Nome: "+ paciente.getNome() + " - Atendimento: Normal");
            }
        } else {
            System.out.println("\n Fila vazia");
        }

        exibirMenu(fila);
    }



}
