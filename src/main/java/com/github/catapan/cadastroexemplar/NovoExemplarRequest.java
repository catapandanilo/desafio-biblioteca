package com.github.catapan.cadastroexemplar;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.catapan.cadastrolivro.Livro;
import com.github.catapan.validator.ExistsValue;

import org.springframework.util.Assert;

public class NovoExemplarRequest {

  @NotNull
  private TipoCirculacao tipoCirculacao;

  @NotBlank
  @ExistsValue(entity = Livro.class, field = "isbn")
  private String isbn;

  public String getIsbn() {
    return this.isbn;
  }

  public NovoExemplarRequest(@NotNull TipoCirculacao tipoCirculacao, @NotBlank String isbn) {
    this.tipoCirculacao = tipoCirculacao;
    this.isbn = isbn;
  }

  public Exemplar toModel() {
    Livro livro = Livro.findByIsbn(this.isbn);
    Assert.notNull(livro, "Um exemplar não pode ser criado com um livro nulo");
    return new Exemplar(tipoCirculacao, livro);
  }
}