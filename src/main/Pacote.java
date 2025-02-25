package main;

import java.util.*;

public class Pacote implements CRUD {
  private int id;
  private ArrayList<Atividade> atividades = new ArrayList<>();
  private ArrayList<Guia> guias = new ArrayList<>();
  private Local local;

  ArrayList<Pacote> pacotes = new ArrayList<>();

  Scanner s = new Scanner(System.in);

  Local local1 = new Local();
  Atividade atividade = new Atividade();
  Pacote pacote;
  Guia guia = new Guia();

  public Pacote(int id, ArrayList<Atividade> atividades, ArrayList<Guia> guias, Local local) {
    this.id = id;
    this.atividades = atividades;
    this.guias = guias;
    this.local = local;
  }

  public Pacote() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Atividade> getAtividades() {
    return atividades;
  }

  public void setAtividades(ArrayList<Atividade> atividades) {
    this.atividades = atividades;
  }

  public List<Guia> getGuias() {
    return guias;
  }

  public void setGuias(ArrayList<Guia> guias) {
    this.guias = guias;
  }

  public Local getLocal() {
    return local;
  }

  public void setLocal(Local local) {
    this.local = local;
  }

  @Override
  public void create() {
    System.out.print("ID do Pacote: ");
    int id = s.nextInt();
    ArrayList<Atividade> atividades = atividade.escolher();
    ArrayList<Guia> guias = guia.escolher();
    Local local2 = local1.escolher();
    pacote = new Pacote(id, atividades, guias, local2);
    pacotes.add(pacote);
  }

  @Override
  public void read() {
    for (Pacote p : pacotes) {
      System.out.println(p.toString());
    }
    System.out.println();
  }

  @Override
  public void update() {
    System.out.print("ID do Pacote: ");
    int id = s.nextInt();
    for (Pacote p : pacotes) {
      if (p.getId() == id) {
        ArrayList<Atividade> atividades = atividade.escolher();
        p.setAtividades(atividades);
        ArrayList<Guia> guias = guia.escolher();
        p.setGuias(guias);
        Local local2 = local1.escolher();
        p.setLocal(local2);
        System.out.print("Pacote atualizado!");
      }
    }
  }

  @Override
  public void delete() {
    System.out.print("ID do Pacote: ");
    int id = s.nextInt();
    pacotes.removeIf(p -> p.getId() == id);
  }

  @Override
  public String toString() {
    return "Pacote: " +
      "\n id: " + id +
      ",\n Atividades: " + atividades +
      ",\n Guias: " + guias +
      ",\n Locais: " + local;
  }

  public void listarPacotes() {
    if (pacotes.isEmpty()) {
      System.out.println("Nenhum pacote cadastrado.");
    } else {
      for (Pacote p : pacotes) {
        System.out.println(p.toString());
      }
    }
  }

  public Pacote encontrarPacotePorId(int id) {
    for (Pacote p : pacotes) {
      if (p.getId() == id) {
        return p;
      }
    }
    return null;
  }
}