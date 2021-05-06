package com.github.catapan.cadastrolivro;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.catapan.validator.UniqueValue;

public class NovoLivroRequest {
  
  @NotBlank
  String titulo;

  @NotNull
  BigDecimal preco;

	@NotBlank
	@UniqueValue(entity = Livro.class, field = "isbn")
  String isbn;

  public NovoLivroRequest(String titulo, BigDecimal preco, String isbn){
    this.titulo = titulo;
    this.preco = preco;
    this.isbn = isbn;
  }

  @Override
	public String toString() {
		return "NovoLivroRequest [titulo=" + titulo + ", preco=" + preco + ", isbn=" + isbn + "]";
	}

  public Livro toModel() {
    return new Livro(this.titulo, this.preco, this.isbn);
  }
}
