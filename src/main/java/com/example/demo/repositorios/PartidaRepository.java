package com.example.demo.repositorios;

import com.example.demo.objetos.partidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<partidas,Long> {

}
