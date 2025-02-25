package main.interfaces;

import main.exceptions.AtividadeNaoEncontradaException;
import main.exceptions.EntradaInvalidaException;

public interface CRUD {
  void create() throws EntradaInvalidaException, AtividadeNaoEncontradaException;

  void read();

  void update() throws EntradaInvalidaException, AtividadeNaoEncontradaException;

  void delete() throws EntradaInvalidaException, AtividadeNaoEncontradaException;
}