package com.github.catapan.cadastroemprestimo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.github.catapan.cadastroexemplar.TipoCirculacao;
import com.github.catapan.cadastrousuario.TipoUsuario;
import com.github.catapan.cadastrousuario.Usuario;

public class NovoEmprestimoRequest {

    @NotNull
    // @ExistsValue(field = "id", entity = Usuario.class)
    Long idUsuario;

    @NotNull
    // @ExistsValue(field = "id", entity = Livro.class)
    Long idLivro;

    @Positive
    @Max(value = 60)
    Integer dias;

    @NotNull
    TipoCirculacao tipoCirculacao;

    public NovoEmprestimoRequest(@NotNull Long idUsuario, @NotNull Long idLivro,
            @Positive @Max(value = 60) Integer dias, @NotNull TipoCirculacao tipoCirculacao) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dias = dias;
        this.tipoCirculacao = tipoCirculacao;
    }

    @Override
    public String toString() {
        return "EmprestimoRequest{" + "idUsuario=" + idUsuario + ", idLivro=" + idLivro + ", dias=" + dias
                + ", tipoCirculacao=" + tipoCirculacao + '}';
    }

    public String toModel() {
        Usuario usuario = Usuario.findById(this.getIdUsuario());

        if (TipoUsuario.PADRAO.equals(usuario.getTipoUsuario())) {
            if (getDias() == null) {
                return "campo 'dias' precisa estar preenchido para usuário padrão";
            }
        }

        return "tudo certo";
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Integer getDias() {
        return dias;
    }
}
