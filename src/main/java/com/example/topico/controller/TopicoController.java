package com.example.topico.controller;


import com.example.topico.domain.topico.*;
import com.example.topico.domain.usuario.Usuario;
import com.example.topico.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicoController {

@Autowired
UsuarioRepository usuarioRepository;


    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico (@PageableDefault(size=2) Pageable paginacion){
    return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));

    }
    @PostMapping
    public ResponseEntity<DatosRegistrarTopico> registrar(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico , UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.getReferenceById(datosRegistrarTopico.idUsuario());
        var topico = new Topico(null,datosRegistrarTopico.mensaje()
                ,datosRegistrarTopico.nombreCurso(),datosRegistrarTopico.titulo(),usuario);
        topicoRepository.save(topico);
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getIdTopico()).toUri();
        return ResponseEntity.created(url).body(datosRegistrarTopico);
   }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){

    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
    topico.actualizarDatos(datosActualizarTopico);
    return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable @Valid Long id){
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.status(404).body(null);
        }


     topicoRepository.deleteById(id);

    return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarTopico(@PathVariable Long id){
        Topico topico =topicoRepository.getReferenceById(id);
    return ResponseEntity.ok(new DatosRespuestaTopico(topico.getIdTopico(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo()));

    }
}
