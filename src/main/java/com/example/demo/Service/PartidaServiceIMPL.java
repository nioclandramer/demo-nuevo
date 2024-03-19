package com.example.demo.Service;

import com.example.demo.Exception.PartidaNotFoundException;
import com.example.demo.Exception.UsuarioNotFoundException;
import com.example.demo.dto.Partida.PartidaDto;
import com.example.demo.dto.Partida.PartidaMapper;
import com.example.demo.dto.Partida.PartidaToSaveDto;
import com.example.demo.objetos.Partida;
import com.example.demo.repositorios.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PartidaServiceIMPL implements PartidaService{
    private final PartidaRepository partidaRepository;

    public PartidaServiceIMPL(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Override
    public PartidaDto guardarPartida(PartidaToSaveDto partida) {
        Partida partida1=PartidaMapper.INSTANCE.ToEntity(partida);
        Partida partidaGuardada=partidaRepository.save(partida1);
        return PartidaMapper.INSTANCE.partidaToDto(partidaGuardada);
    }

    @Override
    public PartidaDto actualizarPartida(PartidaToSaveDto partida) {
        Partida partida1= PartidaMapper.INSTANCE.ToEntity(partida);
        Partida partidaExistente=partidaRepository.findById(partida.id()).orElseThrow(()-> new PartidaNotFoundException("No Se Encontro La PArtida"));
        partidaExistente.setCreador(partida1.getCreador());
        partidaExistente.setDeporte(partida1.getDeporte());
        partidaExistente.setCiudad(partida1.getCiudad());
        partidaExistente.setProvincia(partida1.getProvincia());
        partidaExistente.setFecha(partida1.getFecha());
        partidaExistente.setHoraComienzo(partida1.getHoraComienzo());
        partidaExistente.setHoraFinal(partida1.getHoraFinal());
        partidaExistente.setParticipantes(partida1.getParticipantes());
        partidaExistente.setSuplentes(partida1.getSuplentes());
        partidaExistente.setComentario(partida1.getComentario());
        partidaExistente=partidaRepository.save(partidaExistente);
        return PartidaMapper.INSTANCE.partidaToDto(partidaExistente);
    }

    @Override
    public PartidaDto findById(long id) throws PartidaNotFoundException {
        Partida partida=partidaRepository.findById(id).orElseThrow(()-> new PartidaNotFoundException("No Se Encontro La PArtida"));
        return PartidaMapper.INSTANCE.partidaToDto(partida);
    }

    @Override
    public PartidaDto findByCiudad(String ciudad) throws PartidaNotFoundException {
        Partida partida=partidaRepository.findByCiudad(ciudad);
        if (Objects.isNull(partida)){
            throw new PartidaNotFoundException("Partida No Encontrada");
        }
        return PartidaMapper.INSTANCE.partidaToDto(partida);
    }
}
