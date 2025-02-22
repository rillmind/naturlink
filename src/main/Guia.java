package main;

import java.util.*;

class Guia extends Pessoa implements CRUD {
    Scanner s = new Scanner(System.in);
    ArrayList<Guia> guias = new ArrayList<>();
    String especialidade;

    public Guia(int id, String nome, String email, String especialidade) {
        super(id, nome, email);
        this.especialidade = especialidade;
    }

    public Guia() {
    }

    @Override
    public void create(){
        System.out.print("ID: ");
        int id = s.nextInt(); s.nextLine();
        System.out.print("Nome: ");
        String nome = s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Especialidade: ");
        especialidade = s.nextLine();
        Guia guia = new Guia(id, nome, email, especialidade);
        guias.add(guia);
    }

    @Override
    public void update() {
        System.out.print("ID: ");
        int id = s.nextInt(); s.nextLine();
        for (Guia guia : guias) {
            if (guia.getId() == id) {
                System.out.print("Nome: ");
                guia.setNome(s.nextLine());
                System.out.print("Email: ");
                guia.setEmail(s.nextLine());
                System.out.print("Especialidade: ");
                guia.setEspecialidade(s.nextLine());
            }
        }
    }

    @Override
    public void read() {
        int cont = 1;
        for (Guia guia : guias) {
            System.out.println(
                    "Turista " + cont +
                    ". { id: " + guia.getId() +
                    ". Nome: " + guia.getNome() +
                    ". Email: " + guia.getEmail() +
                    ". Especialidade: " + guia.getEspecialidade() +
                    ". }"
            );
            cont++;
        }
    }

    @Override
    public void delete() {
        System.out.print("ID: ");
        int id = s.nextInt();
        guias.removeIf(guia -> guia.getId() == id);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}