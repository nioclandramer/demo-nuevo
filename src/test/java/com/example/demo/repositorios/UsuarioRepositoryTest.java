package com.example.demo.repositorios;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class UsuarioRepositoryTest extends AstractIntegrationBDTest {
    UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("pertruz noximiliem")
                .nombres("non")
                .password("1234")
                .rep_password("1234")
                .username("bbx")
                .enabled(false)
                .build();
        //when
        Usuario userSaved= usuarioRepository.save(usuario);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    void givenUsers_whenSave_thenGetAllUsers(){
        //given
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("pertruz noximiliem")
                .nombres("non")
                .password("1234")
                .rep_password("1234")
                .username("bbx")
                .enabled(false)
                .build();

        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .email("jose@loco.com")
                .foto("2")
                .edad(21)
                .rol("trabajador")
                .apellidos("canaval torres")
                .nombres("jose armando")
                .password("4321")
                .rep_password("4321")
                .username("xbb")
                .enabled(true)
                .build();

        usuarioRepository.save(usuario2);
        //when
        List<Usuario> usuarios = usuarioRepository.findAll();
        //then
        assertThat(usuarios).hasSize(2);

    }
    @Test
    void giveAnUser_WhenSave_ThenDeleteUser(){
        //given
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("pertruz noximiliem")
                .nombres("non")
                .password("1234")
                .rep_password("1234")
                .username("bbx")
                .enabled(false)
                .build();

        usuarioRepository.save(usuario);
        //when
        usuarioRepository.deleteById(usuario.getId());
        //then
        assertThat(usuarioRepository.findById(usuario.getId())).isEmpty();
    }
    @Test
    void giveAnUser_WhenUpdate_ThenUpdatedUser(){
        //give
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("pertruz")
                .nombres("non")
                .password("1234")
                .rep_password("1234")
                .username("bbx")
                .enabled(false)
                .build();

        Usuario Usuariosaved=usuarioRepository.save(usuario);
        //when
        Usuariosaved.setNombres("Armando");
        Usuario usuarioUpdate=usuarioRepository.save(Usuariosaved);
        //then
        assertThat(usuarioUpdate.getNombres()).isEqualTo(usuario.getNombres());
        assertThat(usuarioUpdate.getId()).isEqualTo(usuario.getId());
        assertThat(usuarioUpdate.getApellidos()).isEqualTo("pertruz");
    }
    @Test
    void giveAnUser_WhenFindUserByName_ThenUserWithThatName(){
        //given
        Usuario usuario = Usuario.builder()
                .email("andre@loco.com")
                .foto("1")
                .edad(24)
                .rol("jefe")
                .apellidos("guitierrez")
                .nombres("alfredo")
                .password("1234")
                .rep_password("1234")
                .username("bbx")
                .enabled(false)
                .build();

        usuarioRepository.save(usuario);
        //When
       Usuario userFound= usuarioRepository.findByNombresAndApellidos("alfredo","guitierrez");
        //then
        assertThat(userFound).isNotNull();
        assertThat(userFound.getNombres()).isEqualTo("alfredo");
        assertThat(userFound.getApellidos()).isEqualTo("guitierrez");
    }
}