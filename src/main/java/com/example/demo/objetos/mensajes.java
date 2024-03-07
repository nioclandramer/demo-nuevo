package com.example.demo.objetos;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class mensajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String creador;
    private String destinatario;
    private LocalDateTime create_at;
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "usuario_ID")

    private Usuario usuario;
}
