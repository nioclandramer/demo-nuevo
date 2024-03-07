package com.example.demo.repositorios;

import com.example.demo.objetos.mensajes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<mensajes,Long> {

}
