package main;

import main.classes.Guia;
import main.classes.Pacote;
import main.classes.Turista;
import main.exceptions.EntradaInvalidaException;
import main.exceptions.AtividadeNaoEncontradaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Turista turista = new Turista();
    Guia guia = new Guia();
    Pacote pacote = new Pacote();

    while (true) {
      try {
        menu();

        System.out.print("\nEscolha: ");
        int option = s.nextInt();
        s.nextLine();
        System.out.println();

        if (option == 0) {
          System.out.println("Saindo...");
          break;
        }

        switch (option) {
          case 1:
            menuTurista(s, turista, pacote);
            break;

          case 2:
            menuGuia(s, guia);
            break;

          case 3:
            menuPacote(s, pacote);
            break;

          default:
            throw new EntradaInvalidaException("Opção inválida. Tente novamente.");
        }
      } catch (EntradaInvalidaException | AtividadeNaoEncontradaException e) {
        System.out.println("Erro: " + e.getMessage());
      } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
        s.nextLine();
      }
    }
  }

  public static void menuTurista(Scanner s, Turista turista, Pacote pacote) throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    while (true) {
      try {
        menuTurista();

        System.out.print("\nEscolha: ");
        int option1 = s.nextInt();
        s.nextLine();
        System.out.println();

        if (option1 == 0) {
          break;
        }

        switch (option1) {
          case 1:
            turista.create();
            sleep(500);
            break;

          case 2:
            turista.read();
            sleep(500);
            break;

          case 3:
            turista.update();
            sleep(500);
            break;

          case 4:
            turista.delete();
            sleep(500);
            break;

          case 5:
            System.out.print("ID do Turista: ");
            int idTurista = s.nextInt();
            s.nextLine();
            Turista turistaReserva = turista.encontrarTuristaPorId(idTurista);
            if (turistaReserva != null) {
              pacote.read();
              System.out.print("ID do Pacote: ");
              int idPacote = s.nextInt();
              s.nextLine();
              Pacote pacoteReserva = pacote.encontrarPacotePorId(idPacote);
              if (pacoteReserva != null) {
                turistaReserva.criarReserva(pacoteReserva);
              } else {
                throw new AtividadeNaoEncontradaException("Pacote não encontrado.");
              }
            } else {
              throw new AtividadeNaoEncontradaException("Turista não encontrado.");
            }
            break;

          case 6:
            System.out.print("ID do Turista: ");
            int idTuristaCancelar = s.nextInt();
            s.nextLine();
            Turista turistaCancelar = turista.encontrarTuristaPorId(idTuristaCancelar);
            if (turistaCancelar != null) {
              System.out.print("ID da Reserva: ");
              int idReserva = s.nextInt();
              s.nextLine();
              turistaCancelar.cancelarReserva(idReserva);
            } else {
              throw new AtividadeNaoEncontradaException("Turista não encontrado.");
            }
            break;

          case 7:
            System.out.print("ID do Turista: ");
            int idTuristaListar = s.nextInt();
            s.nextLine();
            Turista turistaListar = turista.encontrarTuristaPorId(idTuristaListar);
            if (turistaListar != null) {
              System.out.print("Reservas do turista: ");
              turistaListar.listarReservas();
            } else {
              throw new AtividadeNaoEncontradaException("Turista não encontrado.");
            }
            break;

          default:
            throw new EntradaInvalidaException("Opção inválida. Tente novamente.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
        s.nextLine();
      }
    }
  }

  public static void menuGuia(Scanner s, Guia guia) throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    while (true) {
      try {
        menuGuia();

        System.out.print("\nEscolha: ");
        int option2 = s.nextInt();
        s.nextLine();
        System.out.println();

        if (option2 == 0) {
          break;
        }

        switch (option2) {
          case 1:
            guia.create();
            sleep(500);
            break;

          case 2:
            guia.read();
            sleep(500);
            break;

          case 3:
            guia.update();
            sleep(500);
            break;

          case 4:
            guia.delete();
            sleep(500);
            break;

          default:
            throw new EntradaInvalidaException("Opção inválida. Tente novamente.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
        s.nextLine();
      }
    }
  }

  public static void menuPacote(Scanner s, Pacote pacote) throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    while (true) {
      try {
        menuPacote();

        System.out.print("\nEscolha: ");
        int option3 = s.nextInt();
        s.nextLine();
        System.out.println();

        if (option3 == 0) {
          break;
        }

        switch (option3) {
          case 1:
            pacote.create();
            sleep(500);
            break;

          case 2:
            pacote.read();
            sleep(500);
            break;

          case 3:
            pacote.update();
            sleep(500);
            break;

          case 4:
            pacote.delete();
            sleep(500);
            break;

          default:
            throw new EntradaInvalidaException("Opção inválida. Tente novamente.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
        s.nextLine();
      }
    }
  }

  public static void menu() {
    System.out.print("\n1. Menu de Turistas\n2. Menu de Guias\n3. Menu de Pacotes\n0. Sair\n");
  }

  public static void menuTurista() {
    System.out.print("\n1. Criar Turista\n2. Listar Turistas\n3. Atualizar Turista\n4. Excluir Turista\n5. Criar Reserva\n6. Cancelar Reserva\n7. Listar Reservas\n0. Sair\n");
  }

  public static void menuGuia() {
    System.out.print("\n1. Criar Guias\n2. Listar Guias\n3. Atualizar Guia\n4. Excluir Guia\n0. Sair\n");
  }

  public static void menuPacote() {
    System.out.print("\n1. Criar Pacote\n2. Listar Pacotes\n3. Atualizar Pacote\n4. Excluir Pacote\n0. Sair\n");
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}