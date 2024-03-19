package com.example.demo.dto.Sugerencia;

import com.example.demo.objetos.Sugerencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SugerenciaMapper {
    SugerenciaMapper INSTANCE= Mappers.getMapper(SugerenciaMapper.class);

    SugerenciaDto sugerenciaToDto(Sugerencia sugerencia);
    Sugerencia dtoTosugerencia(SugerenciaDto dto);

    Sugerencia ToEntity(SugerenciasToSaveDto sugerenciaD);
}
