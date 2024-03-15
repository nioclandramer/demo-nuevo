package com.example.demo.dto.Usuario;

import com.example.demo.dto.Mensaje.MensajeDto;
import com.example.demo.dto.Sugerencia.SugerenciaDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UsuarioDto {
    private Long id;
    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String password;
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    private LocalDateTime createAt;

    private List<MensajeDto> mensajes;
    private List<SugerenciaDto> sugerencias;
}
