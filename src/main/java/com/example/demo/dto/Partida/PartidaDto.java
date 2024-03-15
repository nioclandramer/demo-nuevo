package com.example.demo.dto.Partida;

import com.example.demo.dto.Usuario.UsuarrioDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PartidaDto {
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    private LocalDateTime fecha;
    private LocalDateTime horaComienzo;
    private LocalDateTime horaFinal;
    private Integer participantes;
    private Integer suplentes;
    private String comentario;

    private List<UsuarrioDto> usuarios;
}
