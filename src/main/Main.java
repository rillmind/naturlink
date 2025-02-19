package main;

public class Main {
    public static void main(String[] args) {
        Turista turista = new Turista(1, "João Silva", "joao@example.com");
        Guia guia = new Guia(2, "Maria Souza", "maria@example.com", null);
        Local local = new Local(1, "Praia do Forte", 100);
        Pacote pacote = new Pacote(1, local, "2023-12-01", "2023-12-07");
        Reserva reserva = new Reserva(1, turista, pacote, "2023-12-01", "2023-12-07");

        turista.adicionarReserva(reserva);
        guia.adicionarPacote(pacote);

        turista.create();
        guia.read();
    }
}