package com.github.catapan;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CadastroLivroResource {

    @POST
    @Transactional
    public Long executa(@Valid NovoLivroRequest request) {
      Livro novoUsuario = request.toModel();
      novoUsuario.persist();
  
      return novoUsuario.getId();
    }

}