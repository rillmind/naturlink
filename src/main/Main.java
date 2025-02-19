package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Turista turista = new Turista();

        while (true) {
            menu();

            System.out.print("Escolha: ");
            int option = s.nextInt();s.nextLine();

            switch (option) {
                case 1:
                    turista.create();
                    break;
                case 2:
                    turista.read();
                    break;
                case 3:
                    turista.update();
            }
            if (option == 0) {
                break;
            }
        }
    }

    public static void menu() {
        System.out.print("\n1. Criar Turista\n2. Listar Turistas\n3. Atualizar Turista\n0. Sair\n");
    }
}