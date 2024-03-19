package com.example.demo.Service;

import com.example.demo.Exception.PartidaNotFoundException;
import com.example.demo.dto.Partida.PartidaDto;
import com.example.demo.dto.Partida.PartidaToSaveDto;

public interface PartidaService {
    PartidaDto guardarPartida(PartidaToSaveDto partida);
    PartidaDto actualizarPartida(PartidaToSaveDto partida);
    PartidaDto findById(long id)throws PartidaNotFoundException;
    PartidaDto findByCiudad(String Ciudad)throws PartidaNotFoundException;
}
