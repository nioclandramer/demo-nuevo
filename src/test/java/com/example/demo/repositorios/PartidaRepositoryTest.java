package com.example.demo.repositorios;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Optional;

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
         //When
        Partida partidaSaved= partidaRepository.save(partida);
        //then
        assertThat(partidaSaved.getId()).isNotNull();
    }
    @Test
    void GivePartidaId_whenFindById_thenPartidaIsFound(){
        //give
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
        partidaRepository.save(partida);
        //when
        Optional<Partida> optionalpartida= partidaRepository.findById(partida.getId());
        //then
        assertThat(optionalpartida).isPresent();
    }
    @Test
    void GivenPartida_WhenUpdate_ThenPartidaUpdated(){
        //give
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
        Partida partidaSaved= partidaRepository.save(partida);
        //When
        partidaSaved.setCiudad("bogota");
        partidaRepository.save((partida));
        //then
        assertThat(partidaSaved.getCiudad()).isEqualTo("bogota");

    }
    @Test
    void givepartidaId_WhenDeleteById_thenPartidaIsDeleted(){
        //give
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
        Partida partidaSaved= partidaRepository.save(partida);
        //when
        partidaRepository.deleteById(partidaSaved.getId());
        //then
        assertThat(partidaRepository.findById(partidaSaved.getId())).isEmpty();
       // Optional<partidas> partidaOptional= partidaRepository.findById(partidaSaved.getId());
       // assertThat(partidaOptional).isEmpty();
    }
}