package com.github.catapan;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoLivroRequest {
  
  @NotBlank
  String titulo;

  @NotBlank
  BigDecimal preco;

  @NotNull
  String ISBN;

  public NovoLivroRequest(String titulo, BigDecimal preco, String ISBN){
    this.titulo = titulo;
    this.preco = preco;
    this.ISBN = ISBN;
  }

  public Livro toModel() {
    return new Livro(this.titulo, this.preco, this.ISBN);
  }
}
