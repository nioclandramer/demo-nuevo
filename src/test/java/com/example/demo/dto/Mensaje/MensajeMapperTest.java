package com.example.demo.dto.Mensaje;

import com.example.demo.AstractIntegrationBDTest;

import com.example.demo.objetos.Mensaje;
import com.example.demo.objetos.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class MensajeMapperTest extends AstractIntegrationBDTest {
    MensajeMapper mensajeMapper=MensajeMapper.INSTANCE;
    @Test
    void mapMensajeToDto (){
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("pertruz noximiliem")
                .nombres("non")
                .password("1234")
                .repPassword("1234")
                .username("bbx")
                .enabled(false)
                .build();

        Mensaje mensaje= new Mensaje();
        mensaje.setUsuario(usuario);
        mensaje.setDestinatario("Juan");
        mensaje.setCreador("Paco");
        mensaje.setCreateAt(LocalDateTime.now());
        mensaje.setContenido("No lo esperaba de tiiiiiiiiiiiiiiiii");

        MensajeDto mensajeDto = mensajeMapper.mensajeToDto(mensaje);

        assertThat(mensajeDto).isNotNull();

        assertThat(mensajeDto.getContenido()).isEqualTo("No lo esperaba de tiiiiiiiiiiiiiiiii");

    }
}