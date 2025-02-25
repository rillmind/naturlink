package main;

import java.util.*;

public class Atividade {
    private int id;
    private String nome;
    private int duracao;
    private String descricao;
    Scanner s = new Scanner(System.in);

    public Atividade(int id, String nome, int duracao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.descricao = descricao;
    }

    public Atividade() {
    }

    private static final Atividade atividade1 = new Atividade(1, "Trilha na Praia", 120, "Trilha pela orla da praia");
    private static final Atividade atividade2 = new Atividade(2, "Visita ao Cristo Redentor", 90, "Visita ao monumento do Cristo Redentor");
    private static final Atividade atividade3 = new Atividade(3, "Passeio de Barco", 180, "Passeio de barco pelas ilhas");
    private static final Atividade atividade4 = new Atividade(4, "Cachoeira da Chapada", 240, "Trilha até a cachoeira");
    private static final Atividade atividade5 = new Atividade(5, "Tour Histórico", 120, "Tour pelo centro histórico");

    private static final ArrayList<Atividade> atividades = new ArrayList<>(Arrays.asList(
            atividade1, atividade2, atividade3, atividade4, atividade5
    ));

    public ArrayList<Atividade> escolher() {
        ArrayList<Atividade> atividades1 = new ArrayList<>();
        while (true) {
            for (Atividade atividade : atividades) {
                System.out.print(atividade.toString() + "\n");
            }
            System.out.print("ID da Atividade: ");
            int id = s.nextInt();
            for (Atividade atividade : atividades) {
                if (atividade.getId() == id) {
                    atividades1.add(atividade);
                }
            }
            System.out.print("Deseja adicionar mais atividades?\n1 - Sim\n2 - Nao\nEscolha: ");
            int resposta = s.nextInt();
            if (resposta == 2) {
                return atividades1;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}