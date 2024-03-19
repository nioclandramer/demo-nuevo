package com.example.demo.Service;

import com.example.demo.Exception.SugerenciaNotFoundException;
import com.example.demo.dto.Sugerencia.SugerenciaDto;
import com.example.demo.dto.Sugerencia.SugerenciasToSaveDto;
import com.example.demo.dto.Usuario.UsuarioToSaveDto;

import java.util.List;

public interface SugerenciaService {
    SugerenciaDto guardarSugerencia(SugerenciasToSaveDto sugerencia);
    SugerenciaDto actualizarSugerencia(SugerenciasToSaveDto sugerencia);
    SugerenciaDto findById(long id)throws SugerenciaNotFoundException;
    List<SugerenciaDto> findByUsuario(UsuarioToSaveDto usuario);

}
