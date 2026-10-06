package com.unifranz.programaciontres.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String email;

    // Campos de auditoría para la tarea
    private String userCreate;
    private String userUpdate;
    private LocalDateTime timeCreate;
    private LocalDateTime timeUpdate;
    private Boolean deleted;
}