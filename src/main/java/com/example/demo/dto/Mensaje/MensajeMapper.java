package com.example.demo.dto.Mensaje;

import com.example.demo.objetos.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MensajeMapper {
    MensajeMapper INSTANCE= Mappers.getMapper(MensajeMapper.class);

    MensajeDto mensajeToDto(Mensaje mensaje);
    Mensaje dtoToMensaje(MensajeDto dto);
}
