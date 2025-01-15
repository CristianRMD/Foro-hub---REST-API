package com.example.topico.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRegistrarTopico(
        @NotNull
        Long idUsuario,
         @NotNull
         String mensaje,
        @NotNull
        String nombreCurso,
        @NotNull
        String titulo

) {
    public DatosRegistrarTopico(Topico topico){
        this(topico.getIdTopico(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
    }
}
