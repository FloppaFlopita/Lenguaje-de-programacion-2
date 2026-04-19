package com.example.examenldp2.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pelicula {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private Integer anyoEstreno;
    private Integer duracionMinutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;
}