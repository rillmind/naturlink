package main;

import java.util.*;

class Turista extends Pessoa implements CRUD {
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Turista(int id, String nome, String email) {
        super(id, nome, email);
        this.reservas = new ArrayList<>();
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
    public void cadastrar() {
        System.out.println("Turista cadastrado: " + getNome());
    }

    @Override
    public void atualizar() {
        System.out.println("Turista atualizado: " + getNome());
    }

    @Override
    public void listar() {
        System.out.println("Listando turista: " + getNome());
    }

    @Override
    public void remover() {
        System.out.println("Turista removido: " + getNome());
    }
}