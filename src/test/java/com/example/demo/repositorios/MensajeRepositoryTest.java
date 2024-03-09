package com.example.demo.repositorios;

import com.example.demo.AstractIntegrationBDTest;
import com.example.demo.objetos.Usuario;
import com.example.demo.objetos.Mensaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MensajeRepositoryTest extends AstractIntegrationBDTest {
    MensajeRepository mensajeRepository;
    UsuarioRepository usuarioRepository;
    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository, UsuarioRepository usuarioRepository) {
        this.mensajeRepository = mensajeRepository;
        this.usuarioRepository= usuarioRepository;
    }

    @BeforeEach
    void setUp() {
        mensajeRepository.deleteAll();
        usuarioRepository.deleteAll();
    }
    @Test
    void giveMensajeAndUser_WhenCreate_ThenMensajeGetId(){
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

        Mensaje mensaje = new Mensaje();
        mensaje.setCreateAt(LocalDateTime.now());
        mensaje.setContenido("Hola mundo");
        mensaje.setCreador("bbx");
        mensaje.setUsuario(usuario);
        mensaje.setDestinatario("xbb");
        //when
        Mensaje msgCreado =mensajeRepository.save(mensaje);
        //then
        assertThat(msgCreado).isNotNull();
        assertThat(msgCreado.getContenido()).isEqualTo("Hola mundo");
        }
        @Test
    void GiveUserAndMsg_whenSave_ThenGetAllMsg(){
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

        Mensaje mensaje = new Mensaje();
        mensaje.setCreateAt(LocalDateTime.now());
        mensaje.setContenido("Hola mundo");
        mensaje.setCreador("bbx");
        mensaje.setUsuario(usuario);
        mensaje.setDestinatario("xbb");
        mensajeRepository.save(mensaje);

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

        Mensaje mensaje2 = new Mensaje();
        mensaje2.setCreateAt(LocalDateTime.now());
        mensaje2.setContenido("Adios mundo");
        mensaje2.setCreador("xbb");
        mensaje2.setUsuario(usuario2);
        mensaje2.setDestinatario("bbx");
        mensajeRepository.save(mensaje2);

        //When
            List<Mensaje> mensajeALL= mensajeRepository.findAll();
        //then
        assertThat(mensajeALL).isNotEmpty();
        assertThat(mensajeALL).hasSize(2);
        }
        @Test
    void giveMsg_whenDelete_thenMsgHasNotAId(){
        //give
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

            Mensaje mensaje2 = new Mensaje();
            mensaje2.setCreateAt(LocalDateTime.now());
            mensaje2.setContenido("Adios mundo");
            mensaje2.setCreador("xbb");
            mensaje2.setUsuario(usuario2);
            mensaje2.setDestinatario("bbx");
            mensajeRepository.save(mensaje2);
         //When
         mensajeRepository.delete(mensaje2);
         //then
          assertThat(mensajeRepository.findById(mensaje2.getId())).isEmpty();
        }
        @Test
    void GiveMsg_WhenUpdateMsg_ThenNewMsg(){
        //give
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

            Mensaje mensaje2 = new Mensaje();
            mensaje2.setCreateAt(LocalDateTime.now());
            mensaje2.setContenido("Adios mundo");
            mensaje2.setCreador("xbb");
            mensaje2.setUsuario(usuario2);
            mensaje2.setDestinatario("bbx");
            mensajeRepository.save(mensaje2);
            //When
            mensaje2.setContenido("Hola mundo");
            mensajeRepository.save(mensaje2);
            //then
            assertThat(mensaje2.getContenido()).isEqualTo("Hola mundo");
            assertThat(mensaje2).isNotNull();
            assertThat(mensajeRepository.findById(mensaje2.getId())).isNotEmpty();
        }


}