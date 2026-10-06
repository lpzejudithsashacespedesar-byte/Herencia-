package com.unifranz.proyectointegrador.application.service.impl;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import com.unifranz.proyectointegrador.application.service.DispositivoService;
import com.unifranz.proyectointegrador.domain.Dispositivo;
import com.unifranz.proyectointegrador.infrastructure.persistence.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository repositorio;

    @Override
    public DispositivoDto guardar(DispositivoDto dto) {
        Dispositivo d = convertirAEntidad(dto);
        Dispositivo guardado = repositorio.save(d);
        return convertirADto(guardado);
    }

    @Override
    public List<DispositivoDto> listarPorMarca(String marca) {
        return repositorio.findByMarcaAndActivoTrue(marca).stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public DispositivoDto editar(Long id, DispositivoDto dto) {
        Dispositivo d = repositorio.findById(id).orElseThrow();
        d.setNombre(dto.getNombre());
        d.setMarca(dto.getMarca());
        d.setPrecio(dto.getPrecio());
        d.setActivo(dto.isActivo());
        Dispositivo actualizado = repositorio.save(d);
        return convertirADto(actualizado);
    }

    @Override
    public void eliminarLogico(Long id) {
        Dispositivo d = repositorio.findById(id).orElseThrow();
        d.setActivo(false);
        repositorio.save(d);
    }

    private Dispositivo convertirAEntidad(DispositivoDto dto) {
        Dispositivo d = new Dispositivo();
        d.setId(dto.getId());
        d.setNombre(dto.getNombre());
        d.setMarca(dto.getMarca());
        d.setPrecio(dto.getPrecio());
        d.setActivo(dto.isActivo());
        return d;
    }

    private DispositivoDto convertirADto(Dispositivo d) {
        DispositivoDto dto = new DispositivoDto();
        dto.setId(d.getId());
        dto.setNombre(d.getNombre());
        dto.setMarca(d.getMarca());
        dto.setPrecio(d.getPrecio());
        dto.setActivo(d.isActivo());
        return dto;
    }
}