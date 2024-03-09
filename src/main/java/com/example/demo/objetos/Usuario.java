package com.example.demo.objetos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String password;
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    private LocalDateTime createAt;
    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> ensajes;
    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> ugerencias;
    @ManyToMany(mappedBy = "usuario")
    private List<Partida> Partida = new ArrayList<>();

    
}
