package com.example.topico.domain.topico;

public record DatosRespuestaTopico(
        Long idTopico,
        String mensaje,
        String nombreCurso,
        String titulo

) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getIdTopico(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
    }
}
