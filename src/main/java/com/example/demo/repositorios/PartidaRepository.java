package com.example.demo.repositorios;

import com.example.demo.objetos.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
    Partida findByCiudad(String ciudad);
}
