package com.unifranz.proyectointegrador.infrastructure.persistence;

import com.unifranz.proyectointegrador.domain.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByMarcaAndActivoTrue(String marca);
}