package com.unifranz.proyectointegrador.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dispositivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String marca;
    private double precio;
    private boolean activo = true;
}