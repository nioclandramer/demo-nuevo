package com.example.demo.Service;

import com.example.demo.Exception.SugerenciaNotFoundException;
import com.example.demo.dto.Sugerencia.SugerenciaDto;
import com.example.demo.dto.Sugerencia.SugerenciaMapper;
import com.example.demo.dto.Sugerencia.SugerenciasToSaveDto;
import com.example.demo.objetos.Sugerencia;
import com.example.demo.repositorios.SugerenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class SugerenciaServiceIMPL implements SugerenciaService{
    private final SugerenciaRepository sugerenciaRepository;

    public SugerenciaServiceIMPL(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }

    @Override
    public SugerenciaDto guardarSugerencia(SugerenciasToSaveDto sugerencia) {
        Sugerencia sugerencia1=SugerenciaMapper.INSTANCE.ToEntity(sugerencia);
        Sugerencia sugerenciaGuardada=sugerenciaRepository.save(sugerencia1);
        return SugerenciaMapper.INSTANCE.sugerenciaToDto(sugerenciaGuardada);
    }

    @Override
    public SugerenciaDto actualizarSugerencia(SugerenciasToSaveDto sugerencia) {
        Sugerencia sugerencia1= SugerenciaMapper.INSTANCE.ToEntity(sugerencia);
        Sugerencia sugerenciaExiste=sugerenciaRepository.findById(sugerencia.id()).orElseThrow(()-> new SugerenciaNotFoundException("No Se Encontro La Sugerencia"));
        sugerenciaExiste.setDescripcion(sugerencia1.getDescripcion());
        sugerenciaExiste.setCreateAt(sugerencia1.getCreateAt());
        sugerenciaExiste.setUsuario(sugerencia1.getUsuario());
        sugerenciaExiste=sugerenciaRepository.save(sugerenciaExiste);
        return SugerenciaMapper.INSTANCE.sugerenciaToDto(sugerenciaExiste);
    }

    @Override
    public SugerenciaDto findById(long id) throws SugerenciaNotFoundException {
        Sugerencia sugerencia=sugerenciaRepository.findById(id).orElseThrow(()-> new SugerenciaNotFoundException("No Se Encontro La Sugerencia"));
        return SugerenciaMapper.INSTANCE.sugerenciaToDto(sugerencia);
    }
}
