package com.github.catapan.cadastroexemplar;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/livros/exemplares")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NovoExemplarResource {

	@POST
	@Transactional
	public Long executa(@Valid NovoExemplarRequest request) {
		Exemplar novoExemplar = request.toModel();
		novoExemplar.persist();

		return novoExemplar.getId();
	}
}
