package com.example.demo.repositorios;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Usuario;
import com.example.demo.objetos.Sugerencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SugerenciaRepositoryTest extends AstractIntegrationBDTest {
    SugerenciaRepository sugerenciaRepository;
    UsuarioRepository usuarioRepository;
    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository,UsuarioRepository usuarioRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
        this.usuarioRepository =usuarioRepository;
    }




    @BeforeEach
    void setUp() {
        sugerenciaRepository.deleteAll();
        usuarioRepository.deleteAll();
    }

    @Test
    void GiveAUserAndSugerencia_WhenSaveSugerencia_ThenGetSugerencia(){
        //give
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
        usuarioRepository.save(usuario);
        Sugerencia sugerencia= new Sugerencia();
        sugerencia.setDescripcion("muy buena");
        sugerencia.setUsuario(usuario);
        sugerencia.setCreateAt(LocalDateTime.now());

        //when
        Sugerencia sugerenciaSaved=sugerenciaRepository.save(sugerencia);
        //then
        assertThat(sugerenciaSaved.getId()).isNotNull();
        assertThat(sugerenciaSaved.getDescripcion()).isEqualTo("muy buena");

    }
    @Test
    void GiveUserAndSugerencia_WhenGetALL_ThenSizeExpected(){
        //Give
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
        usuarioRepository.save(usuario);
        Sugerencia sugerencia= new Sugerencia();
        sugerencia.setDescripcion("muy buena");
        sugerencia.setUsuario(usuario);
        sugerencia.setCreateAt(LocalDateTime.now());

        sugerenciaRepository.save(sugerencia);

        Usuario usuario2 = Usuario.builder()
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
        usuarioRepository.save(usuario2);
        Sugerencia sugerencia2= new Sugerencia();
        sugerencia2.setDescripcion("muy buena");
        sugerencia2.setUsuario(usuario2);
        sugerencia2.setCreateAt(LocalDateTime.now());
        sugerenciaRepository.save(sugerencia2);
        //When
        List<Sugerencia> sugerenciaALL= sugerenciaRepository.findAll();
        //then
        assertThat(sugerenciaALL).isNotEmpty();
        assertThat(sugerenciaALL).hasSize(2);
    }
    @Test
    void GiveAnSugerencia_WhenDelete_ThenSugerenciaIdIsEmpty(){
        //Give
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
        usuarioRepository.save(usuario);
        Sugerencia sugerencia= new Sugerencia();
        sugerencia.setDescripcion("muy buena");
        sugerencia.setUsuario(usuario);
        sugerencia.setCreateAt(LocalDateTime.now());

        sugerenciaRepository.save(sugerencia);
        //when
        sugerenciaRepository.delete(sugerencia);
        //then
        assertThat(sugerenciaRepository.findById(sugerencia.getId())).isEmpty();
    }
    @Test
    void GiveSugerenciaAndUser_whenUpdateSugerencia_ThenUpdatedSugerencia(){
        //Give
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
        usuarioRepository.save(usuario);
        Sugerencia sugerencia= new Sugerencia();
        sugerencia.setDescripcion("muy buena");
        sugerencia.setUsuario(usuario);
        sugerencia.setCreateAt(LocalDateTime.now());
        sugerenciaRepository.save(sugerencia);
        //When
        sugerencia.setDescripcion("muy mala");
        sugerenciaRepository.save(sugerencia);
        //then
        assertThat(sugerencia).isNotNull();
        assertThat(sugerencia.getDescripcion()).isEqualTo("muy mala");

    }
}