package main.classes;

import main.abstratas.Pessoa;
import main.exceptions.AtividadeNaoEncontradaException;
import main.exceptions.EntradaInvalidaException;
import main.interfaces.CRUD;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Guia extends Pessoa implements CRUD {
  Scanner s = new Scanner(System.in);
  static ArrayList<Guia> guias = new ArrayList<>();
  String especialidade;

  public Guia(int id, String nome, String email, String especialidade) {
    super(id, nome, email);
    this.especialidade = especialidade;
  }

  public Guia() {
  }

  public ArrayList<Guia> escolher() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    ArrayList<Guia> guiasEscolhidos = new ArrayList<>();
    while (true) {
      try {
        this.read();
        System.out.print("ID do Guia: ");
        int id = s.nextInt();
        s.nextLine();

        boolean encontrado = false;
        for (Guia guia : guias) {
          if (guia.getId() == id) {
            guiasEscolhidos.add(guia);
            encontrado = true;
            break;
          }
        }

        if (!encontrado) {
          throw new AtividadeNaoEncontradaException("Guia com ID " + id + " não encontrado.");
        }

        System.out.print("\nDeseja adicionar mais Guias?\n1 - Sim\n2 - Nao\nEscolha: ");
        int resposta = s.nextInt();
        s.nextLine();

        if (resposta != 1 && resposta != 2) {
          throw new EntradaInvalidaException("Entrada inválida. Por favor, insira 1 para Sim ou 2 para Não.");
        }

        if (resposta == 2) {
          return guiasEscolhidos;
        }

      } catch (InputMismatchException e) {
        s.nextLine();
        throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro.");
      }
    }
  }

  @Override
  public void create() throws EntradaInvalidaException {
    try {
      System.out.print("ID do Guia: ");
      int id = s.nextInt();
      s.nextLine();
      System.out.print("Nome do Guia: ");
      String nome = s.nextLine();
      System.out.print("Email do Guia: ");
      String email = s.nextLine();
      System.out.print("Especialidade do Guia: ");
      String especialidade = s.nextLine();

      Guia guia = new Guia(id, nome, email, especialidade);
      guias.add(guia);
    } catch (InputMismatchException e) {
      s.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira valores corretos.");
    }
  }

  @Override
  public void read() {
    System.out.println();
    for (Guia guia : guias) {
      System.out.println(
        "Guia " +
          ". { id: " + guia.getId() +
          ". Nome: " + guia.getNome() +
          ". Email: " + guia.getEmail() +
          ". Especialidade: " + guia.getEspecialidade() +
          ". }"
      );
    }
    System.out.println();
  }

  @Override
  public void update() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    try {
      System.out.print("ID do Guia: ");
      int id = s.nextInt();
      s.nextLine();

      boolean encontrado = false;
      for (Guia guia : guias) {
        if (guia.getId() == id) {
          System.out.print("Nome do Guia: ");
          guia.setNome(s.nextLine());
          System.out.print("Email do Guia: ");
          guia.setEmail(s.nextLine());
          System.out.print("Especialidade do Guia: ");
          guia.setEspecialidade(s.nextLine());
          encontrado = true;
          break;
        }
      }

      if (!encontrado) {
        throw new AtividadeNaoEncontradaException("Guia com ID " + id + " não encontrado.");
      }

    } catch (InputMismatchException e) {
      s.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro.");
    }
  }

  @Override
  public void delete() throws EntradaInvalidaException, AtividadeNaoEncontradaException {
    try {
      System.out.print("ID do Guia: ");
      int id = s.nextInt();
      s.nextLine();

      boolean removido = guias.removeIf(guia -> guia.getId() == id);

      if (!removido) {
        throw new AtividadeNaoEncontradaException("Guia com ID " + id + " não encontrado.");
      }

    } catch (InputMismatchException e) {
      s.nextLine();
      throw new EntradaInvalidaException("Entrada inválida. Por favor, insira um número inteiro.");
    }
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  @Override
  public String toString() {
    return "Guia= " + super.toString() + "Especialidade = " + especialidade + "}";
  }
}