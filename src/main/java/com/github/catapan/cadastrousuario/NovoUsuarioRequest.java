package com.github.catapan.cadastrousuario;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class NovoUsuarioRequest {
	@NotNull
	public TipoUsuario tipoUsuario;

	@JsonCreator(mode = Mode.PROPERTIES)
	public NovoUsuarioRequest(@NotNull TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario toModel() {
		return new Usuario(tipoUsuario);
	}
}
