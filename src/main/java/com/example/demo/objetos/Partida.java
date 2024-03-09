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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partida {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String creador;
  private String deporte;
  private String ciudad;
  private String provincia;
  private LocalDateTime fecha;
  private LocalDateTime horaComienzo;
  private LocalDateTime horaFinal;
  private Integer participantes;
  private Integer suplentes;
  private String comentario;
  @ManyToMany
  @JoinTable(
    name = "partidas_usuarios",
    joinColumns = @JoinColumn(name = "partidas_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name= "usuarios_id",referencedColumnName = "id") 
  )
private List<Usuario> usuario =new ArrayList<>();

}
