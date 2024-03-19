package com.example.demo.repositorios;

import com.example.demo.objetos.Sugerencia;
import com.example.demo.objetos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugerenciaRepository extends JpaRepository <Sugerencia,Long>{

}
