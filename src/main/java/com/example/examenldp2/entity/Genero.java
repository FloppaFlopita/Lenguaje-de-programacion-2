package com.example.examenldp2.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Genero {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
}