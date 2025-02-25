package main;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Turista turista = new Turista();
    Guia guia = new Guia();
    Pacote pacote = new Pacote();

    while (true) {
      menu();

      System.out.print("\nEscolha: ");
      int option = s.nextInt();
      s.nextLine();
      System.out.println();

      switch (option) {
        case 1:
          while (true) {
            menuTurista();

            System.out.print("\nEscolha: ");
            int option1 = s.nextInt();
            s.nextLine();
            System.out.println();

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
                    System.out.println("Pacote não encontrado.");
                  }
                } else {
                  System.out.println("Turista não encontrado.");
                }
                break;
              case 6:
                System.out.print("ID do Turista: ");
                int idTuristaCancelar = s.nextInt();
                Turista turistaCancelar = turista.encontrarTuristaPorId(idTuristaCancelar);
                if (turistaCancelar != null) {
                  System.out.print("ID da Reserva: ");
                  int idReserva = s.nextInt();
                  turistaCancelar.cancelarReserva(idReserva);
                } else {
                  System.out.println("Turista não encontrado.");
                }
                break;
              case 7:
                System.out.print("ID do Turista: ");
                int idTuristaListar = s.nextInt();
                Turista turistaListar = turista.encontrarTuristaPorId(idTuristaListar);
                if (turistaListar != null) {
                  System.out.print("Reservas do turista: ");
                  turistaListar.listarReservas();
                } else {
                  System.out.println("Turista não encontrado.");
                }
              default:
                break;
            }
            if (option1 == 0) {
              break;
            }
          }
          break;

        case 2:
          while (true) {
            menuGuia();

            System.out.print("\nEscolha: ");
            int option2 = s.nextInt();
            s.nextLine();
            System.out.println();

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
                break;
            }
            if (option2 == 0) {
              break;
            }
          }
          break;

        case 3:
          while (true) {
            menuPacote();

            System.out.print("\nEscolha: ");
            int option3 = s.nextInt();
            s.nextLine();
            System.out.println();

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
                break;
            }
            if (option3 == 0) {
              break;
            }
          }
      }
      if (option == 0) {
        break;
      }
    }
  }

  public static void menu() {
    System.out.print("\n1. Menu de Turistas\n2. Menu de Guias\n3. Menu de Pacotes\n0. Sair\n");
  }

  public static void menuTurista() {
    System.out.print("\n1. Criar Turista\n2. Listar Turistas\n3. Atualizar Turista\n4. Excluir Turista\n5. Criar Reserva\n6. Cancelar Reserva\n0. Sair\n");
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