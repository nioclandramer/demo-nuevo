package com.example.demo.Service;

import com.example.demo.Exception.MensajeNotFoundException;
import com.example.demo.dto.Mensaje.MensajeDto;
import com.example.demo.dto.Mensaje.MensajeMapper;
import com.example.demo.dto.Mensaje.MensajeToSaveDto;
import com.example.demo.dto.Usuario.UsuarioToSaveDto;
import com.example.demo.objetos.Mensaje;
import com.example.demo.repositorios.MensajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceIMPL implements MensajeService{
    private final MensajeRepository mensajeRepository;

    public MensajeServiceIMPL(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public MensajeDto guardarMensaje(MensajeToSaveDto mensaje) {
        Mensaje mensaje1=MensajeMapper.INSTANCE.ToEntity(mensaje);
        Mensaje mensajeGuardado=mensajeRepository.save(mensaje1);
        return MensajeMapper.INSTANCE.mensajeToDto(mensajeGuardado);
    }

    @Override
    public MensajeDto actualizarMensaje(MensajeToSaveDto mensaje) {
        Mensaje mensaje1= MensajeMapper.INSTANCE.ToEntity(mensaje);
        Mensaje mensajeExistente=mensajeRepository.findById(mensaje.id()).orElseThrow(()-> new MensajeNotFoundException("No Se Encontro El Mensaje"));
        mensajeExistente.setCreador(mensaje1.getCreador());
        mensajeExistente.setDestinatario(mensaje1.getDestinatario());
        mensajeExistente.setCreateAt(mensaje1.getCreateAt());
        mensajeExistente.setContenido(mensaje1.getContenido());
        mensajeExistente.setUsuario(mensaje1.getUsuario());
        mensajeExistente=mensajeRepository.save(mensajeExistente);
        return MensajeMapper.INSTANCE.mensajeToDto(mensajeExistente);
    }

    @Override
    public MensajeDto findById(long id) throws MensajeNotFoundException {
        Mensaje mensaje=mensajeRepository.findById(id).orElseThrow(()-> new MensajeNotFoundException("No Se Encontro El Mensaje"));
        return MensajeMapper.INSTANCE.mensajeToDto(mensaje);
    }


}
