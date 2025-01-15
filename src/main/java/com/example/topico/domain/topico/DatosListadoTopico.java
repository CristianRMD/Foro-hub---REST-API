package com.example.topico.domain.topico;

public record DatosListadoTopico(
         Long idTopico,
         String mensaje,
         String nombreCurso,
         String titulo
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getIdTopico(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
    }
}
