package com.example.demo.Service;

import com.example.demo.Exception.MensajeNotFoundException;
import com.example.demo.dto.Mensaje.MensajeDto;
import com.example.demo.dto.Mensaje.MensajeToSaveDto;
import com.example.demo.dto.Usuario.UsuarioToSaveDto;

import java.util.List;

public interface MensajeService {
    MensajeDto guardarMensaje(MensajeToSaveDto mensaje);
    MensajeDto actualizarMensaje(MensajeToSaveDto mensaje);
    MensajeDto findById(long id)throws MensajeNotFoundException;

}
