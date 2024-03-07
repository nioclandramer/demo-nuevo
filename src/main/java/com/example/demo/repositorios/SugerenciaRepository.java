package com.example.demo.repositorios;

import com.example.demo.objetos.sugerencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugerenciaRepository extends JpaRepository <sugerencias,Long>{

}
