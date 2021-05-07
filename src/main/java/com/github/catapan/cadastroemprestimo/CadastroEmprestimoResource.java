package com.github.catapan.cadastroemprestimo;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/emprestimos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CadastroEmprestimoResource {

    @POST
    @Transactional
    public String executa(@Valid NovoEmprestimoRequest request) {
        return request.toModel();
    }
}
