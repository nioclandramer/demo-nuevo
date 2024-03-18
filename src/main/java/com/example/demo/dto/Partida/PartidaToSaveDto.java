package com.example.demo.dto.Partida;

import java.time.LocalDateTime;

public record PartidaToSaveDto( Long id, String creador,String deporte,String ciudad, String provincia, LocalDateTime fecha,
        LocalDateTime horaComienzo,LocalDateTime horaFinal,Integer participantes,Integer suplentes, String comentario) {
}
