package com.github.catapan.cadastrousuario;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CadastroUsuarioResource {

  @POST
  @Transactional
  public Long executa(@Valid NovoUsuarioRequest request) {
    Usuario novoUsuario = request.toModel();
    novoUsuario.persist();

    return novoUsuario.getId();
  }

}