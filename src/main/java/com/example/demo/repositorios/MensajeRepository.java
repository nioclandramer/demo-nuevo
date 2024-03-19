package com.example.demo.repositorios;

import com.example.demo.objetos.Mensaje;
import com.example.demo.objetos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje,Long> {

}
