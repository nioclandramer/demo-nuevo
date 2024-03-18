package com.example.demo.dto.Usuario;

import java.time.LocalDateTime;

public record UsuarioToSaveDto(Long id, String username,String email, String nombres,String apellidos, Integer edad,
         String password, String repPassword,Boolean enabled,String foto,String rol, LocalDateTime createAt) {
}
