package main;

import java.util.*;

public class Guia extends Pessoa implements CRUD {
  Scanner s = new Scanner(System.in);
  static ArrayList<Guia> guias = new ArrayList<>();
  String especialidade;

  public Guia(int id, String nome, String email, String especialidade) {
    super(id, nome, email);
    this.especialidade = especialidade;
  }

  public Guia() {
  }

  public ArrayList<Guia> escolher() {
    ArrayList<Guia> guias1 = new ArrayList<>();
    while (true) {
      this.read();
      System.out.print("ID do Guia: ");
      int id = s.nextInt();
      for (Guia guia : guias) {
        if (guia.getId() == id) {
          guias1.add(guia);
        }
      }
      System.out.print("\nDeseja adicionar mais Guias?\n1 - Sim\n2 - Nao\nEscolha: ");
      int resposta = s.nextInt();
      if (resposta == 2) {
        return guias1;
      }
      System.out.println();
    }
  }

  @Override
  public void create() {
    System.out.print("ID do Guia: ");
    int id = s.nextInt();
    s.nextLine();
    System.out.print("Nome do Guia: ");
    String nome = s.nextLine();
    System.out.print("Email do Guia: ");
    String email = s.nextLine();
    System.out.print("Especialidade do Guia: ");
    especialidade = s.nextLine();
    Guia guia = new Guia(id, nome, email, especialidade);
    guias.add(guia);
  }

  @Override
  public void read() {
    System.out.println();
    for (Guia guia : guias) {
      System.out.println(
        "Guia " +
          ". { id: " + guia.getId() +
          ". Nome: " + guia.getNome() +
          ". Email: " + guia.getEmail() +
          ". Especialidade: " + guia.getEspecialidade() +
          ". }"
      );
    }
    System.out.println();
  }

  @Override
  public void update() {
    System.out.print("ID do Guia: ");
    int id = s.nextInt();
    s.nextLine();
    for (Guia guia : guias) {
      if (guia.getId() == id) {
        System.out.print("Nome do Guia: ");
        guia.setNome(s.nextLine());
        System.out.print("Email do Guia: ");
        guia.setEmail(s.nextLine());
        System.out.print("Especialidade do Guia: ");
        guia.setEspecialidade(s.nextLine());
      }
    }
  }

  @Override
  public void delete() {
    System.out.print("ID do Guia: ");
    int id = s.nextInt();
    guias.removeIf(guia -> guia.getId() == id);
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  @Override
  public String toString() {
    return "Guia= " + super.toString() + "Especialidade = " + especialidade + "}";
  }
}