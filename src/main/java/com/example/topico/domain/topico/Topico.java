package com.example.topico.domain.topico;

import com.example.topico.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
private Long idTopico;
private String mensaje;
@Column(name="nombre_curso")
private String nombreCurso;
private String titulo;
@JoinColumn(name="usuario_id")
@ManyToOne(fetch= FetchType.LAZY)
private Usuario usuario ;

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.mensaje()!=null){
            this.mensaje=datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.titulo()!=null){
            this.titulo=datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.nombreCurso()!=null){
            this.nombreCurso=datosActualizarTopico.nombreCurso();
        }

    }
 

}
