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
        } else {
            System.out.println("Limite de reservas atingido.");
        }
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    @Override
    public void create() {
        System.out.print("ID do Turista: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nome do Turista: ");
        String nome = sc.nextLine();
        System.out.print("Email do Turista: ");
        String email = sc.nextLine();
        Turista turista = new Turista(id, nome, email);
        turistas.add(turista);
    }

    @Override
    public void update() {
        System.out.print("ID do Turista: ");
        int id = sc.nextInt(); sc.nextLine();
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
    public void read() {
        int cont = 1;
        for (Turista turista : turistas) {
            System.out.println(
                    "Turista " + cont +
                    ". { id: " + turista.getId() +
                    ". Nome: " + turista.getNome() +
                    ". Email: " + turista.getEmail() +
                    ". }"
            );
            cont++;
        }
    }

    @Override
    public void delete() {
        System.out.print("ID do Turista: ");
        int id = sc.nextInt();
        turistas.removeIf(turista -> turista.getId() == id);
        System.out.println("Turista removido.");
    }
}