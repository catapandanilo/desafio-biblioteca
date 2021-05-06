package com.github.catapan.cadastrousuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Usuario extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotNull
	public TipoUsuario tipoUsuario;

	public Usuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Deprecated
	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

}
