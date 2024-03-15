package com.example.demo.dto.Sugerencia;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SugerenciaDto {
    private Long id;
    private String descripcion;
    private LocalDateTime createAt;
}
