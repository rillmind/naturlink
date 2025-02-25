package main.classes;

import main.abstratas.Pessoa;
import main.exceptions.AtividadeNaoEncontradaException;
import main.exceptions.EntradaInvalidaException;
import main.interfaces.CRUD;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

  public void adicionarReserva(Reserva reserva) throws AtividadeNaoEncontradaException {
    if (reservas.size() < 5) {
      reservas.add(reserva);
      System.out.println("Reserva adicionada com sucesso!");
    } else {
      throw new AtividadeNaoEncontradaException("Limite de reservas atingido (máximo de 5 reservas).");
    }
  }

  public void cancelarReserva(int idReserva) throws AtividadeNaoEncontradaException {
    boolean removido = reservas.removeIf(reserva -> reserva.getId() == idReserva);
    if (!removido) {
      throw new AtividadeNaoEncontradaException("Reserva com ID " + idReserva + " não encontrada.");
    } else {
      System.out.println("Reserva cancelada com sucesso!");
    }
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

  public void criarReserva(Pacote pacote) throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    try {
      System.out.print("ID da Reserva: ");
      int idReserva = sc.nextInt();
      sc.nextLine();
      System.out.print("Data de Início (dd/MM/yyyy): ");
      String dataInicio = sc.nextLine();
      System.out.print("Data de Término (dd/MM/yyyy): ");
      String dataTermino = sc.nextLine();

      Reserva reserva = new Reserva(idReserva, this, pacote, dataInicio, dataTermino);
      adicionarReserva(reserva);
    } catch (InputMismatchException e) {
      sc.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro para o ID da reserva.");
    }
  }

  public Turista encontrarTuristaPorId(int id) throws AtividadeNaoEncontradaException {
    for (Turista turista : turistas) {
      if (turista.getId() == id) {
        return turista;
      }
    }
    throw new AtividadeNaoEncontradaException("Turista com ID " + id + " não encontrado.");
  }

  public ArrayList<Turista> getTuristas() {
    return turistas;
  }

  @Override
  public void create() throws EntradaInvalidaException {
    try {
      System.out.print("ID do Turista: ");
      int id = sc.nextInt();
      sc.nextLine();
      System.out.print("Nome do Turista: ");
      String nome = sc.nextLine();
      System.out.print("Email do Turista: ");
      String email = sc.nextLine();
      Turista turista = new Turista(id, nome, email);
      turistas.add(turista);
      System.out.println("Turista criado com sucesso!");
    } catch (InputMismatchException e) {
      sc.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro para o ID.");
    }
  }

  @Override
  public void read() {
    if (turistas.isEmpty()) {
      System.out.println("Nenhum turista cadastrado.");
    } else {
      for (Turista turista : turistas) {
        System.out.println(
          "Turista " +
            " { id: " + turista.getId() +
            " Nome: " + turista.getNome() +
            " Email: " + turista.getEmail() +
            " }"
        );
      }
    }
    System.out.println();
  }

  @Override
  public void update() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    try {
      System.out.print("ID do Turista: ");
      int id = sc.nextInt();
      sc.nextLine();

      boolean encontrado = false;
      for (Turista turista : turistas) {
        if (turista.getId() == id) {
          System.out.print("Nome do Turista: ");
          turista.setNome(sc.nextLine());
          System.out.print("Email do Turista: ");
          turista.setEmail(sc.nextLine());
          encontrado = true;
          System.out.println("Turista atualizado com sucesso!");
          break;
        }
      }

      if (!encontrado) {
        throw new AtividadeNaoEncontradaException("Turista com ID " + id + " não encontrado.");
      }
    } catch (InputMismatchException e) {
      sc.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro para o ID.");
    }
  }

  @Override
  public void delete() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    try {
      System.out.print("ID do Turista: ");
      int id = sc.nextInt();
      sc.nextLine();

      boolean removido = turistas.removeIf(turista -> turista.getId() == id);

      if (!removido) {
        throw new AtividadeNaoEncontradaException("Turista com ID " + id + " não encontrado.");
      } else {
        System.out.println("Turista removido com sucesso!");
      }
    } catch (InputMismatchException e) {
      sc.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro para o ID.");
    }
  }
}