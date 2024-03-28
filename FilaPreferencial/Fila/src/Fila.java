import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

public class Fila {
  private Queue<Paciente> fila;
  public int atendimentos;
  Scanner scanner = new Scanner(System.in);
  int contador = 0;

  public Fila(){
    fila = new LinkedList<>();
    atendimentos = 0;
  }

  public void adicionarPaciente(Paciente paciente) {
    fila.add(paciente);
  }

  public Paciente chamarPaciente() {
    Paciente pacienteChamado = null;


    if (!filaVazia()) {
      Iterator<Paciente> iterator = fila.iterator();
      Paciente paciente = iterator.next();
      while (iterator.hasNext()) {
        if (contador < 3 && paciente.isPreferencial()) {
          contador++;
          pacienteChamado = paciente;
          iterator.remove(); 
          break; 
        } else paciente = iterator.next();
      } 
        if (contador <= 3 || !paciente.isPreferencial()) {
          pacienteChamado = paciente;
          fila.poll();
          contador = 0;
        }
    }

    return pacienteChamado;
  }

  public boolean filaVazia() {
    return fila.isEmpty();
  }

  public void exibirfila() {
    for (Paciente paciente : fila) {
      if(paciente.isPreferencial()){
        System.out.println("Nome: "+ paciente.getNome() + " - Atendimento: Preferencial");
      } else {
        System.out.println("Nome: "+ paciente.getNome() + " - Atendimento: Normal");
        }
    }
    System.out.println("Tamanho da fila: " + fila.size() + " pacientes");
  }
}
