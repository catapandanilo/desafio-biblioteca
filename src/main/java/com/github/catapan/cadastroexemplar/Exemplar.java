package com.github.catapan.cadastroexemplar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.github.catapan.cadastrolivro.Livro;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Exemplar extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotNull
	@ManyToOne
	public Livro livro;

	@NotNull
	public TipoCirculacao tipoCirculacao;

	@Deprecated
	public Exemplar() {
	}

	public Exemplar(@NotNull TipoCirculacao tipoCirculacao, @NotNull Livro livro) {
		this.tipoCirculacao = tipoCirculacao;
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}
}
