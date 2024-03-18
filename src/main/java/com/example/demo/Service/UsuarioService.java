package com.example.demo.Service;

import com.example.demo.Exception.UsuarioNotFoundException;
import com.example.demo.dto.Usuario.UsuarioDto;
import com.example.demo.dto.Usuario.UsuarioToSaveDto;

public interface UsuarioService {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto actualizarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto findUsuarioByid(long id) throws UsuarioNotFoundException;
    UsuarioDto FindUsuarioByemail(String email)throws UsuarioNotFoundException;

}
