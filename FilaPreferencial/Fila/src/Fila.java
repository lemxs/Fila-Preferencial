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


      Iterator<Paciente> iterator = fila.iterator();
      Paciente paciente = iterator.next();

      Iterator<Paciente> iterator2 = fila.iterator();
      Paciente pacientePref = iterator2.next();
      
      for(int i = 1; i <= fila.size(); i++){
        if (pacientePref.isPreferencial() && contador < 3) {
          contador++;
          pacienteChamado = pacientePref;
          iterator2.remove(); 
          break; 
        }else if(i < fila.size()) {
          pacientePref = iterator2.next();
        } 
      }

        if (pacienteChamado == null) {
          pacienteChamado = paciente;
          iterator.remove();
          contador = 0;
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

  public void adicionarPaciente(String string, boolean b) {
  }
}
