package com.example.demo.dto.Mensaje;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensajeDto {
    private Long id;
    private String creador;
    private String destinatario;
    private LocalDateTime createAt;
    private String contenido;
}
