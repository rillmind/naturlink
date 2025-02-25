package main;

import java.util.*;

public class Turista extends Pessoa implements CRUD {
  private ArrayList<Turista> turistas = new ArrayList<>();
  private ArrayList<Reserva> reservas = new ArrayList<>();
  Scanner sc = new Scanner(System.in);

  public Turista(int id, String nome, String email) {
    super(id, nome, email);
    this.reservas = new ArrayList<>();
  }

  public Turista() {
  }

   public void adicionarReserva(Reserva reserva) {
    if (reservas.size() < 5) {
      reservas.add(reserva);
      System.out.println("Reserva adicionada com sucesso!");
    } else {
      System.out.println("Limite de reservas atingido (máximo de 5 reservas).");
    }
  }

  public void cancelarReserva(int idReserva) {
    reservas.removeIf(reserva -> reserva.getId() == idReserva);
    System.out.println("Reserva cancelada com sucesso!");
  }

  public void listarReservas() {
    if (reservas.isEmpty()) {
      System.out.println("Nenhuma reserva encontrada.");
    } else {
      for (Reserva reserva : reservas) {
        System.out.println(reserva.toString());
      }
    }
  }

  public void criarReserva(Pacote pacote) {
    System.out.print("ID da Reserva: ");
    int idReserva = sc.nextInt();
    sc.nextLine();
    System.out.print("Data de Início (dd/MM/yyyy): ");
    String dataInicio = sc.nextLine();
    System.out.print("Data de Término (dd/MM/yyyy): ");
    String dataTermino = sc.nextLine();

    Reserva reserva = new Reserva(idReserva, this, pacote, dataInicio, dataTermino);
    adicionarReserva(reserva);
  }

  public Turista encontrarTuristaPorId(int id) {
    for (Turista turista : turistas) {
      if (turista.getId() == id) {
        return turista;
      }
    }
    return null;
  }

  public ArrayList<Turista> getTuristas() {
    return turistas;
  }

  @Override
  public void create() {
    System.out.print("ID do Turista: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Nome do Turista: ");
    String nome = sc.nextLine();
    System.out.print("Email do Turista: ");
    String email = sc.nextLine();
    Turista turista = new Turista(id, nome, email);
    turistas.add(turista);
  }

  @Override
  public void read() {
    for (Turista turista : turistas) {
      System.out.println(
        "Turista " +
          " { id: " + turista.getId() +
          " Nome: " + turista.getNome() +
          " Email: " + turista.getEmail() +
          " }"
      );
    }
    System.out.println();
  }

  @Override
  public void update() {
    System.out.print("ID do Turista: ");
    int id = sc.nextInt();
    sc.nextLine();
    for (Turista turista : turistas) {
      if (turista.getId() == id) {
        System.out.print("Nome do Turista: ");
        turista.setNome(sc.nextLine());
        System.out.print("Email do Turista: ");
        turista.setEmail(sc.nextLine());
      }
    }
    System.out.print("Turista atualizado.");
  }

  @Override
  public void delete() {
    System.out.print("ID do Turista: ");
    int id = sc.nextInt();
    turistas.removeIf(turista -> turista.getId() == id);
    System.out.println("Turista removido.");
  }
}