package com.example.demo.repositorios;

import com.example.demo.objetos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
Usuario findByNombresAndApellidos(String nombre,String apellidos);
}
