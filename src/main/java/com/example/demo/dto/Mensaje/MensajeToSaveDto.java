package com.example.demo.dto.Mensaje;

import com.example.demo.dto.Usuario.UsuarioDto;

import java.time.LocalDateTime;

public record MensajeToSaveDto(Long id, String creador, String destinatario, LocalDateTime createAt, String contenido, UsuarioDto usuarioDto) {

}
