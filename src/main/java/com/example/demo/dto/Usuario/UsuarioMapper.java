package com.example.demo.dto.Usuario;

import com.example.demo.objetos.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE= Mappers.getMapper(UsuarioMapper.class);
    UsuarioDto usuarioToDto(Usuario usuario);
    Usuario dtoToUsuario(UsuarioDto dto);

    Usuario toEntity(UsuarioToSaveDto dto);


}
