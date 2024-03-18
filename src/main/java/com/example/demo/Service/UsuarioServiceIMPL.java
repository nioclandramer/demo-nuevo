package com.example.demo.Service;

import com.example.demo.Exception.UsuarioNotFoundException;
import com.example.demo.dto.Usuario.UsuarioDto;
import com.example.demo.dto.Usuario.UsuarioMapper;
import com.example.demo.dto.Usuario.UsuarioToSaveDto;
import com.example.demo.objetos.Usuario;
import com.example.demo.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceIMPL implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceIMPL(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuario) {
        Usuario usuario1= UsuarioMapper.INSTANCE.toEntity(usuario);
        Usuario usuarioGuardado = usuarioRepository.save(usuario1);
        return UsuarioMapper.INSTANCE.usuarioToDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioToSaveDto usuario) {
        return null;
    }

    @Override
    public UsuarioDto findUsuarioByid(long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("usuario no encontrado"));
        return UsuarioMapper.INSTANCE.usuarioToDto(usuario);
    }

    @Override
    public UsuarioDto FindUsuarioByemail(String email) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (Objects.isNull(usuario)){
            throw new UsuarioNotFoundException("usuario no encontrado");
        }
        return UsuarioMapper.INSTANCE.usuarioToDto(usuario);
    }
}
