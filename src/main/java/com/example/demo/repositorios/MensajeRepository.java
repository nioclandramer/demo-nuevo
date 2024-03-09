package com.example.demo.repositorios;

import com.example.demo.objetos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje,Long> {

}
