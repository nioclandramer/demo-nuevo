package com.example.demo.dto.Sugerencia;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Sugerencia;
import com.example.demo.objetos.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SugerenciaMapperTest extends AstractIntegrationBDTest {

    SugerenciaMapper sugerenciaMapper=SugerenciaMapper.INSTANCE;

    @Test
    void mapSugerenciaToDto () {
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

        Sugerencia sugerencia=new Sugerencia();
        sugerencia.setUsuario(usuario);
        sugerencia.setDescripcion("nalgas");
        sugerencia.setCreateAt(LocalDateTime.now());

        SugerenciaDto sugerenciaDto= sugerenciaMapper.sugerenciaToDto(sugerencia);

        assertThat(sugerenciaDto).isNotNull();

    }
}