package com.github.catapan.cadastroexemplar;

public class NovoExemplarRequest {

  private TipoCirculacao tipoCirculacao;
  private String isbn;

  public Exemplar toModel() {
    return new Exemplar();
  }
}