package com.example.demo.dto.Sugerencia;

import com.example.demo.dto.Usuario.UsuarioDto;

import java.time.LocalDateTime;

public record SugerenciasToSaveDto(Long id, String descripcion, LocalDateTime createAt, UsuarioDto usuarioDto) {
}
