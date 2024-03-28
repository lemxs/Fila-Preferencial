public class Paciente {
  public Boolean preferencial;
  public String nome;

  public Paciente(String nome, Boolean preferencial){
    this.nome = nome;
    this.preferencial = preferencial;
  }

  public boolean isPreferencial() {
    return preferencial;
  }

  public String getNome() {
    return nome;
  }
}
