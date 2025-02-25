package main.classes;

import main.exceptions.AtividadeNaoEncontradaException;
import main.exceptions.EntradaInvalidaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
  private static final Atividade atividade2 = new Atividade(2, "Tour pela cidade", 90, "Visita as principais atrações da cidade");
  private static final Atividade atividade3 = new Atividade(3, "Passeio de Barco", 180, "Passeio de barco pelas ilhas");
  private static final Atividade atividade4 = new Atividade(4, "Cachoeira da Chapada", 240, "Trilha até a cachoeira");
  private static final Atividade atividade5 = new Atividade(5, "Tour Histórico", 120, "Tour pelo centro histórico");

  private static final ArrayList<Atividade> atividades = new ArrayList<>(Arrays.asList(
    atividade1, atividade2, atividade3, atividade4, atividade5
  ));

  public ArrayList<Atividade> escolher() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    ArrayList<Atividade> atividadesEscolhidas = new ArrayList<>();
    while (true) {
      try {
        System.out.println();
        for (Atividade atividade : atividades) {
          System.out.print(atividade.toString() + "\n");
        }
        System.out.print("\nID da Atividade: ");
        int id = s.nextInt();
        s.nextLine();

        boolean encontrada = false;
        for (Atividade atividade : atividades) {
          if (atividade.getId() == id) {
            if (!atividadesEscolhidas.contains(atividade)) {
              atividadesEscolhidas.add(atividade);
              System.out.println("Atividade adicionada: " + atividade.getNome());
            } else {
              System.out.println("Atividade já foi escolhida. Escolha outra.");
            }
            encontrada = true;
            break;
          }
        }

        if (!encontrada) {
          throw new AtividadeNaoEncontradaException("Atividade com ID " + id + " não encontrada.");
        }

        System.out.print("\nDeseja adicionar mais atividades?\n1 - Sim\n2 - Nao\nEscolha: ");
        int resposta = s.nextInt();
        s.nextLine();

        if (resposta != 1 && resposta != 2) {
          throw new EntradaInvalidaException("Entrada inválida. Por favor, insira 1 para Sim ou 2 para Não.");
        }

        if (resposta == 2) {
          return atividadesEscolhidas;
        }

      } catch (InputMismatchException e) {
        s.nextLine();
        throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro.");
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
    return "Atividade {" +
      "id: " + id +
      ", nome: " + nome +
      ", duracao: " + duracao +
      ", descricao: " + descricao +
      '}';
  }
}