package com.github.catapan.cadastrolivro;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoLivroRequest {
  
  @NotBlank
  String titulo;

  @NotBlank
  BigDecimal preco;

  @NotNull
  String isbn;

  public NovoLivroRequest(String titulo, BigDecimal preco, String isbn){
    this.titulo = titulo;
    this.preco = preco;
    this.isbn = isbn;
  }

  public Livro toModel() {
    return new Livro(this.titulo, this.preco, this.isbn);
  }
}
