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
@AllArgsConstructor
@NoArgsConstructor
public class sugerencias {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDateTime create_at;
    @ManyToOne
    @JoinColumn(name = "usuario_ID")
    private Usuario usuario;
}
