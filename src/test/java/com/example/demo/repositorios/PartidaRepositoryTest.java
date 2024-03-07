package com.example.demo.repositorios;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.partidas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PartidaRepositoryTest extends AstractIntegrationBDTest {
    PartidaRepository partidaRepository;

    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @BeforeEach
    void setUp() {
        partidaRepository.deleteAll();
    }
    @Test
    void GivePartida_WhenCreate_ThenPartidaIsSaved(){
        //Give
        partidas partida= partidas.builder()
                .ciudad("Santa Marta")
                .comentario("mal Partido")
                .fecha(LocalDateTime.now())
                .hora_Comienzo(LocalDateTime.now().plusHours(1))
                .hora_final(LocalDateTime.now().plusHours(2))
                .creador("kino der toten")
                .provincia("provicia")
                .participantes(10)
                .suplentes(5)
                .deporte("basquet")
                .build();
         //When
        partidas partidaSaved= partidaRepository.save(partida);
        //then
        assertThat(partidaSaved.getId()).isNotNull();
    }
    @Test
    void GivePartidaId_whenFindById_thenPartidaIsFound(){
        //give
        partidas partida= partidas.builder()
                .ciudad("Santa Marta")
                .comentario("mal Partido")
                .fecha(LocalDateTime.now())
                .hora_Comienzo(LocalDateTime.now().plusHours(1))
                .hora_final(LocalDateTime.now().plusHours(2))
                .creador("kino der toten")
                .provincia("provicia")
                .participantes(10)
                .suplentes(5)
                .deporte("basquet")
                .build();
        partidaRepository.save(partida);
        //when
        Optional<partidas> optionalpartida= partidaRepository.findById(partida.getId());
        //then
        assertThat(optionalpartida).isPresent();
    }
    @Test
    void GivenPartida_WhenUpdate_ThenPartidaUpdated(){
        //give
        partidas partida= partidas.builder()
                .ciudad("Santa Marta")
                .comentario("mal Partido")
                .fecha(LocalDateTime.now())
                .hora_Comienzo(LocalDateTime.now().plusHours(1))
                .hora_final(LocalDateTime.now().plusHours(2))
                .creador("kino der toten")
                .provincia("provicia")
                .participantes(10)
                .suplentes(5)
                .deporte("basquet")
                .build();
        partidas partidaSaved= partidaRepository.save(partida);
        //When
        partidaSaved.setCiudad("bogota");
        partidaRepository.save((partida));
        //then
        assertThat(partidaSaved.getCiudad()).isEqualTo("bogota");

    }
    @Test
    void givepartidaId_WhenDeleteById_thenPartidaIsDeleted(){
        //give
        partidas partida= partidas.builder()
                .ciudad("Santa Marta")
                .comentario("mal Partido")
                .fecha(LocalDateTime.now())
                .hora_Comienzo(LocalDateTime.now().plusHours(1))
                .hora_final(LocalDateTime.now().plusHours(2))
                .creador("kino der toten")
                .provincia("provicia")
                .participantes(10)
                .suplentes(5)
                .deporte("basquet")
                .build();
        partidas partidaSaved= partidaRepository.save(partida);
        //when
        partidaRepository.deleteById(partidaSaved.getId());
        //then
        assertThat(partidaRepository.findById(partidaSaved.getId())).isEmpty();
       // Optional<partidas> partidaOptional= partidaRepository.findById(partidaSaved.getId());
       // assertThat(partidaOptional).isEmpty();
    }
}