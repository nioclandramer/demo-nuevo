package com.example.demo.dto.Partida;

import com.example.demo.objetos.Partida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartidaMapper {
    PartidaMapper INSTANCE= Mappers.getMapper(PartidaMapper.class);

    PartidaDto partidaToDto(Partida partida);
}
