package com.github.catapan.cadastrolivro;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CadastroLivroResource {

    @POST
    @Transactional
    public Long executa(@Valid NovoLivroRequest request) {
      Livro novoLivro = request.toModel();
      novoLivro.persist();
  
      return novoLivro.getId();
    }

}