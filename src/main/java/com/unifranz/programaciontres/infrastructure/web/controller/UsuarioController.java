package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDto guardar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.guardar(usuarioDto);
    }

    @GetMapping
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }
}