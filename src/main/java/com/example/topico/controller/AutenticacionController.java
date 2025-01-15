package com.example.topico.controller;


import com.example.topico.domain.usuario.DatosAutenticationUsuario;
import com.example.topico.domain.usuario.Usuario;
import com.example.topico.infra.DatosJWTToken;
import com.example.topico.infra.TokenService;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosAutenticationUsuario datosAutenticationUsuario){
        Authentication authToken=new UsernamePasswordAuthenticationToken(datosAutenticationUsuario.usuario(),datosAutenticationUsuario.clave());
        var usuarioAutenticado= authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return  ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }


}
