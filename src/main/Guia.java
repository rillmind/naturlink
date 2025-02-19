package main;

import java.util.*;

class Guia extends Pessoa implements CRUD {
    private Guia mentor;
    private ArrayList<Pacote> pacotes;

    public Guia(int id, String nome, String email, Guia mentor) {
        super(id, nome, email);
        this.mentor = mentor;
        this.pacotes = new ArrayList<>();
    }

    public void adicionarPacote(Pacote pacote) {
        if (pacotes.size() < 3) {
            pacotes.add(pacote);
        } else {
            System.out.println("Limite de pacotes atingido.");
        }
    }

    public void removerPacote(Pacote pacote) {
        pacotes.remove(pacote);
    }

    @Override
    public void cadastrar() {
        System.out.println("Guia cadastrado: " + getNome());
    }

    @Override
    public void atualizar() {
        System.out.println("Guia atualizado: " + getNome());
    }

    @Override
    public void listar() {
        System.out.println("Listando guia: " + getNome());
    }

    @Override
    public void remover() {
        System.out.println("Guia removido: " + getNome());
    }
}