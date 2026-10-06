package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import com.unifranz.programaciontres.domain.Usuario;
import com.unifranz.programaciontres.infrastructure.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());

        Usuario guardado = usuarioRepository.save(usuario);
        return mapToDto(guardado);
    }

    @Override
    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> listarActivos() {
        return usuarioRepository.listarActivos()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto guardarAdmin(UsuarioDto usuarioDto) {
        return guardar(usuarioDto);
    }

    private UsuarioDto mapToDto(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());

        // Campos de auditoría
        dto.setUserCreate(usuario.getUserCreate());
        dto.setUserUpdate(usuario.getUserUpdate());
        dto.setTimeCreate(usuario.getTimeCreate());
        dto.setTimeUpdate(usuario.getTimeUpdate());
        dto.setDeleted(usuario.getDeleted());

        return dto;
    }
}