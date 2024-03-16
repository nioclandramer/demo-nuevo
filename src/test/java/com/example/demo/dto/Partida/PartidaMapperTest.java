package com.example.demo.dto.Partida;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Partida;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartidaMapperTest extends AstractIntegrationBDTest {

    PartidaMapper partidaMapper=PartidaMapper.INSTANCE;

    @Test
    void mapPartidaToDto (){
        Partida partida= Partida.builder()
                .ciudad("Santa Marta")
                .comentario("mal Partido")
                .fecha(LocalDateTime.now())
                .horaComienzo(LocalDateTime.now().plusHours(1))
                .horaFinal(LocalDateTime.now().plusHours(2))
                .creador("kino der toten")
                .provincia("provicia")
                .participantes(10)
                .suplentes(5)
                .deporte("basquet")
                .build();

        PartidaDto partidaDto=partidaMapper.partidaToDto(partida);

        assertThat(partidaDto).isNotNull();
    }

}