package com.example.demo.dto.Usuario;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Usuario;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioMapperTest extends AstractIntegrationBDTest {

    UsuarioMapper usuarioMapper=UsuarioMapper.INSTANCE;

    @Test
    void mapUsuarioToDto (){
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

        UsuarioDto usuarioDto=usuarioMapper.usuarioToDto(usuario);

        assertThat(usuarioDto).isNotNull();
    }

}