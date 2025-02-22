package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Turista turista = new Turista();
        Guia guia = new Guia();

        while (true) {
            menu();

            System.out.print("\nEscolha: ");
            int option = s.nextInt();
            s.nextLine();

            switch (option) {
                case 1:
                    while (true) {
                        menuTurista();

                        System.out.print("\nEscolha: ");
                        int option1 = s.nextInt();
                        s.nextLine();

                        switch (option1) {
                            case 1:
                                turista.create();
                                break;
                            case 2:
                                turista.read();
                                break;
                            case 3:
                                turista.update();
                                break;
                            case 4:
                                turista.delete();
                                break;
                        }
                        if (option1 == 0) {
                            break;
                        }
                    }

                case 2:
                    while (true) {
                        menuGuia();

                        System.out.print("\nEscolha: ");
                        int option1 = s.nextInt();
                        s.nextLine();

                        switch (option1) {
                            case 1:
                                guia.create();
                                break;
                            case 2:
                                guia.read();
                                break;
                            case 3:
                                guia.update();
                                break;
                            case 4:
                                guia.delete();
                                break;
                        }
                        if (option1 == 0) {
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
        System.out.print("\n1. Menu de Turistas\n2. Menu de Guias\n0. Sair\n");
    }

    public static void menuTurista() {
        System.out.print("\n1. Criar Turista\n2. Listar Turistas\n3. Atualizar Turista\n4. Excluir Turista\n0. Sair\n");
    }

    public static void menuGuia() {
        System.out.print("\n1. Criar Guias\n2. Listar Guias\n3. Atualizar Guia\n4. Excluir Guia\n0. Sair\n");
    }
}