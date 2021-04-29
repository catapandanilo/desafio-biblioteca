package com.github.catapan;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Livro extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  String titulo;

  @NotBlank
  BigDecimal preco;

  @NotBlank
  String ISBN;

  public Livro(@NotBlank String titulo, @NotNull BigDecimal preco, @NotBlank String ISBN) {
    this.titulo = titulo;
    this.preco = preco;
    this.ISBN = ISBN;
  }

  @Deprecated
  public Livro() {}

  public Long getId() {
    return this.id;
  }

}